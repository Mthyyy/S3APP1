package menufact;

import menufact.exceptions.MenuException;
import menufact.plats.ConcreteFactoryPlat;
import menufact.plats.PlatAuMenu;
import menufact.plats.FactoryPlats;

import java.io.FileWriter;
import java.io.IOException;
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
        courant = 0;

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
     * Permet de retirer le plat courant du menu
     */
    void retirerCourant(){
        plat.remove(plat.get(courant));
    }

    /**
     * Permet de retirer un plat du menu en fonction de son code
     * @param id code du plat
     */
    void retirerPlat(int id) throws MenuException{

        try{
            for(int i = 0; i < plat.size(); i++){
                if(plat.get(i).getCode() == id){
                    plat.remove(plat.get(i));
                    return;
                }
            }

            throw new MenuException("Le plat n'est pas au menu");
        }

        catch(Exception e){
            System.out.println(e.getMessage());
        }

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
        try{
            if (courant+1 >= plat.size())
                throw new MenuException("On depasse le nombre maximale de plats.");
            else
                courant++;
        }

        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    /**
     * Permet d'aller a la position precedente dans le menu avec la variable courant.
     * @throws MenuException si on est deja au debut du menu
     */
    public void positionPrecedente() throws MenuException
    {
        try{
            if (courant-1 < 0)
                throw new MenuException("On depasse le nombre minimale de plats");
            else
                courant--;
        }

        catch (MenuException e){
            System.out.println(e.getMessage());
        }

    }

    /**
     * Permet d'aller chercher un plat dans le menu selon son code.
     * @param id code du plat a aller chercher
     * @return retourne le plat desire
     */
    public PlatAuMenu getPlat(int id){

        for(int i = 0; i < plat.size(); i++){
            if(plat.get(i).getCode() == id){
                return plat.get(i);
            }
        }

        System.out.println("Aucun plat ne correspond a ce code");
        return null;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }

    public int getCourant(){
        return courant;
    }

    public ArrayList<PlatAuMenu> getListePlats(){
        return plat;
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

    public void ecrireFichier(){
        try {
            FileWriter fichier = new FileWriter("FactureEtMenu.txt");

            fichier.append(this.toString());
            fichier.append("\n\n");
            fichier.close();

        } catch (IOException e) {
            System.out.println("Incapable d'ouvrir le fichier");
            e.printStackTrace();
        }
    }
}
