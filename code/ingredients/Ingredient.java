package ingredients;

public abstract class Ingredient {
    protected String nom;
    protected String description;
    protected int quantite;
    protected EtatIngredient etat;

    public Ingredient()
    {

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite()
    {
        return quantite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
