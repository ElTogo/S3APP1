package tests;

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
        MenuException e = Assertions.assertThrows(MenuException.class, ()-> {m.positionSuivante();});
        Assertions.assertEquals("MenuException: On depasse le nombre maximale de plats.", e.getMessage());
    }

    @Test
    void positionPrecedente() throws  MenuException{
        m.ajoute(new PlatAuMenu(0,"",0));
        m.ajoute(new PlatAuMenu(1,"",1));
        m.position(1);
        m.positionPrecedente();
        Assertions.assertEquals(0, m.platCourant().getCode());
        MenuException e = Assertions.assertThrows(MenuException.class, ()-> {m.positionPrecedente();});
        Assertions.assertEquals("MenuException: On depasse le nombre minimale de plats.", e.getMessage());
    }

    @Test
    void testToString() {
        m.ajoute(new PlatAuMenu(0,"",0));
        m.ajoute(new PlatAuMenu(1,"",1));
        Assertions.assertEquals("menufact.Menu{description='Un Menu', courant=0, plat=\n" +
                "[menufact.plats.PlatAuMenu{code=0, description='', prix=0.0}\n" +
                ", menufact.plats.PlatAuMenu{code=1, description='', prix=1.0}\n" +
                "]}", m.toString());
    }
}