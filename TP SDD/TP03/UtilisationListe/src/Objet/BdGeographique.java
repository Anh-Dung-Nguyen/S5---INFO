package Objet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BdGeographique {
    private final ArrayList<Enregistrement> data;

    public BdGeographique() {
        // Change this line to change list
        this.data = new ArrayList<>();
    }

    public boolean estPresent(Enregistrement e){
        return this.data.contains(e);
    }

    public void vider(){
        this.data.clear();
    }

    public void ajouter(Enregistrement e) throws PresentException{
        if (this.estPresent(e)) {
            throw new PresentException("Le objet est present");
        } else {
            this.data.add(e);
        }
    }

    public void retirer(Enregistrement e) throws RetireException{
        if (!this.estPresent(e)) {
            throw new RetireException("Le objet est retiré");
        } else {
            this.data.remove(e);
        }
    }

    @Override
    public String toString(){
        return this.data.toString();
    }

    public Enregistrement ville(String v){
        for (Enregistrement e : this.data){
            if (e == null){
                return null;
            }
            if (e.getCityName().equals(v)){
                return e;
            }
        }
        return null;
    }

    public Enregistrement coord(Coordonnees c){
        for (Enregistrement e : this.data){
            if (e == null){
                return null;
            }
            if (e.getCoordinates().equals(c)){
                return e;
            }
        }
        return null;
    }

    public void retirerVille(String v) throws AbsentException{
        for (Iterator<Enregistrement> it = this.data.iterator(); it.hasNext();){
            Enregistrement e = it.next();
            if (e.getCityName().equals(v)){
                it.remove();
                return;
            }
        } throw new AbsentException("Le objet est absent");
    }

    public void retirerCoord(Coordonnees c) throws AbsentException {
        for (Iterator<Enregistrement> it = this.data.iterator(); it.hasNext(); ) {
            Enregistrement e = it.next();
            if (e.getCoordinates().equals(c)) {
                it.remove();
                return;
            }
            throw new AbsentException("Le objet est absent");
        }
    }

    public int population(){
        int res = 0;
        for (Enregistrement e : this.data){
            res += e.getPopulation();
        }
        return res;
    }
}
