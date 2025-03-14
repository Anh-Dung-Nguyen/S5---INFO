package Object;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class testBdGeographique {
    private BdGeographique bdGeographique;
    private Engistrement e1;
    private Engistrement e2;

    @BeforeEach
    void setup(){
        bdGeographique = new BdGeographique();
        e1 = new Engistrement("Paris", new Coordonnees(69, 96), 20000);
        e2 = new Engistrement("Hanoi", new Coordonnees(100, 100), 30000);
        bdGeographique.ajouter(e2);
    }

    @Test
    void testEstPresentTrue(){
        assertTrue(bdGeographique.estPresent(e2));
    }

    @Test
    void testEstPresentFalse(){
        assertFalse(bdGeographique.estPresent(e1));
    }

    @Test
    void testVider(){
        bdGeographique.vider();
        assertFalse(bdGeographique.estPresent(e2));
    }

    @Test
    void testAjouter(){
        bdGeographique.ajouter(e1);
        assertTrue(bdGeographique.estPresent(e1));
    }

    @Test
    void testAjouterException() throws estPresentException{
        assertThrows(estPresentException.class, () -> bdGeographique.ajouter(e2));
    }

    @Test
    void testRetirer(){
        bdGeographique.retirer(e2);
        assertFalse(bdGeographique.estPresent(e2));
    }

    @Test
    void testRetirerException() throws estPresentException{
        assertThrows(estPresentException.class, () -> bdGeographique.retirer(e1));
    }

    @Test
    void testVille(){
        assertEquals(e2, bdGeographique.ville("Hanoi"));
    }

    @Test
    void testCoord(){
        assertEquals(e2, bdGeographique.coord(e2.getCoordonnes()));
    }

    @Test
    void testRetirerVille(){
        bdGeographique.retirerVille("Hanoi");
        assertFalse(bdGeographique.estPresent(e2));
    }

    @Test
    void testRetirerVilleException() throws AbsentException{
        assertThrows(AbsentException.class, () -> bdGeographique.retirerVille("Paris"));
    }

    @Test
    void testRetirerCoord(){
        bdGeographique.retirerCoord(e2.getCoordonnes());
        assertFalse(bdGeographique.estPresent(e2));
    }

    @Test
    void testRetirerCoordException(){
        assertThrows(AbsentException.class, () -> bdGeographique.retirerCoord(new Coordonnees(100, 100)));
    }

    @Test
    void testGetPopulation(){
        bdGeographique.ajouter(e1);
        assertEquals(50000, bdGeographique.population());
    }
}
