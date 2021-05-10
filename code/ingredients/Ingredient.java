package ingredients;

public abstract class Ingredient {
    protected String nom;
    protected String description;
    protected int quantite;
    protected EtatIngredient etat;
    protected TypeIngredient type;
    protected IngredientInventaire inventaire;
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

    public TypeIngredient getType(){return type;};
    public EtatIngredient getEtat()
    {
        return etat;
    }

    public void setQuantite(int q)
    { quantite = q;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public IngredientInventaire getInventaire()
    {
        return inventaire;
    }
}
