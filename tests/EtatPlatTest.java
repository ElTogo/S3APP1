import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.plats.etats.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EtatPlatTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void setGetEtatPlat() {
        PlatChoisi plat = new PlatChoisi(new PlatAuMenu(1, "Un plat",1),1);

        Commande commande = new Commande();
        commande.setEtatPlat(plat);
        Assertions.assertEquals(EtatsPlat.COMMANDE, plat.getEtatPlat().getEtatPlat());

        Preparation preparation = new Preparation();
        preparation.setEtatPlat(plat);
        Assertions.assertEquals(EtatsPlat.PREPARATION,plat.getEtatPlat().getEtatPlat());

        CompletServi completServi = new CompletServi();
        completServi.setEtatPlat(plat);
        Assertions.assertEquals(EtatsPlat.COMPLETSERVI, plat.getEtatPlat().getEtatPlat());

        Incomplet incomplet = new Incomplet();
        incomplet.setEtatPlat(plat);
        Assertions.assertEquals(EtatsPlat.INCOMPLET, plat.getEtatPlat().getEtatPlat());
    }

    @Test
    void testToString(){
        EtatPlat etat1 = new Commande();
        Assertions.assertEquals("Commandé", etat1.toString());
        etat1 = new CompletServi();
        Assertions.assertEquals("Complété et servi", etat1.toString());
        etat1 = new Incomplet();
        Assertions.assertEquals("Incomplète", etat1.toString());
        etat1 = new Preparation();
        Assertions.assertEquals("En préparation", etat1.toString());
    }
}