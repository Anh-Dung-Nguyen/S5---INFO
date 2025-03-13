
#ifndef TABLEAU_H
#define TABLEAU_H

#define DIM_TAB 5
#define VAL_MAX 20

void init_alea_tab(int *tab, int taille);
void affiche_tab(int *tab, int taille);
void histogramme(int *tabval, int *histo, int tailleT, int tailleH);
void affiche_histo(int *histo, int taille);

#endif
