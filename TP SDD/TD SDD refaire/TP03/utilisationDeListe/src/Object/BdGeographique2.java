package Object;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BdGeographique2 {
    private final List<Engistrement> data;

    public BdGeographique2() {
        this.data = new ArrayList<>();
    }

    public boolean estPresent(Engistrement e) {
        for (Engistrement engistrement : data) {
            if (engistrement == e) {
                return true;
            }
        }
        return false;
    }

    public void vider(){
        this.data.clear();
    }

    public void ajouter(Engistrement e) throws estPresentException{
        if (estPresent(e)){
            throw new estPresentException("Déjà présent");
        }
        this.data.add(e);
    }

    public void retirer(Engistrement e) throws estPresentException{
        if (!estPresent(e)){
            throw new estPresentException("Pas présent");
        }
        this.data.remove(e);
    }

    public String toString(){
        StringBuilder res = new StringBuilder();
        for (Engistrement e : this.data) {
            res.append(e.toString()).append("\n");
        }
        return res.toString();
    }

    public Engistrement ville(String v){
        for (Engistrement e : this.data) {
            if (e.getVille().equals(v)) {
                return e;
            }
        }
        return null;
    }

    public Engistrement coord(Coordonnees c){
        for (Engistrement e : this.data) {
            if (e.getCoordonnes().equals(c)) {
                return e;
            }
        }
        return null;
    }

    public void retirerVille(String v) throws AbsentException{
        boolean found = false;
        for (Iterator<Engistrement> it = this.data.iterator(); it.hasNext();) {
            Engistrement e = it.next();
            if (e.getVille().equals(v)) {
                it.remove();
                found = true;
            }
        }
        if (!found){
            throw new AbsentException("Ville n'existe pas");
        }
    }

    public void retirerCoord(Coordonnees c) throws AbsentException{
        boolean found = false;
        for (Iterator<Engistrement> it = this.data.iterator(); it.hasNext();) {
            Engistrement e = it.next();
            if (e.getCoordonnes().equals(c)) {
                it.remove();
                found = true;
            }
        }
        if (!found){
            throw new AbsentException("Coordonnees n'existe pas");
        }
    }

    public int population(){
        int res = 0;
        for (Engistrement e : this.data) {
            res += e.getPopulation();
        }
        return res;
    }
}
