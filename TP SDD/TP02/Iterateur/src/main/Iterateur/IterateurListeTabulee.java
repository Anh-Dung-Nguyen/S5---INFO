package main.Iterateur;

public class IterateurListeTabulee implements Iterateur {
    private final ListeTabulee l;
    private int indice = -1;

    public IterateurListeTabulee(ListeTabulee l) {
        this.l = l;
    }

    @Override
    public void entete(){
        this.indice = 0;
    }

    @Override
    public void enqueue(){
        this.indice = this.l.oc - 1;
    }

    @Override
    public boolean estSorti(){
        return this.indice < 0 || this.indice > this.l.oc - 1;
    }

    @Override
    public void succ() throws SortiException{
        if (this.estSorti()){
            throw new SortiException("Erreur");
        }
        this.indice++;
    }

    @Override
    public void pred() throws SortiException{
        if (this.estSorti()){
            throw new SortiException("Erreur");
        }
        this.indice--;
    }

    @Override
    public void ajouterD(Object d) throws SortiException{
        if(!this.estSorti() && this.l.estVide()){
            throw new SortiException("Erreur");
        }
        if(this.l.oc > l.TMAX){
            throw new SortiException("Erreur");
        }
        for (int tmp = this.l.oc; tmp - 1 > this.indice; tmp--){
            this.l.tab[tmp] = this.l.tab[tmp - 1];
            this.indice++;
            this.l.tab[this.indice] = d;
            this.l.oc++;
        }
    }

    @Override
    public void ajouterG(Object g) throws SortiException{
        if(!this.estSorti() && this.l.estVide()){
            throw new SortiException("Erreur");
        }
        if(this.l.oc > l.TMAX){
            throw new SortiException("Erreur");
        }
        for (int tmp = this.l.oc; tmp - 1 > this.indice; tmp--){
            this.l.tab[tmp] = this.l.tab[tmp - 1];
            this.indice++;
            this.l.tab[this.indice + 1] = g;
            this.l.oc++;
        }
    }

    @Override
    public void oterec() throws SortiException{
        if (this.estSorti()){
            throw new SortiException("Erreur");
        }
        for(int tmp = this.indice; tmp < this.l.oc; tmp++){
            this.l.tab[tmp] = this.l.tab[tmp + 1];
            this.l.oc--;
        }
    }

    @Override
    public Object valec() throws SortiException{
        if(this.estSorti()){
            throw new SortiException("Erreur");
        }
        return this.l.tab[this.indice];
    }

    @Override
    public void modifec(Object m) throws SortiException{
        if(this.estSorti()){
            throw new SortiException("Erreur");
        }
        this.l.tab[this.indice] = m;
    }
}
