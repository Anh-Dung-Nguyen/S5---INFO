import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class testTablesCouples {
    private TablesCouples t;
    private Mot m1;
    private Mot m2;
    private Mot m3;
    private Mot m4;
    private Mot m5;
    private Mot m6;

    @BeforeEach
    void setup(){
        t = new TablesCouples();
        m1 = new Mot("Accès direct");
        m2 = new Mot("direct access, random access");
        m3 = new Mot("Accès séquentiel");
        m4 = new Mot("serial access");
        m5 = new Mot("Afficher");
        m6 = new Mot("to display");
        t.ajouter(m1, m2);
        t.ajouter(m3, m4);
    }

    @Test
    void testAjouter(){
        assertTrue(t.ajouter(m5, m6));
        assertFalse(t.ajouter(m1, m2));
    }

    @Test
    void testTraduire(){
        assertEquals(m2, t.traduire(m1));
    }
}
