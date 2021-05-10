package ingredients;

import ingredients.exceptions.IngredientException;

import java.util.ArrayList;

public class FruitInventaire extends IngredientInventaire {

    private static FruitInventaire instance;

    private FruitInventaire()
    {
        listIngredient = new ArrayList<Ingredient>();
    }

    /**
     * créer et retourne l'instance du singleton
     * @return ViandeInventaire
     */
    public static FruitInventaire getInstance()
    {
        if(instance == null)
        {
            instance = new FruitInventaire();
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
    public static void ajouterIngredient(String nom, String description, int quantite, EtatIngredient etat) throws IngredientException {
        try
        {
            if(quantite <=0)
            {
                throw new IngredientException("On ne peut pas avoir une quantite null ou negative d'ingredient");
            }

            ConcreteFactoryIngredient factory = new ConcreteFactoryIngredient();
            listIngredient.add(factory.creerFruit(nom,description,quantite,etat));
        }

        catch (IngredientException e){
            System.out.println(e.getMessage());
        }

    }

    public ArrayList<Ingredient> getListIngredient(){
        return listIngredient;
    }
}
