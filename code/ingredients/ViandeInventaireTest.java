package ingredients;

import ingredients.exceptions.IngredientException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ViandeInventaireTest {
    @Test
    public void testAjouterIngredient() throws IngredientException {
        ViandeInventaire inventaire = ViandeInventaire.getInstance();

        inventaire.getListIngredient().clear();

        inventaire.ajouterIngredient("Boeuf", "c bon", 50, Solide.getInstance());

        assertEquals(inventaire.getListIngredient().get(0).getNom(), "Boeuf");
        assertEquals(inventaire.getListIngredient().get(0).getDescription(), "c bon");
        assertEquals(inventaire.getListIngredient().get(0).getQuantite(), 50);
        assertEquals(inventaire.getListIngredient().get(0).getEtat(), Solide.getInstance());
    }

}