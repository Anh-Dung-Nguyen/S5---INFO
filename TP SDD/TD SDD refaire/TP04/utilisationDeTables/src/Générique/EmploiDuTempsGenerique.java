package Générique;

import javax.swing.plaf.basic.BasicTreeUI;
import java.util.*;

public class EmploiDuTempsGenerique<T, U> {
    private Map<T, Map<HoraireGenerique<T, U>, T>> edt;

    public EmploiDuTempsGenerique(List<T> enseignants) {
        this.edt = new HashMap<>();
        for (T enseignant : enseignants) {
            this.edt.put(enseignant, new HashMap<>());
        }
    }

    public boolean ajouterCours(T enseignant, HoraireGenerique<T, U> horaire, T cours) {
        if (!this.edt.containsKey(enseignant)) {
            return false;
        }
        Map<HoraireGenerique<T, U>, T> map = this.edt.get(enseignant);
        if (map.containsKey(horaire)) {
            return false;
        }
        map.put(horaire, cours);
        return true;
    }

    public Map<HoraireGenerique<T, U>, T> obtenirEDT(T enseignant) {
        if (!this.edt.containsKey(enseignant)) {
            return null;
        }
        return this.edt.get(enseignant);
    }

    public int coursALundi10h(){
        int res = 0;
        for (Map<HoraireGenerique<T, U>, T> map : this.edt.values()) {
            if (map.containsKey(new HoraireGenerique<String, Integer>("lundi", 10))) {
                res++;
            }
        }
        return res;
    }

    public int coursALundi(){
        int res = 0;
        for (Map<HoraireGenerique<T, U>, T> map : this.edt.values()) {
            for (HoraireGenerique<T, U> horaire : map.keySet()) {
                if (horaire.getJour().equals("lundi")){
                    res++;
                }
            }
        }
        return res;
    }

    public T profMatinal(){
        T res = null;
        int total_cours = 0;
        for (Map.Entry<T, Map<HoraireGenerique<T, U>, T>> entry : this.edt.entrySet()) {
            T prof = entry.getKey();
            int cours = 0;
            for (HoraireGenerique<T, U> horaire : entry.getValue().keySet()) {
//                if (horaire.getDebutHeure() >= 8 && horaire.getDebutHeure() <= 12){
//                    cours++;
//                }
            }
            if (cours >= total_cours){
                total_cours = cours;
                res = prof;
            }
        }
        return res;
    }

    public T profChamp(){
        T res = null;
        int total_cours = 0;
        for (Map.Entry<T, Map<HoraireGenerique<T, U>, T>> entry : this.edt.entrySet()) {
            T prof = entry.getKey();
            Map<HoraireGenerique<T, U>, T> map = entry.getValue();
            Set<T> matiere = new HashSet<>(map.values());
            if (matiere.size() >= total_cours){
                total_cours = matiere.size();
                res = prof;
            }
        }
        return res;
    }

    public Map<HoraireGenerique<T, U>, Map<T, T>> autreStruct() {
        Map<HoraireGenerique<T, U>, Map<T, T>> res = new HashMap<>();
        for (Map.Entry<T, Map<HoraireGenerique<T, U>, T>> entry : this.edt.entrySet()) {
            T prof = entry.getKey();
            Map<HoraireGenerique<T, U>, T> emploi = entry.getValue();
            for (Map.Entry<HoraireGenerique<T, U>, T> cours : emploi.entrySet()){
                HoraireGenerique<T, U> horaire = cours.getKey();
                T cour = cours.getValue();
                res.putIfAbsent(horaire, new HashMap<>());
                res.get(horaire).put(cour, prof);
            }
        }
        return res;
    }

    public int nbMiniSalle(){
        Map<HoraireGenerique<T, U>, Integer> res = new HashMap<>();
        for (Map<HoraireGenerique<T, U>, T> occup : this.edt.values()){
            for (HoraireGenerique<T, U> horaire : occup.keySet()){
                res.put(horaire, res.getOrDefault(horaire, 0) + 1);
            }
        }
        int maxSalle = 0;
        for (int nbOccup : res.values()){
            maxSalle = Math.max(maxSalle, nbOccup);
        }
        return maxSalle;
    }
}
