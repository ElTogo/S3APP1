package menufact.facture;

import menufact.Client;
import menufact.facture.exceptions.FactureException;

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
    public double sousTotal(){return facture.sousTotal();}
    public double total(){return facture.sousTotal();}
    public void payer() {facture.payer();}
    public void fermer() {facture.fermer();}
    public void ouvrir() throws FactureException {facture.ouvrir();}
    public FactureEtat getEtat() {return facture.getEtat();}

}