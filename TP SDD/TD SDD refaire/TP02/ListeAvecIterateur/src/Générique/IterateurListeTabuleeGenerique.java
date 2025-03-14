package Générique;

public class IterateurListeTabuleeGenerique<T> implements IterateurGenerique<T> {
    private final ListeTabuleeGenerique<T> liste;
    private int indice = -1;

    public IterateurListeTabuleeGenerique(ListeTabuleeGenerique<T> listeTabulee) {
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
    public void succ() throws SortiException {
        if (this.estSorti()){
            throw new SortiException("Sortie");
        }
        this.indice++;
    }

    @Override
    public void pred() throws SortiException {
        if (this.estSorti()){
            throw new SortiException("Sortie");
        }
        this.indice--;
    }

    @Override
    public void ajouterD(T o) throws SortiException {
        if (this.estSorti() && !this.liste.estVide()){
            throw new SortiException("Sortie");
        }
        if(this.liste.occupation >= ListeTabuleeGenerique.MAX){
            throw new SortiException("Débordement");
        }
        for (int i = this.liste.occupation; i - 1 > this.indice; i--){
            this.liste.listeTabuleeGenerique[i] = this.liste.listeTabuleeGenerique[i - 1];
        }
        this.indice++;
        this.liste.listeTabuleeGenerique[this.indice] = o;
        this.liste.occupation++;
    }

    @Override
    public void ajouterG(T o) throws SortiException {
        if (this.estSorti() && !this.liste.estVide()){
            throw new SortiException("Sortie");
        }
        if(this.liste.occupation >= ListeTabuleeGenerique.MAX){
            throw new SortiException("Débordement");
        }
        if (this.indice < 0) {
            this.indice = 0;
        }
        for (int i = this.liste.occupation; i > this.indice; i--) {
            this.liste.listeTabuleeGenerique[i] = this.liste.listeTabuleeGenerique[i - 1];
        }
        this.liste.listeTabuleeGenerique[this.indice] = o;
        this.liste.occupation++;
    }

    @Override
    public void oterec() throws SortiException {
        if (this.estSorti()){
            throw new SortiException("Sortie");
        }
        for(int i = this.indice; i < this.liste.occupation; i++){
            this.liste.listeTabuleeGenerique[i] = this.liste.listeTabuleeGenerique[i + 1];
        }
        this.liste.occupation--;
    }

    @Override
    public T valec() throws SortiException {
        if (this.estSorti()) {
            throw new SortiException("Sortie");
        }
        return this.liste.listeTabuleeGenerique[this.indice];
    }

    @Override
    public void modifec(T o) throws SortiException {
        if (this.estSorti()){
            throw new SortiException("Sortie");
        }
        this.liste.listeTabuleeGenerique[this.indice] = o;
    }

    @Override
    public boolean estSorti(){
        return this.indice < 0 || this.indice >= ListeTabuleeGenerique.MAX;
    }
}
