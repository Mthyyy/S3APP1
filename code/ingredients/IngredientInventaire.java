package ingredients;

import ingredients.exceptions.IngredientException;

import java.util.ArrayList;

/**
 * Classe Abstraite des Inventaires des Ingrédients
 * @author Mathieu Lefebvre
 * @version 1.0
 */
public abstract class IngredientInventaire {

    protected static ArrayList<Ingredient> listIngredient;

    /**
     * Constructeur
     */
    public  IngredientInventaire() {
        listIngredient = new ArrayList<Ingredient>();
    }

    /**
     * Retourne la quantité disponible de l'ingrédients
     * @param nom nom de l'ingrédient
     * @return la quantié d'ingrédient
     * @throws IngredientException si le nom en parametre est introuvable
     */
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

    /**
     * Set la quantié de l'ingrédient présent dans L'inventaire
     * @param nom nom de l'ingrédient
     * @param quantite quantité de l'ingrédients
     * @throws IngredientException si le nom en parametre est introuvable
     */
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

    /**
     * Retourne un ingrédients
     * @param nom le nom de l'ingrédients voulue
     * @return un ingrédient
     * @throws IngredientException si le nom en parametre est introuvable
     */
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
