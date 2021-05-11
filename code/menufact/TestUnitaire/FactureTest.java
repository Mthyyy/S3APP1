package menufact.TestUnitaire;

import ingredients.exceptions.IngredientException;
import menufact.facture.*;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FactureTest {

    public PlatAuMenu plat1;
    public PlatChoisi platC1;
    public Facture f;


    void initialiser() {
        f = new Facture("factureTest");
        plat1 = new PlatAuMenu(1, "description", 10);

        platC1 = new PlatChoisi(plat1, 1);

    }


    @org.junit.jupiter.api.Test
    void OuvrirFacturePaye()
    {
        initialiser();
        f.payer();
        try {
            f.getEtatFacture().ouvrir();
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            assertEquals("FactureException: On peut changer l'etat, la facture est payee",e.getMessage());
        }

    }

    @org.junit.jupiter.api.Test
    void OuvrirFactureFerme()
    {
        initialiser();

        try {

            assertEquals(FactureEtat.OUVERTE, f.getEtat());
        }
        catch (Exception e){
            System.out.println(e.getMessage());

        }

    }

    @org.junit.jupiter.api.Test
    void sousTotal() throws IngredientException {


        initialiser();
        System.out.println(platC1);
        f.ajoutePlat(platC1);
        f.ajoutePlat(platC1);
        f.ajoutePlat(platC1);

        assertEquals(platC1.getPlat().getPrix() *3,f.sousTotal());

    }

    @org.junit.jupiter.api.Test
    void total() throws IngredientException {
        initialiser();
        f.ajoutePlat(platC1);
         assertEquals((double) platC1.getPlat().getPrix() +  (double)platC1.getPlat().getPrix()*f.getTVQ() +   (double) platC1.getPlat().getPrix()*f.getTPS(),f.total());

    }

    @org.junit.jupiter.api.Test
    void ajoutePlat() throws IngredientException {
        initialiser();

            f.ajoutePlat(platC1);


        Assert.assertSame(platC1, f.getPlatchoisi().get(0));

    }

    @org.junit.jupiter.api.Test
    void ajoutePlatFacturePayer() throws IngredientException {
        initialiser();

        f.getEtatFacture().payer();
        f.ajoutePlat(platC1);


        Assert.assertEquals(0,f.getPlatchoisi().size());

    }

    @org.junit.jupiter.api.Test
    void ajoutePlatFactureFermee() throws IngredientException {
        initialiser();

        try {
            f.getEtatFacture().fermer();
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        f.ajoutePlat(platC1);


        Assert.assertEquals(0,f.getPlatchoisi().size());

    }

    @org.junit.jupiter.api.Test
    void retirerPlat() throws IngredientException {
        initialiser();
        try {
            f.selectionnerPlat(platC1);
            f.retirerPlat();
        } catch (Exception e) {
            e.getMessage();
        }

        for (int i = 0; i < f.getPlatchoisi().size(); i++) {
            assertNotEquals(platC1, f.getPlatchoisi().get(i));
        }
    }

    @org.junit.jupiter.api.Test
    void selectionnerPlat1() throws IngredientException {
        initialiser();

        try {
            f.getEtatFacture().selectionnerPlat(platC1);
        }
        catch (Exception e )
        {
            System.out.println(e.getMessage());
        }

        assertEquals(platC1, f.getPlatSelectionner());
    }

    @org.junit.jupiter.api.Test
    void reinitialiser() throws IngredientException {
        initialiser();

        f.reinitialiser("Voici ma nouvelle description");

        assertEquals("Voici ma nouvelle description", f.getDescription());
        assertEquals(null, f.getPlatSelectionner());
    }

    @Test
    void getTps() {
        initialiser();
        assertEquals(0.05,f.getTPS());
    }

    @Test
    void getTvq() {
        initialiser();
        assertEquals(0.095,f.getTVQ());
    }

    @Test
    void getDescription() {
        initialiser();
        assertEquals("factureTest",f.getDescription());
    }
}