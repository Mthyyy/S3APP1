package menufact.plats;

public abstract class FactoryPlats {
    abstract public PlatAuMenu creerPlat(int code, String description, double prix);
    abstract public PlatEnfant creerPlatEnfant(int code, String description, double prix, double proportion);
    abstract public PlatSante creerPlatSante(int code, String description, double prix, double kcal, double chol, double gras);
}
  