import menufact.facture.Facture;
import menufact.facture.FactureController;
import menufact.facture.FactureView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactureControllerTest {

    @BeforeEach
    void setUp() {
        Facture f = new Facture("Une facure");
        FactureView fw = new FactureView();
        FactureController fc = new FactureController(f,fw);
    }

    @Test
    void genererFacture() {
    }

    @Test
    void testToString() {
    }

    @Test
    void associerClient() {
    }

    @Test
    void payer() {
    }

    @Test
    void fermer() {
    }

    @Test
    void ouvrir() {
    }

    @Test
    void getEtat() {
    }

    @Test
    void ajoutePlat() {
    }
}