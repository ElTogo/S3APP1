package menufact;

import inventaire.Inventaire;
import menufact.plats.PlatChoisi;
import menufact.plats.etats.Preparation;

public class Chef {
    private static Chef instanceChef;
    private Chef() {
        Inventaire.getInstance();
    }

    public void update(PlatChoisi p) {
        preparerPlat(p);
    }

    public void preparerPlat(PlatChoisi p) {
        p.setEtatPlat(new Preparation());
        // TODO: withdraw ingredients from inventory
        // TODO: set meal state to complete
        // TODO: set selected meal to ordered when created
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
