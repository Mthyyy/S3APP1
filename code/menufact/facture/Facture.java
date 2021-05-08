package menufact.facture;

import menufact.Client;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

import java.util.ArrayList;
import java.util.Date;

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
    private EtatFacture etatFacture;
    private String etatString;


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
        return getTVQ() *(getTPS() +1)*sousTotal();
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
     *
     * @param p un plat choisi
     * @throws FactureException Seulement si la facture est OUVERTE
     */
    public void ajoutePlat(PlatChoisi p) throws FactureException {
        /*if (etat == FactureEtat.OUVERTE)
            platchoisi.add(p);
        else
            throw new FactureException("On peut ajouter un plat seulement sur une facture OUVERTE.");*/

        getEtatFacture().ajoutePlat(p, getPlatchoisi());
    }

    /**
     *
     * @return le contenu de la facture en chaîne de caracteres
     */
   //@Override
   //public String toString() {
   //    return "menufact.facture.Facture{" +
   //            "date=" + getDate() +
   //            ", description='" + getDescription() + '\'' +
   //            ", etat=" + getEtat() +
   //            ", platchoisi=" + getPlatchoisi() +
   //            ", courant=" + getCourant() +
   //            ", client=" + getClient() +
   //            ", TPS=" + getTPS() +
   //            ", TVQ=" + getTVQ() +
   //            '}';
   //}

    /**
     *
     * @return une chaîne de caractères avec la facture à imprimer
     */
    /*public String genererFacture()
    {
        String lesPlats = new String();
        String factureGenere = new String();

        int i =1;


        factureGenere =   "Facture generee.\n" +
                          "Date:" + getDate() + "\n" +
                          "Description: " + getDescription() + "\n" +
                          "Client:" + getClient().getNom() + "\n" +
                          "Les plats commandes:" + "\n" + lesPlats;

        factureGenere += "Seq   Plat         Prix   Quantite\n";
        for (PlatChoisi plat : getPlatchoisi())
        {
            factureGenere +=  i + "     " + plat.getPlat().getDescription() +  "  " + plat.getPlat().getPrix() +  "      " + plat.getQuantite() + "\n";
            i++;
        }

        factureGenere += "          TPS:               " + tps() + "\n";
        factureGenere += "          TVQ:               " + tvq() + "\n";
        factureGenere += "          Le total est de:   " + total() + "\n";

        return factureGenere;
    }
*/
    public void retirerPlat(int code){
        //etatFacture.retirerPlat();
    }

    public void selectionnerPlat(PlatChoisi p){
        selectionnerPlat(p);
    }

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

    //public String getEtatString() {
    //    return etatString;
    //}
//
    //public void setEtatString(String etatString) {
    //    this.etatString = etatString;
    //}

    /**********************Constantes ************/
    public double getTPS() {
        return TPS;
    }

    public double getTVQ() {
        return TVQ;
    }
}
