#ifndef TABLEAU_H
#define TABLEAU_H

#define DIMTAB 5
#define VALMAX 20

void init_alea_tab(int* tab);
void affiche_tab(int* tab, int dim);
void histogramme(int* tab, int* histo);
void affiche_histo(int* histo, int dim);

#endif
