package menufact.plats;

import menufact.plats.etats.Commande;
import menufact.plats.etats.EtatPlat;
//TODO : Javadoc (class complete)
public class PlatChoisi {
    private PlatAuMenu plat;
    private int quantite;

    private EtatPlat etatPlat;

    public PlatChoisi(PlatAuMenu plat, int quantite) {
        this.plat = plat;
        this.quantite = quantite;
        this.etatPlat = new Commande();
    }

    @Override
    public String toString() {
        return "menufact.plats.PlatChoisi{" +
                "quantite=" + quantite +
                ", plat=" + plat +
                " : " + etatPlat +
                '}';
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public PlatAuMenu getPlat() {
        return plat;
    }

    public EtatPlat getEtatPlat() {
        return etatPlat;
    }

    public void setEtatPlat(EtatPlat etatPlat) {
        this.etatPlat = etatPlat;
    }
}
