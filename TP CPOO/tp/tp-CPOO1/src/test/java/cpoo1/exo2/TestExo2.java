package cpoo1.exo2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class TestExo2 {
    Exo2 exo2;
    Network network;

    @BeforeEach
    void setUp() {
        network = Mockito.mock(Network.class);
        exo2 = new Exo2(network);
    }

    @Test
    void testConnectServer(){
        assertFalse(exo2.connectServer("122.154.198"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"122.154.198"})
    void testPara(String adresse) {
        assertFalse(exo2.connectServer(adresse));
    }

    @Test
    void checkHTTP(){
        String adresse = "122.154.198";
        network.sendGetHTTPQuery(adresse);
        Mockito.verify(network).sendGetHTTPQuery(adresse);
    }
}
