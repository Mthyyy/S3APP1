package menufact.plats;

import ingredients.*;
import ingredients.exceptions.IngredientException;

import java.util.ArrayList;

/**
 * liste des ingredient d'un platMenu
 */
public class ListeIngredients {

    private ArrayList<Ingredient> lesIngedients;
    private ConcreteFactoryIngredient factory;

    /**
     * constructeur
     */
    public ListeIngredients()
    {
         lesIngedients = new ArrayList<Ingredient>();
         factory = new ConcreteFactoryIngredient();
    }

    /**
     * Ajoute un ingredient dans la liste
     * @param ing ingredient
     * @param quantite la quantite
     * @throws IngredientException ingredient introuvable
     */
    public void ajouterIngredient(Ingredient ing , int quantite) throws IngredientException {

        lesIngedients.add(factory.creerIngredient(ing.getNom(),ing.getDescription(),quantite,ing.getEtat(),ing.getType()));
    }

    /**
     * Retourne la liste des ingredients
     * @return
     */
    public ArrayList<Ingredient> getListIngredients()
    {
        return lesIngedients;
    }

    @Override
    public String toString(){
        String stream = " ";
         for(int i = 0; i < lesIngedients.size(); i++){
             stream = stream + lesIngedients.get(i);
         }

         return stream;
    }

}
