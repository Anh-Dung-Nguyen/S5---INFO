package Object;

public class Coordonnees {
    private float x;
    private float y;

    public Coordonnees(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    public boolean equals(Coordonnees c) {
        return (this.x == c.x) && (this.y == c.y);
    }
}
