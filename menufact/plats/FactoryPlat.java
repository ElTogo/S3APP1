package menufact.plats;

public class FactoryPlat {
    public PlatAuMenu getPlat(TypePlat type, int code, String description, double prix, double arg1, double arg2, double arg3)
    {
        if (type == TypePlat.PLATAUMENU)
        {
            return new PlatAuMenu(code, description, prix);
        }
        else if (type == TypePlat.PLATSANTE)
        {
            return new PlatSante(code, description, prix, arg1, arg2, arg3);
        }
        else if (type == TypePlat.PLATENFANT)
        {
            return new PlatEnfant(code, description, prix, arg1);
        }
        return null;

    }
}
