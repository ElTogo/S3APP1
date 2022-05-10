package main.model;

/**
 * Cette classe gere les clients et enregistre leurs infos
 */
public class Client {
    private int idClient;
    private String nom;
    private String numeroCarteCredit;

    /**
     * Constructeur
     * @param idClient l'identifiant du client
     * @param nom le nom du client
     * @param numeroCarteCredit le numéro de carte de crédit pour payer
     */
    public Client(int idClient, String nom, String numeroCarteCredit) {
        this.idClient = idClient;
        this.nom = nom;
        this.numeroCarteCredit = numeroCarteCredit;
    }

    /**
     * Getter de l'identifiant du client
     * @return l'identifiant du client
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     * Setter de l'identifiant du client
     * @param idClient l'identifiant du client
     */
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    /**
     * Getter du nom du client
     * @return le nom du client
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter du nom du client
     * @param nom le nom du client
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getter du numéro de carte
     * @return le numéro de carte de crédit du client
     */
    public String getNumeroCarteCredit() {
        return numeroCarteCredit;
    }

    /**
     * Setter du numéro de care
     * @param numeroCarteCredit le numéro de carte de crédit du client
     */
    public void setNumeroCarteCredit(String numeroCarteCredit) {
        this.numeroCarteCredit = numeroCarteCredit;
    }

    /**
     * Surcharge de la fonction toString qui permet d'avoir une description du client
     * @return la string qui décrit le client
     */
    @Override
    public String toString() {
        return "main.model.Client{" +
                "idClient=" + idClient +
                ", nom='" + nom + '\'' +
                ", numeroCarteCredit='" + numeroCarteCredit + '\'' +
                '}';
    }
}
/*
@startuml
class main.model.Client{}
* */