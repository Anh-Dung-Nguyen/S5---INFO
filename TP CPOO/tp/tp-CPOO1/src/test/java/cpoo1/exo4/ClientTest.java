package cpoo1.exo4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {
    private Client client;

    @BeforeEach
    void setUp() {
        client = new Client();
    }

    @Test
    void testAddService_NullService() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, () -> client.addService(null));
    }

    @Test
    void testAddService_DuplicateService() throws IllegalArgumentException {
        Service service = new SampleService(10);
        client.addService(service);

        assertThrows(IllegalArgumentException.class, () -> client.addService(service));
    }

    @Test
    void testValideService(){
        Service service = new SampleService(10);
        client.addService(service);
        assertEquals(1, client.getServices().size());
    }

    @Test
    void testGetTotalLatency_EmptyService(){
        assertEquals(0.0, client.getTotalLatency());
    }

    @Test
    void testGetTotalLatency_MultiService(){
        Service service1 = new SampleService(10);
        Service service2 = new SampleService(20);
        client.addService(service1);
        client.addService(service2);

        assertEquals(30.0, client.getTotalLatency());
    }

    private static class SampleService implements Service {
        private final int latency;

        public SampleService(int latency) {
            this.latency = latency;
        }

        @Override
        public int getLatency() {
            return latency;
        }
    }
}
