package Object;

import java.lang.annotation.Documented;

public class IterateurListeTabulee implements Iterateur {
    private final ListeTabluee liste;
    private int indice = -1;

    public IterateurListeTabulee(ListeTabluee listeTabulee) {
        this.liste = listeTabulee;
    }

    @Override
    public void entete(){
        this.indice = 0;
    }

    @Override
    public void enqueue(){
        this.indice = this.liste.occupation - 1;
    }

    @Override
    public void succ() throws SortiException{
        if (this.estSorti()){
            throw new SortiException("Sortie");
        }
        this.indice++;
    }

    @Override
    public void pred() throws SortiException{
        if (this.estSorti()){
            throw new SortiException("Sortie");
        }
        this.indice--;
    }

    @Override
    public void ajouterD(Object o) throws SortiException{
        if (this.estSorti() && !this.liste.estVide()){
            throw new SortiException("Sortie");
        }
        if(this.liste.occupation >= ListeTabluee.MAX){
            throw new SortiException("Débordement");
        }
        for (int i = this.liste.occupation; i - 1 > this.indice; i--){
            this.liste.listeTabulee[i] = this.liste.listeTabulee[i - 1];
        }
        this.indice++;
        this.liste.listeTabulee[this.indice] = o;
        this.liste.occupation++;
    }

    @Override
    public void ajouterG(Object o) throws SortiException{
        if (this.estSorti() && !this.liste.estVide()){
            throw new SortiException("Sortie");
        }
        if(this.liste.occupation >= ListeTabluee.MAX){
            throw new SortiException("Débordement");
        }
        if (this.indice < 0) {
            this.indice = 0;
        }
        for (int i = this.liste.occupation; i > this.indice; i--) {
            this.liste.listeTabulee[i] = this.liste.listeTabulee[i - 1];
        }
        this.liste.listeTabulee[this.indice] = o;
        this.liste.occupation++;
    }

    @Override
    public void oterec() throws SortiException{
        if (this.estSorti()){
            throw new SortiException("Sortie");
        }
        for(int i = this.indice; i < this.liste.occupation; i++){
            this.liste.listeTabulee[i] = this.liste.listeTabulee[i + 1];
        }
        this.liste.occupation--;
    }

    @Override
    public Object valec() throws SortiException {
        if (this.estSorti()) {
            throw new SortiException("Sortie");
        }
        return this.liste.listeTabulee[this.indice];
    }

    @Override
    public void modifec(Object o) throws SortiException{
        if (this.estSorti()){
            throw new SortiException("Sortie");
        }
        this.liste.listeTabulee[this.indice] = o;
    }

    @Override
    public boolean estSorti(){
        return this.indice < 0 || this.indice >= ListeTabluee.MAX;
    }

}
