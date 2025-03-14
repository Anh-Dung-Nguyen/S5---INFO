package ObjetTest;

import java.time.DayOfWeek;
import java.util.*;
import Objet.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;


public class TestEmploieDuTemps {
    EmploieDuTemps emploieDuTemps;

    @BeforeEach
    void setup(){
        ArrayList<String> enseignants = new ArrayList<>();
        enseignants.add("Nguyen Anh Dung");
        this.emploieDuTemps = new EmploieDuTemps(enseignants);
    }

    @Test
    void testEmploieDuTemps() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, () -> emploieDuTemps = new EmploieDuTemps(null));
    }

    @Test
    void testEmploieDuTemps2() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, () -> emploieDuTemps = new EmploieDuTemps(new ArrayList<>()));
    }

    @Test
    void testAjouterCoursNonEnseignant(){
        assertFalse(emploieDuTemps.AjouterCours("", DayOfWeek.MONDAY, 8, "SDD"));
    }

    @Test
    void testAjouterCoursNonJour(){
        assertFalse(emploieDuTemps.AjouterCours("Brieuc Monfort", null, 8, "CPOO"));
    }

    @Test
    void testAjouterCoursDebutInf0(){
        assertFalse(emploieDuTemps.AjouterCours("Adi", DayOfWeek.MONDAY, -2, "CLP"));
    }

    @Test
    void testAjouterCoursDebutSup18(){
        assertFalse(emploieDuTemps.AjouterCours("Mathilde", DayOfWeek.MONDAY, 20, "C"));
    }

    @Test
    void testAjouterCoursDebutImpaire(){
        assertFalse(emploieDuTemps.AjouterCours("Solène", DayOfWeek.MONDAY, 11, "FUS"));
    }

    @Test
    void testAjouterCoursTrue(){
        assertTrue(emploieDuTemps.AjouterCours("Nguyen Anh Dung", DayOfWeek.MONDAY, 8, "LDS"));
    }

    @Test
    void testAjouterCoursFalse(){
        emploieDuTemps.AjouterCours("Nguyen Anh Dung", DayOfWeek.MONDAY, 8, "Proba");
        assertFalse(emploieDuTemps.AjouterCours("Nguyen Anh Dung", DayOfWeek.MONDAY, 8, "R"));
    }
}
