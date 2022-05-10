import ingredients.exceptions.IngredientException;
import menufact.Client;
import menufact.facture.Facture;
import menufact.facture.FactureController;
import menufact.facture.FactureEtat;
import menufact.facture.FactureView;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.plats.exceptions.PlatException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactureControllerTest {
    Facture f;
    FactureView fw;
    FactureController fc;
    @BeforeEach
    void setUp() {
        f = new Facture("Une facure");
        fw = new FactureView();
        fc = new FactureController(f,fw);
    }
    @Test
    void associerClient() {
        Client client = new Client(0, "Un Client", "0123456789");
        fc.associerClient(client);
        Assertions.assertEquals("Un Client", f.getClient().getNom());
    }

    @Test
    void payer() {
        fc.payer();
        Assertions.assertEquals(FactureEtat.PAYEE, fc.getEtat());
    }

    @Test
    void fermer() {
        fc.fermer();
        Assertions.assertEquals(FactureEtat.FERMEE, fc.getEtat());
    }

    @Test
    void ouvrir() throws FactureException {
        fc.ouvrir();
        Assertions.assertEquals(FactureEtat.OUVERTE, fc.getEtat());
        fc.payer();
        FactureException e = Assertions.assertThrows(FactureException.class, () -> {
            f.ouvrir();
        });
        Assertions.assertEquals("FactureException: La facture ne peut pas être reouverte.", e.getMessage());
    }

    @Test
    void ajoutePlat() throws FactureException, PlatException, IngredientException {
        PlatChoisi platChoisi = new PlatChoisi(new PlatAuMenu(), 1);
        f.ajoutePlat(platChoisi);
        f.fermer();
        FactureException e = Assertions.assertThrows(FactureException.class, ()->{f.ajoutePlat(platChoisi);});
        Assertions.assertEquals("On peut ajouter un plat seulement sur une facture OUVERTE.", e.getMessage());
    }

    @Test
    void genererFacture() {
        String t = fc.genererFacture();
        System.out.println(t.length());
    }

    @Test
    void testToString() {
    }
}