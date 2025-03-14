public interface Arbre {
    public Object racine();
    public Arbre arbreG();
    public Arbre arbreD();
    public boolean estVide();
    public void vider();
    public String toString();
    public void dessiner();
    public int hauteur() throws EstVideException;
    public int denombrer(Object o);
    public void remplacer(Object o1, Object o2);
    public void modifRacine(Object o);
}
