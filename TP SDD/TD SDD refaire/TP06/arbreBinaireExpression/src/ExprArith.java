import java.util.HashMap;

public class ExprArith {
    protected Arbre arbre;
    private static HashMap<String, Double> symboles;

    static {
        symboles = new HashMap<>();
        symboles.put("pi", Math.PI);
        symboles.put("e", Math.E);
    }

    public ExprArith(Arbre arbre) {
        this.arbre = arbre;
        this.symboles = new HashMap<>();
    }

    public String toString(){
        return "(" + this.arbre.arbreG().toString() + " " + this.arbre.racine() + " " + this.arbre.arbreD().toString() + ")";
    }

    public void associerValeur(String symbole, double valeur){
        this.symboles.put(symbole, valeur);
    }

    public double evaluer() throws ValeurNonTrouveeException{
        double res;
        if (this.arbre.arbreD().estVide()){
            res = (double) this.arbre.racine();
        }
        double valeurGauche = new ExprArith(this.arbre.arbreG()).evaluer();
        double valeurDroite = new ExprArith(this.arbre.arbreD()).evaluer();
        switch((String)this.arbre.racine()){
            case "+" -> {
                return valeurGauche + valeurDroite;
            }
            case "-" -> {
                return valeurGauche - valeurDroite;
            }
            case "*" -> {
                return valeurGauche * valeurDroite;
            }
            case "/" -> {
                return valeurDroite / valeurGauche;
            }
            default -> {
                throw new ValeurNonTrouveeException("Valeur non trouvée");
            }
        }
    }

    public Object valeur(String s){
        if (symboles.containsKey(s.toLowerCase())){
            return symboles.get(s.toLowerCase());
        }
        else {
            try {
                return Double.parseDouble(s);
            }
            catch (Exception e){
                return s;
            }
        }
    }

    public void simplifier() throws ValeurNonTrouveeException, ClassCastException{
        if (!arbre.arbreG().estVide()) new ExprArith(this.arbre.arbreG()).simplifier();
        if (!arbre.arbreD().estVide()) new ExprArith(this.arbre.arbreD()).simplifier();

        try {
            double res = this.evaluer();
            this.arbre.vider();
            this.arbre.modifRacine("" + res);
        } catch (ValeurNonTrouveeException | ClassCastException ignored) {}
    }
}
