package ingredients;

/**
 * etat Liquide
 */
public class Liquide extends EtatIngredient{

    protected String unite;
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
