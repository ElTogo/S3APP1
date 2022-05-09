package ingredients;

import ingredients.exceptions.IngredientException;

/**
 * Cette classe sert à contenir en information dans un inventaire les aliments et leur quantité associé
 */
public class IngredientInventaire {
    private Ingredient ingredient;
    private int quantite;

    /**
     * Constructeur de IngredientInventaire
     * @param ingredient l'ingrédient désiré
     * @param quantite la quantité disponible de l'ingrédient
     */
    public IngredientInventaire(Ingredient ingredient, int quantite) {
        this.ingredient = ingredient;
        this.quantite = quantite;
    }

    /**
     * Getter de la quantité
     * @return la quantité disponible de l'ingrédient
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * Setter de la quantité
     * Gère les exceptions
     * @param quantite la quantité de l'ingrédient
     * @throws IngredientException Exception si la quantité est négative
     */
    public void setQuantite(int quantite) throws IngredientException{

        if (quantite < 0)
            throw new IngredientException("Il n'est pas possible d'avoir une quantité negative");
        else
            this.quantite = quantite;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    @Override
    public boolean equals(Object o) {
        if (ingredient == ((IngredientInventaire)o).getIngredient()) {
            return true;
        }
        return false;
    }
}
