package menufact.plats;

import ingredients.*;
import ingredients.exceptions.IngredientException;

import java.util.ArrayList;

public class ListeIngredients {

    private ArrayList<Ingredient> lesIngedients;
    FactoryIngredient factory;

    public ListeIngredients()
    {
         lesIngedients = new ArrayList<Ingredient>();
         factory = new ConcreteFactoryIngredient();
    }
    public void ajouterIngredient(String nom, String description, int quantite , EtatIngredient etat, TypeIngredient type) throws IngredientException {

        lesIngedients.add(factory.creerIngredient(nom,description,quantite,etat,type));
    }
    public void ajouterViande(String nom, String description, int quantite , EtatIngredient etat) {

        lesIngedients.add(factory.creerViande(nom,description,quantite,etat));
    }
    public void ajouterLaitier(String nom, String description, int quantite , EtatIngredient etat) {

        lesIngedients.add(factory.creerLaitier(nom,description,quantite,etat));
    }
    public void ajouterEpice(String nom, String description, int quantite , EtatIngredient etat) {

        lesIngedients.add(factory.creerEpice(nom,description,quantite,etat));
    }
    public void ajouterFruit(String nom, String description, int quantite , EtatIngredient etat) {

        lesIngedients.add(factory.creerFruit(nom,description,quantite,etat));
    }
    public void ajouterLegume(String nom, String description, int quantite , EtatIngredient etat) {

        lesIngedients.add(factory.creerLegume(nom,description,quantite,etat));
    }
    public ArrayList<Ingredient> getListIngredients()
    {
        return lesIngedients;
    }


}
