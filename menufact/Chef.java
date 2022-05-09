package menufact;

import ingredients.IngredientInventaire;
import ingredients.exceptions.IngredientException;
import inventaire.Inventaire;
import menufact.plats.PlatChoisi;
import menufact.plats.etats.CompletServi;
import menufact.plats.etats.Preparation;
//TODO : Javadoc (class complete)
public class Chef {
    private static Chef instanceChef;

    private Inventaire inventaire;
    private Chef() {
        this.inventaire = Inventaire.getInstance();
    }

    public void update(PlatChoisi p) throws IngredientException {
        preparerPlat(p);
    }

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

    public static Chef getInstance()
    {
        if (instanceChef == null)
        {
            instanceChef = new Chef();
        }
        return instanceChef;
    }
}
