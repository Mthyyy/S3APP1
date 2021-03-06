package ingredients;

/**
 * Ingredient viande
 * @author Mathieu Lefebvre
 * @version 1.0
 * @see Ingredient
 */
public class Viande extends Ingredient{


    public Viande(String nom, String description,int quantite, EtatIngredient etat) {
            this.nom = nom;
            this.description = description;
            this.quantite = quantite;
            this.etat = etat;
            this.type = TypeIngredient.VIANDE;
            this.inventaire = ViandeInventaire.getInstance();
    }


    @Override
    public String toString() {
        String c;
        c = " " + String.valueOf(quantite) + etat.getUnite() +  " de "+ nom;
        return c;
    }
}
