package main.model.exceptions;

/**
 * Erreur liée à la classe Menu
 */
public class MenuException extends Exception{
    /**
     * Constructeur de MenuException
     * @param message Le message d'erreur à afficher
     */
    public MenuException(String message){
        super("MenuException: " + message);
    }
}

