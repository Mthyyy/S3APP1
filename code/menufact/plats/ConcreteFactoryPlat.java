package menufact.plats;

/**
 * La classe ConcreteFactoryPlat est l'implementation concrete de la factory de plats
 * @Author Mathias Gagnon
 * @version 1.0
 * @see FactoryPlats
 */
public class  ConcreteFactoryPlat implements FactoryPlats{

    /**
     * Methode qui permet de creer un PlatAuMenu
     * @param code code du plat
     * @param description description du plat
     * @param prix prix du plat
     * @return retourne le PlatAuMenu
     */
    public PlatAuMenu creerPlat(int code, String description, double prix){
        return new PlatAuMenu(code, description, prix);
    }

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
    public PlatSante creerPlatSante(int code, String description, double prix, double kcal, double chol, double gras){
        return new PlatSante(code, description, prix, kcal, chol, gras);
    }

    /**
     * Methode qui permet de creer un PlatEnfant
     * @param code code du plat
     * @param description description du plat
     * @param prix prix du plat
     * @param proportion proportion du plat enfant
     * @return
     */
    public PlatEnfant creerPlatEnfant(int code, String description, double prix, double proportion){
        return  new PlatEnfant(code, description, prix, proportion);
    }
}
