/*
// Created by nguyen-anh-dung on 10/30/24.
*/

#include <stdio.h>
#include <stdlib.h>
#include "tache.h"

void saisieTache(Tache *t) {
    int i;

    printf("L'identifiant de tache: ");
    scanf("%d", &t -> no);

    printf("La duree de la tache: ");
    scanf("%d", &t -> duree);

    printf("Le nombre de predecesseurs: ");
    scanf("%d", &t -> nbPred);

    for (i = 0; i < t -> nbPred; i++) {
        printf("La predecesseur %d: ", i + 1);
        scanf("%d", t -> pred[i]);
    }

    printf("Le titre de la tache: ");
    scanf("%s", t -> titre);
}

Tache* lireTachesFichierDyn(char* nomFichier, int* nbtaches) {
    FILE *f = NULL;
    int i = 0;
    int j;
    Tache* tab = NULL;

    f = fopen(nomFichier, "r");
    if (f == NULL) {
        fprintf(stderr, "Erreur d'ouverture");
        return NULL;
    }

    tab = (Tache*)malloc((*nbtaches) * sizeof(Tache));
    if (tab == NULL) {
        printf("Erreur d'allocation de mémoire");
        return NULL;
    }

    while(!feof(f)) {
        fscanf(f, "%d %d %d", &tab[i].no, &tab[i].duree, &tab[i].nbPred);
        for (j = 0; j < tab[i].nbPred; j++) {
            fscanf(f, "%d", tab[i].pred[j]);
        }
        fscanf(f, "%[^\n]\n", tab[i].titre);
        i++;
    }
    fclose(f);
    return tab;
}

void afficheTache(Tache *t) {
    int i;
    printf("L'identifiant de tache: %d", t -> no);
    printf("La duree de la tache: %d", t -> duree);
    printf("Le nombre de predecesseurs: %d", t -> nbPred);
    printf("Le titre de la tache: %s", t -> titre);
    for (i = 0; i < t -> nbPred; i++) {
        printf("La predecesseur %d: %d", i + 1, t -> pred[i]);
    }
}

int lireTachesFichier(char* nomFichier, Tache* tab_t) {
    FILE *f = NULL;
    int i = 0;
    int j;
    f = fopen(nomFichier, "r");
    if (f == NULL) {
        fprintf(stderr, "Impossible de charger le fichier\n");
        exit(0);
    }
    while(!feof(f)) {
        fscanf(f, "%d %d %d", &tab_t[i].no, &tab_t[i].duree, &tab_t[i].nbPred);
        for (j = 0; j < tab_t[i].nbPred; j++) {
            fscanf(f, "%d", tab_t[i].pred[j]);
        }
        fscanf(f, "%[^\n]\n", tab_t[i].titre);
        i++;
    }
    fclose(f);
    return i;
}

void afficheTabTaches(Tache* tab_t, int nbtaches) {
    int i;
    for (i = 0; i < nbtaches; i++) {
        afficheTache(&tab_t[i]);
        printf("============================\n");
    }
}

int sommeTotalDuree(Tache* tab, int nbtaches) {
    int i;
    int somme = 0;
    for (i = 0; i < nbtaches; i++) {
        somme += tab[i].duree;
    }
    return somme;
}

int ecrireTachesFichier(char* nomFichier, Tache *tab_t, int nbtaches) {
    FILE *f = NULL;
    int i, j;
    f = fopen(nomFichier, "w");
    if (f == NULL) {
        fprintf(stderr, "Impossible de charger le fichier\n");
        return 1;;
    }
    for (i = 0; i < nbtaches; i++) {
        fprintf(f, "%d %d %d", tab_t[i].no, tab_t[i].duree, tab_t[i].nbPred);
        for (j = 0; j < tab_t[i].nbPred; j++) {
            fprintf(f, " %d", tab_t[i].pred[j]);
        }
        fprintf(f, "%s\n", tab_t[i].titre);
    }
    fclose(f);
    return 0;
}