package inventaire;

import ingredients.Ingredient;
import ingredients.IngredientInventaire;

import java.util.ArrayList;

public class Inventaire {
    private static Inventaire instanceInventaire;

    private ArrayList<IngredientInventaire> lesIngredients = new ArrayList<IngredientInventaire>();

    private Inventaire() {
    }

    public static Inventaire getInstance()
    {
        if (instanceInventaire == null)
        {
            instanceInventaire = new Inventaire();
        }
        return instanceInventaire;
    }

    public void ajouter (IngredientInventaire ingredient)
    {
        lesIngredients.add(ingredient);
    }

    public void retirer (IngredientInventaire ingredient) { lesIngredients.remove(ingredient); }

    public ArrayList<IngredientInventaire> getLesIngredients() {
        return lesIngredients;
    }
}
