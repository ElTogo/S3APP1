package menufact.plats;

import ingredients.IngredientInventaire;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe sert à gérer les plats disponible au menu
 */
public class PlatAuMenu {
    private int code;
    private String description;
    private double prix;

    private List<IngredientInventaire> ingredients;

    /**
     * Constructeur sans liste d'ingrédient
     * @param code le code du plat
     * @param description la description du plat
     * @param prix le prix du plat
     */
    public PlatAuMenu(int code, String description, double prix) {
        this.code = code;
        this.description = description;
        this.prix = prix;
        this.ingredients = new ArrayList<IngredientInventaire>();
    }

    /**
     * Constructeur avec une liste d'ingrédient
     * @param code le code du plat
     * @param description la description du plat
     * @param prix le prix du plat
     * @param ingredients la liste des ingrédients du plat
     */
    public PlatAuMenu(int code, String description, double prix, List<IngredientInventaire> ingredients) {
        this.code = code;
        this.description = description;
        this.prix = prix;
        this.ingredients = ingredients;
    }

    /**
     * Constructeur vide
     */
    public PlatAuMenu() {
    }

    /**
     * Surcharge de la fonction toString pour créé un string du plat
     * @return le string qui décrit le plat
     */
    @Override
    public String toString() {
        return "menufact.plats.PlatAuMenu{" +
                "code=" + code +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                "}\n";
    }

    /**
     * Getter du code
     * @return le code du plat
     */
    public int getCode() {
        return code;
    }

    /**
     * Setter du plat
     * @param code le code du plat
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Getter de la description
     * @return la description du plat
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter de la description
     * @param description la description du plat
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter du prix
     * @return le prix du plat
     */
    public double getPrix() {
        return prix;
    }

    /**
     * Setter du prix
     * @param prix le prix du plat
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }

    /**
     * Getter de la liste d'ingrédients
     * @return la liste d'ingrédient du plat
     */
    public List<IngredientInventaire> getIngredients() {
        return ingredients;
    }

    /**
     * Setter de la liste d'ingrédients
     * @param ingredients la liste d'ingrédients
     */
    public void setIngredients(List<IngredientInventaire> ingredients) {
        this.ingredients = ingredients;
    }
}
