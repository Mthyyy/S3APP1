package ingredients;

import ingredients.exceptions.IngredientException;
import menufact.facture.exceptions.FactureException;

/**
 * Createur d'ingrédient
 */
public abstract class FactoryIngredient {

    public FactoryIngredient()
    {

    }

    /**
     * Creer un ingrédient
     * @param nom nom de l'ingrédient
     * @param description description de l'ingrédient
     * @param quantite quantité de l'ingrédient
     * @param etat EtatIngrédient
     * @param type TypeIngredient
     * @return Ingrédient
     * @throws IngredientException
     */
    public abstract Ingredient creerIngredient(String nom,String description, int quantite ,EtatIngredient etat,TypeIngredient type) throws IngredientException;

    /**
     * Creer une Viande
     * @param nom nom de l'ingrédient
     * @param description description de l'ingrédient
     * @param quantite quantité de l'ingrédient
     * @param etat EtatIngrédient
     * @return Ingrédient
     */
    public abstract Ingredient creerViande(String nom,String description, int quantite ,EtatIngredient etat);

    /**
     *
     * Creer une Epice
     * @param nom nom de l'ingrédient
     * @param description description de l'ingrédient
     * @param quantite quantité de l'ingrédient
     * @param etat EtatIngrédient
     * @return Ingrédient
     */
    public abstract Ingredient creerEpice(String nom,String description, int quantite ,EtatIngredient etat);

    /**
     * Creer un Fruit
     * @param nom nom de l'ingrédient
     * @param description description de l'ingrédient
     * @param quantite quantité de l'ingrédient
     * @param etat EtatIngrédient
     * @return Ingrédient
     */
    public abstract Ingredient creerFruit(String nom,String description, int quantite ,EtatIngredient etat);

    /**
     * Creer un Legume
     * @param nom nom de l'ingrédient
     * @param description description de l'ingrédient
     * @param quantite quantité de l'ingrédient
     * @param etat EtatIngrédient
     * @return Ingrédient
     */
    public abstract Ingredient creerLegume(String nom,String description, int quantite ,EtatIngredient etat);

    /**
     * Creer un Laitier
     * @param nom nom de l'ingrédient
     * @param description description de l'ingrédient
     * @param quantite quantité de l'ingrédient
     * @param etat EtatIngrédient
     * @return Ingrédient
     */
    public abstract Ingredient creerLaitier(String nom,String description, int quantite ,EtatIngredient etat);


}
