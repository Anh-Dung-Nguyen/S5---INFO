/*
// Created by nguyen-anh-dung on 10/30/24.
*/

#ifndef TACHE_H
#define TACHE_H

#define NMAXPRED 16
#define LGMAX 64
#define MAXTACHES 64

typedef struct {
    int no;
    int duree;
    int nbPred;
    int pred[NMAXPRED];
    char titre[LGMAX];
} Tache;

void saisieTache(Tache *t);
void afficheTache(Tache *t);
int lireTachesFichier(char * nomFichier, Tache *tab_t);
void afficheTabTaches(Tache* tab_t, int nbtaches);
int sommeTotalDuree(Tache* tab, int nbtaches);
int ecrireTachesFichier(char* nomFichier, Tache *tab_t, int nbtaches);

#endif /*TACHE_H*/
