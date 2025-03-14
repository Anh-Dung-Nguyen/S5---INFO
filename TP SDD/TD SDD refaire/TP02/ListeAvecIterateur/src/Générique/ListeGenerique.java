package Générique;

public interface ListeGenerique<T> {
    public void vider();
    public boolean estVide();
    IterateurGenerique<T> iterateurGenerique();
}
