package menufact.plats;

import ingredients.IngredientInventaire;

import java.util.ArrayList;
import java.util.List;

/**
 * Desing Pattern : Factory
 * Cette classe sert à
 */
public class FactoryPlat {
    
    /**
     * DESIGN PATTER : FACTORY
     * Créer un objet du type demander et le retourne. Remplacement des constructeurs.
     * (Cette version ne retourne que des type PlatSante. Dautre version avec différentes signatures sont disponible)
     * @param type le type de plat désiré
     * @param code le code du plat
     * @param description la description du plat
     * @param prix le prix du plat
     * @param ingredients la listes des ingrédients nécessaires
     * @param arg1 le premier argument variable
     * @param arg2 le deuxième argument variable
     * @param arg3 le troisième argument variable
     * @return un objet du type désiré
     */
    public PlatAuMenu getPlat(TypePlat type, int code, String description, double prix, List<IngredientInventaire> ingredients, double arg1, double arg2, double arg3)
    {
        if (type == TypePlat.PLATSANTE)
        {
            return new PlatSante(code, description, prix, ingredients, arg1, arg2, arg3);
        }
        return null;
    }

    /**
     * DESIGN PATTER : FACTORY
     * Créer un objet du type demander et le retourne. Remplacement des constructeurs.
     * (Cette version ne retourne que des type PlatAuMenu. Dautre version avec différentes signatures sont disponible)
     * @param type le type du plat désiré
     * @param code le code du plat
     * @param description la description du plat
     * @param prix le prix du plat
     * @param ingredients la listes des ingrédients nécessaires
     * @return un objet du type désiré
     */
    public PlatAuMenu getPlat(TypePlat type, int code, String description, double prix, List<IngredientInventaire> ingredients)
    {
        if (type == TypePlat.PLATAUMENU)
        {
            return new PlatAuMenu(code, description, prix, ingredients);
        }
        return null;
    }

    /**
     * DESIGN PATTER : FACTORY
     * Créer un objet du type demander et le retourne. Remplacement des constructeurs.
     (Cette version ne retourne que des type PlatSante. Dautre version avec différentes signatures sont disponible)
     * @param type le type du plat désiré
     * @param code le code du plat
     * @param description la description du plat
     * @param prix le prix du plat
     * @param ingredients la listes des ingrédients nécessaires
     * @param arg1 le premier argument variable
     * @return
     */
    public PlatAuMenu getPlat(TypePlat type, int code, String description, double prix, List<IngredientInventaire> ingredients, double arg1)
    {
        if (type == TypePlat.PLATENFANT)
        {
            return new PlatEnfant(code, description, prix, ingredients, arg1);
        }
        return null;
    }
}
