package menufact.plats.exceptions;

/**
 * Erreur liée à la classe Plat
 */
public class PlatException extends Exception {
    /**
     * Constructeur de PlatException
     * @param message Le message d'erreur à afficher
     */
    public PlatException(String message){
        super("PlatException: " + message);
    }
}
