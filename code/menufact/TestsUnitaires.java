package menufact;

import ingredients.LegumeInventaire;
import ingredients.Solide;
import ingredients.ViandeInventaire;
import ingredients.exceptions.IngredientException;
import menufact.exceptions.MenuException;
import menufact.plats.*;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestsUnitaires {
    @Test
    public void TestsMenu() throws IngredientException, MenuException {
        ViandeInventaire.getInstance();
        LegumeInventaire.getInstance();

        Menu menu = Menu.getInstance("Menu du restaurant");
        Menu menu2 = Menu.getInstance("2eme Menu du restaurant");

        //Test que le menu est bel et bien un singleton
        Assert.assertEquals(menu2, menu);

        ViandeInventaire.ajouterIngredient("poulet","allo",100, Solide.getInstance());
        LegumeInventaire.ajouterIngredient("patate","allo",50,Solide.getInstance());

        ListeIngredients liste = new ListeIngredients();
        ListeIngredients liste2 = new ListeIngredients();

        liste.ajouterIngredient(ViandeInventaire.getIngredient("poulet"),100);
        liste2.ajouterIngredient(LegumeInventaire.getIngredient("patate"),50);


        FactoryPlats factoryPlats = new ConcreteFactoryPlat();

        PlatAuMenu pm1 = factoryPlats.creerPlat(1, "frite", 11.25);
        PlatAuMenu pm2 = factoryPlats.creerPlatEnfant(2, "poutine", 16.25, 0.5);

        pm1.setListeIngredients(liste);
        pm2.setListeIngredients(liste2);

        menu.ajoute(pm1);
        menu.ajoute(pm2);

        menu.positionSuivante();

        //Test que l'option de selectionner un plat au menu avec la variable courant fonctionne
        Assert.assertEquals(menu.platCourant(), pm2);

        //Test que le getter de plat selon son code fonctionne
        Assert.assertEquals(menu.getPlat(1), pm1);

        String nouvelleDescription = "Je suis la nouvelle description du menu";

        menu.setDescription(nouvelleDescription);

        //Test que la methode setDescription nous permet de modifier la description du menu
        Assert.assertEquals(menu.getDescription(), nouvelleDescription);

        menu.retirerCourant();
         //a continuer
    }
}