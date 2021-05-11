package menufact.TestUnitaire;

import menufact.facture.*;
import menufact.plats.ConcreteFactoryPlat;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerFacturesTest {

    Facture f;
    Vue vue;

    void Initialiser(){
        f = new Facture("Test");
        vue = new Vue();
    }

    @Test
    void getFacture() {
        Initialiser();
        ControllerFactures controller = new ControllerFactures(f, vue);

        Assert.assertEquals(f, controller.getFacture());
    }

    @Test
    void connectionVue() {
        Initialiser();
        ControllerFactures controller = new ControllerFactures(f, vue);
        controller.connectionVue();

        Assert.assertEquals(f, vue.getFacture());
    }

    @Test
    void testFermerFacture(){
        Initialiser();

        ControllerFactures controller = new ControllerFactures(f, vue);
        try{
            controller.fermerFacture();
        }

        catch(Exception e){
            System.out.println(e.getMessage());
        }

        Assert.assertEquals(f.getEtat(), FactureEtat.FERMEE);
    }

    @Test
    void testOuvrirFacture(){
        Initialiser();

        ControllerFactures controller = new ControllerFactures(f, vue);
        try{
            controller.ouvrirFacture();
        }

        catch(Exception e){
            System.out.println(e.getMessage());
        }

        Assert.assertEquals(f.getEtat(), FactureEtat.OUVERTE);
    }

    @Test
    void testPayerFacture(){
        Initialiser();

        ControllerFactures controller = new ControllerFactures(f, vue);
        try{
            controller.payerFacture();
        }

        catch(Exception e){
            System.out.println(e.getMessage());
        }

        Assert.assertEquals(f.getEtat(), FactureEtat.PAYEE);
    }

    @Test
    void testsousTotal(){
        Initialiser();

        ControllerFactures controller = new ControllerFactures(f, vue);

        ConcreteFactoryPlat factoryPlat = new ConcreteFactoryPlat();
        PlatAuMenu pm = factoryPlat.creerPlat(2, "Poulet", 20.25);
        PlatChoisi p = new PlatChoisi(pm, 20);
        f.ajoutePlat(p);

        double soustotal=0;
        soustotal += 20 * 20.25;


        Assert.assertEquals(controller.sousTotal(), f.sousTotal(), 1);
        Assert.assertEquals(controller.sousTotal(), soustotal, 1);
    }

    @Test
    void testReinitialiser(){
        Initialiser();

        ControllerFactures controller = new ControllerFactures(f, vue);

        ConcreteFactoryPlat factoryPlat = new ConcreteFactoryPlat();
        PlatAuMenu pm = factoryPlat.creerPlat(2, "Poulet", 20.25);
        PlatChoisi p = new PlatChoisi(pm, 20);
        f.ajoutePlat(p);

        controller.reinitialiserFacture("Nouvelle facture");

        Assert.assertEquals("Nouvelle facture", f.getDescription());


    }

    @Test
    void testTPS(){
        Initialiser();

        ControllerFactures controller = new ControllerFactures(f, vue);

        ConcreteFactoryPlat factoryPlat = new ConcreteFactoryPlat();
        PlatAuMenu pm = factoryPlat.creerPlat(2, "Poulet", 20.25);
        PlatChoisi p = new PlatChoisi(pm, 20);
        f.ajoutePlat(p);

        double tps = controller.sousTotal() * f.getTPS();

        Assert.assertEquals(tps, controller.tps(), 0);
    }

    @Test
    void testTVQ(){
        Initialiser();

        ControllerFactures controller = new ControllerFactures(f, vue);

        ConcreteFactoryPlat factoryPlat = new ConcreteFactoryPlat();
        PlatAuMenu pm = factoryPlat.creerPlat(2, "Poulet", 20.25);
        PlatChoisi p = new PlatChoisi(pm, 20);
        f.ajoutePlat(p);

        double tvq = controller.sousTotal() * f.getTVQ();

        Assert.assertEquals(tvq, controller.tvq(), 0);
    }

    @Test
    void testTotal(){
        Initialiser();

        ControllerFactures controller = new ControllerFactures(f, vue);

        ConcreteFactoryPlat factoryPlat = new ConcreteFactoryPlat();
        PlatAuMenu pm = factoryPlat.creerPlat(2, "Poulet", 20.25);
        PlatChoisi p = new PlatChoisi(pm, 20);
        f.ajoutePlat(p);

        double total = controller.sousTotal() + controller.tvq() + controller.tps();

        Assert.assertEquals(total, controller.total(), 0);
    }
}