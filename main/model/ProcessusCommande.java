package main.model;

import main.model.ingredients.exceptions.IngredientException;
import main.model.facture.exceptions.FactureException;
import main.model.plats.PlatChoisi;

/**
 * MdC utilisé : Chain of Responsibility
 * Interface ProcessusCommande
 */
public interface ProcessusCommande {
    /**
     * MdC utilisé : Chain of Responsibility
     * Méthode du MdC Chain of Responsibility
     * @param p Le plat à envoyer
     * @throws FactureException Envoyée par une ou plusieurs méthodes surchargées
     * @throws IngredientException Envoyée par une ou plusieurs méthodes surchargées
     */
    void next(PlatChoisi p) throws FactureException, IngredientException;
}
