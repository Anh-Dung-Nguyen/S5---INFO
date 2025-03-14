package Object;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ListeDouleChainageTest {
    private ListeDoubleChainage ldc;

    @BeforeEach
    void setup(){
        ldc = new ListeDoubleChainage();
    }

    @Test
    void testNewEmpty(){
        assertTrue(ldc.estVide());
    }

    @Test
    void testNotEmpty(){
        ldc.ajouterD(1);
        assertFalse(ldc.estVide());
    }

    @Test
    void oterecMovesToNext(){
        ldc.ajouterD(1);
        ldc.ajouterD(2);
        ldc.entete();
        ldc.oterec();
        assertEquals(2, ldc.valec());
    }

    @Test
    void removedGone(){
        ldc.ajouterD(1);
        ldc.ajouterD(2);
        ldc.ajouterD(3);
    }

    @Test
    void succOfPredIsSame(){
        ldc.ajouterD(1);
        ldc.ajouterD(2);
        ldc.entete();
        ldc.succ();
        ldc.pred();
        assertEquals(1, ldc.valec());
    }

    @Test
    void predOfSuccIsSame(){
        ldc.ajouterD(1);
        ldc.ajouterD(2);
        ldc.entete();
        ldc.succ();
        ldc.pred();
        ldc.succ();
        assertEquals(2, ldc.valec());
    }

    @Test
    void succFromEnqueueOutOfBound(){
        ldc.ajouterD(1);
        ldc.enqueue();
        ldc.succ();
        assertTrue(ldc.estSorti());
    }

    @Test
    void predFromEnteteOutOfBound(){
        ldc.ajouterD(1);
        ldc.entete();
        ldc.pred();
        assertTrue(ldc.estSorti());
    }

    @Test
    void NewListOutOfBound(){
        assertTrue(ldc.estSorti());
    }

    @Test
    void entetePutsOnItem(){
        ldc.ajouterD(1);
        ldc.entete();
        assertFalse(ldc.estSorti());
    }

    @Test
    void enqueuePutsOnItem(){
        ldc.ajouterD(1);
        ldc.enqueue();
        assertFalse(ldc.estSorti());
    }

    @Test
    void addingDoesPutOutOfBound(){
        ldc.ajouterD(1);
        assertEquals(1, ldc.valec());
    }

    @Test
    void ecMovesToNew(){
        ldc.ajouterD(1);
        assertEquals(1, ldc.valec());
    }

    @Test
    void ecPredMovesToNewPred(){
        ldc.ajouterD(1);
        ldc.ajouterD(2);
        ldc.pred();
        assertEquals(1, ldc.valec());
    }

    @Test
    void ecSuccMovesToNewSucc(){
        ldc.ajouterD(1);
        ldc.ajouterD(2);
        ldc.entete();
        ldc.succ();
        assertEquals(2, ldc.valec());
    }

    @Test
    void valecThrowsOnOut(){
        assertTrue(ldc.estSorti());
        assertThrows(SortiException.class, () -> ldc.valec());
    }

    @Test
    void predOnOutOfBounds(){
        assertTrue(ldc.estSorti());
        assertThrows(SortiException.class, () -> ldc.pred());
    }

    @Test
    void succOnOutOfBounds(){
        assertTrue(ldc.estSorti());
        assertThrows(SortiException.class, () -> ldc.succ());
    }

    @Test
    void preOnOterRecOutOfBounds(){
        assertTrue(ldc.estSorti());
        assertThrows(SortiException.class, () -> ldc.oterec());
    }

    @Test
    void preAjouterD(){
        ldc.ajouterD(1);
        assertFalse(ldc.estVide());
        ldc.enqueue();
        ldc.succ();
        assertTrue(ldc.estSorti());
        assertThrows(SortiException.class, () -> ldc.ajouterD(2));
    }
}
