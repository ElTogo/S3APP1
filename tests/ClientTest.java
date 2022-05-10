import menufact.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    Client c;

    @BeforeEach
    void setUp() {
        c = new Client(0, "Un Nom", "0");
    }

    @Test
    void getIdClient() {
        Assertions.assertEquals(0, c.getIdClient());
    }

    @Test
    void setIdClient() {
        c.setIdClient(1);
        Assertions.assertEquals(1,c.getIdClient());
    }

    @Test
    void getNom() {
        Assertions.assertEquals("Un Nom", c.getNom());
    }

    @Test
    void setNom() {
        c.setNom("Le Nom");
        Assertions.assertEquals("Le Nom", c.getNom());
    }

    @Test
    void getNumeroCarteCredit() {
        Assertions.assertEquals("0", c.getNumeroCarteCredit());
    }

    @Test
    void setNumeroCarteCredit() {
        c.setNumeroCarteCredit("00");
        Assertions.assertEquals("00", c.getNumeroCarteCredit());
    }

    @Test
    void testToString() {
        Assertions.assertEquals("menufact.Client{idClient=0, nom='Un Nom', numeroCarteCredit='0'}", c.toString());
    }
}