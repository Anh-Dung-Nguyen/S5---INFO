package Object;

public class Horaire {
    private String jour;
    private int heureDebut;

    public Horaire(String jour, int heureDebut) {
        this.jour = jour;
        this.heureDebut = heureDebut;
    }

    public String getJour() {
        return this.jour;
    }

    public int getHeureDebut() {
        return this.heureDebut;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public void setHeureDebut(int heureDebut) {
        this.heureDebut = heureDebut;
    }

    public boolean equals(Horaire o){
        return this.jour == o.jour && this.heureDebut == o.heureDebut;
    }

    public String toString(){
        return "(" + this.jour + ", " + this.heureDebut + ")";
    }
}
