package menufact.plats;

import menufact.plats.PlatAuMenu;

/**
 * La classe PlatChoisi contient toutes les informations par rapport a un plat que le client veut commander comme sa quantite ou son etat.
 * @author Domingo Palao Munoz, Mathias Gagnon, Mathieu Lefebre
 * @version 2.0
 * @see PlatEtat
 * @see PlatAuMenu
 */
public class PlatChoisi {

    /**
     * plat contient le plat que le client veut commander.
     */
    private PlatAuMenu plat;

    /**
     * quantite contient la quantite du plat que le client veut commander.
     */
    private int quantite;

    /**
     * etat contient l'etat du plat.
     */
    private PlatEtat etat;

    /**
     * Constructeur avec parametres de la classe, l'etat est initialise a l'etat COMMANDE.
     * @param plat contient le PlatAuMenu
     * @param quantite contient la quantite
     */
    public PlatChoisi(PlatAuMenu plat, int quantite) {
        this.plat = plat;
        this.quantite = quantite;
        this.etat = PlatEtat.COMMANDE;
    }

    /**
     * Surcharge de la methode toString pour pouvoir afficher les informations du plat choisi.
     * @return String contenant les informations du plat choisi
     */
    @Override
    public String toString() {
        return "menufact.plats.PlatChoisi{" +
                "quantite=" + quantite +
                ", plat=" + plat +
                ", etat =" + etat +
                '}';
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setEtat(PlatEtat etat){
        this.etat = etat;
    }

    public PlatAuMenu getPlat() {
        return plat;
    }
}
