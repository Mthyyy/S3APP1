package menufact;

import menufact.exceptions.MenuException;
import menufact.plats.ConcreteFactoryPlat;
import menufact.plats.PlatAuMenu;
import menufact.plats.FactoryPlats;

import java.util.ArrayList;

/**
 * La classe menu contient tous les plats que le client peut commander et contient les methodes necessaires pour changer quels plats sont offerts. Le menu est un singleton, car le restaurant offre le meme menu a tous ses clients.
 * @author Domingo Palao Munoz, Mathias Gagnon, Mathieu Lefebvre
 * @version 2.0
 * @see PlatAuMenu
 */
public class Menu {

    /**
     * description contient la description du menu.
     */
    private String description;

    /**
     * courant contient l'index du plat qui est selectionne.
     */
    private int courant;

    /**
     * plat contient la liste de tous les plats au menu.
     */
    private ArrayList<PlatAuMenu> plat = new ArrayList<PlatAuMenu>();

    /**
     * menu contient un objet de classe Menu afin de faire la methode singleton.
     */
    private static Menu menu;

    /**
     * factory contient la factory qui sert a ajouter de nouveaux plats au menu.
     */
    private FactoryPlats factory;

    /**
     * Constructeur prive avec parametres de la classe Menu.
     * @param description contient la description du menu
     */
    private Menu(String description) {
        this.description = description;
        factory = new ConcreteFactoryPlat();

    }

    /**
     * Methode qui permet d'aller chercher l'instance du menu, necessaire car la constructeur est prive.
     * @param description contient la description du menu
     * @return l'instance du menu
     */
    public static Menu getInstance(String description){
        if(menu == null){
            menu = new Menu(description);
        }

        return menu;
    }

    /**
     * Permet d'ajouter un plat au menu.
     * @param p plat au menu a ajouter
     */
    void ajoute (PlatAuMenu p)
    {
        plat.add(p);
    }

    /**
     * Setter de la position, soit de la variable courant.
     * @param i index du plat courant
     */
    public void position(int i)
    {
        courant = i;
    }

    /**
     * Getter du plat au menu courant.
     * @return retourne le plat au menu a l'index courant
     */
    public PlatAuMenu platCourant()
    {
        return plat.get(courant);
    }

    /**
     * Permet d'aller a la position suivante dans le menu avec la variable courant.
     * @throws MenuException si il n'y a plus de place dans le menu
     */
    public void positionSuivante() throws MenuException
    {
        if (courant+1 >= plat.size())
            throw new MenuException("On depasse le nombre maximale de plats.");
        else
            courant++;
    }

    /**
     * Permet d'aller a la position precedente dans le menu avec la variable courant.
     * @throws MenuException si on est deja au debut du menu
     */
    public void positionPrecedente() throws MenuException
    {
        if (courant-1 < 0)
            throw new MenuException("On depasse le nombre minimale de plats");
        else
            courant--;
    }

    /**
     * Surcharge de la methode toString pour pouvoir afficher les informations du menu.
     * @return String contenant les informations du menu
     */
    @Override
    public String toString() {
        return "menufact.Menu{" +
                "description='" + description + '\'' +
                ", courant=" + courant +
                ", plat=" + "\n" + plat +
                '}';
    }
}
