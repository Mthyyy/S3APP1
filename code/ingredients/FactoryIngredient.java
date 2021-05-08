package ingredients;

import ingredients.exceptions.IngredientException;
import menufact.facture.exceptions.FactureException;

public  class FactoryIngredient {

    public FactoryIngredient()
    {

    }

    public  Ingredient creerIngredient(String nom,String description, int quantite ,EtatIngredient etat,TypeIngredient type) throws IngredientException
    {
        Ingredient i;
        switch (type)
        {
            case EPICE: i = new Épice(nom,description,quantite,etat);
            break;

            case FRUIT : i = new Fruit(nom,description,quantite,etat);
            break;

            case LEGUME : i = new Legume(nom,description,quantite,etat);
            break;

            case VIANDE : i = new Viande(nom,description,quantite,etat);
            break;

            case LAITIER : i = new Laitier(nom,description,quantite,etat);
            break;

            default:  throw new IngredientException("Erreur de type d'ingredient");

        }

        return i;

    }

}
