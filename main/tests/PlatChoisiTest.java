package main.tests;

import main.model.ingredients.Ingredient;
import main.model.ingredients.IngredientInventaire;
import main.model.plats.PlatAuMenu;
import main.model.plats.PlatChoisi;
import main.model.plats.etats.EtatsPlat;
import main.model.plats.etats.Preparation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class PlatChoisiTest {

    PlatChoisi p;

    @BeforeEach
    void setUp() {
        ArrayList<IngredientInventaire> f = new ArrayList<IngredientInventaire>();
        f.add(new IngredientInventaire(new Ingredient(), 2));
        p = new PlatChoisi(new PlatAuMenu(1,"Plat",2, f),2);
    }

    @Test
    void testToString() {
        Assertions.assertNotEquals(0,p.toString());
    }

    @Test
    void getQuantite() {
        Assertions.assertEquals(2,p.getQuantite());
    }

    @Test
    void setQuantite() {
        p.setQuantite(1);
        Assertions.assertEquals(1,p.getQuantite());
    }

    @Test
    void getPlat() {
        Assertions.assertEquals("Plat", p.getPlat().getDescription());
    }

    @Test
    void getEtatPlat() {
        Assertions.assertEquals(EtatsPlat.COMMANDE, p.getEtatPlat().getEtatPlat());
    }

    @Test
    void setEtatPlat() {
        p.setEtatPlat(new Preparation());
        Assertions.assertEquals(EtatsPlat.PREPARATION, p.getEtatPlat().getEtatPlat());
    }
}