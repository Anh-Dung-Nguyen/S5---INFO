package cpoo1.exo9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestExo9 {
    Exo9 exo9;
    Exo9 exo99;

    @BeforeEach
    void setUp() {
        exo9 = new Exo9();
    }

    @Test
    void testIsEmpty() {
        assertTrue(exo9.estVide());
    }

    @Test
    void testAjouterElement() {
        exo9.ajouterElement("foo");
        assertFalse(exo9.estVide());
        assertTrue(exo9.contient("foo"));
    }

    @Test
    void testContient() {
        exo9.ajouterElement("bar");
        assertTrue(exo9.contient("bar"));
        assertFalse(exo9.contient("foo"));
    }

    @Test
    void testAjouterPlusieursElements() {
        exo9.ajouterElement("foo");
        exo9.ajouterElement("bar");
        exo9.ajouterElement("baz");
        assertTrue(exo9.contient("foo"));
        assertTrue(exo9.contient("bar"));
        assertTrue(exo9.contient("baz"));
        assertFalse(exo9.estVide());
    }
}

/**
 1.
    La méthode testIsEmpty() n'est testée adéquate car elle teste seulement le cas quand elle est vide et retourne true.
 Il faut vérifier aussi dans les cas où après on ajoute un élément ou on supprime un élément.
    La méthode testAjouterElement() n'as pas la vérification.
 Elle ajoute un élément mais pas fait le test.
    La méthode testContient() lèvera une exception IndexOutOfBoundsException.
 Le méthode contient() dans Exo9 parcourt de i = 0 et i <= taille donc taille max ici est -1
 2.
    Quand on commente les contenus dans les 3 méthodes dans Exo9.java, les tests passent toujours.
 */
