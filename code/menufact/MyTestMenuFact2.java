package menufact;

import ingredients.*;
import ingredients.exceptions.IngredientException;
import menufact.exceptions.MenuException;
import menufact.plats.*;
import menufact.*;

public class MyTestMenuFact2 {

    public static void main(String[] args) throws IngredientException, MenuException {
        ViandeInventaire.getInstance();
        LegumeInventaire.getInstance();

        Menu menu = Menu.getInstance("Menu du restaurant");

        ViandeInventaire.ajouterIngredient("poulet","allo",100,Solide.getInstance());
        LegumeInventaire.ajouterIngredient("patate","allo",50,Solide.getInstance());

        ListeIngredients liste = new ListeIngredients();

        liste.ajouterIngredient(ViandeInventaire.getIngredient("poulet"),50);

        ListeIngredients liste2 = new ListeIngredients();

        liste2.ajouterIngredient(LegumeInventaire.getIngredient("patate"),50);


        Chef chef = new Chef();

        Serveur serveur1 = new Serveur();
        Serveur serveur2 = new Serveur();

        FactoryPlats factoryPlats = new ConcreteFactoryPlat();

        PlatAuMenu pm1 = factoryPlats.creerPlat(1, "frite", 11.25);
        PlatAuMenu pm2 = factoryPlats.creerPlatEnfant(2, "poutine", 16.25, 0.5);

        pm1.setListeIngredients(liste);
        pm2.setListeIngredients(liste2);

        menu.ajoute(pm1);
        menu.ajoute(pm2);

        menu.positionSuivante();

        System.out.println(menu);

        System.out.println(menu.platCourant());

        System.out.println(menu.getPlat(1));
        System.out.println(menu.getPlat(3));

        PlatChoisi p1 = new PlatChoisi(pm1, 3);
        PlatChoisi p2 = new PlatChoisi(pm2, 1);

        chef.ajouterServeur(serveur1);
        chef.ajouterServeur(serveur2);

        chef.ajouterPlat(p1);
        chef.ajouterPlat(p2);

        chef.preparer();

        System.out.println(p1);
        System.out.println(p2);

        chef.termine();

        System.out.println(p1);
        System.out.println(p2);
    }



}