package menufact;

import ingredients.Liquide;
import ingredients.TypeIngredient;
import ingredients.exceptions.IngredientException;
import menufact.plats.ListeIngredients;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.plats.Chef;
import menufact.plats.Serveur;

public class MyTestMenuFact2 {

    public static void main(String[] args) throws IngredientException {

        ListeIngredients liste = new ListeIngredients();

        liste.ajouterIngredient("poulet","allo,",50,new Liquide(), TypeIngredient.VIANDE);

        System.out.println(liste.getListIngredients().get(0).ToString());

        Chef chef = new Chef();

        Serveur serveur1 = new Serveur();
        Serveur serveur2 = new Serveur();

        PlatAuMenu pm1 = new PlatAuMenu(1, "frites", 11.25);
        PlatAuMenu pm2 = new PlatAuMenu(2, "poutine", 16.25);

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