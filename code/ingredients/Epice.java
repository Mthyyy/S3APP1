package ingredients;

/**
 * Ingredient epice
 * @author Mathieu Lefebvre
 * @version 1.0
 * @see Ingredient
 */
public class Epice extends Ingredient{
    public Epice(String nom, String description, int quantite, EtatIngredient etat) {
        this.nom = nom;
        this.description = description;
        this.quantite = quantite;
        this.etat = etat;
        this.type = TypeIngredient.EPICE;
        this.inventaire = EpiceInventaire.getInstance();
    }

    @Override
    public String toString() {
        String c;
        c = " " + String.valueOf(quantite) + etat.getUnite() +  " de "+ nom;
        return c;
    }
}
