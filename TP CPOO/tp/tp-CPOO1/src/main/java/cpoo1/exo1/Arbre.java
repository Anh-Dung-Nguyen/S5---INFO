package cpoo1.exo1;

public abstract class Arbre {
    protected double age;
    protected double volume;
    protected static double prix;
    protected static double agemin;

    public Arbre() {
        age=0;
        volume=0;
    }

    public Arbre(double v, double a){
        age = a;
        volume = v;
    }

    public abstract boolean peutEtreCoupe();

    public double defPrix() {
        return 0;
    }

    public double getPrix(){
        return prix*volume;
    }
    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
    public void vieillir(){
        age++;
    }
}