package Objet;

import java.time.DayOfWeek;

public class Horaire {
    private final DayOfWeek jour;
    private final int debut;

    public Horaire(DayOfWeek jour, int debut) {
        this.jour = jour;
        this.debut = debut;
    }

    public DayOfWeek getJour() {
        return this.jour;
    }

    public int getDebut() {
        return this.debut;
    }

    public String toString() {
        return this.jour + " commence à " + this.debut + "h";
    }
}
