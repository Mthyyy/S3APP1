package ingredients;

import java.util.ArrayList;

public class ViandeInventaire extends IngredientInventaire{

    private static ViandeInventaire instance;

    private ViandeInventaire()
    {
        listIngredient = new ArrayList<Ingredient>();
    }



    public static ViandeInventaire getInstance()
    {
        if(instance == null)
        {
            instance = new ViandeInventaire();
        }
        return instance;
    }


    public static void ajouterIngredient(String nom, String description, int quantite, EtatIngredient etat) {
        ConcreteFactoryIngredient factory = new ConcreteFactoryIngredient();
        listIngredient.add(factory.creerViande(nom,description,quantite,etat));
    }



}
