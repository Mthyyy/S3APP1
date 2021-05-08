package menufact.plats;

import java.util.ArrayList;

public class Chef {
    ArrayList<Serveur> listeServeurs;
    ArrayList<PlatChoisi> listePlats;

    public Chef(){
        listeServeurs = new ArrayList<Serveur>();
        listePlats = new ArrayList<PlatChoisi>();
    }

    public void ajouterPlat(PlatChoisi p){
        listePlats.add(p);
    }

    public void ajouterServeur(Serveur s){
        listeServeurs.add(s);
    }

    private void notifier(){
        for(int i = 0; i < listeServeurs.size(); i++){
            listeServeurs.get(i).update(listePlats);
        }
    }

    public void preparer(){
        for(int i = 0; i < listePlats.size(); i++){
            listePlats.get(i).setEtat(PlatEtat.PREPARATION);
        }
    }

    public void termine(){
        for(int i = 0; i < listePlats.size(); i++){
            listePlats.get(i).setEtat(PlatEtat.TERMINE);
        }

        notifier();
    }
}