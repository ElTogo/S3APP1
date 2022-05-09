package menufact.plats;

import ingredients.IngredientInventaire;

import java.util.ArrayList;
import java.util.List;
//TODO : Javadoc (class complete)
public class PlatEnfant extends PlatAuMenu{
    private double proportion;

    public PlatEnfant() {
    }

    public PlatEnfant(int code, String description, double prix, double proportion) {
        super(code, description, prix);
        this.proportion = proportion;
    }

    public PlatEnfant(int code, String description, double prix, List<IngredientInventaire> ingredients, double proportion) {
        super(code, description, prix, ingredients);
        this.proportion = proportion;
    }

    public double getProportion() {
        return proportion;
    }

    @Override
    public String toString() {
        return "PlatEnfant{" +
                "proportion=" + proportion +
                "} " + super.toString();
    }
}
