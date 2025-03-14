public class ArbreBinaire implements Arbre {
    private Object valeur;
    private Arbre arbreG;
    private Arbre arbreD;

    public ArbreBinaire() {
        this.valeur = null;
        this.arbreG = null;
        this.arbreD = null;
    }

    public ArbreBinaire(String valeur) {
        this.valeur = valeur;
        this.arbreG = new ArbreBinaire();
        this.arbreD = new ArbreBinaire();
    }

    public ArbreBinaire(String valeur, Arbre arbreD, Arbre arbreG) {
        this.valeur = valeur;
        this.arbreG = arbreG;
        this.arbreD = arbreD;
    }

    @Override
    public Object racine(){
        return this.valeur;
    }

    @Override
    public Arbre arbreG() {
        return this.arbreG;
    }

    @Override
    public Arbre arbreD() {
        return this.arbreD;
    }

    @Override
    public boolean estVide(){
        return this.valeur == null && this.arbreG == null && this.arbreD == null;
    }

    @Override
    public void vider(){
        this.valeur = null;
        this.arbreG = new ArbreBinaire();
        this.arbreD = new ArbreBinaire();
    }

    @Override
    public String toString(){
        String res = "";
        if (!this.arbreG.estVide()){
            res += this.arbreG.toString() + " ";
        }
        res += this.valeur;
        if (!this.arbreD.estVide()){
            res += this.arbreD.toString() + " ";
        }
        return res;
    }

    @Override
    public void dessiner(){
        Trees.draw(this);
    }

    @Override
    public int hauteur() throws EstVideException{
        if (this.estVide()){
            throw new EstVideException("L'arbre est vide");
        }
        return 1 + Math.max(this.arbreG.hauteur(), this.arbreD.hauteur());
    }

    @Override
    public int denombrer(Object o){
        if (this.estVide()){
            return 0;
        }
        int res = 0;
        if (this.valeur == o){
            res = 1;
        }
        if (!this.arbreG.estVide()){
            res += this.arbreG.denombrer(o);
        }
        if (!this.arbreD.estVide()){
            res += this.arbreD.denombrer(o);
        }
        return res;
    }

    @Override
    public void remplacer(Object o1, Object o2){
        if (this.valeur == o1){
            this.valeur = o2;
        }
        if (!this.arbreG.estVide()){
            this.arbreG.remplacer(o1, o2);
        }
        if (!this.arbreD.estVide()){
            this.arbreD.remplacer(o1, o2);
        }
    }

    @Override
    public void modifRacine(Object o){
        this.valeur = o;
    }
}
