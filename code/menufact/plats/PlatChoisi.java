package menufact.plats;

import menufact.plats.PlatAuMenu;

public class PlatChoisi {
    private PlatAuMenu plat;
    private int quantite;
    private PlatEtat etat;

    public PlatChoisi(PlatAuMenu plat, int quantite) {
        this.plat = plat;
        this.quantite = quantite;
        this.etat = PlatEtat.COMMANDE;
    }

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
