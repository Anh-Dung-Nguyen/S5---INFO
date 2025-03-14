package Object;

public class ListeDoubleChainage implements Liste{
    private final Maillon tete;
    private final Maillon queue;
    private Maillon ec;

    private static class Maillon{
        Object val;
        Maillon s;
        Maillon p;
        public Maillon(Object o){
            this.val = o;
        }
    }

    public ListeDoubleChainage(){
        tete = new Maillon(null);
        queue = new Maillon(null);
        ec = new Maillon(null);
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
    public void succ() throws SortiException{
        if (this.estSorti()){
            throw new SortiException("Sortie");
        }
        this.ec = this.ec.s;
    }

    @Override
    public void pred() throws SortiException{
        if(this.estSorti()){
            throw new SortiException("Sortie");
        }
        this.ec = this.ec.p;
    }

    @Override
    public void ajouterD(Object o) throws SortiException{
        if (!this.estVide() && this.estSorti()){
            throw new SortiException("Sortie");
        }
        if (this.estSorti()){
            this.ec = this.tete;
        }
        Maillon m = new Maillon(o);
        m.p = this.ec;
        this.ec.s.p = m;
        m.s = this.ec.s;
        this.ec.s = m;
        this.ec = m;
    }

    @Override
    public void oterec()throws SortiException{
        if (this.estSorti()){
            throw new SortiException("Sortie");
        }
        this.ec.p.s = this.ec.s;
        this.ec.s.p = this.ec.p;
        this.ec = this.ec.s;
    }

    @Override
    public Object valec() throws SortiException{
        if (this.estSorti()){
            throw new SortiException("Sortie");
        }
        return this.ec.val;
    }
}
