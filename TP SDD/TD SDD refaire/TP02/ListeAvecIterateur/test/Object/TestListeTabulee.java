package Object;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestListeTabulee {
    ListeTabluee liste;
    Iterateur iterateur;

    @BeforeEach
    void setup() {
        liste = new ListeTabluee();
        iterateur = new IterateurListeTabulee(liste);
    }

    @Test
    void testNewEmpty(){
        assertTrue(liste.estVide());
    }

    @Test
    void testEstPasVide(){
        iterateur.ajouterD(1);
        assertFalse(liste.estVide());
    }

    @Test
    void testVider(){
        iterateur.ajouterD(1);
        iterateur.ajouterD(2);
        liste.vider();
        assertTrue(liste.estVide());
    }
}
