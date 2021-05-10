package menufact.facture;

import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

import java.util.ArrayList;

/**
 * La classe EtatFerme contient les surcharges des methodes de EtatFacture lorsqu'on veut fermer la facture.
 * @author Mathias Gagnon
 * @version 1.0
 * @see EtatFacture
 */
public class EtatFerme extends EtatFacture{

    /**
     * Constructeur avec parametres de la classe.
     * @param facture est la facture a laquelle l'etat est associe
     */
    public EtatFerme(Facture facture) {
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
        return;
    }

    /**
     * Surcharge de la methode ouvrir.
     */
    @Override
    public void ouvrir() {
        facture.setEtatFacture(new EtatOuvert(facture));
    }

    /**
     * Surcharge de la methode ajoutePlat.
     * @param p plat a ajouter
     * @param platchoisi liste des plats a laquelle il faut ajouter le plat p
     * @throws FactureException Si on essai d'ajouter un plat alors que la facture est fermee
     */
    @Override
    public void ajoutePlat(PlatChoisi p, ArrayList<PlatChoisi> platchoisi) throws FactureException {
        throw new FactureException("On peut ajouter un plat seulement sur une facture OUVERTE.");
    }

    /**
     * Surcharge de la methode retirerPlat.
     */
    @Override
    public void retirerPlat() throws FactureException {
        throw new FactureException("Impossible de slectionner un plat dans une facture ferme");
    }

    /**
     * Surcharge de la methode selectionnerPlat.
     */
    @Override
    public void selectionnerPlat(PlatChoisi p) throws FactureException {
        throw new FactureException("Impossible de slectionner un plat dans une facture ferme");
    }
}
