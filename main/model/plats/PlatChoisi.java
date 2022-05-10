package main.model.plats;

import main.model.plats.etats.Commande;
import main.model.plats.etats.EtatPlat;

/**
 * Cette classe sert à gerer les plats qui sont choisi par le consomateur et qui vont être ajouer à la facture
 */
public class PlatChoisi {
    private PlatAuMenu plat;
    private int quantite;

    private EtatPlat etatPlat;

    /**
     * Constructeur
     * @param plat le plat commandé
     * @param quantite le nombre de plat commandé
     */
    public PlatChoisi(PlatAuMenu plat, int quantite) {
        this.plat = plat;
        this.quantite = quantite;
        this.etatPlat = new Commande();
    }

    /**
     * Surcharge de toString qui permet d'avoir une description des plats comandé
     * @return la string qui décrit la commande
     */
    @Override
    public String toString() {
        return "main.model.plats.PlatChoisi{" +
                "quantite=" + quantite +
                ", plat=" + plat +
                " : " + etatPlat +
                '}';
    }

    /**
     * Getter de la quantité
     * @return la quantité de plat commandé
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * Setter de la quantité
     * @param quantite la quantité de plat commandé
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    /**
     * Getter du plat commandé
     * @return le plat commandé
     */
    public PlatAuMenu getPlat() {
        return plat;
    }

    /**
     * Getter de l'état du plat
     * @return l'état du plat commandé
     */
    public EtatPlat getEtatPlat() {
        return etatPlat;
    }

    /**
     * Setter de l'état du plat
     * @param etatPlat l'état du plat commandé
     */
    public void setEtatPlat(EtatPlat etatPlat) {
        this.etatPlat = etatPlat;
    }
}
