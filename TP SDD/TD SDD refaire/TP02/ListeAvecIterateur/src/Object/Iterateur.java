package Object;

public interface Iterateur {
    public void entete();
    public void enqueue();
    public void succ() throws SortiException;
    public void pred() throws SortiException;
    public void ajouterD(Object o) throws SortiException;
    public void ajouterG(Object o) throws SortiException;
    public void oterec() throws SortiException;
    public Object valec() throws SortiException;
    public void modifec(Object o) throws SortiException;
    public boolean estSorti();
}
