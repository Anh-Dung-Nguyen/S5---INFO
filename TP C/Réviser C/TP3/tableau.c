#include <stdio.h>
#include "tableau.h"
#include <stdlib.h>
#include <time.h>

void init_alea_tab(int* tab) {
    int i;
    srand(time(NULL));
    for (i = 0; i <= DIMTAB; i ++) {
        tab[i] = rand() % VALMAX;
    }
}

void affiche_tab(int* tab, int dim) {
    int i;
    for (i = 0; i < dim; i ++) {
        printf("%d ", tab[i]);
    }
    printf("\n");
}

void histogramme(int* tab, int* histo) {
    int i;
    for (i = 0; i < DIMTAB; i ++) {
        histo[tab[i]]++;
    }
}

void affiche_histo(int* histo, int dim) {
    int i, j;
    for (i = 0; i < dim; i ++) {
        if (histo[i] == 0) {
            printf("%d: ", i);
        } else {
            printf("%d: ", i);
            for (j = 0; j < histo[i]; j ++) {
                printf("-");
            }
        }
        printf("\n");
    }
}
