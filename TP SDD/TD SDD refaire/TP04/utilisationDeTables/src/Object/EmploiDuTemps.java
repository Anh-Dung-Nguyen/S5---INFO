package Object;

import java.util.*;

public class EmploiDuTemps {
    private Map<String, Map<Horaire, String>> edt;

    public EmploiDuTemps(List<String> enseignants) {
        this.edt = new HashMap<>();
        for (String enseignant : enseignants) {
            this.edt.put(enseignant, new HashMap<>());
        }
    }

    public void ajouterCours(String e, Horaire h, String c) throws IllegalArgumentException{
        if (!this.edt.containsKey(e)) {
            throw new IllegalArgumentException("Enseignant n'existe pas");
        }
        Map<Horaire, String> emploi = this.edt.get(e);
        if (emploi.containsKey(h)){
            throw new IllegalArgumentException("Horaire déjà existe");
        }
        emploi.put(h, c);
    }

    public Map<Horaire, String> obtenirEdt(String e) throws IllegalArgumentException{
        if (!this.edt.containsKey(e)) {
            throw new IllegalArgumentException("Enseignant n'existe pas");
        }
        return this.edt.get(e);
    }

    public int coursLundiA10h(){
        int res = 0;
        for (Map<Horaire, String> EDT: this.edt.values()) {
            if (EDT.containsKey(new Horaire("lundi", 10))){
                res += 1;
            }
        }
        return res;
    }

    public int coursLundi(){
        int res = 0;
        for (Map<Horaire, String> EDT: this.edt.values()) {
            for (Horaire h : EDT.keySet()) {
                if (h.getJour().equals("lundi")) {
                    res += 1;
                }
            }
        }
        return res;
    }

    public String ProfMatinal() {
        String ProfMatinal = "";
        int total_cours = 0;
        for (Map.Entry<String, Map<Horaire, String>> entry : this.edt.entrySet()) {
            String prof = entry.getKey();
            int cours_matin = 0;
            for (Horaire h : entry.getValue().keySet()) {
                if (h.getHeureDebut() >= 8 && h.getHeureDebut() <= 12) {
                    cours_matin += 1;
                }
            }
            if (cours_matin > total_cours) {
                total_cours = cours_matin;
                ProfMatinal = prof;
            }
        }
        return ProfMatinal;
    }

    public String ProfChamp(){
        String ProfChamp = "";
        int total_cours = 0;
        for (Map.Entry<String, Map<Horaire, String>> entry : this.edt.entrySet()) {
            String prof = entry.getKey();
            Map<Horaire, String> emploi = entry.getValue();
            Set<String> matiere = new HashSet<>(emploi.values());
            if (matiere.size() > total_cours) {
                total_cours = matiere.size();
                ProfChamp = prof;
            }
        }
        return ProfChamp;
    }

    public Map<Horaire, Map<String, String>> autreStruct(){
        Map<Horaire, Map<String, String>> map = new HashMap<>();
        for (Map.Entry<String, Map<Horaire, String>> entry : this.edt.entrySet()) {
            String prof = entry.getKey();
            Map<Horaire, String> emploi = entry.getValue();
            for(Map.Entry<Horaire, String> cour : emploi.entrySet()){
                Horaire horaire = cour.getKey();
                String cours = cour.getValue();
                map.putIfAbsent(horaire, new HashMap<>());
                map.get(horaire).put(prof, cours);
            }
        }
        return map;
    }

    public int nbSalleMin(){
        Map<Horaire, Integer> horaireOccup = new HashMap<>();
        for (Map<Horaire, String> cours: this.edt.values()) {
            for (Horaire horaire : cours.keySet()) {
                horaireOccup.put(horaire, horaireOccup.getOrDefault(horaire, 0) + 1);
            }
        }
        int maxSalle = 0;
        for (int nbCoursSimultanes: horaireOccup.values()){
            maxSalle = Math.max(maxSalle, nbCoursSimultanes);
        }
        return maxSalle;
    }
}