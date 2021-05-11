package menufact.TestUnitaire;

import ingredients.Solide;
import ingredients.ViandeInventaire;
import menufact.plats.ConcreteFactoryPlat;
import menufact.plats.ListeIngredients;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlatChoisiTest {

    @Test
    void EnleverQuantiteIngredient()
    {

        try {
            ViandeInventaire.getInstance();
            ViandeInventaire.ajouterIngredient("poulet","desc",200, Solide.getInstance());
            ViandeInventaire.getInstance().setQuantite("poulet",200);
            PlatAuMenu plat1 = new PlatAuMenu(1,"a",50);
            ListeIngredients liste = new ListeIngredients();
            liste.ajouterIngredient(ViandeInventaire.getIngredient("poulet"),100);
            plat1.setListeIngredients(liste);
            PlatChoisi platC1 = new PlatChoisi(plat1,1);

            System.out.println(platC1);
            assertEquals(100,ViandeInventaire.getInstance().getQuantite("poulet"));
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }


    }

    @Test
    void EnleverQuantiteIngredient2()
    {

        try {
            ViandeInventaire.getInstance();
            ViandeInventaire.ajouterIngredient("poulet","desc",199, Solide.getInstance());
            ViandeInventaire.getInstance().setQuantite("poulet",199);
            PlatAuMenu plat1 = new PlatAuMenu(1,"a",50);
            ListeIngredients liste = new ListeIngredients();
            liste.ajouterIngredient(ViandeInventaire.getIngredient("poulet"),200);
            plat1.setListeIngredients(liste);
            PlatChoisi platC1 = new PlatChoisi(plat1,1);

            assertEquals(199,ViandeInventaire.getInstance().getQuantite("poulet"));

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }


    }

    @Test
    public void testRetirerPlat() throws Exception{
        ConcreteFactoryPlat factory = new ConcreteFactoryPlat();
        PlatAuMenu pm= factory.creerPlat(1, "Poulet", 10.25);

        ViandeInventaire.getInstance();
        ViandeInventaire.ajouterIngredient("boeuf","allo",500,Solide.getInstance());

        ListeIngredients liste = new ListeIngredients();

        liste.ajouterIngredient(ViandeInventaire.getIngredient("boeuf"),200);

        pm.setListeIngredients(liste);

        PlatChoisi p = new PlatChoisi(pm, 1);

        p.retirerPlat();

        Assert.assertEquals(ViandeInventaire.getIngredient("boeuf").getQuantite(), 500);
    }

    @Test
    public void testRetirerPlat2() throws Exception{
        ConcreteFactoryPlat factory = new ConcreteFactoryPlat();
        PlatAuMenu pm= factory.creerPlat(1, "boeuf", 10.25);

        ViandeInventaire.getInstance();
        ViandeInventaire.ajouterIngredient("boeuf","allo",1000,Solide.getInstance());

        ListeIngredients liste = new ListeIngredients();

        liste.ajouterIngredient(ViandeInventaire.getIngredient("boeuf"),500);

        pm.setListeIngredients(liste);

        PlatChoisi p = new PlatChoisi(pm, 1);

        p.retirerPlat();

        Assert.assertEquals(ViandeInventaire.getIngredient("boeuf").getQuantite(), 500);
    }

    @Test
    public void testSetQte() throws Exception{
        ConcreteFactoryPlat factory = new ConcreteFactoryPlat();
        PlatAuMenu pm= factory.creerPlat(1, "Cheval", 10.25);

        ViandeInventaire.getInstance();
        ViandeInventaire.ajouterIngredient("Cheval","allo",1000,Solide.getInstance());

        ListeIngredients liste = new ListeIngredients();

        liste.ajouterIngredient(ViandeInventaire.getIngredient("Cheval"),500);

        pm.setListeIngredients(liste);

        PlatChoisi p = new PlatChoisi(pm, 1);

        p.setQuantite(2);

        Assert.assertEquals(ViandeInventaire.getIngredient("Cheval").getQuantite(), 0);
    }
}