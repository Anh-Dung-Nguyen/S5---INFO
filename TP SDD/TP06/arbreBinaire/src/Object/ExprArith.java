package Object;

import java.util.HashMap;

public class ExprArith {
    protected Arbre arbre;
    private HashMap<String, Double> symboles;

    public ExprArith(Arbre arbre) {
        this.arbre = arbre;
        this.symboles = new HashMap<>();
    }

    public String toString(){
        return "(" + this.arbre.arbreG().toString() + " " + this.arbre.racine().toString() + " " + this.arbre.arbreD().toString() + ")";
    }

    public void associerValeur(String symbole, double valeur){
        this.symboles.put(symbole, valeur);
    }

    public void evaluer(){

    }
}
