package menufact;

/**
 * La classe client contient toutes les informations du client
 * @author Domingo Palao Munoz, Mathias Gagnon, Mathieu Lefebvre
 * @version 2.0
 */
public class Client {
    /**
     * idClient est le numero d'identification du client
     */
    private int idClient;

    /**
     * nom est le nom du client
     */
    private String nom;

    /**
     * numeroCarteCredit est le numero de carte de credit du client
     */
    private String numeroCarteCredit;

    /**
     * Constructeur avec parametres de la classe client.
     * @param idClient numero d'identification du client
     * @param nom nom du client
     * @param numeroCarteCredit numero de carte de credit du client
     */
    public Client(int idClient, String nom, String numeroCarteCredit) {
        this.idClient = idClient;
        this.nom = nom;
        this.numeroCarteCredit = numeroCarteCredit;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumeroCarteCredit() {
        return numeroCarteCredit;
    }

    public void setNumeroCarteCredit(String numeroCarteCredit) {
        this.numeroCarteCredit = numeroCarteCredit;
    }

    /**
     * Surcharge de la methode toString pour pouvoir afficher les informations du client.
     * @return String contenant les informations du client
     */
    @Override
    public String toString() {
        return "menufact.Client{" +
                "idClient=" + idClient +
                ", nom='" + nom + '\'' +
                ", numeroCarteCredit='" + numeroCarteCredit + '\'' +
                '}';
    }
}
/*
@startuml
class menufact.Client{}
* */