import java.util.Locale;

public class Mot {
    private String mot;

    public Mot(String mot) {
        this.mot = mot.toLowerCase();
    }

    public String toString() {
        return this.mot;
    }

    public boolean equals(Object o){
        if (o == null){
            return false;
        }
        if (o.getClass() != this.getClass()){
            return false;
        }
        Mot m = (Mot) o;
        return m.mot.equals(this.mot);
    }

    public int hashCode() {
        if (mot.length() >= 2){
            return mot.charAt(0) * 26 + mot.charAt(1);
        }
        return mot.charAt(0) * 26;
    }

    public String getMot(){
        return this.mot;
    }
}
