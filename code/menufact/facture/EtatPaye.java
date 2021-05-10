package menufact.facture;

import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

import java.util.ArrayList;

/**
 * La classe EtatOuvert contient les surcharges des methodes de EtatFacture lorsqu'on veut payer la facture.
 * @author Mathias Gagnon
 * @version 1.0
 * @see EtatFacture
 */
public class EtatPaye extends EtatFacture{

    /**
     * Constructeur avec parametres de la classe.
     * @param facture est la facture a laquelle l'etat est associe
     */
    public EtatPaye(Facture facture) {
        super(facture);
    }

    /**
     * Surcharge de la methode payer.
     */
    @Override
    public void payer() {
        return;
    }

    /**
     * Surcharge de la methode fermer.
     * @throws FactureException Si on essai de fermer la facture alors qu'elle est deja payee
     */
    @Override
    public void fermer() throws FactureException {
        throw new FactureException("On peut changer l'etat, la facture est payee");
    }

    /**
     * Surcharge de la methode ouvrir.
     * @throws FactureException Si on essai d'ouvrir la facture alors qu'elle est deja payee
     */
    @Override
    public void ouvrir() throws FactureException{
        throw new FactureException("On peut changer l'etat, la facture est payee");

    }

    /**
     * Surcharge de la methode ajoutePlat.
     * @param p plat a ajouter
     * @param platchoisi liste des plats a laquelle il faut ajouter le plat p
     * @throws FactureException Si on essai d'ajouter un plat alors que la facture est payee
     */
    @Override
    public void ajoutePlat(PlatChoisi p, ArrayList<PlatChoisi> platchoisi) throws FactureException{
        throw new FactureException("On peut ajouter un plat seulement sur une facture OUVERTE.");
    }

    /**
     * Surcharge de la methode retirerPlat.
     * @throws FactureException Si on essai de retirer un plat alors que la facture est payee
     */
    @Override
    public void retirerPlat() throws FactureException{
        throw new FactureException("On peut retirer un plat seulement sur une facture OUVERTE.");
    }

    /**
     * Surcharge de la methode selectionnerPlat.
     */
    @Override
    public void selectionnerPlat(PlatChoisi p) throws FactureException {
    throw new FactureException("impossible la facture est payer");
    }
}
