package ingredients;

/**
 * Etat liquide pour un ingredient, c'est un singleton
 * @author Mathieu Lefebvre
 * @version 1.0
 * @see EtatIngredient
 */
public class Solide extends EtatIngredient {

    /**
     * String qui contient l'unite
     */
    protected String unite;

    /**
     * Instance du singleton
     */
    private static Solide instance;


    private Solide(){

        unite = "g";
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
     * Retourne l'Instance du singleton
     * @return Solide
     */
    public static EtatIngredient getInstance()
    {
        if(instance == null)
        {
            instance = new Solide();

        }
        return instance;
    }
}
