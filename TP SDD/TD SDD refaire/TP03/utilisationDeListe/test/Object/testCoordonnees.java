package Object;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class testCoordonnees {
    private Coordonnees coordonnees;

    @BeforeEach
    void setup(){
        this.coordonnees = new Coordonnees(10, 20);
    }

    @Test
    void testX() {
        assertEquals(10, this.coordonnees.getX());
    }

    @Test
    void testY() {
        assertEquals(20, this.coordonnees.getY());
    }

    @Test
    void setX(){
        this.coordonnees.setX(20);
        assertEquals(20, this.coordonnees.getX());
    }

    @Test
    void setY(){
        this.coordonnees.setY(30);
        assertEquals(30, this.coordonnees.getY());
    }
}
