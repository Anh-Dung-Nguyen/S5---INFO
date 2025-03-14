package Generique;

public class ListeDoubleChainageGenerique<T> implements Liste<T> {
    private final Maillon<T> tete;
    private final Maillon<T> queue;
    private Maillon<T> ec;

    private static class Maillon<T>{
        T val;
        Maillon<T> s;
        Maillon<T> p;
        public Maillon(T o){
            this.val = o;
        }
    }

    public ListeDoubleChainageGenerique(){
        tete = new Maillon<>(null);
        queue = new Maillon<>(null);
        ec = new Maillon<>(null);
        tete.s = queue;
        queue.p = tete;
        entete();
    }

    @Override
    public boolean estSorti(){
        return this.ec == this.tete || this.ec == this.queue;
    }

    @Override
    public boolean estVide(){
        return this.tete.s == this.queue;
    }

    @Override
    public void entete(){
        this.ec = this.tete.s;
    }

    @Override
    public void enqueue(){
        this.ec = this.queue.p;
    }

    @Override
    public void succ() throws SortiExceptionGenerique {
        if (this.estSorti()){
            throw new SortiExceptionGenerique("Sortie");
        }
        this.ec = this.ec.s;
    }

    @Override
    public void pred() throws SortiExceptionGenerique {
        if(this.estSorti()){
            throw new SortiExceptionGenerique("Sortie");
        }
        this.ec = this.ec.p;
    }

    @Override
    public void ajouterD(T o) throws SortiExceptionGenerique {
        if (!this.estVide() && this.estSorti()){
            throw new SortiExceptionGenerique("Sortie");
        }
        if (this.estSorti()){
            this.ec = this.tete;
        }
        Maillon<T> m = new Maillon<>(o);
        m.p = this.ec;
        this.ec.s.p = m;
        m.s = this.ec.s;
        this.ec.s = m;
        this.ec = m;
    }

    @Override
    public void oterec()throws SortiExceptionGenerique {
        if (this.estSorti()){
            throw new SortiExceptionGenerique("Sortie");
        }
        this.ec.p.s = this.ec.s;
        this.ec.s.p = this.ec.p;
        this.ec = this.ec.s;
    }

    @Override
    public T valec() throws SortiExceptionGenerique {
        if (this.estSorti()){
            throw new SortiExceptionGenerique("Sortie");
        }
        return this.ec.val;
    }
}