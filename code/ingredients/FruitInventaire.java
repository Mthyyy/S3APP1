package ingredients;

import java.util.ArrayList;

public class FruitInventaire extends IngredientInventaire {

    private static FruitInventaire instance;

    private FruitInventaire()
    {
        listIngredient = new ArrayList<Ingredient>();
    }

    public static FruitInventaire getInstance()
    {
        if(instance == null)
        {
            instance = new FruitInventaire();
        }
        return instance;
    }


    public static void ajouterIngredient(String nom, String description, int quantite, EtatIngredient etat) {
        ConcreteFactoryIngredient factory = new ConcreteFactoryIngredient();
        listIngredient.add(factory.creerFruit(nom,description,quantite,etat));
    }
}
