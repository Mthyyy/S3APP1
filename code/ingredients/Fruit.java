package ingredients;

/**
 * Un Fruit
 */
public class Fruit extends Ingredient{
    public Fruit(String nom, String description,int quantite,EtatIngredient etat) {
        this.nom = nom;
        this.description = description;
        this.quantite = quantite;
        this.etat = etat;
        this.type = TypeIngredient.FRUIT;
        this.inventaire = FruitInventaire.getInstance();
    }

    @Override
    public String toString() {
        String c;
        c = " " + String.valueOf(quantite) + etat.getUnite() +  " de "+ nom;
        return c;
    }
}
