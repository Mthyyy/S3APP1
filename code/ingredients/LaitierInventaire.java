package ingredients;

import java.util.ArrayList;

public class LaitierInventaire extends IngredientInventaire  {
    private static LaitierInventaire instance;

    private LaitierInventaire()
    {
        listIngredient = new ArrayList<Ingredient>();
    }

    public static LaitierInventaire getInstance()
    {
        if(instance == null)
        {
            instance = new LaitierInventaire();
        }
        return instance;
    }


    public static void ajouterIngredient(String nom, String description, int quantite, EtatIngredient etat) {
        ConcreteFactoryIngredient factory = new ConcreteFactoryIngredient();
        listIngredient.add(factory.creerLaitier(nom,description,quantite,etat));
    }
}
