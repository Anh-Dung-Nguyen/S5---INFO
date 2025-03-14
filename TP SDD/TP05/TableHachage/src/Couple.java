public class Couple {
    private Mot mot;
    private Mot traduction;

    public Couple(Mot mot, Mot traduction) {
        this.mot = mot;
        this.traduction = traduction;
    }

    public String toString(){
        return this.mot + " means " + this.traduction;
    }

    public Mot getMot(){
        return this.mot;
    }

    public Mot compCoupleMot(Mot m){
        if (this.mot.equals(m)){
            return this.traduction;
        }
        return null;
    }
}
