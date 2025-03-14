package Generique;

public interface Liste<T> {
    public void entete();
    public void enqueue();
    public void succ() throws SortiExceptionGenerique;
    public void pred() throws SortiExceptionGenerique;
    public void ajouterD(T o) throws SortiExceptionGenerique;
    public void oterec() throws SortiExceptionGenerique;
    public T valec() throws SortiExceptionGenerique;
    public boolean estSorti();
    public boolean estVide();
}
