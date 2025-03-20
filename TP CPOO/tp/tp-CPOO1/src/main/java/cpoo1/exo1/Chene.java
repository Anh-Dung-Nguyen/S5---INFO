package cpoo1.exo1;

public class Chene extends Arbre{
    private static int prix =1000;
    private static double agemin=10;
    private double prixV;

    public Chene(){
        super();
//        this.agemin=10;
//        this.prix=1000;
    }

    public Chene(double v, double a) {
        super(v, a);
        this.prixV = v*prix;
//        this.agemin =10;
//        this.prix=1000;
    }

    @Override
    public boolean peutEtreCoupe() {
        return age>=agemin;
    }

    @Override
    public double getPrix() {
        return prix*volume;
    }

    public void setPrix() {
        prixV = prix*volume;
    }

    public static double getAgemin() {
        return agemin;
    }

    public static void setAgemin(double agemin) {
        Chene.agemin = agemin;
    }

    @Override
    public double defPrix() {
        return prix*volume;
    }
}
