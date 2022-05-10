package main.view;

import main.model.facture.Facture;
import main.model.plats.PlatChoisi;

/**
 * Cette classe sert à implmenter le desing pattern de MVC (partie Controller) de la classe facture
 */
public class FactureView {
    /**
     * Génere la facture sous forme de string
     * @param facture la facture qu'on veut générer
     * @return le string de la facture
     */
    public String genererFacture(Facture facture)
    {
        String lesPlats = new String();
        String factureGenere = new String();

        int i =1;


        factureGenere =   "Facture generee.\n" +
                "Date:" + facture.getDate() + "\n" +
                "Description: " + facture.getDescription() + "\n" +
                "Client:" + facture.getClient().getNom() + "\n" +
                "Les plats commandes:" + "\n" + lesPlats;

        factureGenere += "Seq   Plat         Prix   Quantite\n";
        for (PlatChoisi plat : facture.getPlatchoisi())
        {
            factureGenere +=  i + "     " + plat.getPlat().getDescription() +  "  " + plat.getPlat().getPrix() +  "      " + plat.getQuantite() + "\n";
            i++;
        }

        factureGenere += "          TPS:               " + facture.getTPSTotal() + "\n";
        factureGenere += "          TVQ:               " + facture.getTVQTotal() + "\n";
        factureGenere += "          Le total est de:   " + facture.getTotal() + "\n";

        return factureGenere;
    }
}
