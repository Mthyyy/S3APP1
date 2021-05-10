package menufact.plats;

public class  ConcreteFactoryPlat implements FactoryPlats{

    public PlatAuMenu creerPlat(int code, String description, double prix){
        return new PlatAuMenu(code, description, prix);
    }

    public PlatSante creerPlatSante(int code, String description, double prix, double kcal, double chol, double gras){
        return new PlatSante(code, description, prix, kcal, chol, gras);
    }

    public PlatEnfant creerPlatEnfant(int code, String description, double prix, double proportion){
        return  new PlatEnfant(code, description, prix, proportion);
    }
}
