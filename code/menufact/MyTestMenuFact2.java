package menufact;

import ingredients.Liquide;
import ingredients.Solide;
import ingredients.TypeIngredient;
import ingredients.exceptions.IngredientException;
import menufact.plats.*;

public class MyTestMenuFact2 {

    public static void main(String[] args) throws IngredientException {

        ListeIngredients liste = new ListeIngredients();

        liste.ajouterIngredient("poulet","allo,",50,Liquide.getInstance(), TypeIngredient.VIANDE);

        ListeIngredients liste2 = new ListeIngredients();

        liste2.ajouterIngredient("patates","allo,",50,Solide.getInstance(), TypeIngredient.LEGUME);

        System.out.println(liste.getListIngredients().get(0));

        Chef chef = new Chef();

        Serveur serveur1 = new Serveur();
        Serveur serveur2 = new Serveur();

        FactoryPlats factoryPlats = new ConcreteFactoryPlat();

        PlatAuMenu pm1 = factoryPlats.creerPlat(1, "frite", 11.25);
        PlatAuMenu pm2 = factoryPlats.creerPlatEnfant(2, "poutine", 16.25, 0.5);

        pm1.setListeIngredients(liste);
        pm2.setListeIngredients(liste2);

        System.out.println(pm2);

        PlatChoisi p1 = new PlatChoisi(pm1, 1);
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