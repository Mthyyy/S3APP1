package menufact.plats;

/**
 * Interface de la abstract factory de plats
 * @Author Mathias Gagnon
 * @version 1.0
 */
public interface FactoryPlats {

    /**
     * Methode qui permet de creer un PlatAuMenu
     * @param code code du plat
     * @param description description du plat
     * @param prix prix du plat
     * @return retourne le PlatAuMenu
     */
    PlatAuMenu creerPlat(int code, String description, double prix);

    /**
     * Methode qui permet de creer un PlatEnfant
     * @param code code du plat
     * @param description description du plat
     * @param prix prix du plat
     * @param proportion proportion du plat enfant
     * @return
     */
    PlatEnfant creerPlatEnfant(int code, String description, double prix, double proportion);

    /**
     * Methode qui permet de creer un PlatSante
     * @param code code du plat
     * @param description description du plat
     * @param prix prix du plat
     * @param kcal qte de kilo calories du plat
     * @param chol qte de cholesterol du plat
     * @param gras qte de gras du plat
     * @return retourne le PlatSante
     */
    PlatSante creerPlatSante(int code, String description, double prix, double kcal, double chol, double gras);
}
