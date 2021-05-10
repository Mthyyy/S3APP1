package ingredients;

/**
 * etat Solide
 */
public class Solide extends EtatIngredient {

    protected String unite;
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
