package ingredients;

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
    public static void ajouterIngredient(String nom, String description, int quantite, EtatIngredient etat) {
        ConcreteFactoryIngredient factory = new ConcreteFactoryIngredient();
        listIngredient.add(factory.creerEpice(nom,description,quantite,etat));
    }
}
