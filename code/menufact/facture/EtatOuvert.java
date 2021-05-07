package menufact.facture;

import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

import java.util.ArrayList;

public class EtatOuvert extends EtatFacture{

    public EtatOuvert(Facture facture) {
        super(facture);
    }

    @Override
    public void payer() {
        facture.setEtatFacture(new EtatPaye(facture));
    }

    @Override
    public void fermer() {
        facture.setEtatFacture(new EtatFerme(facture));
    }

    @Override
    public void ouvrir() {
        return;
    }

    @Override
    public void ajoutePlat(PlatChoisi p, ArrayList<PlatChoisi> platchoisi) throws FactureException{
        platchoisi.add(p);
    }

    @Override
    public void retirerPlat() {

    }

    @Override
    public void selectionnerPlat() {

    }
}
