package menufact;

import ingredients.exceptions.IngredientException;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

public interface ProcessusCommande {

    void next(PlatChoisi p) throws FactureException, IngredientException;
}
