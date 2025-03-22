package cpoo1.exo1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ForetTest {
    Foret f;
    Arbre a,b;
    @BeforeEach
    void setUp(){
        f= new Foret();
        a =new Chene(12,12);
        b=new Pin(3,10);
    }
    @Test
    void getForet() {
        assertEquals(f.foret,f.getForet());
    }

    @Test
    void setForet() {
    }

    @Test
    void planterArbre() {
        f.planterArbre(a);
        assertTrue(f.getForet().contains(a));
    }

    @Test
    void coupeArbre() {
        f.planterArbre(a);
        f.planterArbre(b);

    }

    @Test
    void getCoupe() {
    }

    @Test
    void setCoupe() {
    }
    @Test
    void peutetrecoupee(){
        assertTrue(b.peutEtreCoupe());
    }

    @Test
    void PrixTotal() {
        final var pin = new Pin(2, 100);
        final var chene1 = new Chene(2, 3);
        final var chene2 = new Chene(10, 300);
        f.planterArbre(pin);
        f.planterArbre(chene1);
        f.planterArbre(chene2);
        assertEquals(11000, f.getPrixTotal());
    }

}