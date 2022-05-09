package menufact.facture;

import menufact.Client;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

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
    public void ajoutePlat(PlatChoisi p) throws FactureException {facture.ajoutePlat(p);}
}
