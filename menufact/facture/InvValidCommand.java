package menufact.facture;

import ingredients.IngredientInventaire;
import inventaire.Inventaire;
import menufact.ProcessusCommande;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;
import menufact.plats.etats.Incomplet;

import java.util.List;

public class InvValidCommand implements ProcessusCommande {

    /**
     *
     * @param p le plat à valider
     * @returns
     * @throws FactureException
     */
    //TODO : faire la javadoc
    public boolean invValidation(PlatChoisi p) throws FactureException
    {
        List<IngredientInventaire> ingredientInventaires = Inventaire.getInstance().getLesIngredients();

        if (!p.getPlat().getIngredients().isEmpty() || p.getPlat().getIngredients() != null) {

            for (IngredientInventaire ingredient : p.getPlat().getIngredients()) {

                if (ingredientInventaires.contains(ingredient)) {
                    //TODO : regarder le bug pk ca entre pas
                    int index = ingredientInventaires.indexOf(ingredient);

                    if (ingredient.getQuantite() > ingredientInventaires.get(index).getQuantite()) {
                        p.setEtatPlat(new Incomplet());
                        return false;
                    }
                }
                else {
                    p.setEtatPlat(new Incomplet());
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void next(PlatChoisi p) throws FactureException {
        if (!invValidation(p)) {
            throw new FactureException("L'inventaire doit contenir tous les ingrédients d'un plat en quantité suffisante pour le facturer.");
        }
    }
}
