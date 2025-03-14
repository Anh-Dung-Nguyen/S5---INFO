import java.util.LinkedList;

public class TablesCouplesLinkedList {
    private LinkedList<Couple>[] listes;

    public TablesCouplesLinkedList() {
        this.listes = new LinkedList[100];
        for (int i = 0; i < 100; i++) {
            this.listes[i] = new LinkedList<>();
        }
    }

    public String toString(){
        String res = "";
        for (LinkedList<Couple> list : this.listes) {
            for (Couple couple : list) {
                res += couple.toString() + "\n";
            }
        }
        return res;
    }

    public boolean ajouter(Mot m1, Mot m2){
        int codeM1 = m1.hashCode() % 100;
        for (Couple couple : this.listes[codeM1]) {
            if (couple.getMot().equals(m1)) {
                return false;
            }
        }
        this.listes[codeM1].add(new Couple(m1, m2));
        return true;
    }

    public Mot traduire(Mot m){
        int codeM = m.hashCode() % 100;
        for (Couple couple : this.listes[codeM]) {
            if (couple.getMot().equals(m)) {
                return couple.compCoupleMot(m);
            }
        }
        return null;
    }
}
