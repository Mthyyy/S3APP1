package ingredients;

import ingredients.exceptions.IngredientException;
import menufact.facture.exceptions.FactureException;

public abstract class FactoryIngredient {

    public FactoryIngredient()
    {

    }

    public abstract Ingredient creerIngredient(String nom,String description, int quantite ,EtatIngredient etat,TypeIngredient type) throws IngredientException;
    public abstract Ingredient creerViande(String nom,String description, int quantite ,EtatIngredient etat);
    public abstract Ingredient creerEpice(String nom,String description, int quantite ,EtatIngredient etat);
    public abstract Ingredient creerFruit(String nom,String description, int quantite ,EtatIngredient etat);
    public abstract Ingredient creerLegume(String nom,String description, int quantite ,EtatIngredient etat);
    public abstract Ingredient creerLaitier(String nom,String description, int quantite ,EtatIngredient etat);


}
