package main.model;

import main.model.ingredients.IngredientInventaire;
import main.model.ingredients.exceptions.IngredientException;
import main.model.inventaire.Inventaire;
import main.model.plats.PlatChoisi;
import main.model.plats.etats.CompletServi;
import main.model.plats.etats.Preparation;

/**
 * Cette classe sert à gérer le chef cuisinier qui prépare les plats, gere les etats des plats et diminue l'main.model.inventaire
 * Desing pattern de singleton pour éviter qu'il y ait plus qu'un chef
 */
public class Chef {
    private static Chef instanceChef;

    private Inventaire inventaire;

    /**
     * Constructeur du chef cuisiner (prive car on doit passer par getInstance())
     */
    private Chef() {
        this.inventaire = Inventaire.getInstance();
    }

    /**
     * Méthode du modèle de conception Observer
     * Déclenche la méthode preparerPlat de Chef avec le PlatChoisi
     * @param p Le PlatChoisi pour la préparation
     * @throws IngredientException Lorsqu'un changement de quantité en main.model.inventaire est inférieur à 1
     */
    public void update(PlatChoisi p) throws IngredientException {
        preparerPlat(p);
    }

    /**
     * Prépare un plat
     * S'assure que les ingrédient sont présent
     * @param p le plat a préparer
     * @throws IngredientException s'il manque d'ingrédient
     */
    public void preparerPlat(PlatChoisi p) throws IngredientException {
        p.setEtatPlat(new Preparation());
        int index;
        IngredientInventaire ingInv;

        for (IngredientInventaire ingredient : p.getPlat().getIngredients()) {
            index = inventaire.getLesIngredients().indexOf(ingredient);
            ingInv = inventaire.getLesIngredients().get(index);

            if (ingInv.getQuantite() == ingredient.getQuantite()) {
                inventaire.retirer(ingredient);
            }
            else {
                ingInv.setQuantite(ingInv.getQuantite() - ingredient.getQuantite());
            }
        }
        p.setEtatPlat(new CompletServi());
    }

    /**
     * Fonction pour recevoir l'instance unique de Chef
     * Evite qu'il ait plus qu'un chef
     * @return
     */
    public static Chef getInstance()
    {
        if (instanceChef == null)
        {
            instanceChef = new Chef();
        }
        return instanceChef;
    }
}
