package cpoo1.exo8;

import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;
import org.mockito.MockedStatic;

import java.util.random.RandomGenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TestExo8 {

    @Test
    void testUneFonctionInutile2() {
        /**
         MockedConstruction remplace toute nouvelle instance de la classe Random créée dans le code par un objet mock
         Une fois qu'un objet de type Random est créé via un new Random(), il est remplacé par un objet mock
         */
        try (MockedConstruction<Random> mockedRandom = mockConstruction(Random.class)) {
            /**
             En utilisant mockConstruction, l'instance de Random créée dans le constructeur de Exo8 sera automatique remplacée par un mock
             */
            Exo8 exo8 = new Exo8();
            /**
             mockedRandom.constructed() renvoie la liste de toutes les instances de Random créées pendant la durée de vie de ce mock
             getFirst() récupère la première instance mockée de Random
             */
            Random mockRandom = mockedRandom.constructed().getFirst();
            when(mockRandom.nextRandom()).thenReturn(5);
            int result = exo8.uneFonctionInutile(3);
            assertEquals(15, result);
            /** Vérifie que la méthode nextRandom() a été effectivement appelée une fois sur l'objet mock Random*/
            verify(mockRandom).nextRandom();
        }
    }

    @Test
    void testAutreFonctionInutile() {
        try (MockedStatic<RandomGenerator> mockedRandomGenerator = mockStatic(RandomGenerator.class)) {
            RandomGenerator mockGenerator = mock(RandomGenerator.class);
            mockedRandomGenerator.when(RandomGenerator :: getDefault).thenReturn(mockGenerator);
            when (mockGenerator.nextInt()).thenReturn(5);
            Exo8 exo8 = new Exo8();
            int result = exo8.uneAutreFonctionInutile(3);
            assertEquals(15, result);
            mockedRandomGenerator.verify(RandomGenerator :: getDefault);
            verify(mockGenerator).nextInt();
        }
    }

}
