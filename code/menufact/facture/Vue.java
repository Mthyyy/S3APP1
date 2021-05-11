package menufact.facture;

import menufact.Menu;
import menufact.plats.PlatChoisi;

import java.io.FileWriter;
import java.io.Writer;
import java.lang.constant.Constable;
import java.io.File;
import java.io.IOException;

/**
 * La classe Vue est la vue dans le modele de conception MVC. Elle permet de faire l'affichage des informations pertinentes.
 * @author Mathias Gagnon
 */
public class Vue{

    /**
     * f contient la facture qui a les informations que la vue doit afficher
     */
    Facture f;

    Menu menu;

    /**
     * Constructeur de base, sans parametres, de la classe.
     */
    public Vue(){

    }

    /**
     * Constructeur avec parametres de la classe.
     * @param f facture a associer a la vue
     */
    public Vue(Facture f){
        this.f = f;
    }

    /**
     * Methode qui permet de generer la facture avec toutes les informations pertinentes
     * @return String qui contient toutes les informations de la facture
     */
    public String genererFacture(){
        String lesPlats = new String();
        String factureGenere = new String();

        int i =1;

        try{
            if(f.getClient() == null){
                throw new Exception("Aucun client n'est associe");
            }

            factureGenere =   "Facture generee.\n" +
                    "Date:" + f.getDate() + "\n" +
                    "Description: " + f.getDescription() + "\n" +
                    "Client:" + f.getClient().getNom() + "\n" +
                    "Les plats commandes:" + "\n" + lesPlats;

            factureGenere += "Seq   Plat         Prix   Quantite\n";
        }

        catch(Exception e){
            System.out.println(e.getMessage());
        }



        for (PlatChoisi plat : f.getPlatchoisi())
        {
            factureGenere +=  i + "     " + plat.getPlat().getDescription() +  "  " + plat.getPlat().getPrix() +  "      " + plat.getQuantite() + "\n";
            i++;
        }

        factureGenere += "          TPS:               " + f.getTPS() + "\n";
        factureGenere += "          TVQ:               " + f.getTVQ() + "\n";
        factureGenere += "          Le total est de:   " + f.total() +  "\n";

        return factureGenere;
    }

    /**
     * Surcharge de la methode toString pour afficher les informations pertinentes de la facture
     * @return
     */
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
                f.getEtatFacture().affiche() +
                '}';
    }

    public void setFacture(Facture f){
        this.f = f;
    }

    public void setMenu(Menu f){
        this.menu = menu;
    }

    public void ecrireFichier(){
        try {
            FileWriter fichier = new FileWriter("FactureEtMenu.txt");

            fichier.write(genererFacture());
            fichier.close();

        } catch (IOException e) {
            System.out.println("Incapable d'ouvrir le fichier");
            e.printStackTrace();
        }
    }
}
