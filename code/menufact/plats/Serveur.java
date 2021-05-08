package menufact.plats;

import java.util.ArrayList;

public class Serveur {
    public void update(ArrayList <PlatChoisi> listePlats){
        System.out.println("J'ai ete notifie");

        for(int i = 0; i < listePlats.size(); i++){
            listePlats.get(i).setEtat(PlatEtat.SERVI);
        }
    }
}
