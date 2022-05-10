package tests;

import ingredients.*;
import inventaire.Inventaire;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventaireTest {
    Inventaire inv;

    @BeforeEach
    void setUp() {
        inv = Inventaire.getInstance();

    }

    @Test
    void getInstance() {
        IngredientInventaire ing=new IngredientInventaire(new Viande(), 3);
        inv.ajouter(ing);
        Assertions.assertEquals(Inventaire.getInstance().getLesIngredients(), inv.getLesIngredients());
        inv.retirer(ing);
    }

    @Test
    void ajouter() {
        IngredientInventaire ing=new IngredientInventaire(new Viande(), 2);
        inv.ajouter(ing);
        Assertions.assertEquals(2, inv.getLesIngredients().get(0).getQuantite());
        inv.retirer(ing);
    }

    @Test
    void retirer() {
        IngredientInventaire ing=new IngredientInventaire(new Viande(), 2);
        inv.ajouter(ing);
        inv.retirer(ing);
        Assertions.assertEquals(0, inv.getLesIngredients().size());

    }

    @Test
    void getLesIngredients() {
        IngredientInventaire ing1 = new IngredientInventaire(new Viande(),2);
        IngredientInventaire ing2 = new IngredientInventaire(new Laitier(), 3);
        inv.ajouter(ing1);
        inv.ajouter(ing2);
        Assertions.assertEquals(2, inv.getLesIngredients().size());
        inv.retirer(ing1);
        inv.retirer(ing2);
    }
}