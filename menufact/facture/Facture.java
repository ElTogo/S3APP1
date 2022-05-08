package menufact.facture;

import ingredients.IngredientInventaire;
import inventaire.Inventaire;
import menufact.Chef;
import menufact.Client;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;
import menufact.plats.etats.Incomplet;

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
    public void ajoutePlat(PlatChoisi p) throws FactureException
    {
        if (etat == FactureEtat.OUVERTE) {
            List<IngredientInventaire> ingredientInventaires = Inventaire.getInstance().getLesIngredients();

            if (!p.getPlat().getIngredients().isEmpty() || p.getPlat().getIngredients() != null) {

                for (IngredientInventaire ingredient : p.getPlat().getIngredients()) {

                    if (ingredientInventaires.contains(ingredient)) {
                        int index = ingredientInventaires.indexOf(ingredient);

                        if (ingredient.getQuantite() > ingredientInventaires.get(index).getQuantite()) {
                            p.setEtatPlat(new Incomplet());
                            throw new FactureException("Tous les ingrédients d'un plat doivent être en quantité suffisante dans l'inventaire pour être facturé.");
                        }
                    }
                    else {
                        p.setEtatPlat(new Incomplet());
                        throw new FactureException("Tous les ingrédients d'un plat doivent être en inventaire pour être facturé.");
                    }
                }
            }
            platchoisi.add(p);
            notifyChef(p);
        }
        else
            throw new FactureException("On peut ajouter un plat seulement sur une facture OUVERTE.");
    }

    public void addChef(Chef chef) {
        if (chefs.size() < 1) {
            chefs.add(chef);
        }
    }

    public void notifyChef(PlatChoisi p) {
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
     *
     * @return une chaîne de caractères avec la facture à imprimer
     */
    public Date getDate(){return date;}
    public String getDescription(){return description;}
    public ArrayList<PlatChoisi> getPlatchoisi(){return platchoisi;}
    public Client getClient(){return client;}
    public double getTPSTotal(){return tps();}
    public double getTVQTotal(){return tvq();}
    public double getTotal(){return total();}
    public int getCourant(){return courant;}
    public double getTPS(){return TPS;}
    public double getTVQ(){return TVQ;}
}
