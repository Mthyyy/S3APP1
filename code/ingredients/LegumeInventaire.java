package ingredients;

import java.util.ArrayList;

public class LegumeInventaire extends IngredientInventaire {

    private static LegumeInventaire instance;

    private LegumeInventaire()
    {
        listIngredient = new ArrayList<Ingredient>();
    }

    public static LegumeInventaire getInstance()
    {
        if(instance == null)
        {
            instance = new LegumeInventaire();
        }
        return instance;
    }


    public static void ajouterIngredient(String nom, String description, int quantite, EtatIngredient etat) {
        ConcreteFactoryIngredient factory = new ConcreteFactoryIngredient();
        listIngredient.add(factory.creerLegume(nom,description,quantite,etat));
    }
}
