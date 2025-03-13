#ifndef LISTE_H
#define LISTE_H

#include "tache.h"

typedef struct struct_element {
    Tache t;
    struct struct_element *suivant;
} Element;

typedef Element* Liste;

void ajoutdeb(Liste* l, Tache t);
int nbelement(Liste l);
void afficheListe(Liste l);
void ajoutTri(Liste* l, Tache t);

#endif
