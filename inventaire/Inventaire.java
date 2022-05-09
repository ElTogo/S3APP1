package inventaire;

import ingredients.Ingredient;
import ingredients.IngredientInventaire;

import java.util.ArrayList;

/**
 * Cette classe sert à garder un inventaire des ingrédients
 * Une implémentation de singleton assure qu'il n'y ait qu'un inventaire actif
 */
public class Inventaire {
    private static Inventaire instanceInventaire;

    private ArrayList<IngredientInventaire> lesIngredients = new ArrayList<IngredientInventaire>();

    /**
     * Constructeur vide
     */
    private Inventaire() {
    }

    /**
     * Fonction pour recevoir l'instance unique de Inventaire
     * @return l'objet Inventaire du programme
     */
    public static Inventaire getInstance()
    {
        if (instanceInventaire == null)
        {
            instanceInventaire = new Inventaire();
        }
        return instanceInventaire;
    }

    /**
     * Ajoute un ingredient a l'inventaire
     * @param ingredient l'ingredient a ajouter
     */
    public void ajouter (IngredientInventaire ingredient)
    {
        lesIngredients.add(ingredient);
    }

    /**
     * Retire un ingredient de l'inventaire
     * @param ingredient l'ingredient a retirer
     */
    public void retirer (IngredientInventaire ingredient) { lesIngredients.remove(ingredient); }

    /**
     * Retourne la liste des ingredient
     * @return la liste des ingredient
     */
    public ArrayList<IngredientInventaire> getLesIngredients() {
        return lesIngredients;
    }
}
