package TestIterateur;

import main.Iterateur.ListeTabulee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestIterateur {
    ListeTabulee liste;
    ListeTabulee liste1;

    @BeforeEach
    void setUp() {
        liste = new ListeTabulee();

        liste1 = new ListeTabulee();
        liste1.tab[0] = "Elément 1";
        liste1.tab[1] = "Elément 2";
        liste1.tab[2] = "Elément 3";
        liste1.oc = 3;
    }

    @Test
    void testEstVide() {
        assertTrue(liste.estVide());
    }

    @Test
    void testVider1(){
        assertFalse(liste1.estVide());
    }

    @Test
    void testVider2(){
        liste1.vider();
        assertTrue(liste1.estVide());
    }
}
