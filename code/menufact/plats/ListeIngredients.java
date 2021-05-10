package menufact.plats;

import ingredients.*;
import ingredients.exceptions.IngredientException;

import java.util.ArrayList;

public class ListeIngredients {

    private ArrayList<Ingredient> lesIngedients;
    FactoryIngredient factory;

    public ListeIngredients()
    {
         lesIngedients = new ArrayList<Ingredient>();
         factory = new ConcreteFactoryIngredient();
    }
    public void ajouterIngredient(Ingredient ing , int quantite) throws IngredientException {

        lesIngedients.add(factory.creerIngredient(ing.getNom(),ing.getDescription(),quantite,ing.getEtat(),ing.getType()));
    }

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
