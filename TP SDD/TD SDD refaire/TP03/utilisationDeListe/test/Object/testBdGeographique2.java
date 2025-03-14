package Object;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class testBdGeographique2 {
    private BdGeographique2 bdGeographique2;
    private Engistrement e1;
    private Engistrement e2;

    @BeforeEach
    void setup(){
        bdGeographique2 = new BdGeographique2();
        e1 = new Engistrement("Paris", new Coordonnees(69, 96), 20000);
        e2 = new Engistrement("Hanoi", new Coordonnees(100, 100), 30000);
        bdGeographique2.ajouter(e2);
    }

    @Test
    void testEstPresentTrue(){
        assertTrue(bdGeographique2.estPresent(e2));
    }

    @Test
    void testEstPresentFalse(){
        assertFalse(bdGeographique2.estPresent(e1));
    }

    @Test
    void testVider(){
        bdGeographique2.vider();
        assertFalse(bdGeographique2.estPresent(e2));
    }

    @Test
    void testAjouter(){
        bdGeographique2.ajouter(e1);
        assertTrue(bdGeographique2.estPresent(e1));
    }

    @Test
    void testAjouterException() throws estPresentException{
        assertThrows(estPresentException.class, () -> bdGeographique2.ajouter(e2));
    }

    @Test
    void testRetirer(){
        bdGeographique2.retirer(e2);
        assertFalse(bdGeographique2.estPresent(e2));
    }

    @Test
    void testRetirerException() throws estPresentException{
        assertThrows(estPresentException.class, () -> bdGeographique2.retirer(e1));
    }

    @Test
    void testVille(){
        assertEquals(e2, bdGeographique2.ville("Hanoi"));
    }

    @Test
    void testCoord(){
        assertEquals(e2, bdGeographique2.coord(e2.getCoordonnes()));
    }

    @Test
    void testRetirerVille(){
        bdGeographique2.retirerVille("Hanoi");
        assertFalse(bdGeographique2.estPresent(e2));
    }

    @Test
    void testRetirerVilleException() throws AbsentException{
        assertThrows(AbsentException.class, () -> bdGeographique2.retirerVille("Paris"));
    }

    @Test
    void testRetirerCoord(){
        bdGeographique2.retirerCoord(e2.getCoordonnes());
        assertFalse(bdGeographique2.estPresent(e2));
    }

    @Test
    void testRetirerCoordException(){
        assertThrows(AbsentException.class, () -> bdGeographique2.retirerCoord(new Coordonnees(69, 96)));
    }

    @Test
    void testGetPopulation(){
        bdGeographique2.ajouter(e1);
        assertEquals(50000, bdGeographique2.population());
    }
}
