package Object;

public class Engistrement {
    private String ville;
    private Coordonnees coordonnes;
    private int population = 0;

    public Engistrement(String ville, Coordonnees coordonnes, int population) {
        this.ville = ville;
        this.coordonnes = coordonnes;
        this.population = population;
    }

    public String getVille() {
        return this.ville;
    }

    public Coordonnees getCoordonnes() {
        return this.coordonnes;
    }

    public int getPopulation() {
        return this.population;
    }

    public String toString(){
        return this.getVille() + " : " + this.population + " @ " + this.getCoordonnes();
    }

    public boolean equals(Engistrement e){
        return this.getVille() == e.getVille() && this.getCoordonnes().equals(e.coordonnes) && this.getPopulation() == e.getPopulation();
    }
}
