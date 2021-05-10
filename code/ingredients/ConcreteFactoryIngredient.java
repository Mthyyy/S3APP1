package ingredients;

import ingredients.exceptions.IngredientException;

/**
 * Instance concrete de Factory Ingredient
 */
public class ConcreteFactoryIngredient implements FactoryIngredient {


    @Override
    public Ingredient creerIngredient(String nom, String description, int quantite, EtatIngredient etat, TypeIngredient type) throws IngredientException {
        Ingredient i;
        switch (type)
        {
            case EPICE: i = creerEpice(nom,description,quantite,etat);
                break;

            case FRUIT : i = creerFruit(nom,description,quantite,etat);
                break;

            case LEGUME : i = creerLegume(nom,description,quantite,etat);
                break;

            case VIANDE : i = creerViande(nom,description,quantite,etat);
                break;

            case LAITIER : i = creerLaitier(nom,description,quantite,etat);
                break;

            default:  throw new IngredientException("Erreur de type d'ingredient");
        }

        return i;
    }

    @Override
    public Ingredient creerViande(String nom, String description, int quantite, EtatIngredient etat) {

        return new Viande(nom,description,quantite,etat);
    }

    @Override
    public Ingredient creerEpice(String nom, String description, int quantite, EtatIngredient etat) {
        return new Epice(nom,description,quantite,etat);
    }

    @Override
    public Ingredient creerFruit(String nom, String description, int quantite, EtatIngredient etat) {
        return new Fruit(nom,description,quantite,etat);
    }

    @Override
    public Ingredient creerLegume(String nom, String description, int quantite, EtatIngredient etat) {
        return new Legume(nom,description,quantite,etat);
    }

    @Override
    public Ingredient creerLaitier(String nom, String description, int quantite, EtatIngredient etat) {
       return new Laitier(nom,description,quantite,etat);
    }
}
