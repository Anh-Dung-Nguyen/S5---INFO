package main.ListeObjects;

public interface Liste{
    boolean estVide();
    void entete();
    void enqueue();
    void succ() throws SortiException;
    void pred() throws SortiException;
    void ajouterD(Object d) throws SortiException;
    void oterec() throws SortiException;
    Object valec()throws SortiException;
    boolean estSorti();
}
