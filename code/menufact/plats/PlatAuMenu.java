package menufact.plats;

import ingredients.Ingredient;

import java.util.ArrayList;

/**
 * La classe PlatAuMenu contient est la classe generale des plats qui peuvent etre ajoutes au menu du restaurant et commandes.
 * @author Domingo Palao Munoz, Mathias Gagnon, Mathieu Lefebvre
 * @version 2.0
 */

public class PlatAuMenu {
    /**
     * code contient le code associe au plat. On peut identifier le plat dans le menu avec.
     */
    private int code;

    /**
     * description contient une courte description du plat.
     */
    private String description;

    /**
     * prix contient le prix du plat.
     */
    private double prix;

    /**
     * listeIngredients contient les ingredients necessaires pour faire le plat
     */
    private ListeIngredients listeIngredients;

    /**
     * Constructeur avec parametres de la classe.
     * @param code contient le code du plat
     * @param description contient la description du plat
     * @param prix contient le prix du plat
     */
    public PlatAuMenu(int code, String description, double prix) {
        this.code = code;
        this.description = description;
        this.prix = prix;
        this.listeIngredients = new ListeIngredients();
    }

    /**
     * Constructeur sans parametres de la classe.
     */
    public PlatAuMenu() {
    }

    /**
     * Surcharge de la methode toString pour pouvoir afficher les informations du plat.
     * @return String contenant les informations du plat
     */
    @Override
    public String toString() {
        return "PlatAuMenu{" +
                "code=" + code +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                "}" + listeIngredients + "." + '\n';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public ListeIngredients getListeIngredients(){
        return this.listeIngredients;
    }

    public void setListeIngredients(ListeIngredients listeIngredients){
        this.listeIngredients = listeIngredients;
    }
}
