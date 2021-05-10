package menufact.TestUnitaire;

import menufact.plats.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ServeurTest {


    @Test
    void update() {
        Chef chef = new Chef();
        Serveur serveur1 = new Serveur();
        Serveur serveur2 = new Serveur();
        ArrayList<PlatChoisi> listPlat = new ArrayList<PlatChoisi>();
        listPlat.add(new PlatChoisi(new PlatAuMenu(1,"1",23),1));

        chef.ajouterPlat(new PlatChoisi(new PlatAuMenu(1,"1",23),1));
        chef.termine();

        serveur1.update(listPlat);
        serveur2.update(listPlat);

        assertEquals(PlatEtat.SERVI,serveur1.listPlat.get(0).getEtat());
        assertEquals(PlatEtat.SERVI,serveur2.listPlat.get(0).getEtat());


    }
}