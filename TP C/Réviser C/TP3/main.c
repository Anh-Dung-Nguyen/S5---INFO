#include <stdio.h>
#include "tableau.h"

int main(void) {
    int tab[DIMTAB];
    int histo[VALMAX] = {0};    /** initialiser tous les éléments dans histo en 0 */
    init_alea_tab(tab);
    affiche_tab(tab, DIMTAB);
    histogramme(tab, histo);
    affiche_tab(histo, VALMAX);
    affiche_histo(histo, VALMAX);
    return 0;
}
