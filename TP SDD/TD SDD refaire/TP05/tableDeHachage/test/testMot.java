import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class testMot {
    private Mot m1;
    private Mot m2;
    private Mot m3;

    @BeforeEach
    void setup(){
        m1 = new Mot("Computer");
        m2 = new Mot("computer");
        m3 = new Mot("Science");
    }

    @Test
    void testMotLowerCase(){
        assertEquals("computer", m1.getMot());
    }

    @Test
    void testEquals(){
        assertTrue(m1.equals(m2));
    }

    @Test
    void testNotEquals(){
        assertFalse(m1.equals(m3));
    }

    @Test
    void testHashCode(){
        assertEquals(2685, m1.hashCode());
        assertEquals(3089, m3.hashCode());
    }
}
