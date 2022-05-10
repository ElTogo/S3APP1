import menufact.exceptions.MenuException;
import menufact.plats.PlatAuMenu;
import menufact.Menu;
import menufact.plats.TypePlat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    Menu m;

    @BeforeEach
    void setUp() {
        m = new Menu("Un Menu");

    }

    @Test
    void ajoute() {
        m.ajoute(new PlatAuMenu(2,"",0));
        Assertions.assertEquals(2, m.platCourant().getCode());
    }

    @Test
    void position() {
        m.ajoute(new PlatAuMenu(0,"",0));
        m.ajoute(new PlatAuMenu(1,"",1));
        m.ajoute(new PlatAuMenu(2,"",2));
        Assertions.assertEquals(0,m.platCourant().getCode());
        m.position(2);
        Assertions.assertEquals(2, m.platCourant().getCode());
    }


    @Test
    void positionSuivante() throws MenuException {
        m.ajoute(new PlatAuMenu(0,"",0));
        m.ajoute(new PlatAuMenu(1,"",1));
        m.positionSuivante();
        Assertions.assertEquals(1, m.platCourant().getCode());
    }

    @Test
    void positionPrecedente() {

    }

    @Test
    void testToString() {
    }
}