package menufact.facture;

import ingredients.IngredientInventaire;
import inventaire.Inventaire;
import menufact.ProcessusCommande;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;
import menufact.plats.etats.Incomplet;

import java.util.List;

/**
 * Desing Pattern Command
 * Desing Patter Chain Of Resposability
 */
public class ValidationCommand implements ProcessusCommande {

    /**
     * Valide si le plat peut être ajouter ou non
     * Valide les types d'ingrédients disponible et leur quantite
     * @param p le plat à valider
     * @returns si oui ou non le plat peut etre cuisine
     * @throws FactureException
     */
    public boolean invValidation(PlatChoisi p) throws FactureException
    {
        List<IngredientInventaire> ingredientInventaires = Inventaire.getInstance().getLesIngredients();

        if (!p.getPlat().getIngredients().isEmpty() || p.getPlat().getIngredients() != null) {

            for (IngredientInventaire ingredient : p.getPlat().getIngredients()) {

                if (ingredientInventaires.contains(ingredient)) {
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

    /**
     * Surcharge de la fonction next
     * @param p le plat choisi
     * @throws FactureException Si on ne peut ajouter le plat
     */
    @Override
    public void next(PlatChoisi p) throws FactureException {
        if (!invValidation(p)) {
            throw new FactureException("L'inventaire doit contenir tous les ingrédients d'un plat en quantité suffisante pour le facturer.");
        }
    }
}
