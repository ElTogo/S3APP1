package main.model.ingredients;

/**
 * Classe Ingredient
 * Classe pouvant être étendu par des classes enfant afin de créer de nouveaux ingrédients
 */
public class Ingredient {
    private String nom;
    private String description;
    private TypeIngredient typeIngredient;

    /**
     * Getter du nom
     * @return le nom de l'ingrédient
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter du nom
     * @param nom le nom de l'ingrédient
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getter de la description
     * @return la description de l'ingrédient
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter de la descriptiom
     * @param description la description de l'ingrédient
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter du type
     * @return le type de l'ingrédient
     */
    public TypeIngredient getTypeIngredient() {
        return typeIngredient;
    }

    /**
     * Setter du type
     * @param typeIngredient le type de l'ingrédient
     */
    public void setTypeIngredient(TypeIngredient typeIngredient) {
        this.typeIngredient = typeIngredient;
    }
}
