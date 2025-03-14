package Object;

public class ListeDoublementChainee implements Liste{
    public final Maillon tete;
    public final Maillon queue;

    public static class Maillon{
        Object val;
        Maillon p;
        Maillon s;
        public Maillon(Object val){
            this.val = val;
        }
    }

    public ListeDoublementChainee(){
        tete = new Maillon(null);
        queue = new Maillon(null);
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
    public Iterateur iterateur(){
        return new IterateurDoublementChainee(this);
    }
}
