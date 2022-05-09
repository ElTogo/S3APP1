package menufact.facture;

import ingredients.IngredientInventaire;
import ingredients.exceptions.IngredientException;
import inventaire.Inventaire;
import menufact.Chef;
import menufact.Client;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;
import menufact.plats.etats.Incomplet;
import menufact.plats.exceptions.PlatException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Une facture du systeme Menufact
 * @author Domingo Palao Munoz
 * @version 1.0
 */
public class Facture {
    private Date date;

    private String description;
    private FactureEtat etat;
    private ArrayList<PlatChoisi> platchoisi = new ArrayList<PlatChoisi>();
    private int courant;
    private Client client;

    private List<Chef> chefs;


    /**********************Constantes ************/
    private final double TPS = 0.05;
    private final double TVQ = 0.095;

    /**
     *
     * @param client le client de la facture
     */
    public void associerClient (Client client)
    {
        this.client = client;
    }

    /**
     * Calcul du sous total de la facture
     * @return le sous total
     */
    public double sousTotal()
    {
        double soustotal=0;
         for (PlatChoisi p : platchoisi)
             soustotal += p.getQuantite() * p.getPlat().getPrix();
        return soustotal;
    }

    /**
     *
     * @return le total de la facture
     */
    public double total(){
        return sousTotal()+tps()+tvq();
    }

    /**
     *
     * @return la valeur de la TPS
     */
    private double tps(){
        return TPS*sousTotal();
    }

    /**
     *
     * @return la valeur de la TVQ
     */
    private  double tvq(){
        return TVQ*(TPS+1)*sousTotal();
    }

    /**
     * Permet de chager l'état de la facture à PAYEE
     */
    public void payer()
    {
       etat = FactureEtat.PAYEE;
    }
    /**
     * Permet de chager l'état de la facture à FERMEE
     */
    public void fermer()
    {
       etat = FactureEtat.FERMEE;
    }

    /**
     * Permet de changer l'état de la facture à OUVERTE
     * @throws FactureException en cas que la facture soit PAYEE
     */
    public void ouvrir() throws FactureException
    {
        if (etat == FactureEtat.PAYEE)
            throw new FactureException("La facture ne peut pas être reouverte.");
        else
            etat = FactureEtat.OUVERTE;
    }

    /**
     *
     * @return l'état de la facture
     */
    public FactureEtat getEtat()
    {
        return etat;
    }

    /**
     *
     * @param description la description de la Facture
     */
    public Facture(String description) {
        date = new Date();
        etat = FactureEtat.OUVERTE;
        courant = -1;
        this.description = description;
        chefs = new ArrayList<Chef>();
    }

    /**
     *
     * @param p un plat choisi
     * @throws FactureException Seulement si la facture est OUVERTE
     */
    public void ajoutePlat(PlatChoisi p) throws FactureException, PlatException, IngredientException {
        if (etat == FactureEtat.OUVERTE) {
            if (InvValidCommand.invValidation(p)) {
                platchoisi.add(p);
                notifyChef(p);
            }
        }
        else
            throw new FactureException("On peut ajouter un plat seulement sur une facture OUVERTE.");
    }

    /**
     * Ajout d'un chef (si possible)
     * Non untilisable pour le moment puisqu'il y a un singleton
     * @param chef le chef à ajouter
     */
    public void addChef(Chef chef) {
        if (chefs.size() < 1) {
            chefs.add(chef);
        }
    }
    //TODO : Javadoc (ALEX)
    public void notifyChef(PlatChoisi p) throws IngredientException {
        if (!chefs.isEmpty()) {
            chefs.get(0).update(p);
        }
    }

    /**
     *
     * @return le contenu de la facture en chaîne de caracteres
     */
    @Override
    public String toString() {
        return "menufact.facture.Facture{" +
                "date=" + date +
                ", description='" + description + '\'' +
                ", etat=" + etat +
                ", platchoisi=" + platchoisi +
                ", courant=" + courant +
                ", client=" + client +
                ", TPS=" + TPS +
                ", TVQ=" + TVQ +
                '}';
    }

    /**
     * Getter de la date
     * @return la date de la facture
     */
    public Date getDate(){return date;}

    /**
     * Getter de la description
     * @return la description de la facture
     */
    public String getDescription(){return description;}

    /**
     * Getter des plats choisis
     * @return le taableau des plats choisi
     */
    public ArrayList<PlatChoisi> getPlatchoisi(){return platchoisi;}

    /**
     * Getter du client
     * @return le client associé à la facture
     */
    public Client getClient(){return client;}

    /**
     * Getter de la valeur des TPS sur la facture
     * @return le montant des retenu des taxes
     */
    public double getTPSTotal(){return tps();}

    /**
     * Getter de la valeur des TVS sur la facture
     * @return le montant des retenu des taxes
     */
    public double getTVQTotal(){return tvq();}
    /**
     * Getter de la valeur total sur la facture
     * @return le montant des retenu des taxes
     */
    public double getTotal(){return total();}
}
