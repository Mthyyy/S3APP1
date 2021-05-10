package ingredients;

import java.util.ArrayList;

public class LegumeInventaire extends IngredientInventaire {

    private static LegumeInventaire instance;

    private LegumeInventaire()
    {
        listIngredient = new ArrayList<Ingredient>();
    }

    /**
     * créer et retourne l'instance du singleton
     * @return ViandeInventaire
     */
    public static LegumeInventaire getInstance()
    {
        if(instance == null)
        {
            instance = new LegumeInventaire();
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
    public static void ajouterIngredient(String nom, String description, int quantite, EtatIngredient etat) {
        ConcreteFactoryIngredient factory = new ConcreteFactoryIngredient();
        listIngredient.add(factory.creerLegume(nom,description,quantite,etat));
    }
}
