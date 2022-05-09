package menufact.facture;

import ingredients.Ingredient;
import ingredients.IngredientInventaire;
import inventaire.Inventaire;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;
import menufact.plats.etats.Incomplet;

import java.util.List;

public class InvValidCommand {
    /**
     *
     * @param p le plat à valider
     * @return
     * @throws FactureException
     */
    //TODO : faire la javadoc
    static public boolean invValidation(PlatChoisi p) throws FactureException
    {
        List<IngredientInventaire> ingredientInventaires = Inventaire.getInstance().getLesIngredients();

        if (!p.getPlat().getIngredients().isEmpty() || p.getPlat().getIngredients() != null) {

            for (IngredientInventaire ingredient : p.getPlat().getIngredients()) {

                if (ingredientInventaires.contains(ingredient)) {
                    //TODO : regarder le bug pk ca entre pas
                    int index = ingredientInventaires.indexOf(ingredient);

                    if (ingredient.getQuantite() > ingredientInventaires.get(index).getQuantite()) {
                        p.setEtatPlat(new Incomplet());
                        throw new FactureException("Tous les ingrédients d'un plat doivent être en quantité suffisante dans l'inventaire pour être facturé.");
                    }
                }
                else {
                    p.setEtatPlat(new Incomplet());
                    throw new FactureException("Tous les ingrédients d'un plat doivent être en inventaire pour être facturé.");
                }
            }
        }
        return true;
    }
}
