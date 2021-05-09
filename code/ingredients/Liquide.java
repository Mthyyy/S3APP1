package ingredients;

public class Liquide extends EtatIngredient{

    protected String unite;
    private static Liquide instance;
    private Liquide(){

        unite = "ml";
    }

    public String getUnite()
    {
        return unite;
    }

    public static EtatIngredient getInstance() {
            if(instance == null)
            {
                instance = new Liquide();

            }
            return instance;
    }
}
