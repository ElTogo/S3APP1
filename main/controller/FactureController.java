package main.controller;

import main.model.ingredients.exceptions.IngredientException;
import main.view.FactureView;
import main.model.Client;
import main.model.facture.Facture;
import main.model.facture.FactureEtat;
import main.model.facture.exceptions.FactureException;
import main.model.plats.PlatChoisi;
import main.model.plats.exceptions.PlatException;

/**
 * Cette classe sert à implémenter un desing pattern de MVC (partie Controller) pour la classe Facture
 */
public class FactureController {
    private Facture facture;
    private FactureView factureView;

    /**
     * Constructeur
     * @param f la facture
     * @param fw le facture View
     */
    public FactureController(Facture f, FactureView fw)
    {
        this.facture = f;
        this.factureView = fw;
    }

    /**
     * Génerer la facture en string
     * @return
     */
    public String genererFacture()
    {
        return factureView.genererFacture(facture);
    }

    /**
     * Génerer un string qui décrit les infos de la facture
     * @return les infos de la factures
     */
    @Override
    public String toString() {
        return facture.toString();
    }

    /**
     * Ajouter un client à la facture
     * @param client le client qu'on veut associé à la facture
     */
    public void associerClient (Client client) {facture.associerClient(client);}

    /**
     * Mettre la facture à l'état payer
     */
    public void payer() {facture.payer();}

    /**
     * Mettre la facture à l'état fermer
     */
    public void fermer() {facture.fermer();}

    /**
     * Mettre la facture à l'état ouvrir
     * @throws FactureException si la facture est à l'état payée
     */
    public void ouvrir() throws FactureException {facture.ouvrir();}

    /**
     * Getter de l'état
     * @return l'état de la facture
     */
    public FactureEtat getEtat() {return facture.getEtat();}

    /**
     * Ajoute un plat à la facture
     * @param p le plat à ajouter
     * @throws FactureException si la facture n'est pas à l'état ouvert
     * @throws PlatException
     * @throws IngredientException s'il manque d'ingrédient
     */
    public void ajoutePlat(PlatChoisi p) throws FactureException, PlatException, IngredientException {facture.ajoutePlat(p);}
}
