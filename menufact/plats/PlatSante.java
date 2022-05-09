package menufact.plats;

import ingredients.IngredientInventaire;
import menufact.plats.PlatAuMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe sert à gérer un type de plat, les plat santé
 */
public class PlatSante extends PlatAuMenu {
    private double kcal;
    private double chol;
    private double gras;

    /**
     * Constructeur sans liste d'ingrédient
     * @param code le code du plat
     * @param description la description du plat
     * @param prix le prix du plat
     * @param kcal le nombre de millier de calories
     * @param chol le niveau de cholestérole du plat
     * @param gras la quantité de gras dans le plat
     * */
    public PlatSante(int code, String description, double prix, double kcal, double chol, double gras) {
        super(code, description, prix);
        this.kcal = kcal;
        this.chol = chol;
        this.gras = gras;
    }

    /**
     * Constructeur avec liste d'ingrédient
     * @param code le code du plat
     * @param description la descritpion du plat
     * @param prix le prix du plat
     * @param ingredients la liste d'ingrédient
     * @param kcal le nombre de milier de calories
     * @param chol le niveau de cholestérole
     * @param gras la quantité de gras dans le plat
     */
    public PlatSante(int code, String description, double prix, List<IngredientInventaire> ingredients, double kcal, double chol, double gras) {
        super(code, description, prix, ingredients);
        this.kcal = kcal;
        this.chol = chol;
        this.gras = gras;
    }

    /**
     * Constructeur vide
     */
    public PlatSante() {
    }

    /**
     * Surcharge de la fonction toString qui donne une decscription du plat
     * @return la string qui décrit le plat
     */
    @Override
    public String toString() {
        return "menufact.plats.PlatSante{" +
                "kcal=" + kcal +
                ", chol=" + chol +
                ", gras=" + gras +
                "} " + super.toString();
    }

    /**
     * Getter du nombre de calorie
     * @return le nombre de milier de calories
     */
    public double getKcal() {
        return kcal;
    }

    /**
     * Getter du niveau de cholestérole
     * @return le niveau de cholestérole du plat
     */
    public double getChol() {
        return chol;
    }

    /**
     * Getter de la quantité de gras
     * @return la quantité de gras dans le plat
     */
    public double getGras() {
        return gras;
    }
}
