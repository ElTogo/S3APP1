package tests;

import ingredients.Ingredient;
import ingredients.IngredientInventaire;
import ingredients.Legume;
import ingredients.Viande;
import ingredients.exceptions.IngredientException;
import inventaire.Inventaire;
import menufact.Chef;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.plats.etats.CompletServi;
import menufact.plats.etats.EtatPlat;
import menufact.plats.etats.EtatsPlat;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChefTest {
    Chef chef;
    Inventaire inv;
    PlatAuMenu pm;
    PlatChoisi pc;

    @org.junit.jupiter.api.Test
    void getInstance() {
        Assertions.assertNull(chef);
        chef = Chef.getInstance();
        Assertions.assertEquals(Chef.class, chef.getClass());
        Assertions.assertEquals(chef, Chef.getInstance());
    }

    @org.junit.jupiter.api.Test
    void update() throws IngredientException {
        chef = Chef.getInstance();
        inv = Inventaire.getInstance();

        Ingredient ingredient = new Viande();
        IngredientInventaire i = new IngredientInventaire(ingredient, 1);
        List<IngredientInventaire> listeIngredients = new ArrayList<>();
        listeIngredients.add(i);
        inv.ajouter(i);

        pm = new PlatAuMenu();
        pm.setIngredients(listeIngredients);
        pc = new PlatChoisi(pm, 1);

        chef.update(pc);
        inv.retirer(i);
    }

    @org.junit.jupiter.api.Test
    void preparerPlat() throws IngredientException {
        /**
         * la methode est vulnerable aux :
         * - plats choisis null
         * - plats sans ingredient
         * - inventaire null
         * - quantites plus petites que 1 en inventaire
         * - ingredients null
         *
         * Ces cas ne devraient pas arriver dans une implementation complete et donc de tels cas d'essai sont non pertinents
         * En l'occurence, les objets appeles par la methode devraient etre proteges.
         */

        chef = Chef.getInstance();
        inv = Inventaire.getInstance();

        Ingredient ingredient = new Viande();
        Ingredient ingredient2 = new Legume();
        IngredientInventaire i = new IngredientInventaire(ingredient, 1);
        IngredientInventaire i2 = new IngredientInventaire(ingredient2, 2);
        IngredientInventaire i3 = new IngredientInventaire(ingredient2, 3);
        List<IngredientInventaire> listeIngredients = new ArrayList<>();
        listeIngredients.add(i);
        listeIngredients.add(i2);
        inv.ajouter(i);
        inv.ajouter(i3);

        pm = new PlatAuMenu();
        pm.setIngredients(listeIngredients);
        pc = new PlatChoisi(pm, 1);

        Assertions.assertEquals(2, inv.getLesIngredients().size());
        chef.preparerPlat(pc);
        EtatPlat expected = new CompletServi();
        Assertions.assertEquals(expected.getClass(), pc.getEtatPlat().getClass());
        Assertions.assertEquals(1, inv.getLesIngredients().size());

        inv.retirer(i);
        inv.retirer(i3);
    }
}