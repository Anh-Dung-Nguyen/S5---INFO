package Objet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BdGeographiqueTest {
    private BdGeographique bdGeographique;
    private Enregistrement enregistrement1;
    private Enregistrement enregistrement2;
    private Enregistrement enregistrement3;

    @BeforeEach
    void setup(){
        bdGeographique = new BdGeographique();
        enregistrement1 = new Enregistrement("Rennes", new Coordonnees(12.5F, 13.6F), 500);
        enregistrement2 = new Enregistrement("Hanoi", new Coordonnees(19.5F, 63.6F), 1000);
        enregistrement3 = new Enregistrement("Paris", new Coordonnees(11F, 32F), 1500);
        bdGeographique.ajouter(enregistrement3);
    }

    @Test
    void TestEstPresent(){
        assertTrue(bdGeographique.estPresent(enregistrement3));
    }

    @Test
    void TestVider(){
        bdGeographique.retirer(enregistrement3);
        assertFalse(bdGeographique.estPresent(enregistrement3));
    }

    @Test
    void TestAjouter1(){
        bdGeographique.ajouter(enregistrement1);
        assertTrue(bdGeographique.estPresent(enregistrement1));
    }

    @Test
    void TestAjouter2(){
        bdGeographique.ajouter(enregistrement2);
        assertFalse(bdGeographique.estPresent(enregistrement1));
    }

    @Test
    void TestAjouter3() throws PresentException{
        assertThrows(PresentException.class, () -> bdGeographique.ajouter(enregistrement3));
    }

    @Test
    void TestRetirer1(){
        bdGeographique.retirer(enregistrement3);
        assertFalse(bdGeographique.estPresent(enregistrement3));
    }

    @Test
    void TestRetirer2() throws RetireException{
        bdGeographique.retirer(enregistrement3);
        assertThrows(RetireException.class, () -> bdGeographique.retirer(enregistrement3));
    }

    @Test
    void TestEnregistrementVille1(){
        assertEquals(null, bdGeographique.ville("Rennes"));
    }

    @Test
    void TestEnregistrementVille2(){
        assertEquals(enregistrement3, bdGeographique.ville("Paris"));
    }

    @Test
    void TestEnregistrementCoord1(){
        assertEquals(null, bdGeographique.coord(new Coordonnees(.5F, 13.6F)));
    }

    @Test
    void TestEnregistrementCoord2(){
        assertEquals(enregistrement3, bdGeographique.coord(new Coordonnees(11F, 32F)));
    }

    @Test
    void TestRetirerVille1() throws AbsentException{
        assertThrows(AbsentException.class, () -> bdGeographique.retirerVille("Betton"));
    }

    @Test
    void TestRetirerVille2(){
        bdGeographique.retirerVille("Paris");
        assertFalse(bdGeographique.estPresent(enregistrement3));
    }

    @Test
    void TestRetirerCoord1() throws AbsentException{
        assertThrows(AbsentException.class, () -> bdGeographique.retirerCoord(new Coordonnees(19F, 33F)));
    }

    @Test
    void TestRetirerCoord2(){
        bdGeographique.retirerCoord(new Coordonnees(11F, 32F));
        assertFalse(bdGeographique.estPresent(enregistrement3));
    }

    @Test
    void TestPopulation(){
        assertEquals(1500, bdGeographique.population());
    }
}
