import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testCouple {
    private Couple couple;
    private Mot m1;
    private Mot m2;

    @BeforeEach
    void setup(){
        m1 = new Mot("Computer");
        m2 = new Mot("Ordinateur");
        couple = new Couple(m1, m2);
    }

    @Test
    void testCompCoupleMot(){
        assertEquals(m2, couple.compCoupleMot(m1));
    }
}
