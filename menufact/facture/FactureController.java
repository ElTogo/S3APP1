package menufact.facture;

import ingredients.exceptions.IngredientException;
import menufact.Client;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;
import menufact.plats.exceptions.PlatException;
//TODO : Javadoc (class complete)
public class FactureController {
    private Facture facture;
    private FactureView factureView;

    public FactureController(Facture f, FactureView fw)
    {
        this.facture = f;
        this.factureView = fw;
    }

    public String genererFacture()
    {
        return factureView.genererFacture(facture);
    }

    @Override
    public String toString() {
        return facture.toString();
    }

    public void associerClient (Client client) {facture.associerClient(client);}
    public void payer() {facture.payer();}
    public void fermer() {facture.fermer();}
    public void ouvrir() throws FactureException {facture.ouvrir();}
    public FactureEtat getEtat() {return facture.getEtat();}
    public void ajoutePlat(PlatChoisi p) throws FactureException, PlatException, IngredientException {facture.ajoutePlat(p);}
}
