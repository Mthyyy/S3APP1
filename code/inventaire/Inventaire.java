package inventaire;

import ingredients.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class Inventaire {
    private ArrayList<Ingredient> lesIngredients = new ArrayList<Ingredient>();

    public void ajouter (Ingredient ingredient)
    {
        lesIngredients.add(ingredient);
    }

}
