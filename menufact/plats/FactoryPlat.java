package menufact.plats;

public class FactoryPlat {
    /**
     * DESIGN PATTER : FACTORY
     * Créer un objet du type demander et le retourne. Remplacement des constructeurs.
     * (Cette version ne retourne que des type PlatSante. Dautre version avec différentes signatures sont disponible)
     * @param type le type de plat désiré
     * @param code le code du plat
     * @param description la description du plat
     * @param prix le prix du plat
     * @param arg1 le premier argument variable
     * @param arg2 le deuxième argument variable
     * @param arg3 le troisième argument variable
     * @return un objet du type désiré
     */
    public PlatAuMenu getPlat(TypePlat type, int code, String description, double prix, double arg1, double arg2, double arg3)
    {
        if (type == TypePlat.PLATSANTE)
        {
            return new PlatSante(code, description, prix, arg1, arg2, arg3);
        }
        return null;
    }

    /**
     * DESIGN PATTER : FACTORY
     * Créer un objet du type demander et le retourne. Remplacement des constructeurs.
     * (Cette version ne retourne que des type PlatAuMenu. Dautre version avec différentes signatures sont disponible)
     * @param type le type du plat désiré
     * @param code le code du plat
     * @param description la description du plat
     * @param prix le prix du plat
     * @return un objet du type désiré
     */
    public PlatAuMenu getPlat(TypePlat type, int code, String description, double prix)
    {
        if (type == TypePlat.PLATAUMENU)
        {
            return new PlatAuMenu(code, description, prix);
        }
        return null;
    }

    /**
     * DESIGN PATTER : FACTORY
     * Créer un objet du type demander et le retourne. Remplacement des constructeurs.
     (Cette version ne retourne que des type PlatSante. Dautre version avec différentes signatures sont disponible)
     * @param type le type du plat désiré
     * @param code le code du plat
     * @param description la description du plat
     * @param prix le prix du plat
     * @param arg1 le premier argument variable
     * @return
     */
    public PlatAuMenu getPlat(TypePlat type, int code, String description, double prix, double arg1)
    {
        if (type == TypePlat.PLATENFANT)
        {
            return new PlatEnfant(code, description, prix, arg1);
        }
        return null;
    }
}
