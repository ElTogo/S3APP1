package menufact;

public class Chef {
    private static Chef instanceChef;
    private Chef() {
    }

    public void preparerPlat() {

    }

    static Chef getInstance()
    {
        if (instanceChef == null)
        {
            instanceChef = new Chef();
        }
        return instanceChef;
    }
}
