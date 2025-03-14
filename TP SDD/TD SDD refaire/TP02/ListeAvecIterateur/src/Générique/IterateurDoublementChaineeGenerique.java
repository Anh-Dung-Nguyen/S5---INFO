package Générique;

public class IterateurDoublementChaineeGenerique<T> implements IterateurGenerique<T>{
    public ListeDoublementChaineeGenerique<T> liste;
    public ListeDoublementChaineeGenerique.Maillon<T> ec;

    public IterateurDoublementChaineeGenerique(ListeDoublementChaineeGenerique<T> liste){
        this.liste = liste;
        this.ec = this.liste.tete;
    }

    @Override
    public void entete(){
        this.ec = this.liste.tete.s;
    }

    @Override
    public void enqueue(){
        this.ec = this.liste.queue.s;
    }

    @Override
    public void succ() throws SortiException {
        if (this.estSorti()){
            throw new SortiException("Sortie");
        }
        this.ec = this.ec.s;
    }

    @Override
    public void pred() throws SortiException {
        if (this.estSorti()){
            throw new SortiException("Sortie");
        }
        this.ec = this.ec.p;
    }

    @Override
    public void ajouterD(T o) throws SortiException {
        if (this.estSorti() && !this.liste.estVide()){
            throw new SortiException("Sortie");
        }
        if (this.liste.estVide()){
            this.ec = this.liste.tete;
        }
        ListeDoublementChaineeGenerique.Maillon<T> m = new ListeDoublementChaineeGenerique.Maillon<T>(o);
        m.p = this.ec;
        this.ec.s.p = m;
        m.s = this.ec.s;
        this.ec.s = m;
        this.ec = m;
    }

    @Override
    public void ajouterG(T o) throws SortiException {
        if (this.estSorti() && !this.liste.estVide()){
            throw new SortiException("Sortie");
        }
        if (this.liste.estVide()){
            this.ec = this.liste.queue;
        }
        ListeDoublementChaineeGenerique.Maillon<T> m = new ListeDoublementChaineeGenerique.Maillon<T>(o);
        m.p = this.ec.p;
        this.ec.p.s = m;
        m.s = this.ec;
        this.ec.p = m;
        this.ec = m;
    }

    @Override
    public void oterec() throws SortiException {
        if (this.estSorti()){
            throw new SortiException("Sortie");
        }
        this.ec.s.p = this.ec.p;
        this.ec.p.s = this.ec.s;
        this.ec = this.ec.s;
    }

    @Override
    public T valec() throws SortiException {
        if (this.estSorti()){
            throw new SortiException("Sortie");
        }
        return this.ec.val;
    }

    @Override
    public void modifec(T o) throws SortiException {
        if (this.estSorti()){
            throw new SortiException("Sortie");
        }
        this.ec.val = o;
    }

    @Override
    public boolean estSorti(){
        return this.ec.p == null || this.ec.s == null;
    }
}
