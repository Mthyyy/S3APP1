package menufact;

import ingredients.LegumeInventaire;
import ingredients.Solide;
import ingredients.Viande;
import ingredients.ViandeInventaire;
import ingredients.exceptions.IngredientException;
import menufact.exceptions.MenuException;
import menufact.plats.ConcreteFactoryPlat;
import menufact.plats.FactoryPlats;
import menufact.plats.ListeIngredients;
import menufact.plats.PlatAuMenu;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {

    Menu menu;
    PlatAuMenu pm1;
    PlatAuMenu pm2;
    ListeIngredients liste;
    ListeIngredients liste2;

    public void initialiser() throws IngredientException {
        menu = Menu.getInstance("Menu du restaurant");
        ViandeInventaire.getInstance();
        ViandeInventaire.ajouterIngredient("poulet","allo",100, Solide.getInstance());

        liste = new ListeIngredients();
        liste2 = new ListeIngredients();

        liste.ajouterIngredient(ViandeInventaire.getIngredient("poulet"),100);
        liste2.ajouterIngredient(ViandeInventaire.getIngredient("poulet"),50);


        pm1 = new PlatAuMenu(1, "frites", 11.25);
        pm2 = new PlatAuMenu(2, "poutine", 16.25);

        pm1.setListeIngredients(liste);
        pm2.setListeIngredients(liste2);

        menu.position(0);
        menu.getListePlats().clear();
    }


    @Test
    public void testSingleton(){
        menu = Menu.getInstance("Menu du restaurant");
        Menu menu2 = Menu.getInstance("Deuxieme menu du restaurant");

        Assert.assertEquals(menu, menu2);
    }

    @Test
    public void testPlatCourant() throws IngredientException, MenuException {
        initialiser();


        menu.ajoute(pm1);
        menu.ajoute(pm2);

        menu.positionSuivante();


        Assert.assertEquals(menu.platCourant(), pm2);

        menu.retirerPlat(1);
        menu.retirerPlat(2);
    }

    @Test
    public void testGetPlat() throws IngredientException, MenuException{
        menu  = Menu.getInstance("Menu");
        pm1 = new PlatAuMenu(1, "frites", 11.25);
        menu.ajoute(pm1);
        Assert.assertEquals(menu.getPlat(1), pm1);
        menu.retirerPlat(1);
    }

    @Test
    public void testSetDescription() throws IngredientException, MenuException{
        initialiser();
        String nouvelleDescription = "Je suis la nouvelle description du menu";

        menu.setDescription(nouvelleDescription);
        Assert.assertEquals(menu.getDescription(), nouvelleDescription);
    }

    @Test
    public void testAjouter() throws IngredientException, MenuException{
        initialiser();

        menu.ajoute(pm1);

        Assert.assertEquals(menu.getPlat(1), pm1);

        menu.retirerPlat(1);
    }

    @Test
    public void testRetirerPlat() throws IngredientException, MenuException{

        initialiser();

        menu.ajoute(pm1);

        menu.retirerPlat(1);

        Assert.assertEquals(menu.getPlat(1), null);

    }

    @Test
    public void testRetirerCourant() throws IngredientException, MenuException{
        initialiser();

        menu.ajoute(pm1);
        menu.ajoute(pm2);

        menu.retirerCourant();

        Assert.assertEquals(menu.getPlat(1), null);
        Assert.assertEquals(menu.getPlat(2), pm2);

        menu.retirerPlat(2);
    }

    @Test
    public void testPositionSuivante() throws IngredientException, MenuException{
        initialiser();

        menu.ajoute(pm1);
        menu.ajoute(pm2);

        menu.positionSuivante();

        Assert.assertEquals(menu.getCourant(), 1);

        menu.retirerPlat(1);
        menu.retirerPlat(2);
    }

    @Test
    public void testPositionPrecedente() throws IngredientException, MenuException{
        initialiser();

        menu.ajoute(pm1);
        menu.ajoute(pm2);

        menu.positionSuivante();

        menu.positionPrecedente();

        Assert.assertEquals(menu.getCourant(), 0);

        menu.retirerPlat(1);
        menu.retirerPlat(2);
    }
}