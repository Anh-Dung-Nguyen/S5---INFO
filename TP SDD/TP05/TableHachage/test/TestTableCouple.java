import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestTableCouple {
    private TableCouplesAmeliorer t;

    @BeforeEach
    void setup() {
        t = new TableCouplesAmeliorer();
    }

    @Test
    void testAjouterTrue(){
        assertTrue(t.ajouter(new Mot("Accès direct"), new Mot("direct access, random access")));
    }

    @Test
    void testAjouterFalse(){
        t.ajouter(new Mot("Accès direct"), new Mot("direct access, random access"));
        assertFalse(t.ajouter(new Mot("Accès direct"), new Mot("direct access, random access")));
    }
}
