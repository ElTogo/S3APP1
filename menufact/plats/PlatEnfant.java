package menufact.plats;

import ingredients.IngredientInventaire;

import java.util.ArrayList;
import java.util.List;
/**
 * Cette classe sert à gérer un type de plat, les plat pour enfant avec des portions plus petite
 */
public class PlatEnfant extends PlatAuMenu{
    private double proportion;

    /**
     * Constructeur vide
     */
    public PlatEnfant() {
    }

    /**
     * Constructeur sans liste d'ingrédients
     * @param code le code du plat
     * @param description la description du plat
     * @param prix le prix du plat
     * @param proportion la portion comparé à un PlatAuMenu
     */
    public PlatEnfant(int code, String description, double prix, double proportion) {
        super(code, description, prix);
        this.proportion = proportion;
    }

    /**
     * Constructeur avec liste d'ingrédients
     * @param code le code du plat
     * @param description la description du plat
     * @param prix le prix du plat
     * @param ingredients la liste d'ingrédient
     * @param proportion la portion comparé à un plat au menu
     */
    public PlatEnfant(int code, String description, double prix, List<IngredientInventaire> ingredients, double proportion) {
        super(code, description, prix, ingredients);
        this.proportion = proportion;
    }

    /**
     * Getter de la portion
     * @return la portion comparé à un PlatAuMenu
     */
    public double getProportion() {
        return proportion;
    }

    /**
     * Surcharge de la fonction toString qui permet d'avoir une description du plat
     * @return la string qui décrit le plat
     */
    @Override
    public String toString() {
        return "PlatEnfant{" +
                "proportion=" + proportion +
                "} " + super.toString();
    }
}
