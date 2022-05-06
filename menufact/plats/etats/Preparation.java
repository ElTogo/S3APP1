package menufact.plats.etats;

import menufact.plats.PlatChoisi;

public class Preparation implements EtatPlat {
    private EtatsPlat etat = EtatsPlat.PREPARATION;

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
