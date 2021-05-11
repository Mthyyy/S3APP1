package menufact.facture;

import menufact.Client;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;
import menufact.plats.PlatEtat;

import java.util.ArrayList;
import java.util.Date;

/**
 * Une facture du systeme Menufact
 * @author Domingo Palao Munoz, Mathias Gagnon, Mathieu Lefebvre
 * @version 1.0
 * @see Facture
 */
public class Facture {
    private Date date;
    private String description;
    private FactureEtat etat;
    private ArrayList<PlatChoisi> platchoisi = new ArrayList<PlatChoisi>();
    private int courant;
    private Client client;
    private EtatFacture etatFacture;
    private PlatChoisi platSelectionner;


    private final double TPS = 0.05;
    private final double TVQ = 0.095;

    /**
     *
     * @param client le client de la facture
     */
    public void associerClient (Client client)
    {
        this.setClient(client);
    }

    /**
     * Calcul du sous total de la facture
     * @return le sous total
     */
    public double sousTotal() {
        double soustotal=0;
         for (PlatChoisi p : getPlatchoisi())
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
        return getTPS() *sousTotal();
    }

    /**
     *
     * @return la valeur de la TVQ
     */
    private  double tvq(){
        return getTVQ()*sousTotal();
    }

    /**
     * Permet de chager l'état de la facture à PAYEE
     */
    public void payer() {
       getEtatFacture().payer();
    }
    /**
     * Permet de chager l'état de la facture à FERMEE
     */
    public void fermer() throws FactureException {
       getEtatFacture().fermer();
    }

    /**
     * Permet de changer l'état de la facture à OUVERTE
     * @throws FactureException en cas que la facture soit PAYEE
     */
    public void ouvrir() throws FactureException {
        getEtatFacture().ouvrir();
    }

    /**
     *
     * @return l'état de la facture
     */
    public FactureEtat getEtat() {
        return etat;
    }

    /**
     *
     * @param description la description de la Facture
     */
    public Facture(String description) {
        setDate(new Date());
        setEtat(FactureEtat.OUVERTE);
        setEtatFacture(new EtatOuvert(this));
        setCourant(-1);
        this.setDescription(description);
    }

    /**
     * Permet d'ajouter un plat a la facture
     * @param p plat a ajouter
     * @throws FactureException au cas ou la facture soit trop pleine
     */
    public void ajoutePlat(PlatChoisi p) {
        try{
            if(p.getEtat() != PlatEtat.IMPOSSIBLE){
                getEtatFacture().ajoutePlat(p, getPlatchoisi());
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Permet de retirer un plat de la facture
     */
    public void retirerPlat() throws FactureException {
        etatFacture.retirerPlat();
    }

    /**
     * Permet de selectionner un plat
     * @param p plat a selectionner
     */
    public void selectionnerPlat(PlatChoisi p) throws FactureException{

        etatFacture.selectionnerPlat(p);

    }

    /**
     * Methode qui reinitialise la facture
     * @param description
     */
    public void reinitialiser(String description){
        etatFacture.reinitialiser(description);

    }

    public PlatChoisi getPlatSelectionner(){return platSelectionner;}

    public void setEtat(FactureEtat etat){
        this.etat = etat;
    }

    public void setEtatFacture(EtatFacture etat){
        this.etatFacture = etat;
    }

    public Date getDate(){
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<PlatChoisi> getPlatchoisi() {
        return platchoisi;
    }

    public void setPlatchoisi(ArrayList<PlatChoisi> platchoisi) {
        this.platchoisi = platchoisi;
    }

    public int getCourant() {
        return courant;
    }

    public void setCourant(int courant) {
        this.courant = courant;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public EtatFacture getEtatFacture() {
        return etatFacture;
    }

    public void setPlatSelectionner(PlatChoisi p){
        this.platSelectionner = p;
    }

    /**********************Constantes ************/
    public double getTPS() {
        return TPS;
    }

    public double getTVQ() {
        return TVQ;
    }
}
