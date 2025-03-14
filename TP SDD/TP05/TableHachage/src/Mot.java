public class Mot {
    private String mot;

    public Mot(String mot) {
        this.mot = mot.toLowerCase();
    }

    public String toString(){
        return this.mot;
    }

    public boolean equals(Object o){
        if (o instanceof Mot){
            return this.mot.equals(o.toString());
        }
        return false;
    }

    public int hashCode(){
        if (this.mot.length() >= 2){
            return this.mot.charAt(0) * 26 + this.mot.charAt(1);
        }
        return this.mot.charAt(0);
    }
}
