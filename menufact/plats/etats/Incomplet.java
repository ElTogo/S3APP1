package menufact.plats.etats;

import menufact.plats.PlatChoisi;

public class Incomplet implements EtatPlat {
    private EtatsPlat etat = EtatsPlat.INCOMPLET;

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
