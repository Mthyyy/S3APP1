package menufact.facture;

import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

import java.util.ArrayList;

public class EtatFerme extends EtatFacture{

    public EtatFerme(Facture facture) {
        super(facture);
    }

    @Override
    public void payer() {
        facture.setEtatFacture(new EtatPaye(facture));
    }

    @Override
    public void fermer() {
        return;
    }

    @Override
    public void ouvrir() {
        facture.setEtatFacture(new EtatOuvert(facture));
    }

    @Override
    public void ajoutePlat(PlatChoisi p, ArrayList<PlatChoisi> platchoisi) throws FactureException {
        throw new FactureException("On peut ajouter un plat seulement sur une facture OUVERTE.");
    }

    @Override
    public void retirerPlat() {

    }

    @Override
    public void selectionnerPlat() {

    }
}
