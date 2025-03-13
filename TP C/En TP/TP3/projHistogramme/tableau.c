#include <stdio.h>
#include <stdlib.h>
#include "tableau.h"
#include <time.h>

void init_alea_tab(int tab [], int taille) {
    int i;
    srand(time(NULL));

    for (i = 0; i < taille; i++) {
        tab[i] = rand() % VAL_MAX;
    }
}

void affiche_tab(int tab[], int taille) {
    int i;
    for (i = 0; i < taille; i++) {
        printf("tab[%d] = %d\n", i, tab[i]);
    }
    printf("===========================\n");
}

void histogramme(int tabval[], int histo[], int tailleT, int tailleH) {
    int i;

    for (i = 0; i < tailleH; i++) {
        histo[i] = 0;
    }

    for (i = 0; i < tailleT; i++) {
        histo[tabval[i]] += 1;
    }
}

void affiche_histo(int histo[], int taille) {
    int i, j;
    for (i = 0; i < taille; i++) {
        if (histo[i] == 0) {
            printf("%d: ", i);
        } else {
            printf("%d: ", i);
            for (j = 0; j < histo[i]; j++) {
                printf("-");
            }
        }
        printf("\n");
    }
}