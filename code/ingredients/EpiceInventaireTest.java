package ingredients;

import ingredients.exceptions.IngredientException;
import menufact.plats.ListeIngredients;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EpiceInventaireTest {
    @Test
    public void testAjouterIngredient() throws IngredientException {
        EpiceInventaire inventaire = EpiceInventaire.getInstance();

        inventaire.ajouterIngredient("Basilic", "c bon", 50, Solide.getInstance());

        assertEquals(inventaire.getListIngredient().get(0).getNom(), "Basilic");
        assertEquals(inventaire.getListIngredient().get(0).getDescription(), "c bon");
        assertEquals(inventaire.getListIngredient().get(0).getQuantite(), 50);
        assertEquals(inventaire.getListIngredient().get(0).getEtat(), Solide.getInstance());
    }

}