#include <stdio.h>

#include "chaine.h"

int main(void)
{
    char nom[MAX_NOM];
    char prenom[MAX_NOM];
    char id[MAX_ID];

    printf("Votre nom: \n");
    scanf("%s", nom);

    printf("Votre prenom: \n");
    scanf("%s", prenom);

    identifiant2(nom, prenom, id);
    printf("Votre id: %s\n", id);

    return 0;
}
