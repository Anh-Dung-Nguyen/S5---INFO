package cpoo1.exo1;
import java.util.ArrayList;
import java.util.List;

public class Foret {
    protected List<Arbre> foret;
    protected List<Arbre> coupe;

    public Foret(){
        foret=new ArrayList<Arbre>();
        coupe=new ArrayList<Arbre>();
    }


    public List<Arbre> getForet() {
        return foret;
    }

    public void setForet(List<Arbre> foret) {
        this.foret = foret;
    }

    public void planterArbre(Arbre a){
        foret.add(a);

    }

    public void coupeArbre(Arbre a){
        foret.remove(a);
        coupe.add(a);
    }

    public List<Arbre> getCoupe() {
        return coupe;
    }

    public void setCoupe(List<Arbre> coupe) {
        this.coupe = coupe;
    }

    public double getPrixTotal(){
        double res = 0;
        for(Arbre a : foret){
            if(a.peutEtreCoupe()) {
                res = res + a.getPrix();
            }
        }
        return res;
    }
}
