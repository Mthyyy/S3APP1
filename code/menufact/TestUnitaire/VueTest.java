package menufact.TestUnitaire;

import menufact.Client;
import menufact.facture.Facture;
import menufact.facture.Vue;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VueTest {

    Facture f;
    Vue vue;
    void initialiser()
    {
        vue = new Vue();
        f = new Facture("Allo");
        f.setClient(new Client(12,"MathiasLeJambon","1628012"));
        PlatAuMenu plat1 = new PlatAuMenu(4,"as",10);
        PlatChoisi platc1= new PlatChoisi(plat1,3);
        f.ajoutePlat(platc1);
        f.ajoutePlat(platc1);

    }
    @Test
    void genererFacture() {
        initialiser();

        vue.setFacture(f);
        assertNotEquals(null,vue.genererFacture());
    }
}