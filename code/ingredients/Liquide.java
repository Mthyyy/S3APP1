package ingredients;

/**
 * Etat liquide pour un ingredient, c'est un singleton
 * @author Mathieu Lefebvre
 * @version 1.0
 * @see EtatIngredient
 */
public class Liquide extends EtatIngredient{

    /**
     * String qui contient l'unite
     */
    protected String unite;

    /**
     * Instance du singleton
     */
    private static Liquide instance;

    /**
     * Constructeur
     */
    private Liquide(){

        unite = "ml";
    }

    /**
     * Retourne l'unite de mesure
     * @return String unite
     */
    public String getUnite()
    {
        return unite;
    }

    /**
     * retourne l'instance du singleton
     * @return Liquide
     */
    public static EtatIngredient getInstance() {
            if(instance == null)
            {
                instance = new Liquide();

            }
            return instance;
    }
}
