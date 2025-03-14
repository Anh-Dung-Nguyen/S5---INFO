package Générique;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestListeTabuleeGenerique<T> {
    ListeTabuleeGenerique<Integer> liste;
    IterateurListeTabuleeGenerique<Integer> iterateur;

    @BeforeEach
    void setup() {
        liste = new ListeTabuleeGenerique<>();
        iterateur = new IterateurListeTabuleeGenerique<>(liste);
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
