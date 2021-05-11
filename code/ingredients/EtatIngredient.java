package ingredients;

/**
 * Etat physique de l'ingrédients
 * @author Mathieu Lefebvre
 * @version 1.0
 */
public abstract class EtatIngredient {

     protected String unite;

     /**
      * constructeur
      */
     public EtatIngredient()
     {

     }

     /**
      * Unite de mesure
      * @return l'unite de mesure
      */
     public abstract String getUnite();

}
