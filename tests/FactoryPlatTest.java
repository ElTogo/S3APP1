import menufact.plats.FactoryPlat;
import menufact.plats.PlatAuMenu;
import menufact.plats.TypePlat;
import ingredients.IngredientInventaire;
import ingredients.Ingredient;
import ingredients.TypeIngredient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ingredients.Legume;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FactoryPlatTest {

    @Test
    void getPlat() {
        List<IngredientInventaire> listeIngredient1 = new ArrayList<IngredientInventaire>();
        listeIngredient1.add(new IngredientInventaire(new Legume(),2));
        PlatAuMenu p;
        FactoryPlat f = new FactoryPlat();
        p = f.getPlat(TypePlat.PLATAUMENU, 0,"PlatAuMenu", 10, listeIngredient1);
        Assertions.assertEquals(0, p.getCode());
        p = f.getPlat(TypePlat.PLATSANTE, 1, "PlatSante", 20, listeIngredient1, 1,2,3);
        Assertions.assertEquals("PlatSante", p.getDescription());
        p = f.getPlat(TypePlat.PLATENFANT, 2, "PlatEnfant", 5, listeIngredient1, 0.5);
        Assertions.assertEquals("PlatEnfant", p.getDescription());
        p = f.getPlat(TypePlat.PLATENFANT, 0,"PlatAuMenu", 10, listeIngredient1);
        Assertions.assertEquals(null, p);
        p = f.getPlat(TypePlat.PLATAUMENU, 1, "PlatSante", 20, listeIngredient1, 1,2,3);
        Assertions.assertEquals(null, p);
        p = f.getPlat(TypePlat.PLATAUMENU, 2, "PlatEnfant", 5, listeIngredient1, 0.5);
        Assertions.assertEquals(null, p);
    }
}