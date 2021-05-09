package ingredients;

public class Epice extends Ingredient{
    public Epice(String nom, String description, int quantite, EtatIngredient etat) {
        this.nom = nom;
        this.description = description;
        this.quantite = quantite;
        this.etat = etat;
    }

    @Override
    public String ToString() {
        String c;
        c = String.valueOf(quantite) + etat.getUnite() +  " de "+ nom;
        return c;
    }
}
