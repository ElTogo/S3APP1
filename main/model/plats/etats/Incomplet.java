package main.model.plats.etats;

import main.model.plats.PlatChoisi;

/**
 * Desing pattern State
 * Cette classe permet de contenir l'etat du plat et de contenir les methodes necessaires
 */
public class Incomplet implements EtatPlat {
    private EtatsPlat etat = EtatsPlat.INCOMPLET;

    /**
     * Surcharge de la fonction setEtat plat
     * @param plat Le plat devant changer d'etat
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
        return "Incomplète";
    }
}
