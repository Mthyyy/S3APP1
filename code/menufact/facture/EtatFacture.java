package menufact.facture;

import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

import java.util.ArrayList;

public abstract class EtatFacture {
    protected Facture facture;

    public EtatFacture(Facture facture){
        this.facture = facture;
    }

    public abstract void payer();
    public abstract void fermer() throws FactureException;
    public abstract void ouvrir() throws FactureException;
    public abstract void ajoutePlat(PlatChoisi p, ArrayList<PlatChoisi> platchoisi) throws FactureException;
    public abstract void retirerPlat() throws FactureException;
    public abstract void selectionnerPlat();
}
