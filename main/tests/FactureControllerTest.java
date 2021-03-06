package main.tests;

import main.model.ingredients.exceptions.IngredientException;
import main.model.inventaire.Inventaire;
import main.model.Chef;
import main.model.Client;
import main.model.facture.Facture;
import main.controller.FactureController;
import main.model.facture.FactureEtat;
import main.view.FactureView;
import main.model.facture.exceptions.FactureException;
import main.model.plats.PlatAuMenu;
import main.model.plats.PlatChoisi;
import main.model.plats.exceptions.PlatException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.model.ingredients.IngredientInventaire;
import main.model.ingredients.Legume;

import java.util.List;
import java.util.ArrayList;

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
        List<IngredientInventaire> listeIngredient1 = new ArrayList<IngredientInventaire>();
        listeIngredient1.add(new IngredientInventaire(new Legume(),2));
        IngredientInventaire ing1 = new IngredientInventaire(new Legume(),3);
        Inventaire.getInstance().ajouter(ing1);
        Chef chef = Chef.getInstance();
        f.addChef(chef);

        PlatChoisi platChoisi = new PlatChoisi(new PlatAuMenu(0, "Un Plat", 10, listeIngredient1), 1);
        fc.ajoutePlat(platChoisi);
        Inventaire.getInstance().retirer(ing1);
        FactureException e = Assertions.assertThrows(FactureException.class, () -> {fc.ajoutePlat(platChoisi);});
        Assertions.assertEquals("FactureException: L'main.model.inventaire doit contenir tous les ingrédients d'un plat en quantité suffisante pour le facturer.", e.getMessage());
        Inventaire.getInstance().retirer(ing1);

        IngredientInventaire ing2 = new IngredientInventaire(new Legume(),1);
        Inventaire.getInstance().ajouter(ing2);
        PlatChoisi platChoisi2 = new PlatChoisi(new PlatAuMenu(0, "Un Plat", 10, listeIngredient1), 1);
        e = Assertions.assertThrows(FactureException.class, ()->{f.ajoutePlat(platChoisi2);});
        Assertions.assertEquals("FactureException: L'main.model.inventaire doit contenir tous les ingrédients d'un plat en quantité suffisante pour le facturer.", e.getMessage());
        Inventaire.getInstance().retirer(ing2);

        f.fermer();
        e = Assertions.assertThrows(FactureException.class, ()->{f.ajoutePlat(platChoisi);});
        Assertions.assertEquals("FactureException: On peut ajouter un plat seulement sur une facture OUVERTE.", e.getMessage());




    }

    @Test
    void genererFacture() throws FactureException, PlatException, IngredientException {
        List<IngredientInventaire> listeIngredient1 = new ArrayList<IngredientInventaire>();
        listeIngredient1.add(new IngredientInventaire(new Legume(),2));
        IngredientInventaire ing1 = new IngredientInventaire(new Legume(),2);
        Inventaire i = Inventaire.getInstance();
        i.ajouter(ing1);
        Client client = new Client(0, "Un client", "00000");

        f.associerClient(client);
        PlatChoisi platChoisi = new PlatChoisi(new PlatAuMenu(0, "Un Plat", 10, listeIngredient1), 1);
        f.ajoutePlat(platChoisi);
        Assertions.assertNotEquals(0,fc.genererFacture().length());
        i.retirer(ing1);
    }

    @Test
    void testToString() {
        Assertions.assertNotEquals(0, fc.toString().length());
    }
}