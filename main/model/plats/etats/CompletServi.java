package main.model.plats.etats;

import main.model.plats.PlatChoisi;

/**
 * Desing Pattern State
 * Cette classe permet de garder l'etat completServi et les methodes associe
 */
public class CompletServi implements EtatPlat {
    private EtatsPlat etat = EtatsPlat.COMPLETSERVI;

    /**
     * Surcharge de la fonction setEtatPlat
     * @param plat le plat a cheger l'etat
     */
    @Override
    public void setEtatPlat(PlatChoisi plat) {
        plat.setEtatPlat(this);
    }

    /**
     * Surcharge de la fonction getEtatPlat
     * @return l'etat du plat
     */
    @Override
    public EtatsPlat getEtatPlat() {
        return etat;
    }

    /**
     * Surcharge de la fonction toString
     * @return la string qui decrit l'etat
     */
    @Override
    public String toString() {
        return "Complété et servi";
    }
}
