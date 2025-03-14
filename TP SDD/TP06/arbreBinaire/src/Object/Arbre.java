package Object;

public interface Arbre {
    public Object racine();
    public Arbre arbreG();
    public Arbre arbreD();
    public boolean estVide();
    public void vider();
    public void modifRacine(Object r);
    public void modifArbreG(Object a);
    public void modifArbreD(Object a);
    public String toString();
    public void dessiner();
    public int denombrer(Object o);
    public void remplacer(Object o1, Object o2);
    public int hauteur() throws ArithmeticException;
}
