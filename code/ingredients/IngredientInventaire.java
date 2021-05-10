package ingredients;

import ingredients.exceptions.IngredientException;

import java.util.ArrayList;

public abstract class IngredientInventaire {

    protected static ArrayList<Ingredient> listIngredient;
    public  IngredientInventaire() {
        listIngredient = new ArrayList<Ingredient>();
    }

    public int getQuantite(String nom) throws IngredientException {
        boolean ingredientTrouver = false;

        for(int i = 0 ; i < listIngredient.size();i++)
        {
            if(listIngredient.get(i).getNom() == nom)
            {
                ingredientTrouver =true;
                return listIngredient.get(i).getQuantite();
            }
        }
        if(!ingredientTrouver) throw new IngredientException("Ingredients introuvable");
        return 0;
    }

    public void setQuantite(String nom, int quantite) throws IngredientException{

        boolean ingredientTrouver = false;

        for(int i = 0 ; i < listIngredient.size();i++)
        {
            if(listIngredient.get(i).getNom() == nom)
            {
                ingredientTrouver =true;
                listIngredient.get(i).setQuantite(quantite);
            }
        }
        if(!ingredientTrouver) throw new IngredientException("Ingredients introuvable");

        if (quantite < 0)
            throw new IngredientException("Il n'est pas possible d'avoir une quantité negative");

    }

    public static Ingredient getIngredient(String nom) throws IngredientException {
        boolean ingredientTrouver = false;

        for(int i = 0 ; i < listIngredient.size();i++)
        {
            if(listIngredient.get(i).getNom() == nom)
            {
                ingredientTrouver =true;
                return listIngredient.get(i);
            }
        }
        if(!ingredientTrouver) throw new IngredientException("Ingredients introuvable");
        return null;
    }







}
