package menufact.facture;

import menufact.plats.PlatChoisi;

/**
 * La classe ControllerFactures est le controller dans le modele de conception MVC, il fait le lien entre la vue et le modele.
 * @author Mathias Gagnon
 * @version 1.0
 * @see Facture
 * @see Vue
 */
public class ControllerFactures {

    /**
     * facture est l'instance de facture a lier a la vue. C'est le modele dans le modele MVC.
     */
    private Facture facture;

    /**
     * vue est l'instance de Vue dans le modele MVC
     */
    private Vue vue;

    /**
     * Constructeur avec parametres de la classe.
     * @param facture facture a ajouter au controller
     * @param vue vue a ajouter au controller
     */

    public ControllerFactures(Facture facture, Vue vue){
        this.facture = facture;
        this.vue = vue;
    }

    public Facture getFacture(){
        return facture;
    }

    /**
     * Methode qui permet de connecter la vue au modele.
     */
    public void connectionVue(){
        vue.setFacture(getFacture());
    }

    public String afficher(){
        return vue.toString();
    }

    public void fermerFacture() throws Exception{
        facture.fermer();
    }

    public void ouvrirFacture() throws Exception{
        facture.ouvrir();
    }

    public void payerFacture() throws Exception{
        facture.payer();
    }

    public void reinitialiserFacture(String description){
        facture.reinitialiser(description);
    }

    /**
     * Calcul du sous total de la facture
     * @return le sous total
     */
    public double sousTotal() {
        double soustotal=0;
        for (PlatChoisi p : facture.getPlatchoisi())
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
        return facture.getTPS() *sousTotal();
    }


    /**
     *
     * @return la valeur de la TVQ
     */
    private  double tvq(){
        return facture.getTVQ()*sousTotal();
    }
}
