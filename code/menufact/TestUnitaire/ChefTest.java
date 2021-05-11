package menufact.TestUnitaire;

import menufact.plats.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChefTest {

    Chef chef;
    PlatAuMenu plat1;
    PlatChoisi platc1;
    Serveur serveur;
    void initialiser()
    {
        chef = new Chef();
        serveur = new Serveur();
         plat1 = new PlatAuMenu(7,"a",10);
         platc1 = new PlatChoisi(plat1,2);
    }
    @Test
    void ajouterPlat() {
        initialiser();
        chef.ajouterPlat(platc1);
        assertEquals(platc1,chef.listePlats.get(0));
    }


    @Test
    void ajouterServeur() {
        initialiser();
        chef.ajouterServeur(serveur);
        assertEquals(serveur,chef.listeServeurs.get(0));
    }

    @Test
    void retirerServeur() {
        initialiser();

        Serveur serveur2 = new Serveur();

        chef.ajouterServeur(serveur);
        chef.ajouterServeur(serveur2);
        chef.retirerServeur(serveur);

        assertEquals(serveur2 ,chef.listeServeurs.get(0));
    }

    @Test
    void preparer() {
        initialiser();
        chef.ajouterPlat(platc1);
        chef.preparer();
        assertEquals(PlatEtat.PREPARATION,chef.listePlats.get(0).getEtat());
    }

    @Test
    void termine() {
        initialiser();
        chef.ajouterPlat(platc1);
        chef.termine();
        assertEquals(0,chef.listePlats.size());
    }
}