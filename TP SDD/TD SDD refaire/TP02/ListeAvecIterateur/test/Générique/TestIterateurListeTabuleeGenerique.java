package Générique;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestIterateurListeTabuleeGenerique<T> {
    ListeTabuleeGenerique<Integer> liste;
    IterateurListeTabuleeGenerique<Integer> iterateur;

    @BeforeEach
    void setup(){
        liste = new ListeTabuleeGenerique<>();
        iterateur = new IterateurListeTabuleeGenerique<>(liste);
    }

    @Test
    void testNewSorti(){
        assertTrue(iterateur.estSorti());
    }

    @Test
    void testEntete(){
        iterateur.ajouterD(0);
        iterateur.ajouterD(1);
        iterateur.entete();
        assertEquals(0, iterateur.valec());
    }

    @Test
    void testEnqueue(){
        iterateur.ajouterD(0);
        iterateur.ajouterD(1);
        iterateur.enqueue();
        assertEquals(1, iterateur.valec());
    }

    @Test
    void testEnqueueException(){
        iterateur.enqueue();
        assertTrue(iterateur.estSorti());
    }

    @Test
    void testSucc(){
        iterateur.ajouterD(0);
        iterateur.ajouterD(1);
        iterateur.entete();
        iterateur.succ();
        assertEquals(1, iterateur.valec());
    }

    @Test
    void testSuccException() throws SortiException {
        assertThrows(SortiException.class, () -> iterateur.succ());
    }

    @Test
    void testPred(){
        iterateur.ajouterD(0);
        iterateur.ajouterD(1);
        iterateur.enqueue();
        iterateur.pred();
        assertEquals(0, iterateur.valec());
    }

    @Test
    void testPredException() throws SortiException {
        assertThrows(SortiException.class, () -> iterateur.pred());
    }

    @Test
    void testAjouterDPasVide(){
        iterateur.ajouterD(0);
        assertFalse(liste.estVide());
    }

    @Test
    void testAjouterDPasSortie(){
        iterateur.ajouterD(0);
        assertFalse(iterateur.estSorti());
    }

    @Test
    void testAjouterD(){
        iterateur.ajouterD(0);
        assertEquals(0, iterateur.valec());
    }

    @Test
    void testAjouterDInsertion(){
        iterateur.ajouterD(0);
        iterateur.ajouterD(1);
        iterateur.pred();
        iterateur.ajouterD(2);
        iterateur.pred();
        assertEquals(0, iterateur.valec());
    }

    @Test
    void testAjouterDException() throws SortiException {
        iterateur.ajouterD(0);
        iterateur.ajouterD(1);
        iterateur.ajouterD(2);
        iterateur.ajouterD(3);
        assertThrows(SortiException.class, () -> iterateur.ajouterD(4));
    }

    @Test
    void testAjouterGPasVide(){
        iterateur.ajouterG(0);
        assertFalse(liste.estVide());
    }

    @Test
    void testAjouterGPasSortie(){
        iterateur.ajouterG(0);
        assertFalse(iterateur.estSorti());
    }

    @Test
    void testAjouterG(){
        iterateur.ajouterG(0);
        assertEquals(0, iterateur.valec());
    }

    @Test
    void testAjouterGInsertion(){
        iterateur.ajouterG(0);
        iterateur.ajouterG(1);
        iterateur.succ();
        iterateur.ajouterG(2);
        iterateur.succ();
        assertEquals(0, iterateur.valec());
    }

    @Test
    void testAjouterGException() throws SortiException {
        iterateur.ajouterG(0);
        iterateur.ajouterG(1);
        iterateur.ajouterG(2);
        iterateur.ajouterG(3);
        assertThrows(SortiException.class, () -> iterateur.ajouterG(4));
    }

    @Test
    void testOterec(){
        iterateur.ajouterD(0);
        iterateur.oterec();
        assertTrue(liste.estVide());
    }

    @Test
    void testOterecException() throws SortiException {
        assertThrows(SortiException.class, () -> iterateur.oterec());
    }

    @Test
    void testOterec2(){
        iterateur.ajouterD(0);
        iterateur.ajouterD(1);
        iterateur.ajouterD(2);
        iterateur.entete();
        iterateur.oterec();
        assertEquals(1, iterateur.valec());
    }

    @Test
    void testValecException() throws SortiException {
        assertThrows(SortiException.class, () -> iterateur.valec());
    }

    @Test
    void testModifec(){
        iterateur.ajouterD(0);
        iterateur.modifec(1);
        assertEquals(1, iterateur.valec());
    }

    @Test
    void testModifecException() throws SortiException {
        assertThrows(SortiException.class, () -> iterateur.modifec(1));
    }
}
