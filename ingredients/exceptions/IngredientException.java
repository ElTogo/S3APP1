package ingredients.exceptions;

/**
 * Erreur liée à la classe Ingredient et ses enfants
 */
public class IngredientException extends Exception{
    /**
     * Constructeur d'IngredientException
     * @param message Le message d'erreur à afficher
     */
    public IngredientException(String message){
        super("IngredientException: " + message);
    }
}
