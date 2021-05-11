package ingredients;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;

import static org.junit.jupiter.api.Assertions.*;

class IngredientInventaireTest {



    @Test
    void getQuantite() {
        ViandeInventaire.getInstance();
        ViandeInventaire.ajouterIngredient("poulet","a",10,Solide.getInstance());

        try {
            assertEquals(10,ViandeInventaire.getInstance().getQuantite("poulet"));
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
    @Test
    void getQuantiteInvalide() {
        ViandeInventaire.getInstance();
        ViandeInventaire.ajouterIngredient("poulet","a",10,Solide.getInstance());

        try {
            assertEquals(0,ViandeInventaire.getInstance().getQuantite("poulewwwwwt"));
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }


    @Test
    void setQuantiteInvalide() {

        ViandeInventaire.getInstance();
        ViandeInventaire.ajouterIngredient("dinde","a",10,Solide.getInstance());

        try {
           ViandeInventaire.getInstance().setQuantite("dindawdde",30);
           assertEquals(0,ViandeInventaire.getInstance().getQuantite("dinde"));
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
    @Test
    void setQuantite() {

        ViandeInventaire.getInstance();
        ViandeInventaire.ajouterIngredient("dinde","a",10,Solide.getInstance());

        try {
            ViandeInventaire.getInstance().setQuantite("dinde",30);
            assertEquals(30,ViandeInventaire.getInstance().getQuantite("dinde"));
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    @Test
    void getIngredient() {
        ViandeInventaire.getInstance();
        ViandeInventaire.ajouterIngredient("poulet","a",10,Solide.getInstance());
        try{
            assertNotEquals(null,ViandeInventaire.getIngredient("poulet"));
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    @Test
    void getIngredientInvalide() {
        ViandeInventaire.getInstance();
        ViandeInventaire.ajouterIngredient("poulet","a",10,Solide.getInstance());
        try{
            assertNotEquals(null,ViandeInventaire.getIngredient("pouletwwwwwwww"));
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}