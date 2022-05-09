package tests;

import ingredients.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTest {
    Ingredient ingredient;
    @BeforeEach
    void setUp() {
        ingredient = new Ingredient();
        ingredient.setNom("Ingredient");
        ingredient.setDescription("Un Ingredient");
        ingredient.setTypeIngredient(TypeIngredient.EPICE);
    }

    @Test
    void getNom() {
        Assertions.assertEquals("Ingredient", ingredient.getNom());
    }

    @Test
    void setNom() {
        ingredient.setNom("IngredientDifferent");
        Assertions.assertEquals("IngredientDifferent", ingredient.getNom());
    }

    @Test
    void getDescription() {
        Assertions.assertEquals("Un Ingredient", ingredient.getDescription());
    }

    @Test
    void setDescription() {
        ingredient.setDescription("Un autre ingredient");
        Assertions.assertEquals("Un autre ingredient", ingredient.getDescription());
    }

    @Test
    void getTypeIngredient() {
        Assertions.assertEquals(TypeIngredient.EPICE, ingredient.getTypeIngredient());
    }

    @Test
    void setTypeIngredient() {
        ingredient.setTypeIngredient(TypeIngredient.FRUIT);
        Assertions.assertEquals(TypeIngredient.FRUIT, ingredient.getTypeIngredient());
    }

    @Test
    void classEnfant()
    {
        ingredient = new Legume();
        Assertions.assertEquals(TypeIngredient.LEGUME, ingredient.getTypeIngredient());
        ingredient = new Fruit();
        Assertions.assertEquals(TypeIngredient.FRUIT, ingredient.getTypeIngredient());
        ingredient = new Epice();
        Assertions.assertEquals(TypeIngredient.EPICE, ingredient.getTypeIngredient());
        ingredient = new Laitier();
        Assertions.assertEquals(TypeIngredient.LAITIER, ingredient.getTypeIngredient());
        ingredient = new Viande();
        Assertions.assertEquals(TypeIngredient.VIANDE, ingredient.getTypeIngredient());
    }
}