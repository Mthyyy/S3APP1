package menufact.TestUnitaire;

import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import org.junit.Assert;

import static org.junit.jupiter.api.Assertions.*;

class FactureTest {

    public PlatAuMenu plat1;
    void initialiser()
    {
        PlatAuMenu plat1 = new PlatAuMenu(1,"description",10);

    }

    @org.junit.jupiter.api.Test
    void associerClient() {
    }

    @org.junit.jupiter.api.Test
    void sousTotal() {
    }

    @org.junit.jupiter.api.Test
    void total() {
    }

    @org.junit.jupiter.api.Test
    void payer() {
    }

    @org.junit.jupiter.api.Test
    void fermer() {
    }

    @org.junit.jupiter.api.Test
    void ouvrir() {
    }

    @org.junit.jupiter.api.Test
    void getEtat() {
    }

    @org.junit.jupiter.api.Test
    void ajoutePlat() {
        initialiser();
        Assert.assertSame();


    }

    @org.junit.jupiter.api.Test
    void retirerPlat() {
    }

    @org.junit.jupiter.api.Test
    void selectionnerPlat() {
    }

    @org.junit.jupiter.api.Test
    void setEtat() {
    }

    @org.junit.jupiter.api.Test
    void setEtatFacture() {
    }

    @org.junit.jupiter.api.Test
    void getDate() {
    }

    @org.junit.jupiter.api.Test
    void setDate() {
    }

    @org.junit.jupiter.api.Test
    void getDescription() {
    }

    @org.junit.jupiter.api.Test
    void setDescription() {
    }

    @org.junit.jupiter.api.Test
    void getPlatchoisi() {
    }

    @org.junit.jupiter.api.Test
    void setPlatchoisi() {
    }

    @org.junit.jupiter.api.Test
    void getCourant() {
    }

    @org.junit.jupiter.api.Test
    void setCourant() {
    }

    @org.junit.jupiter.api.Test
    void getClient() {
    }

    @org.junit.jupiter.api.Test
    void setClient() {
    }

    @org.junit.jupiter.api.Test
    void getEtatFacture() {
    }

    @org.junit.jupiter.api.Test
    void getTPS() {
    }

    @org.junit.jupiter.api.Test
    void getTVQ() {
    }
}