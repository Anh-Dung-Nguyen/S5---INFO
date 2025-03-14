public class TablesCouples {
    private Couple[] couples;

    public TablesCouples() {
        couples = new Couple[1000];
    }

    public String toString(){
        String res = "";
        for (int i = 0; i < couples.length; i++) {
            res += couples[i].toString();
            System.out.println("\n");
        }
        return res;
    }

    public boolean ajouter(Mot m1, Mot m2){
        int codeM1 = m1.hashCode() % 1000;
        if (couples[codeM1] == null) {
            couples[codeM1] = new Couple(m1, m2);
            return true;
        }
        return false;
    }

    public Mot traduire(Mot m){
        int codeM = m.hashCode() % 1000;
        if (couples[codeM] == null) {
            return null;
        } else if (!couples[codeM].getMot().equals(m)) {
            return null;
        } else {
            return couples[codeM].compCoupleMot(m);
        }
    }
}
