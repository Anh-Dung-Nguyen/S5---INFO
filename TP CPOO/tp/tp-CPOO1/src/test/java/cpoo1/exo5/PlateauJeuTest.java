package cpoo1.exo5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class PlateauJeuTest {
    private PlateauJeu plateauJeu;
    private static final int SIZE = 5;

    public static Stream<Integer> provideTestValues(){
        return Stream.of(-1, 0, 4, 5, 6);
    }

    @BeforeEach
    void setup(){
        plateauJeu = new PlateauJeu();
    }

    @ParameterizedTest
    @MethodSource("provideTestValues")
    void test_isOut(int value){
        if (value < 0 || value >= SIZE) {
            assertTrue(plateauJeu.isOut(value));
        } else {
            assertFalse(plateauJeu.isOut(value));
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 4, 5, 6})
    void test_IsOutOf(int value){
        if (value < 0 || value >= SIZE) {
            assertTrue(plateauJeu.isOut(value));
        } else {
            assertFalse(plateauJeu.isOut(value));
        }
    }
}
