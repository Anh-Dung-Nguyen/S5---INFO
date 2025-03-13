
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "tableau.h"

int main()
{
    int tab[DIM_TAB];
    int histo[VAL_MAX + 1];

    int tab_int[DIM_TAB];
    init_alea_tab(tab_int, DIM_TAB);
    affiche_tab(tab_int, DIM_TAB);

    init_alea_tab(tab, DIM_TAB);

    histogramme(tab, histo, DIM_TAB, VAL_MAX);
    affiche_tab(histo, VAL_MAX);
    affiche_histo(histo, VAL_MAX);

    return 0;
}