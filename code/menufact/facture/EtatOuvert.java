package menufact.facture;

import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

import java.util.ArrayList;

/**
 * La classe EtatOuvert contient les surcharges des methodes de EtatFacture lorsqu'on veut ouvrir la facture.
 * @author Mathias Gagnon
 * @version 1.0
 * @see EtatFacture
 */
public class EtatOuvert extends EtatFacture{

    /**
     * Constructeur avec parametres de la classe.
     * @param facture est la facture a laquelle l'etat est associe
     */
    public EtatOuvert(Facture facture) {
        super(facture);
    }

    /**
     * Surcharge de la methode payer.
     */
    @Override
    public void payer() {
        facture.setEtatFacture(new EtatPaye(facture));
    }

    /**
     * Surcharge de la methode fermer.
     */
    @Override
    public void fermer() {
        facture.setEtatFacture(new EtatFerme(facture));
    }

    /**
     * Surcharge de la methode ouvrir.
     */
    @Override
    public void ouvrir() {
        return;
    }

    /**
     * Surcharge de la methode ajoutePlat.
     * @param p plat a ajouter
     * @param platchoisi liste des plats a laquelle il faut ajouter le plat p
     */
    @Override
    public void ajoutePlat(PlatChoisi p, ArrayList<PlatChoisi> platchoisi) {
        platchoisi.add(p);
    }

    /**
     * Surcharge de la methode retirerPlat.
     */
    @Override
    public void retirerPlat() {
        facture.getPlatchoisi().remove(facture.getPlatSelectionner());
    }

    /**
     * Surcharge de la methode selectionnerPlat.
     */
    @Override
    public void selectionnerPlat(PlatChoisi p) {
        facture.selectionnerPlat(p);
    }
}
