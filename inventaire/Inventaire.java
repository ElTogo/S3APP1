package inventaire;

import ingredients.Ingredient;

import java.util.ArrayList;

public class Inventaire {
    private static Inventaire instanceInventaire;

    private ArrayList<Ingredient> lesIngredients = new ArrayList<Ingredient>();

    static Inventaire getInstance()
    {
        if (instanceInventaire == null)
        {
            instanceInventaire = new Inventaire();
        }
        return instanceInventaire;
    }

    public void ajouter (Ingredient ingredient)
    {
        lesIngredients.add(ingredient);
    }
    public void retirer (Ingredient ingredient) { lesIngredients.remove(ingredient); }
}
