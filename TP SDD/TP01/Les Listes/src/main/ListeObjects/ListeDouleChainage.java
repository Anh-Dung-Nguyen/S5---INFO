package main.ListeObjects;

import org.w3c.dom.Node;

public class ListeDouleChainage implements Liste{
    protected Maillon tete;
    protected Maillon ec;
    protected Maillon queue;

    private class Maillon{
        Object val;
        Maillon succ;
        Maillon pred;
    }

    public ListeDouleChainage(){
        tete = new Maillon();
        queue = new Maillon();
        tete.succ = queue;
        queue.pred = tete;
        entete();
    }

    @Override
    public boolean estSorti() {
        return this.ec == this.queue || this.ec == this.tete;
    }

    @Override
    public boolean estVide() {
        return this.tete.succ == this.queue;
    }

    @Override
    public void entete(){
        this.ec = this.tete.succ;
    }

    @Override
    public void enqueue(){
        this.ec = this.queue.pred;
    }

    @Override
    public void succ() throws SortiException{
        if(this.estSorti()){
            throw new SortiException("Erreur");
        }
        this.ec = this.ec.succ;
    }

    @Override
    public void pred() throws SortiException{
        if(!this.estSorti()){
            throw new SortiException("Erreur");
        }
        this.ec = this.queue.pred;
    }

    @Override
    public Object valec() throws SortiException{
        if(this.estSorti()){
            throw new SortiException("Erreur");
        }
        return this.ec.val;
    }

    @Override
    public void ajouterD(Object d) throws SortiException {
        if(!this.estVide() && this.estSorti()){
            throw new SortiException("Erreur");
        }
        if(this.estVide()){
            this.ec = tete;
        }
        Maillon c = new Maillon();
        c.pred = this.ec;
        this.ec.succ.pred = c;
        c.succ = this.ec.succ;
        this.ec.succ = c;
    }

    @Override
    public void oterec() throws SortiException{
        if (this.estVide()){
            throw new SortiException("Erreur");
        }
        this.ec.pred.succ = this.ec.succ;
        this.ec.succ.pred = this.ec.pred;
        this.ec = this.ec.succ;
    }
}
