import java.util.LinkedList;

public class TableCouplesAmeliorer {
    private LinkedList<Couple>[] listes;

    public TableCouplesAmeliorer() {
        listes = new LinkedList[100];
        for (int i = 0; i < 100; i++) {
            listes[i] = new LinkedList<>();
        }
    }

    public String toString(){
        String res = "";
        for (LinkedList<Couple> liste : this.listes) {
            for (Couple couple : liste) {
                res = res + couple.toString() + "\n";
            }
        }
        return res;
    }

    public boolean ajouter(Mot m, Mot n){
        int codeM = m.hashCode() % 100;
        for (Couple c : this.listes[codeM]) {
            if (c.getMot().equals(m)) {
                return false;
            }
        }
        this.listes[codeM].add(new Couple(m, n));
        return true;
    }

    public Mot traduire(Mot m){
        for (Couple c : this.listes[m.hashCode()]) {
            if (c.getMot().equals(m)) {
                return c.compCoupleMot(m);
            }
        }
        return null;
    }
}
