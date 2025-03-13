/*
// Created by nguyen-anh-dung on 10/31/24.
*/

#ifndef LISTE_H
#define LISTE_H

#include "tache.h"

typedef struct struc_element {
    Tache t;
    struct struc_element *suivant;
} Element;

typedef Element* Liste;

void ajoutdeb(Liste* l, Tache t);

#endif /*LISTE_H*/
