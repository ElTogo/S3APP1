package menufact.plats.etats;

import menufact.plats.PlatChoisi;

public class CompletServi implements EtatPlat {
    private EtatsPlat etat = EtatsPlat.COMPLETSERVI;

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
        return "Complété et servi";
    }
}
