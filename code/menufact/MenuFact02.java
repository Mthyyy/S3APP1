package menufact;

import ingredients.*;
import ingredients.exceptions.IngredientException;
import menufact.exceptions.MenuException;
import menufact.facture.ControllerFactures;
import menufact.facture.Facture;
import menufact.facture.Vue;
import menufact.plats.*;
import menufact.*;

public class MenuFact02 {

    public static void main(String[] args) throws IngredientException, MenuException, Exception {
        ViandeInventaire.getInstance();
        LegumeInventaire.getInstance();
        LaitierInventaire.getInstance();
        FruitInventaire.getInstance();
        EpiceInventaire.getInstance();

        Menu menu = Menu.getInstance("Menu du restaurant");

        ViandeInventaire.ajouterIngredient("poulet","allo",500,Solide.getInstance());
        LegumeInventaire.ajouterIngredient("patate","allo",1000,Solide.getInstance());
        LaitierInventaire.ajouterIngredient("Fromage", "Fromage de chevre", 1000, Solide.getInstance());
        FruitInventaire.ajouterIngredient("Pomme", "Jus de pomme", 1000, Liquide.getInstance());
        EpiceInventaire.ajouterIngredient("Basilic", "Feuilles de basilic", 500, Solide.getInstance());

        ListeIngredients liste = new ListeIngredients();
        ListeIngredients liste2 = new ListeIngredients();
        ListeIngredients liste3 = new ListeIngredients();

        liste.ajouterIngredient(ViandeInventaire.getIngredient("poulet"),200);
        liste.ajouterIngredient(LegumeInventaire.getIngredient("patate"),400);
        liste.ajouterIngredient(EpiceInventaire.getIngredient("Basilic"), 100);

        liste2.ajouterIngredient(ViandeInventaire.getIngredient("Fromage"),900);
        liste2.ajouterIngredient(LegumeInventaire.getIngredient("Pomme"),400);
        liste2.ajouterIngredient(EpiceInventaire.getIngredient("Basilic"), 300);

        liste3.ajouterIngredient(ViandeInventaire.getIngredient("poulet"),200);
        liste3.ajouterIngredient(LegumeInventaire.getIngredient("patate"),400);
        liste3.ajouterIngredient(EpiceInventaire.getIngredient("Basilic"), 1000);


        Chef chef = new Chef();

        Serveur serveur1 = new Serveur();
        Serveur serveur2 = new Serveur();

        FactoryPlats factoryPlats = new ConcreteFactoryPlat();

        PlatAuMenu pm1 = factoryPlats.creerPlat(1, "frite", 11.25);
        PlatAuMenu pm2 = factoryPlats.creerPlatEnfant(2, "poutine", 16.25, 0.5);
        PlatAuMenu pm3 = factoryPlats.creerPlatSante(3, "Poulet au basilic", 20, 3, 200, 45);

        pm1.setListeIngredients(liste);
        pm2.setListeIngredients(liste2);
        pm3.setListeIngredients(liste3);

        menu.ajoute(pm1);
        menu.ajoute(pm2);
        menu.ajoute(pm3);

        //System.out.println(menu);

        menu.positionSuivante();
        menu.retirerCourant();

        //System.out.println(menu);

        menu.ajoute(pm2);

        //System.out.println(menu);

        PlatChoisi p1 = new PlatChoisi(pm1, 1);
        PlatChoisi p2 = new PlatChoisi(pm2, 1);
        PlatChoisi p3 = new PlatChoisi(pm3, 1);

        chef.ajouterServeur(serveur1);
        chef.ajouterServeur(serveur2);

        chef.ajouterPlat(p1);
        chef.ajouterPlat(p2);
        chef.ajouterPlat(p3);

        chef.preparer();

        //System.out.println(p1);
        //System.out.println(p2);
        //System.out.println(p3);

        chef.termine();

        //System.out.println(p1);
        //System.out.println(p2);
        //System.out.println(p3);

        Facture facture = new Facture("Table 3");
        Vue vue = new Vue();
        ControllerFactures controller = new ControllerFactures(facture, vue);
        controller.connectionVue();

        Client client = new Client(1, "Med", "292");
        facture.associerClient(client);

        //System.out.println(vue.genererFacture());

        facture.ajoutePlat(p1);
        facture.ajoutePlat(p2);
        facture.ajoutePlat(p3);

        PlatChoisi p4 = new PlatChoisi(pm1, 3);

        controller.fermerFacture();

        System.out.println(vue);

        //System.out.println(vue.genererFacture());
        //System.out.println(vue);

        controller.payerFacture();

        vue.ecrireFichier(menu);

        //System.out.println(vue);
        //facture.ouvrir();
        System.out.println(vue.genererFacture());

        facture.reinitialiser("Table 4");
        System.out.println(vue);

    }



}