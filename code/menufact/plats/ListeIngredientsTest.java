package menufact.plats;

import ingredients.*;
import ingredients.exceptions.IngredientException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListeIngredientsTest {
    @Test
    public void testAjouterIngredient() throws IngredientException {
        int qte = 2;
        ConcreteFactoryIngredient factory = new ConcreteFactoryIngredient();
        Ingredient ingredient = factory.creerViande("Poulet", "Volaille", 50, Solide.getInstance());
        ListeIngredients liste = new ListeIngredients();
        liste.ajouterIngredient(ingredient, 50);

        assertEquals(ingredient.getNom(), liste.getListIngredients().get(0).getNom());
        assertEquals(ingredient.getDescription(), liste.getListIngredients().get(0).getDescription());
        assertEquals(ingredient.getQuantite(), liste.getListIngredients().get(0).getQuantite());
        assertEquals(ingredient.getInventaire(), liste.getListIngredients().get(0).getInventaire());
    }

}