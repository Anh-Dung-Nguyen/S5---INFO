package cpoo1.exo5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

interface Pion {
    int getX();
    int getY();
}

public class PlateauJeu {

    /*
    Les classes d'équivalence de la coordonnée x et y:
    Les valeurs valides: x = [0, SIZE - 1] et y = [0, SIZE - 1]
    Les valeurs invalides: x < 0 et y < 0
                           x > SIZE et y > SIZE
     */

    /**
     * Un plateau est carré et de cette dimension.
     **/
    public static final int SIZE = 5;

    private final List<Pion> pions;
    //la référence à la liste ne peut pas être réassignée, mais le contenu de la liste (c'est-à-dire les éléments qu'elle contient) peut être modifié.

    /*
    Attribut primitif final (SIZE) : Sa valeur est constante après l'initialisation.
    Par exemple, SIZE est toujours égal à 5 et ne peut pas être changé.

    Attribut complexe final (pions) : Bien que la référence à la liste ne puisse pas être changée, les éléments de la liste peuvent être ajoutés ou supprimés.
    La structure des données peut donc être modifiée, mais la référence à cette structure reste constante.
     */

    public PlateauJeu() {
        pions = new ArrayList<>();
    }

    /**
     * @return La liste des pions du plateau.
     * La liste retournée n'est pas modifiable : par exemple, un appel à clear() sur cette liste
     * levera une exception UnmodifiableListException.
     */
    public List<Pion> getPions() {
        return Collections.unmodifiableList(pions);
    }

    /**
     * Retourne vrai si aucun pion n'est placé aux coordonnées données.
     **/
    public boolean isFree(final int x, final int y) {
        if(isOut(x) || isOut(y)) {
            return false;
        }

        for (final Pion pion : pions) {
            if (pion.getX() == x && pion.getY() == y) {
                return false;
            }
        }

        return true;
    }

    /**
     * Ajoute un pion au plateau si non nul et si aucun autre pion n'est déjà placé
     * aux mêmes coordonnées.
     **/
    public boolean addPion(final Pion p) {
        if (p == null || !isFree(p.getX(), p.getY())) {
            return false;
        }
        pions.add(p);
        return true;
    }

    /**
     * La position d'un élément du plateau est forcement dans l'intervalle [0,SIZE[.
     **/
    public boolean isOut(final int value) {
        return value < 0 || value >= SIZE;
    }
}
