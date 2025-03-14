package testObjects;

import main.ListeObjects.ListeDouleChainage;
import main.ListeObjects.SortiException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestListeDoubleChainage {

    ListeDouleChainage liste;
    ListeDouleChainage liste1;
    ListeDouleChainage liste2;
    Object obj;

    @BeforeEach
    public void setup(){
        liste = new ListeDouleChainage();
        liste1 = new ListeDouleChainage();
        liste2 = new ListeDouleChainage();
        obj = new Object();
    }

    @Test
    public void testEstVideNew(){
        assertTrue(liste.estVide());
    }

    @Test
    public void testEstVideAjouter() throws SortiException {
        this.liste.ajouterD(obj);
        assertFalse(this.liste.estVide());
    }

    @Test
    public void testValec1() throws SortiException {
    }

    @Test
    public void testSucc() throws SortiException {
        this.liste.pred();
        this.liste.succ();
        assertEquals(this.liste1, this.liste);
    }
}
