package menufact.TestUnitaire;

import ingredients.Solide;
import ingredients.ViandeInventaire;
import menufact.plats.ListeIngredients;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
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
}