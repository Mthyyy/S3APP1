package ingredients;

public class Solide extends EtatIngredient {

    protected String unite;
    private static Solide instance;
    private Solide(){

        unite = "g";
    }

    public String getUnite()
    {
        return unite;
    }

    public static EtatIngredient getInstance()
    {
        if(instance == null)
        {
            instance = new Solide();

        }
        return instance;
    }
}
