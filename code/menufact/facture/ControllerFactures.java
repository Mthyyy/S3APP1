package menufact.facture;

public class ControllerFactures {

    private Facture facture;
    private Vue vue;

    public ControllerFactures(Facture facture, Vue vue){
        this.facture = facture;
        this.vue = vue;
    }

    public Facture getFacture(){
        return facture;
    }

    public void connectionVue(){
        vue.setFacture(getFacture());
    }
}
