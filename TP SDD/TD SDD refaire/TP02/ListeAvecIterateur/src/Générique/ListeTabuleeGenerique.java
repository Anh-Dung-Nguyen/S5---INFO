package Générique;

public class ListeTabuleeGenerique<T> implements ListeGenerique<T> {
    public static final int MAX = 100;
    public T[] listeTabuleeGenerique;
    public int occupation;


    public ListeTabuleeGenerique(){
        listeTabuleeGenerique = (T[]) new Object[MAX];
        this.occupation = 0;
    }

    @Override
    public void vider(){
        while (this.occupation > 0){
            this.listeTabuleeGenerique[this.occupation - 1] = null;
            this.occupation--;
        }
    }

    @Override
    public boolean estVide(){
        return this.occupation == 0;
    }

    @Override
    public IterateurGenerique<T> iterateurGenerique(){
        return new IterateurListeTabuleeGenerique<T>(this);
    }
}
