package Object;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testEngistrement {
    private Engistrement engistrement;

    @BeforeEach
    void setup(){
        this.engistrement = new Engistrement("Rennes", new Coordonnees(83, 86), 10000);
    }

    @Test
    void testGetVille(){
        assertEquals("Rennes", this.engistrement.getVille());
    }

    @Test
    void testGetCoordonnees(){
        assertEquals(83.0, this.engistrement.getCoordonnes().getX());
        assertEquals(86.0, this.engistrement.getCoordonnes().getY());
    }

    @Test
    void testGetPopulation(){
        assertEquals(10000, this.engistrement.getPopulation());
    }
}
