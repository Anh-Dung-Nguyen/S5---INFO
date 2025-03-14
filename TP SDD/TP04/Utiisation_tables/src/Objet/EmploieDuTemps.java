package Objet;

import java.io.IOException;
import java.time.DayOfWeek;
import java.util.*;

public class EmploieDuTemps {
    private Map<String, Map<Horaire, String>> data;

    public EmploieDuTemps(List<String> enseignants) throws IllegalArgumentException {
        if (enseignants == null || enseignants.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.data = new HashMap<>();
        for (String enseignant : enseignants) {
            data.put(enseignant, new HashMap<>());
        }
    }

    public boolean AjouterCours(String enseignant, DayOfWeek jour, int debut, String nomCours){
        if (enseignant == null || enseignant == ""){
            return false;
        }
        if (jour == null) {
            return false;
        }
        if (nomCours == null || nomCours == ""){
            return false;
        }
        if (debut % 2 != 0 || debut < 0 || debut > 18){
            return false;
        }
        if (!this.data.containsKey(enseignant)) {
            data.put(enseignant, new HashMap<>());
        }
        return this.data.get(enseignant).putIfAbsent(new Horaire(jour, debut), nomCours) == null;
    }

    public Map<Horaire, String> getEmploieDuTemps(String enseignant) throws IllegalArgumentException {
        if (enseignant == null || enseignant == ""){
            throw new IllegalArgumentException();
        }
        return this.data.get(enseignant);
    }

    public int coursA10h(){
        int res = 0;
        for (Map<Horaire, String> map : this.data.values()) {
            if (map.containsKey(new Horaire(DayOfWeek.MONDAY, 10))){
                res += 1;
            }
        }
        return res;
    }

    public int coursALundi() {
        int res = 0;
        for (Map<Horaire, String> map : this.data.values()) {
            for (Horaire horaire : map.keySet()) {
                if (horaire.getJour() == DayOfWeek.MONDAY) {
                    res += 1;
                }
            }
        }
        return res;
    }

    public String Enseignant(){
        HashMap<String, Integer> enseignant = new HashMap<>();
        for (String enseignants: this.data.keySet()){
            for (Horaire key: this.data.get(enseignants).keySet()){
                if (key.getDebut() > 8 && key.getDebut() < 12){
                    enseignant.putIfAbsent(enseignants, enseignant.getOrDefault(enseignants, 0) + 1);
                }
            }
        }
        String res = "";
        int max = 0;
        for (Map.Entry<String, Integer> entry : enseignant.entrySet()){
            res = entry.getKey();
            max = entry.getValue();
        }
        return res;
    }
}
