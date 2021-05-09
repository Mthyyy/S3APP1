package menufact.plats;

import java.util.ArrayList;

/**
 * La classe serveur est un exemple de l'utilite du modèle de conception observer fait dans la classe chef. Le serveur est notifie par le chef et sert les plats.
 * @author Mathias Gagnon
 * @version 1.0
 * @see Chef
 */
public class Serveur {

    /**
     * Methode qui recoit la notificaiton du chef et qui sert les plats recus.
     * @param listePlats liste des plats que le serveur doit servir
     */
    public void update(ArrayList <PlatChoisi> listePlats){
        System.out.println("J'ai ete notifie");

        for(int i = 0; i < listePlats.size(); i++){
            listePlats.get(i).setEtat(PlatEtat.SERVI);
        }
    }
}
