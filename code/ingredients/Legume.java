package ingredients;

/**
 * Legume
 */
public class Legume extends Ingredient{
    public Legume(String nom, String description,int quantite,EtatIngredient etat) {
        this.nom = nom;
        this.description = description;
        this.quantite = quantite;
        this.etat = etat;
        this.type = TypeIngredient.LEGUME;
        this.inventaire = LegumeInventaire.getInstance();
    }

    @Override
    public String toString() {
        String c;
        c = " " + String.valueOf(quantite) + etat.getUnite() +  " de "+ nom;
        return c;
    }
}
