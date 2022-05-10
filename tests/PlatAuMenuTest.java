package tests;

import ingredients.Ingredient;
import ingredients.IngredientInventaire;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatEnfant;
import menufact.plats.PlatSante;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlatAuMenuTest {
    PlatAuMenu p = new PlatAuMenu();

    @BeforeEach
    void setUp() {
        p = new PlatAuMenu(0, "Plat", 1);
    }

    @Test
    void testToString() {
        Assertions.assertEquals("menufact.plats.PlatAuMenu{code=0, description='Plat', prix=1.0}\n", p.toString());
    }

    @Test
    void getCode() {
        Assertions.assertEquals(0,p.getCode());
    }

    @Test
    void setCode() {
        p.setCode(1);
        Assertions.assertEquals(1,p.getCode());
    }

    @Test
    void getDescription() {
        Assertions.assertEquals("Plat", p.getDescription());
    }

    @Test
    void setDescription() {
        p.setDescription("Un Plat");
        Assertions.assertEquals("Un Plat", p.getDescription());
    }

    @Test
    void getPrix() {
        Assertions.assertEquals(1,p.getPrix());
    }

    @Test
    void setPrix() {
        p.setPrix(2);
        Assertions.assertEquals(2,p.getPrix());
    }

    @Test
    void getIngredients() {
        Assertions.assertEquals(0, p.getIngredients().size());
    }

    @Test
    void setIngredients() {
        ArrayList<IngredientInventaire> e = new ArrayList<IngredientInventaire>();
        e.add(new IngredientInventaire(new Ingredient(), 2));
        p.setIngredients(e);
        Assertions.assertEquals(1, p.getIngredients().size());
    }

    @Test
    void testPlatEnfant()
    {
        ArrayList<IngredientInventaire> f = new ArrayList<IngredientInventaire>();
        f.add(new IngredientInventaire(new Ingredient(), 2));
        PlatEnfant e = new PlatEnfant(1,"PlatEnfant", 1, 0.5);
        Assertions.assertEquals(0.5, e.getProportion());
        e = new PlatEnfant(2,"Plat Enfant",8, f, 0.8);
        Assertions.assertNotEquals(0,e.toString().length());
        e = new PlatEnfant();
        Assertions.assertEquals(null,e.getDescription());
    }

    @Test
    void testPlatSante() {
        ArrayList<IngredientInventaire> f = new ArrayList<IngredientInventaire>();
        f.add(new IngredientInventaire(new Ingredient(), 2));
        PlatSante s = new PlatSante(3, "PlatSante", 5, 1,1,1);
        Assertions.assertEquals(1,s.getKcal());
        Assertions.assertEquals(1, s.getChol());
        Assertions.assertEquals(1, s.getGras());
        s = new PlatSante(1,"Plat Sante", 1, f, 2,2,2);
        Assertions.assertNotEquals(0, s.toString().length());
        s = new PlatSante();
        Assertions.assertEquals(null, s.getDescription());
    }
}