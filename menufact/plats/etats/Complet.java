package menufact.plats.etats;

import menufact.plats.PlatChoisi;

public class Complet implements EtatPlat {
    private EtatsPlat etat = EtatsPlat.COMPLET;

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
        return etat.toString();
    }
}
