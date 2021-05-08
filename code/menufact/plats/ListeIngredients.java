package menufact.plats;

import ingredients.EtatIngredient;
import ingredients.FactoryIngredient;
import ingredients.Ingredient;
import ingredients.TypeIngredient;
import ingredients.exceptions.IngredientException;

import java.util.ArrayList;

public class ListeIngredients {

    private ArrayList<Ingredient> lesIngedients;
    FactoryIngredient factory;

    public ListeIngredients()
    {
         lesIngedients = new ArrayList<Ingredient>();
         factory = new FactoryIngredient();
    }
    public void ajouterIngredient(String nom, String description, int quantite , EtatIngredient etat, TypeIngredient type) throws IngredientException {

        lesIngedients.add(factory.creerIngredient(nom,description,quantite,etat,type));
    }
    public ArrayList<Ingredient> getListIngredients()
    {
        return lesIngedients;
    }


}
