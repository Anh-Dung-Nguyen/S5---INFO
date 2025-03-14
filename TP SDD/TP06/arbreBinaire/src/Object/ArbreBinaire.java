package Object;

public class ArbreBinaire implements Arbre{
    private String valeur;
    private Arbre arbreG;
    private Arbre arbreD;

    public ArbreBinaire(String valeur, Arbre arbreG, Arbre arbreD) {
        this.valeur = valeur;
        this.arbreG = arbreG;
        this.arbreD = arbreD;
    }

    public ArbreBinaire(String valeur) {
        this(valeur, new ArbreBinaire(), new ArbreBinaire());
    }

    public ArbreBinaire(){
        this("", null, null);
    }

    @Override
    public Object racine(){
        return this.valeur;
    }

    @Override
    public Arbre arbreG(){
        return this.arbreG();
    }

    @Override
    public Arbre arbreD(){
        return this.arbreD();
    }

    @Override
    public boolean estVide(){
        return this.valeur.isEmpty() && this.arbreG() == null && this.arbreD() == null;
    }

    @Override
    public void vider(){
        this.valeur = "";
        this.arbreG = null;
        this.arbreD = null;
    }

    @Override
    public void modifRacine(Object r){
        this.valeur = (String) r;
    }

    @Override
    public void modifArbreG(Object a){
        this.arbreG = (Arbre) a;
    }

    @Override
    public void modifArbreD(Object a){
        this.arbreD = (Arbre) a;
    }

    @Override
    public String toString(){
        String res = "";
        if (!this.arbreG.estVide()){
            res += this.arbreG.toString();
        }
        if (!this.arbreD.estVide()){
            res += this.arbreD.toString();
        }
        res += this.valeur;
        return res;
    }

    @Override
    public void dessiner(){
        Trees.draw(this);
    }

    @Override
    public int hauteur() throws ArbreVideException{
        int res = 0;
        if (this.estVide()){
            throw new ArbreVideException("Arbre est vide");
        }
        int droite = 0;
        int gauche = 0;
        if (!this.arbreG().estVide()){
            gauche += this.arbreG().hauteur();
        }
        if (!this.arbreD().estVide()){
            droite += this.arbreD().hauteur();
        }
        res = 1 + Math.max(droite, gauche);
        return res;
    }

    @Override
    public int denombrer(Object n){
        int res = 0;
        if (this.estVide()){
            return res;
        }
        if (this.valeur == (String) n){
            res = 1;
        }
        if (!this.arbreG.estVide()){
            res += this.arbreG.denombrer(n);
        }
        if (!this.arbreD.estVide()){
            res += this.arbreD.denombrer(n);
        }
        return res;
    }

     @Override
    public void remplacer(Object o1, Object o2){
        if (this.valeur == (String) o1){
            this.valeur = (String) o2;
        }
        if (!this.arbreG.estVide()){
            this.arbreG.remplacer(o1, o2);
        }

        if (!this.arbreD.estVide()){
            this.arbreD.remplacer(o1, o2);
        }
    }
}
