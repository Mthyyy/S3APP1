package ingredients;

public class Legume extends Ingredient{
    public Legume(String nom, String description,int quantite,EtatIngredient etat) {
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
