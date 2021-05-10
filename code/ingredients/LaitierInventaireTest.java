package ingredients;

import ingredients.exceptions.IngredientException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LaitierInventaireTest{
    @Test
    public void testAjouterIngredient() throws IngredientException {
        LaitierInventaire inventaire = LaitierInventaire.getInstance();

        inventaire.ajouterIngredient("Lait", "c bon", 50, Solide.getInstance());

        assertEquals(inventaire.getListIngredient().get(0).getNom(), "Lait");
        assertEquals(inventaire.getListIngredient().get(0).getDescription(), "c bon");
        assertEquals(inventaire.getListIngredient().get(0).getQuantite(), 50);
        assertEquals(inventaire.getListIngredient().get(0).getEtat(), Solide.getInstance());
    }
}