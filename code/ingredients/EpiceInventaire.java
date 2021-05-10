package ingredients;

import ingredients.exceptions.IngredientException;

import java.util.ArrayList;

/**
 * Gere l'inventaire des epice
 */
public class EpiceInventaire  extends IngredientInventaire{
    private static EpiceInventaire instance;

    private EpiceInventaire()
    {
        listIngredient = new ArrayList<Ingredient>();

    }

    /**
     * créer et retourne l'instance du singleton
     * @return ViandeInventaire
     */
    public static EpiceInventaire getInstance()
    {
        if(instance == null)
        {
            instance = new EpiceInventaire();
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
    public static void ajouterIngredient(String nom, String description, int quantite, EtatIngredient etat) throws IngredientException{
        try{
            if(quantite <= 0)
            {
                throw new IngredientException("On ne peut pas avoir une quantite null ou negative d'ingredient");
            }
            ConcreteFactoryIngredient factory = new ConcreteFactoryIngredient();
            listIngredient.add(factory.creerEpice(nom,description,quantite,etat));
        }

        catch (IngredientException e){
            System.out.println(e.getMessage());
        }

    }

    public ArrayList<Ingredient> getListIngredient(){
        return listIngredient;
    }
}
