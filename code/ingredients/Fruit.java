package ingredients;

public class Fruit extends Ingredient{
    public Fruit(String nom, String description,int quantite,EtatIngredient etat) {
        this.nom = nom;
        this.description = description;
        this.quantite = quantite;
        this.etat = etat;
    }

    @Override
    public String toString() {
        String c;
        c = String.valueOf(quantite) + etat.getUnite() +  "de "+ nom;
        return c;
    }
}
