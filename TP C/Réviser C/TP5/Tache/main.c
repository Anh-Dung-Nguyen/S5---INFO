#include <stdio.h>
#include <stdlib.h>
#include "tache.h"

int main(void) {
    /**
    FILE *ptr_fic = NULL;
    char nom_fichier[] = "../taches.txt";
    char ligne[256];

    if ((ptr_fic = fopen(nom_fichier, "r")) == NULL) {
        fprintf(stderr, "Erreur ouverture\n");
        exit(0);
    }
    while (fgets(ligne, sizeof(ligne), ptr_fic) != NULL) {
        printf("%s", ligne);
    }
    if (fclose(ptr_fic)) {
        fprintf(stderr, "Erreur fermeture\n");
    }
    */

    /**
    Tache tache[MAXTACHES];
    int nbTaches = 0;
    int i;

    printf("Enter number of taches: ");
    scanf("%d", &nbTaches);

    if (nbTaches > MAXTACHES) {
        fprintf(stderr, "Too many taches.\n");
        exit(EXIT_FAILURE);
    }

    for (i = 0; i < nbTaches; i++) {
        printf("Enter tache number %d: ", i + 1);
        saisieTache(&tache[i]);
    }

    printf("Affichage of taches:\n");
    for (i = 0; i < nbTaches; i++) {
        printf("Tache number %d: ", i + 1);
        afficheTache(&tache[i]);
    }
    */

    int nbTaches;
    Tache tab_taches[MAXTACHES];
    nbTaches = lireTachesFichier("../taches.txt", tab_taches);
    afficheTabTaches(tab_taches, nbTaches);

    printf("Somme des durees : %d\n",sommeTotalDuree(tab_taches,nbTaches));
    ecrireTachesFichier("../tachesB.txt",tab_taches,nbTaches);

    return 0;
}
