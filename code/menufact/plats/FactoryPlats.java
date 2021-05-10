package menufact.plats;

public interface FactoryPlats {
    PlatAuMenu creerPlat(int code, String description, double prix);
    PlatEnfant creerPlatEnfant(int code, String description, double prix, double proportion);
    PlatSante creerPlatSante(int code, String description, double prix, double kcal, double chol, double gras);
}
