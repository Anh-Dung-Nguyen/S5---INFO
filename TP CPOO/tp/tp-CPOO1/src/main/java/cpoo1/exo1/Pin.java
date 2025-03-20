package cpoo1.exo1;

public class Pin extends Arbre {
    private static int prix =500;
    private static double agemin=5;
    //private double prixV;

    public Pin(){
        super();
//        this.agemin =5;
//        this.prix=500;
    }

    public Pin(double v, double a) {
        super(v, a);
        //  this.prixV = v*prix;
//        this.agemin =5;
//        this.prix=500;
    }

    @Override
    public boolean peutEtreCoupe() {
        return age>=agemin;
    }

    public double getPrix() {
        return prix*volume;
    }

    public static void setPrix(int pri) {
        prix = pri;
    }

    public static double getAgemin() {
        return agemin;
    }

    public static void setAgemin(double agemi) {
        agemin = agemi;
    }

    @Override
    public double defPrix() {
        return this.volume*prix;
    }
}