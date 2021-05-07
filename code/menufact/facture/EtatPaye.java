package menufact.facture;

import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

import java.util.ArrayList;

public class EtatPaye extends EtatFacture{

    public EtatPaye(Facture facture) {
        super(facture);
    }

    @Override
    public void payer() {
        return;
    }

    @Override
    public void fermer() throws FactureException {
        throw new FactureException("On peut changer l'etat, la facture est payee");
    }

    @Override
    public void ouvrir() throws FactureException{
        System.out.println("calisse");
        throw new FactureException("On peut changer l'etat, la facture est payee");

    }

    @Override
    public void ajoutePlat(PlatChoisi p, ArrayList<PlatChoisi> platchoisi) throws FactureException{
        throw new FactureException("On peut ajouter un plat seulement sur une facture OUVERTE.");
    }

    @Override
    public void retirerPlat() throws FactureException{
        throw new FactureException("On peut retirer un plat seulement sur une facture OUVERTE.");
    }

    @Override
    public void selectionnerPlat() {

    }
}
