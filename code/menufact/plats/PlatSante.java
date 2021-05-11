package menufact.plats;

import menufact.plats.PlatAuMenu;

/**
 * La classe plat sante herite de la classe plat au menu. Elle l'etend en ajoutant les valeurs de calories, de cholesterol et de gras.
 * @author Domingo Palao Munoz, Mathias Gagnon, Mathieu Lefebvre
 * @version 2.0
 * @see PlatAuMenu
 */
public class PlatSante extends PlatAuMenu {

    /**
     * kcal contient le nombre de kilo calories du plat.
     */
    private double kcal;

    /**
     * chol contient la quantite de cholesterol du plat.
     */
    private double chol;

    /**
     * gras contient la quantite de gras du plat.
     */
    private double gras;

    /**
     * Constructeur avec parametres de la classe.
     * @param code contient le code du plat
     * @param description contient la description du plat
     * @param prix contient le prix du plat
     * @param kcal contient la quantite de calories du plat
     * @param chol contient la quantite de cholesterol du plat
     * @param gras contient la quantite de gras du plat
     */
    public PlatSante(int code, String description, double prix, double kcal, double chol, double gras) {
        super(code, description, prix);
        this.kcal = kcal;
        this.chol = chol;
        this.gras = gras;
    }

    /**
     * Constructeur de base sans parametres de la classe.
     */
    public PlatSante() {
    }

    /**
     * Surcharge de la methode toString pour pouvoir afficher les informations du plat sante.
     * @return String contenant les informations du plat sante
     */
    @Override
    public String toString() {
        return "PlatSante{" +
                "kcal=" + kcal +
                ", chol=" + chol +
                ", gras=" + gras +
                "} " + super.toString();
    }

    public double getKcal() {
        return kcal;
    }

    public double getChol() {
        return chol;
    }

    public double getGras() {
        return gras;
    }
}
