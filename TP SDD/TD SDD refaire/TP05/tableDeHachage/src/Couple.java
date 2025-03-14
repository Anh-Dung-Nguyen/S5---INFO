public class Couple {
    private Mot mot;
    private Mot traduction;

    public Couple(Mot mot, Mot traduction) {
        this.mot = mot;
        this.traduction = traduction;
    }

    public String toString(){
        return this.mot + ": " + this.traduction;
    }

    public Mot compCoupleMot(Mot m){
        if (m == null){
            return null;
        }
        if (this.mot == m){
            return this.traduction;
        }
        return null;
    }

    public Mot getMot(){
        return this.mot;
    }
}
