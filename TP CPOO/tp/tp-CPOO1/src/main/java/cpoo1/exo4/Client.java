package cpoo1.exo4;

import java.util.ArrayList;
import java.util.List;

interface Service {
    int getLatency();
}

public class Client {
    private final List<Service> services;

    /** Creates the objet with an empty list of services. **/
    public Client() {
        services = new ArrayList<>();
    }

    /**
     * Adds a service.
     * @throws IllegalArgumentException if 'service' is null
     **/
    public void addService(Service s) {
        if(s==null || services.contains(s)) throw new IllegalArgumentException();
        /* si s est null, services.contains(s) ne sera pas évalué, évitant ainsi une possible NullPointerException.*/
        services.add(s);

        /*
        && Évalue la deuxième condition seulement si la première est vraie. Si la première condition est fausse, la seconde n'est pas évaluée et le résultat est directement false.
        & value toujours les deux conditions, peu importe la valeur de la première. Si les deux conditions sont vraies, le résultat est true; sinon, il est false.
        | Évalue toujours les deux conditions, peu importe la valeur de la première.
        || Évalue la deuxième condition seulement si la première est fausse. Si la première condition est vraie, la seconde n'est pas évaluée.
        */

        /*
        s == null    services.contains(s)    Résultat if
        false        false                   false
        false        true                    true
        true         true                    true
        true         false                   true
        */

        /*
        cas valide: s est instance valide de Service et pas présente dans la liste "services" (ligne 14)
        cas invalide: s est null ou s est une instance de Service et déjà présente dans la liste "services" (ligne 14)
        */
    }

    /** Returns the list of services **/
    public List<Service> getServices() {
        return services;
    }

    /** Returns the total of all the latencies of the services. **/
    public double getTotalLatency() { // A
        // Calls the method getLatency from Service on each element
        // of 'services' to sum all the latencies.
//        return services.stream().mapToDouble(s -> s.getLatency()).sum();
        double sum = 0.0; // B
        for(Service s : services) { // C
            sum += s.getLatency(); // D
        }
        return sum; // E
    }
}
