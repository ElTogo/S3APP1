package menufact.plats.etats;

import menufact.plats.PlatChoisi;

public class Commande implements EtatPlat {
    private EtatsPlat etat = EtatsPlat.COMMANDE;
    @Override
    public void setEtatPlat(PlatChoisi plat) {
        plat.setEtatPlat(this);
    }

    @Override
    public EtatsPlat getEtatPlat() {
        return etat;
    }

    @Override
    public String toString() {
        return "Commandé";
    }
}
