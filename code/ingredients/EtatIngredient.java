package ingredients;

/**
 * Etat physique de l'ingrédients
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
