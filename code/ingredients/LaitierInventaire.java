package ingredients;

import ingredients.exceptions.IngredientException;

import java.util.ArrayList;

/**
 * Inventaire des produits laitier
 */
public class LaitierInventaire extends IngredientInventaire  {
    private static LaitierInventaire instance;

    private LaitierInventaire()
    {
        listIngredient = new ArrayList<Ingredient>();
    }

    /**
     * créer et retourne l'instance du singleton
     * @return ViandeInventaire
     */
    public static LaitierInventaire getInstance()
    {
        if(instance == null)
        {
            instance = new LaitierInventaire();
        }
        return instance;
    }

    /**
     * Ajoute un Ingrédient dans l'inventaire
     * @param nom nom de l'ingrédient
     * @param description description de L'ingrédient
     * @param quantite quantité de l'ingrédient
     * @param etat EtatIngredient solide ou liquide
     */
    public static void ajouterIngredient(String nom, String description, int quantite, EtatIngredient etat) {
        try
        {
            if(quantite <=0)
            {
                throw new IngredientException("On ne peut pas avoir une quantite null ou negative d'ingredient");
            }

            ConcreteFactoryIngredient factory = new ConcreteFactoryIngredient();
            listIngredient.add(factory.creerLaitier(nom,description,quantite,etat));
        }

        catch (IngredientException e){
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Ingredient> getListIngredient(){
        return listIngredient;
    }
}
