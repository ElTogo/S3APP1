package main.model.plats.etats;

import main.model.plats.PlatChoisi;

/**
 * Desing pattern State
 * Cette classe permet de contenir l'etat du plat et de contenir les methodes necessaires
 */
public class Commande implements EtatPlat {

    private EtatsPlat etat = EtatsPlat.COMMANDE;

    /**
     * Surcharge de la fonction setEtatPlat
     * @param plat le plat a changer l'etat
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
     * Surccharge de la fonction toString
     * @return le string de l'etat
     */
    @Override
    public String toString() {
        return "Commandé";
    }
}
