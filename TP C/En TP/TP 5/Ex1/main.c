#include <stdio.h>
#include "tache.h"

int main() {
    int nbTaches;
    Tache tab_taches;

    tab_taches = lireTacheFichierDyn("../tachesDyn.txt", &nbTaches)[9];
    afficheTache(&tab_taches);
    free((void*)lireTacheFichierDyn("../tachesDyn.txt", &nbTaches));
    return 0;
}