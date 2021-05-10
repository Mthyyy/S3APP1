package ingredients;

import java.util.ArrayList;

/**
 * Inventaire de la viande
 */
public class ViandeInventaire extends IngredientInventaire{

    private static ViandeInventaire instance;

    /**
     * Constructeur
     */
    private ViandeInventaire()
    {
        listIngredient = new ArrayList<Ingredient>();
    }


    /**
     * créer et retourne l'instance du singleton
     * @return ViandeInventaire
     */
    public static ViandeInventaire getInstance()
    {
        if(instance == null)
        {
            instance = new ViandeInventaire();
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

        boolean ingredientTrouver = false;
        for(int i = 0 ; i < listIngredient.size();i++)
        {
            if(listIngredient.get(i).getNom() == nom)
            {
                ingredientTrouver = true;
                System.out.println("Erreur Ingredient deja present");
            }
        }
        if(!ingredientTrouver)
        {
            ConcreteFactoryIngredient factory = new ConcreteFactoryIngredient();
            listIngredient.add(factory.creerViande(nom,description,quantite,etat));
        }

    }



}
