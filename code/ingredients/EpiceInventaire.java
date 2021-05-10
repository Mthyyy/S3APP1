package ingredients;

import java.util.ArrayList;

public class EpiceInventaire  extends IngredientInventaire{
    private static EpiceInventaire instance;

    private EpiceInventaire()
    {
        listIngredient = new ArrayList<Ingredient>();

    }

    public static EpiceInventaire getInstance()
    {
        if(instance == null)
        {
            instance = new EpiceInventaire();
        }
        return instance;
    }


    public static void ajouterIngredient(String nom, String description, int quantite, EtatIngredient etat) {
        ConcreteFactoryIngredient factory = new ConcreteFactoryIngredient();
        listIngredient.add(factory.creerEpice(nom,description,quantite,etat));
    }
}
