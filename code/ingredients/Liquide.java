package ingredients;

public class Liquide extends EtatIngredient{

    protected String unite;

    public Liquide(){

        unite = "ml";
    }

    public String getUnite()
    {
        return unite;
    }
}
