package menufact.plats;

import java.util.ArrayList;

/**
 * Chef est la classe qui represente le chef du restaurant. Celui-ci recoit les plats commandes et peut les preparer, les terminer et notifier les serveurs qu'il faut les apporter aux clients.
 *
 * @author Mathias Gagnon
 * @version 1.0
 * @see PlatChoisi
 * @see Serveur
 */
public class Chef {

    /**
     * listeServeurs est la liste de tous les serveurs a notifier lorsqu'un plat est pret.
     */
    public ArrayList<Serveur> listeServeurs;

    /**
     * listePlats est la liste de tous les plats que le chef doit preparer
     */
    public ArrayList<PlatChoisi> listePlats;

    /**
     * Constructeur de la classe chef.
     */
    public Chef(){
        listeServeurs = new ArrayList<Serveur>();
        listePlats = new ArrayList<PlatChoisi>();
    }

    /**
     * Methode pour ajouter un plat a preparer par le chef.
     * @param p contient le plat a ajouter au chef
     */
    public void ajouterPlat(PlatChoisi p){
        if(p.getEtat() != PlatEtat.IMPOSSIBLE)listePlats.add(p);
    }

    /**
     * Methode pour ajouter un serveur a la liste de serveurs à notifier.
     * @param s contient le serveur a ajouter
     */
    public void ajouterServeur(Serveur s){
        listeServeurs.add(s);
    }

    public void retirerServeur(Serveur s){
        try{
            for(int i = 0; i < listeServeurs.size();i++){
                if(listeServeurs.get(i) == s){
                    listeServeurs.remove(i);
                    return;
                }
            }

            throw new Exception("Le serveur en figure pas sur la liste");
        }

        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Methode qui sert a notifier les serveurs.
     */
    private void notifier(){
        for(int i = 0; i < listeServeurs.size(); i++){
            listeServeurs.get(i).update(listePlats);
        }
    }

    /**
     * Methode qui sert a faire la preparation des plats.
     */
    public void preparer(){
        for(int i = 0; i < listePlats.size(); i++){
            listePlats.get(i).setEtat(PlatEtat.PREPARATION);
        }
    }

    /**
     * Methode qui est a terminer la preparation des plats, elle notifie ensuite les serveurs.
     */
    public void termine(){
        for(int i = 0; i < listePlats.size(); i++){
            listePlats.get(i).setEtat(PlatEtat.TERMINE);
        }

        notifier();

        listePlats.clear();
    }
}