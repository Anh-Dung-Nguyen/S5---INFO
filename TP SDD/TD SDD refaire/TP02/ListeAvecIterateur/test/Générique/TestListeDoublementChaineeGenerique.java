package Générique;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestListeDoublementChaineeGenerique<T> {
    private ListeDoublementChaineeGenerique<Integer> liste;
    private IterateurDoublementChaineeGenerique<Integer> iterateur;

    @BeforeEach
    void setup(){
        liste = new ListeDoublementChaineeGenerique<>();
        iterateur = new IterateurDoublementChaineeGenerique<>(liste);
    }

    @Test
    void testEstVide(){
        assertTrue(liste.estVide());
    }

    @Test
    void testEstPasVide(){
        iterateur.ajouterD(0);
        assertFalse(liste.estVide());
    }

    @Test
    void testVider(){
        iterateur.ajouterD(0);
        liste.vider();
        assertTrue(liste.estVide());
    }
}
