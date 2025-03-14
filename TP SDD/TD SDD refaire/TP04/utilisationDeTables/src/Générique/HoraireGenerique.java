package Générique;

public class HoraireGenerique<T, U> {
    private T jour;
    private U debutHeure;

    public HoraireGenerique(T jour, U debutHeure) {
        this.jour = jour;
        this.debutHeure = debutHeure;
    }

    public T getJour() {
        return this.jour;
    }

    public U getDebutHeure() {
        return this.debutHeure;
    }

    public void setJour(T jour) {
        this.jour = jour;
    }

    public void setDebutHeure(U debutHeure) {
        this.debutHeure = debutHeure;
    }

    public String toString() {
        return "(" + this.jour + ", " + this.debutHeure + ")";
    }

    public boolean equals(HoraireGenerique<T, U> horaire) {
        return this.jour == horaire.jour && this.debutHeure == horaire.debutHeure;
    }
}
