package menufact.facture;

import menufact.plats.PlatChoisi;

public class Vue {

    Facture f;

    public Vue(){

    }

    public Vue(Facture f){
        this.f = f;
    }

    public String genererFacture(){
        String lesPlats = new String();
        String factureGenere = new String();

        int i =1;


        factureGenere =   "Facture generee.\n" +
                "Date:" + f.getDate() + "\n" +
                "Description: " + f.getDescription() + "\n" +
                "Client:" + f.getClient().getNom() + "\n" +
                "Les plats commandes:" + "\n" + lesPlats;

        factureGenere += "Seq   Plat         Prix   Quantite\n";
        for (PlatChoisi plat : f.getPlatchoisi())
        {
            factureGenere +=  i + "     " + plat.getPlat().getDescription() +  "  " + plat.getPlat().getPrix() +  "      " + plat.getQuantite() + "\n";
            i++;
        }

        factureGenere += "          TPS:               " + f.getTPS() + "\n";
        factureGenere += "          TVQ:               " + f.getTVQ() + "\n";
        factureGenere += "          Le total est de:   " + f.sousTotal() +  "\n";

        return factureGenere;
    }

    @Override
    public String toString() {
        return "menufact.facture.Facture{" +
                "date=" + f.getDate() +
                ", description='" + f.getDescription() + '\'' +
                ", etat=" + f.getEtat() +
                ", platchoisi=" + f.getPlatchoisi() +
                ", courant=" + f.getCourant() +
                ", client=" + f.getClient() +
                ", TPS=" + f.getTPS() +
                ", TVQ=" + f.getTVQ() +
                '}';
    }

    public void setFacture(Facture f){
        this.f = f;
    }
}
