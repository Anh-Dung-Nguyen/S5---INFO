package Générique;

public class ListeDoublementChaineeGenerique<T> implements ListeGenerique<T> {
    public final ListeDoublementChaineeGenerique.Maillon tete;
    public final ListeDoublementChaineeGenerique.Maillon queue;

    public static class Maillon<T>{
        T val;
        ListeDoublementChaineeGenerique.Maillon<T> p;
        ListeDoublementChaineeGenerique.Maillon<T> s;
        public Maillon(T val){
            this.val = val;
        }
    }

    public ListeDoublementChaineeGenerique(){
        tete = new Maillon<T>(null);
        queue = new Maillon<T>(null);
        tete.s = queue;
        queue.p = tete;
    }

    @Override
    public void vider(){
        tete.s = this.queue;
        queue.p = this.tete;
    }

    @Override
    public boolean estVide(){
        return this.tete.s == this.queue;
    }

    @Override
    public IterateurGenerique<T> iterateurGenerique(){
        return new IterateurDoublementChaineeGenerique<T>(this);
    }
}
