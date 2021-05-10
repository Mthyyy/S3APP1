package menufact.TestUnitaire;

import menufact.plats.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteFactoryPlatTest {

    ConcreteFactoryPlat factory;
    PlatAuMenu plat;
    PlatSante platsante;
    PlatEnfant platEnfant;
    void initialiser()
    {
        factory = new ConcreteFactoryPlat();
        plat = new PlatAuMenu(1,"allo",10);
        platsante = new PlatSante(1, "sante", 20, 10, 15, 17);
        platEnfant = new PlatEnfant(3, "enfant", 18, 0.5);
    }
    @Test
    void creerPlat() {
        initialiser();
       PlatAuMenu plat2 =  factory.creerPlat(1,"allo",10);
        assertEquals(plat.getCode(),plat2.getCode());
        assertEquals(plat.getPrix(),plat2.getPrix());
        assertEquals(plat.getDescription(),plat2.getDescription());


    }

    @Test
    void creerPlatSante() {
        initialiser();

        PlatSante plat2 =  factory.creerPlatSante(1, "sante", 20, 10, 15, 17);
        assertEquals(platsante.getCode(),plat2.getCode());
        assertEquals(platsante.getPrix(),plat2.getPrix());
        assertEquals(platsante.getCode(),plat2.getCode());
        assertEquals(platsante.getKcal(),plat2.getKcal());
        assertEquals(platsante.getChol(),plat2.getChol());
        assertEquals(platsante.getGras(),plat2.getGras());
        assertEquals(platsante.getDescription(),plat2.getDescription());
    }

    @Test
    void creerPlatEnfant() {
        initialiser();

        PlatEnfant plat2 = new PlatEnfant(3, "enfant", 18, 0.5);
        assertEquals(platEnfant.getCode(),plat2.getCode());
        assertEquals(platEnfant.getPrix(),plat2.getPrix());
        assertEquals(platEnfant.getCode(),plat2.getCode());
        assertEquals(platEnfant.getProportion(),plat2.getProportion());
        assertEquals(platEnfant.getDescription(),plat2.getDescription());
    }
}