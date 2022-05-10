package main.model.facture.exceptions;

/**
 * Erreur liée à la classe Facture
 */
public class FactureException extends Exception{
    /**
     * Constructeur de FactureException
     * @param message Le message d'erreur à afficher
     */
    public FactureException(String message){
        super("FactureException: " + message);
   }
}
