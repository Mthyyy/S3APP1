package ingredients;

/**
 * Un ingrédient
 */
public abstract class Ingredient {
    protected String nom;
    protected String description;
    protected int quantite;
    protected EtatIngredient etat;
    protected TypeIngredient type;
    protected IngredientInventaire inventaire;

    /**
     * Constructeur
     */
    public Ingredient()
    {

    }

    /**
     * retourne nom de l'ingérdient
     * @return String nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Set le nom de l'ingredient
     * @param nom nom de l'ingredient
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Quantite de l'ingredient
     * @return int
     */
    public int getQuantite()
    {
        return quantite;
    }

    /**
     * retourne le Type d'ingredient
     * @return TypeIngredient
     */
    public TypeIngredient getType(){return type;};

    /**
     * retourne l'etat de l'ingredient
     * @return EtatIngredient
     */
    public EtatIngredient getEtat()
    {
        return etat;
    }

    /**
     * set la quantite de l'ingredient
     * @param q int quantite
     */
    public void setQuantite(int q)
    { quantite = q;
    }

    /**
     * retourne la description de l'ingredient
     * @return String description
     */
    public String getDescription() {
        return description;
    }

    /**
     * set la description de l'ingredient
     * @param description String description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * retourne un instance de ingredientInventaire
     * @return IngredientInventaire
     */
    public IngredientInventaire getInventaire()
    {
        return inventaire;
    }
}
