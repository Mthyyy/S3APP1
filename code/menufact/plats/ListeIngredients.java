package menufact.plats;

import ingredients.*;
import ingredients.exceptions.IngredientException;

import java.util.ArrayList;

/**
 * La classe listeIngredients est la liste des ingredients dans un PlatAuMenu
 * @author Mathieu Lefebvre
 * @version 1.0
 * @see Ingredient
 */
public class ListeIngredients {

    /**
     * lesIngredients contient tous les ingredients
     */
    private ArrayList<Ingredient> lesIngedients;

    /**
     * factory est la factory qui cree les ingredients a ajouter dans la liste
     */
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

    /**
     * Surcharge la methode toString
     * @return
     */
    @Override
    public String toString(){
        String stream = " ";
         for(int i = 0; i < lesIngedients.size(); i++){
             stream = stream + lesIngedients.get(i);
         }

         return stream;
    }

}
