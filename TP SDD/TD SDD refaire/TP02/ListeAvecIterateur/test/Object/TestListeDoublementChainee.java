package Object;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestListeDoublementChainee {
    private ListeDoublementChainee liste;
    private IterateurDoublementChainee iterateur;

    @BeforeEach
    void setup(){
        liste = new ListeDoublementChainee();
        iterateur = new IterateurDoublementChainee(liste);
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
