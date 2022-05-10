package menufact.plats.etats;

import menufact.plats.PlatChoisi;

/**
 * MdC utilisé : State
 * Interface d'EtatPlat
 * Permet l'implémentation de nouveaux états pour PlatChoisi
 */
public interface EtatPlat {
    /**
     * Configure l'état du PlatChoisi passé en paramètre pour l'objet de la classe concrète
     * @param plat Le plat devant changer d'état
     */
    public void setEtatPlat(PlatChoisi plat);

    /**
     * Donne l'état provenant de l'enum assigné à la classe concrète
     * @return L'état provenant de l'enum
     */
    public EtatsPlat getEtatPlat();
}
