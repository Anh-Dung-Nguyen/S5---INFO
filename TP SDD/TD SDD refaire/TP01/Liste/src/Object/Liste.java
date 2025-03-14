package Object;

public interface Liste {
    public void entete();
    public void enqueue();
    public void succ() throws SortiException;
    public void pred() throws SortiException;
    public void ajouterD(Object o) throws SortiException;
    public void oterec() throws SortiException;
    public Object valec() throws SortiException;
    public boolean estSorti();
    public boolean estVide();
}
