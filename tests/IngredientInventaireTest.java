package tests;

import ingredients.Ingredient;
import ingredients.IngredientInventaire;
import ingredients.Legume;
import ingredients.exceptions.IngredientException;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class IngredientInventaireTest {
    IngredientInventaire inv;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        inv = new IngredientInventaire(new Legume(), 3);
    }

    @org.junit.jupiter.api.Test
    void getQuantite() {
        Assertions.assertEquals(3, inv.getQuantite());
    }

    @org.junit.jupiter.api.Test
    void setQuantite() throws IngredientException {
        inv.setQuantite(2);
        Assertions.assertEquals(2, inv.getQuantite());
        IngredientException e = Assertions.assertThrows(IngredientException.class, () -> {inv.setQuantite(-2);});
        Assertions.assertEquals("Il n'est pas possible d'avoir une quantité negative", e.getMessage());
    }
}