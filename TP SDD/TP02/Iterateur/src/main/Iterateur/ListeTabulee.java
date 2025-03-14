package main.Iterateur;

public class ListeTabulee implements Liste {
    static final int TMAX = 1000;
    public Object tab[];
    public int oc = 0;

    public ListeTabulee() {
        tab = new Object[ListeTabulee.TMAX];
    }

    public boolean estVide(){
        return this.oc == 0;
    }

    public void vider(){
        while(this.oc > 0){
            this.tab[this.oc - 1] = null;
            this.oc--;
        }
    }

    public Iterateur iterateur(){
        return new IterateurListeTabulee(this);
    }
}
