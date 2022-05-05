package menufact.plats;

public class FactoryPlat {
    static PlatAuMenu getPlat(String type, int code, String description, double prix, double arg1, double arg2, double arg3)
    {
        if (type == "PlatAuMenu")
        {
            return new PlatAuMenu(code, description, prix);
        }
        else if (type == "PlatSante")
        {
            return new PlatSante(code, description, prix, arg1, arg2, arg3);
        }
        else if (type == "PlatEnfant")
        {
            return new PlatEnfant(code, description, prix, arg1);
        }
        else
        {
            throw new MenuException("Type de plat invalide");
        }

    }
}
