package Générique;

public interface IterateurGenerique<T> {
    public void entete();
    public void enqueue();
    public void succ() throws SortiException;
    public void pred() throws SortiException;
    public void ajouterD(T o) throws SortiException;
    public void ajouterG(T o) throws SortiException;
    public void oterec() throws SortiException;
    public T valec() throws SortiException;
    public void modifec(T o) throws SortiException;
    public boolean estSorti();
}
