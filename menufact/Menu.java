package menufact;

import menufact.exceptions.MenuException;
import menufact.plats.PlatAuMenu;

import java.util.ArrayList;

/**
 * Cette classe sert à garder en mémoir le menu, le plat courant et la description
 */
public class Menu {
    private String description;
    private int courant;
    private ArrayList<PlatAuMenu> plat = new ArrayList<PlatAuMenu>();

    /**
     * Constructeur qui créé un menu vide avec uniquement une description
     * @param description la description du menu
     */
    public Menu(String description) {
        this.description = description;
    }

    /**
     * Ajoute un plat au menu
     * @param p le plat a ajouter au menu
     */
    void ajoute (PlatAuMenu p)
    {
        plat.add(p);
    }

    /**
     * Setter de la position courante du plat actif
     * @param i la position desirer
     */
    public void position(int i)
    {
        courant = i;
    }

    /**
     * Getter du plat courant
     * @return le plat courant
     */
    public PlatAuMenu platCourant()
    {
        return plat.get(courant);
    }

    /**
     * Augmenter de un la position du plat courant
     * @throws MenuException si la position est hors limite
     */
    public void positionSuivante() throws MenuException
    {
        if (courant+1 >= plat.size())
            throw new MenuException("On depasse le nombre maximale de plats.");
        else
            courant++;
    }

    /**
     * Diminue de un la position du plat courant
     * @throws MenuException si la position est hors limite
     */
    public void positionPrecedente() throws MenuException
    {
        if (courant-1 < 0)
            throw new MenuException("On depasse le nombre minimale de plats");
        else
            courant--;
    }

    /**
     * Surcharge de la fonction toString qui donne une description du menu
     * @return la string qui décrit le menu
     */
    @Override
    public String toString() {
        return "menufact.Menu{" +
                "description='" + description + '\'' +
                ", courant=" + courant +
                ", plat=" + "\n" + plat +
                '}';
    }
}
