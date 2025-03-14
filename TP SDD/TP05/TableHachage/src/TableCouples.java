public class TableCouples {

    private Couple[] couples;

    public TableCouples() {
        this.couples = new Couple[100];
    }

    public String toString(){
        String res = "";
        for (int i = 0; i < this.couples.length; i++) {
            res += this.couples[i].toString();
        }
        return res;
    }

    public boolean ajouter(Mot m, Mot n){
        int codeM = m.hashCode() % 100;
        if (couples[codeM] == null) {
            couples[codeM] = new Couple(m, n);
            return true;
        }
        return false;
    }

    public Mot traduire(Mot m){
        int codeM = m.hashCode() % 100;
        if (couples[codeM] == null) {
            return null;
        }
        else if (!couples[codeM].getMot().equals(m)) {
            return null;
        } else {
            return couples[codeM].compCoupleMot(m);
        }
    }
}
