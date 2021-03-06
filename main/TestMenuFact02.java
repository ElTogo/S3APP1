package main;

import main.model.Client;
import main.model.Menu;
import main.model.ingredients.*;
import main.model.ingredients.exceptions.IngredientException;
import main.model.inventaire.Inventaire;
import main.model.exceptions.MenuException;
import main.model.facture.Facture;
import main.controller.FactureController;
import main.model.plats.FactoryPlat;
import main.model.plats.PlatAuMenu;
import main.model.plats.PlatChoisi;
import main.model.plats.TypePlat;
import main.view.FactureView;
import main.model.facture.exceptions.FactureException;
import main.model.plats.exceptions.PlatException;

import java.util.ArrayList;
import java.util.List;

public class TestMenuFact02 {

    public static void main(String[] args) {
        boolean trace = true;
        //CRÉATION DES OBJETS

        TestMenuFact02 t = new TestMenuFact02();
        FactoryPlat factoryPlat = new FactoryPlat();

        Menu m1 = new Menu("menufact.Menu 1");
        Menu m2 = new Menu("menufact.Menu 2");

        Facture f1 = new Facture("Ma facture");
        FactureView fw1 = new FactureView();
        FactureController fc1= new FactureController(f1, fw1);

        Client c1 = new Client(1,"Mr Client","1234567890");

        List<IngredientInventaire> listeIngredient1 = new ArrayList<IngredientInventaire>();
        List<IngredientInventaire> listeIngredient2 = new ArrayList<IngredientInventaire>();

        PlatAuMenu p1 = factoryPlat.getPlat(TypePlat.PLATAUMENU,0,"PlatAuMenu0",10, listeIngredient1);
        PlatAuMenu p2 = factoryPlat.getPlat(TypePlat.PLATAUMENU,1,"PlatAuMenu1",20, listeIngredient1);
        PlatAuMenu p3 = factoryPlat.getPlat(TypePlat.PLATAUMENU,2,"PlatAuMenu2",30, listeIngredient1);
        PlatAuMenu p4 = factoryPlat.getPlat(TypePlat.PLATAUMENU,3,"PlatAuMenu3",40, listeIngredient1);
        PlatAuMenu p5 = factoryPlat.getPlat(TypePlat.PLATAUMENU,4,"PlatAuMenu4",50, listeIngredient1);

        PlatAuMenu ps1 = factoryPlat.getPlat(TypePlat.PLATSANTE,10,"PlatSante0",10, listeIngredient2,11,11,11);
        PlatAuMenu ps2 = factoryPlat.getPlat(TypePlat.PLATSANTE,11,"PlatSante1",20, listeIngredient2,11,11,11);
        PlatAuMenu ps3 = factoryPlat.getPlat(TypePlat.PLATSANTE,12,"PlatSante2",30, listeIngredient2,11,11,11);
        PlatAuMenu ps4 = factoryPlat.getPlat(TypePlat.PLATSANTE,13,"PlatSante3",40, listeIngredient2,11,11,11);
        PlatAuMenu ps5 = factoryPlat.getPlat(TypePlat.PLATSANTE,14,"PlatSante4",50, listeIngredient2,11,11,11);

        PlatAuMenu pe1 = factoryPlat.getPlat(TypePlat.PLATENFANT, 20, "PlatEnfant0", 10, listeIngredient2,0.5);
        PlatAuMenu pe2 = factoryPlat.getPlat(TypePlat.PLATENFANT, 21, "PlatEnfant0", 20, listeIngredient2,0.5);
        PlatAuMenu pe3 = factoryPlat.getPlat(TypePlat.PLATENFANT, 22, "PlatEnfant0", 30, listeIngredient2,0.5);
        PlatAuMenu pe4 = factoryPlat.getPlat(TypePlat.PLATENFANT, 23, "PlatEnfant0", 40, listeIngredient2,0.5);
        PlatAuMenu pe5 = factoryPlat.getPlat(TypePlat.PLATENFANT, 24, "PlatEnfant0", 50, listeIngredient2,0.5);

        //Ajout des objet à des stockage
        listeIngredient1.add(new IngredientInventaire(new Legume(),2));
        listeIngredient1.add(new IngredientInventaire(new Fruit(),2));
        listeIngredient1.add(new IngredientInventaire(new Epice(),1));

        listeIngredient1.add(new IngredientInventaire(new Viande(),3));
        listeIngredient1.add(new IngredientInventaire(new Laitier(),2));
        listeIngredient1.add(new IngredientInventaire(new Epice(),1));

        Inventaire.getInstance().ajouter(new IngredientInventaire(new Epice(), 1));
        Inventaire.getInstance().ajouter(new IngredientInventaire(new Fruit(), 2));
        Inventaire.getInstance().ajouter(new IngredientInventaire(new Laitier(), 2));
        Inventaire.getInstance().ajouter(new IngredientInventaire(new Legume(), 2));
        Inventaire.getInstance().ajouter(new IngredientInventaire(new Viande(), 3));

        t.test1_AffichePlatsAuMenu(trace, p1,p2,p3,p4,p5);
        t.test2_AffichePlatsSante(trace, ps1,ps2,ps3,ps4,ps5);
        t.test2_AffichePlatEnfant(trace,pe1,pe2,pe3,pe4,pe5);

        t.test4_AjoutPlatsAuMenu(trace, m1, p1, p2, ps1, ps2, m2, p3, p4, ps3, ps4);


        try {
            t.test5_DeplacementMenuAvancer(m1);
        } catch (MenuException e) {
            System.out.println(e.getMessage());
        }

        try {
            t.test6_DeplacementMenuReculer(m1);
        } catch (MenuException e) {
            System.out.println(e.getMessage());
        }

        try {
            t.test7_CreerFacture(fc1, m1);
        } catch (FactureException e) {
            System.out.println(e.getMessage());
        } catch (PlatException e) {
            throw new RuntimeException(e);
        } catch (IngredientException e) {
            throw new RuntimeException(e);
        }


        t.test8_AjouterClientFacture(fc1, c1);

        try {
            t.test8_AjouterPlatsFacture(fc1, m1,1);
        } catch (FactureException fe)
        {
            System.out.println(fe.getMessage());
        }
        catch (MenuException me)
        {
            System.out.println(me);
        } catch (PlatException e) {
            throw new RuntimeException(e);
        } catch (IngredientException e) {
            throw new RuntimeException(e);
        }

        t.test9_PayerFacture(fc1);

        try {
            t.test8_AjouterPlatsFacture(fc1, m1,1);
        } catch (FactureException fe)
        {
            System.out.println(fe.getMessage());
        }
        catch (MenuException me)
        {
            System.out.println(me);
        } catch (PlatException e) {
            throw new RuntimeException(e);
        } catch (IngredientException e) {
            throw new RuntimeException(e);
        }

        try {
            f1.ouvrir();
        } catch (FactureException fe)
        {
            System.out.println(fe.getMessage());
        }

        System.out.println("FIN DE TOUS LES TESTS...");

        System.out.println(fc1.genererFacture());
    }

    private void test1_AffichePlatsAuMenu(boolean trace, PlatAuMenu p1, PlatAuMenu p2,
                                                 PlatAuMenu p3, PlatAuMenu p4, PlatAuMenu p5)
    {
        System.out.println("=== test1_AffichePlatsAuMenu");
        if(trace)
        {
            System.out.println(p1);
            System.out.println(p2);
            System.out.println(p3);
            System.out.println(p4);
            System.out.println(p5);
        }
    }


   private void test2_AffichePlatsSante(boolean trace, PlatAuMenu ps1, PlatAuMenu ps2,
                                        PlatAuMenu ps3, PlatAuMenu ps4, PlatAuMenu ps5)
    {
        System.out.println("=== test2_AffichePlatsSante");

        if(trace)
        {
            System.out.println(ps1);
            System.out.println(ps2);
            System.out.println(ps3);
            System.out.println(ps4);
            System.out.println(ps5);
        }
    }

    private void test2_AffichePlatEnfant(boolean trace, PlatAuMenu pe1, PlatAuMenu pe2,
                                         PlatAuMenu pe3, PlatAuMenu pe4, PlatAuMenu pe5)
    {
        System.out.println("=== test2_AffichePlatsSante");

        if(trace)
        {
            System.out.println(pe1);
            System.out.println(pe2);
            System.out.println(pe3);
            System.out.println(pe4);
            System.out.println(pe5);
        }
    }

    private static void test3_AjoutMenu(boolean trace, Menu m1, Menu m2)
    {

        System.out.println("=== test3_AjoutMenu");

        if(trace) {
            System.out.println(m1);
            System.out.println(m2);
        }
    }


    private void test4_AjoutPlatsAuMenu(boolean trace, Menu m1,
                                        PlatAuMenu p1, PlatAuMenu p2,
                                        PlatAuMenu ps1, PlatAuMenu ps2,
                                        Menu m2,
                                        PlatAuMenu p3, PlatAuMenu p4,
                                        PlatAuMenu ps3, PlatAuMenu ps4)
    {
        System.out.println("=== test4_AjoutPlatsAuMenu");
        System.out.println("=== Ajout de plats au menu 1");
        m1.ajoute(p1);
        m1.ajoute(p2);
        m1.ajoute(ps1);
        m1.ajoute(ps2);


        System.out.println("=== Ajout de plats au menu 2");
        m2.ajoute(p3);
        m2.ajoute(p4);
        m2.ajoute(ps3);
        m2.ajoute(ps4);

        if(trace) {
            System.out.println(m1);
            System.out.println(m2);
        }
    }


    private void test5_DeplacementMenuAvancer(Menu m1) throws MenuException
    {
        System.out.println("=== test5_DeplacementMenuAvancer");

        System.out.println("===Selectionner un plat du menu 0");
        m1.position(0);

        System.out.println("=== Afficher le plat courant");
        System.out.println(m1.platCourant());
        try {

            System.out.println("=== Avancer le plat courant");
            System.out.println("1.");
            m1.positionSuivante();
            System.out.println("2.");
            m1.positionSuivante();
            System.out.println("3.");
            m1.positionSuivante();
            System.out.println("4.");
            m1.positionSuivante();
            System.out.println("5.");
            m1.positionSuivante();
        }
        catch (MenuException me)
        {
                throw me;
        }
    }


    private void test6_DeplacementMenuReculer(Menu m1) throws MenuException
    {
        System.out.println("===test6_DeplacementMenuReculer");

        System.out.println("===Selectionner un plat du menu 3");
        m1.position(3);

        System.out.println("=== Afficher le plat courant");
        System.out.println(m1.platCourant());
        try {

            System.out.println("=== Reculer le plat courant");
            System.out.println("2.");
            m1.positionPrecedente();
            System.out.println("1.");
            m1.positionPrecedente();
            System.out.println("0.");
            m1.positionPrecedente();
            System.out.println("-1.");
            m1.positionPrecedente();
            System.out.println("-2.");
            m1.positionPrecedente();
        }
        catch (MenuException me)
        {
            throw me;
        }
    }

    private void test7_CreerFacture(FactureController fc1, Menu m1) throws FactureException, PlatException, IngredientException {
        System.out.println("===test7_CreerFacture");

        PlatChoisi platChoisi = new PlatChoisi(m1.platCourant(),5);
        try
        {
            fc1.ajoutePlat(platChoisi);
        }
        catch (FactureException fe)
        {
            throw fe;
        } catch (PlatException e) {
            throw e;
        } catch (IngredientException e) {
            throw e;
        }
        System.out.println(fc1);
    }


    private void test8_AjouterClientFacture(FactureController fc1,Client c1) {
        System.out.println("===test8_AjouterClientFacture");
        fc1.associerClient(c1);
        System.out.println(fc1);
    }
    private void test8_AjouterPlatsFacture(FactureController fc1, Menu m1, int pos) throws MenuException, FactureException, PlatException, IngredientException {
        System.out.println("===test8_AjouterPlatsFacture");

        try{
            for (int i=0; i< pos; i++)
                m1.positionSuivante();
        }
        catch (MenuException me)
        {
            throw me;
        }

        PlatChoisi platChoisi = new PlatChoisi(m1.platCourant(),5);
        try
        {
            fc1.ajoutePlat(platChoisi);
        }
        catch (FactureException fe)
        {
            throw fe;
        } catch (PlatException e) {
            throw e;
        } catch (IngredientException e) {
            throw e;
        }
        System.out.println(fc1);
    }

    private void test9_PayerFacture(FactureController fc1)
    {
        System.out.println("===test9_PayerFacture");

        System.out.println("Avant payer la facture");
        System.out.println(fc1);
        fc1.payer();
        System.out.println("Apres avoir paye la facture");
        System.out.println(fc1);
    }
}
