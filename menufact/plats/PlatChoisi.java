package menufact.plats;

import menufact.plats.PlatAuMenu;
import menufact.plats.etats.EtatPlat;

public class PlatChoisi {
    private PlatAuMenu plat;
    private int quantite;

    private EtatPlat etatPlat;

    public PlatChoisi(PlatAuMenu plat, int quantite) {
        this.plat = plat;
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "menufact.plats.PlatChoisi{" +
                "quantite=" + quantite +
                ", plat=" + plat +
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
