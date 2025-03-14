package ObjetTest;

import Objet.Horaire;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.DayOfWeek;

public class TestHoraire {
    Horaire horaire;

    @BeforeEach
    void setup(){
        this.horaire = new Horaire(DayOfWeek.MONDAY, 8);
    }

    @Test
    void testGetHoraire(){
        assertEquals(DayOfWeek.MONDAY, horaire.getJour());
    }

    @Test
    void testGetHoraireFalse(){
        assertNotEquals(DayOfWeek.TUESDAY, horaire.getJour());
    }

    @Test
    void testGetTime(){
        assertEquals(8, horaire.getDebut());
    }

    @Test
    void testGetTimeFalse(){
        assertNotEquals(10, horaire.getDebut());
    }

    @Test
    void testToString(){
        assertEquals("MONDAY commence à 8h", horaire.toString());
    }
}
