package menufact.plats;

/**
 * La classe plat enfant herite de la classe plat au menu. Elle l'etend en ajoutant le parametre proportion.
 * @author Domingo Palao Munoz, Mathias Gagnon, Mathieu Lefebvre
 * @version 2.0
 * @see PlatAuMenu
 */
public class PlatEnfant extends PlatAuMenu{

    /**
     * proportion contient le proportion d'un plat d'adulte du plat pour enfant.
     */
    private double proportion;

    /**
     * Constructeur de base sans parametres de la classe.
     */
    public PlatEnfant() {
    }

    /**
     * Constructeur avec parametres de la classe.
     * @param code contient le code du plat
     * @param description contient la descritpion du plat
     * @param prix contient le prix du plat
     * @param proportion contient la proportion du plat
     */
    public PlatEnfant(int code, String description, double prix, double proportion) {
        super(code, description, prix);
        this.proportion = proportion;
    }

    public double getProportion() {
        return proportion;
    }

    /**
     * Surcharge de la methode toString pour pouvoir afficher les informations du plat enfant.
     * @return String contenant les informations du plat enfant
     */
    @Override
    public String toString() {
        return "PlatEnfant{" +
                "proportion=" + proportion +
                "} " + super.toString();
    }
}
