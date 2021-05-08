package menufact;

import ingredients.Liquide;
import ingredients.Solide;
import ingredients.TypeIngredient;
import ingredients.exceptions.IngredientException;
import menufact.exceptions.MenuException;
import menufact.facture.Facture;
import menufact.facture.exceptions.FactureException;
import menufact.plats.ListeIngredients;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.plats.PlatSante;
public class MyTestMenuFact2 {

    public static void main(String[] args) throws IngredientException {

        ListeIngredients liste = new ListeIngredients();

        liste.ajouterIngredient("poulet","allo,",50,new Liquide(), TypeIngredient.VIANDE);

        System.out.println(liste.getListIngredients().get(0).ToString());


    }



}