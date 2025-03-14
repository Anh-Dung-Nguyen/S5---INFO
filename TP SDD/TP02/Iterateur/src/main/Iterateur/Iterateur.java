package main.Iterateur;

public interface Iterateur {
    void entete();
    void enqueue();
    void succ() throws SortiException;
    void pred() throws SortiException;
    void ajouterD(Object d) throws SortiException;
    void ajouterG(Object g) throws SortiException;
    void oterec() throws SortiException;
    Object valec()throws SortiException;
    boolean estSorti();
    void modifec(Object m) throws SortiException;
}