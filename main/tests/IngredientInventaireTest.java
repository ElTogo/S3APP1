package main.tests;

import main.model.ingredients.Ingredient;
import main.model.ingredients.IngredientInventaire;
import main.model.ingredients.Laitier;
import main.model.ingredients.Legume;
import main.model.ingredients.exceptions.IngredientException;
import org.junit.jupiter.api.Assertions;

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
        Assertions.assertEquals("IngredientException: Il n'est pas possible d'avoir une quantité negative", e.getMessage());
    }

    @org.junit.jupiter.api.Test
    void equals() {
        Ingredient i = new Laitier();
        IngredientInventaire j = new IngredientInventaire(i, 2);
        Assertions.assertEquals(false, i.equals(null));
    }
}