package Générique;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestIterateurDoublementChaineeGenerique<T> {
    public ListeDoublementChaineeGenerique<Integer> liste;
    public IterateurDoublementChaineeGenerique<Integer> iterateur;

    @BeforeEach
    void setup(){
        liste = new ListeDoublementChaineeGenerique<>();
        iterateur = new IterateurDoublementChaineeGenerique<>(liste);
    }

    @Test
    void testNewEmpty(){
        assertTrue(liste.estVide());
    }

    @Test
    void testNotEmpty(){
        iterateur.ajouterD(0);
        assertFalse(liste.estVide());
    }

    @Test
    void oterecMovesToNext(){
        iterateur.ajouterD(1);
        iterateur.ajouterD(2);
        iterateur.entete();
        iterateur.oterec();
        assertEquals(2, iterateur.valec());
    }

    @Test
    void removedGone(){
        iterateur.ajouterD(1);
        iterateur.ajouterD(2);
        iterateur.ajouterD(3);
    }

    @Test
    void succOfPredIsSame(){
        iterateur.ajouterD(1);
        iterateur.ajouterD(2);
        iterateur.entete();
        iterateur.succ();
        iterateur.pred();
        assertEquals(1, iterateur.valec());
    }

    @Test
    void predOfSuccIsSame(){
        iterateur.ajouterD(1);
        iterateur.ajouterD(2);
        iterateur.entete();
        iterateur.succ();
        iterateur.pred();
        iterateur.succ();
        assertEquals(2, iterateur.valec());
    }

    @Test
    void succFromEnqueueOutOfBound() throws NullPointerException{
        iterateur.ajouterD(1);
        iterateur.enqueue();
        assertThrows(NullPointerException.class, () -> iterateur.succ());
    }

    @Test
    void predFromEnteteOutOfBound(){
        iterateur.ajouterD(1);
        iterateur.entete();
        iterateur.pred();
        assertTrue(iterateur.estSorti());
    }

    @Test
    void NewListOutOfBound(){
        assertTrue(iterateur.estSorti());
    }

    @Test
    void entetePutsOnItem(){
        iterateur.ajouterD(1);
        iterateur.entete();
        assertFalse(iterateur.estSorti());
    }

    @Test
    void enqueuePutsOnItem() throws NullPointerException{
        iterateur.ajouterD(1);
        iterateur.enqueue();
        assertThrows(NullPointerException.class, () -> iterateur.valec());
    }

    @Test
    void addingDoesPutOutOfBound(){
        iterateur.ajouterD(1);
        assertEquals(1, iterateur.valec());
    }

    @Test
    void ecMovesToNew(){
        iterateur.ajouterD(1);
        assertEquals(1, iterateur.valec());
    }

    @Test
    void ecPredMovesToNewPred(){
        iterateur.ajouterD(1);
        iterateur.ajouterD(2);
        iterateur.pred();
        assertEquals(1, iterateur.valec());
    }

    @Test
    void ecSuccMovesToNewSucc(){
        iterateur.ajouterD(1);
        iterateur.ajouterD(2);
        iterateur.entete();
        iterateur.succ();
        assertEquals(2, iterateur.valec());
    }

    @Test
    void valecThrowsOnOut(){
        assertTrue(iterateur.estSorti());
        assertThrows(SortiException.class, () -> iterateur.valec());
    }

    @Test
    void predOnOutOfBounds(){
        assertTrue(iterateur.estSorti());
        assertThrows(SortiException.class, () -> iterateur.pred());
    }

    @Test
    void succOnOutOfBounds(){
        assertTrue(iterateur.estSorti());
        assertThrows(SortiException.class, () -> iterateur.succ());
    }

    @Test
    void preOnOterRecOutOfBounds(){
        assertTrue(iterateur.estSorti());
        assertThrows(SortiException.class, () -> iterateur.oterec());
    }

    @Test
    void preAjouterD() throws NullPointerException{
        iterateur.ajouterD(1);
        assertFalse(liste.estVide());
        iterateur.enqueue();
        assertThrows(NullPointerException.class, () -> iterateur.succ());
        assertThrows(NullPointerException.class, () -> iterateur.ajouterD(2));
    }
}
