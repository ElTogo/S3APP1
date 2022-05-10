package main.model.plats.etats;

import main.model.plats.PlatChoisi;

/**
 * MdC utilisé : State
 * État de plat : En préparation
 */
public class Preparation implements EtatPlat {
    private EtatsPlat etat = EtatsPlat.PREPARATION;

    /**
     * Configure l'état du plat passé en paramètre pour lui-même
     * @param plat Le plat devant chagner d'état
     */
    @Override
    public void setEtatPlat(PlatChoisi plat) {
        plat.setEtatPlat(this);
    }

    /**
     * Donne l'état provenant de l'enum
     * @return L'état provenant de l'enum
     */
    @Override
    public EtatsPlat getEtatPlat() {
        return etat;
    }


    /**
     * Méthode toString de Preparation
     * @return une string décrivant la classe
     */
    @Override
    public String toString() {
        return "En préparation";
    }
}
