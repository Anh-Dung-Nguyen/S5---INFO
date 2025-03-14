package Objet;

public class Coordonnees {
    float x;
    float y;

    public Coordonnees(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public boolean equals(Coordonnees u) {
        return this.x == u.x && this.y == u.y;
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
