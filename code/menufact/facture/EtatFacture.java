package menufact.facture;

import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

import java.util.ArrayList;

/**
 * La classe abstraite EtatFacture contient toutes les methodes et les attributs necessaire pour faire la modele de conception State pour la facture.
 * @author Mathias Gagnon
 * @version 1.0
 * @see Facture
 */
public abstract class EtatFacture {

    /**
     * facture est l'objet auquel les etats sont associes
     */
    protected Facture facture;

    /**
     * constructeur avec parametres de la classe
     * @param facture facture a laquelle il faut associer les etats
     */
    public EtatFacture(Facture facture){
        this.facture = facture;
    }

    /**
     * Methode qui permet de payer la facture
     */
    public abstract void payer();

    /**
     * Methode qui permet de fermer la facture
     * @throws FactureException Peut se produire dependemment de l'etat
     */
    public abstract void fermer() throws FactureException;

    /**
     * Methode qui permet d'ouvrir la facture
     * @throws FactureException Peut se produire dependemment de l'etat
     */
    public abstract void ouvrir() throws FactureException;

    /**
     * Methode qui permet d'ajouter un plat a la facture
     * @param p plat a ajouter
     * @param platchoisi liste des plats a laquelle il faut ajouter le plat p
     * @throws FactureException Peut se produire dependemment de l'etat
     */
    public abstract void ajoutePlat(PlatChoisi p, ArrayList<PlatChoisi> platchoisi) throws FactureException;

    /**
     * Methode qui permet de retirer un plat de la facture
     * @throws FactureException Peut se produire dependemment de l'etat
     */
    public abstract void retirerPlat() throws FactureException;

    /**
     * Methode qui permet de selectionner un plat
     */
    public abstract void selectionnerPlat();
}
