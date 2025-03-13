/*
// Created by nguyen-anh-dung on 10/31/24.
*/

#include <stdio.h>
#include "liste.h"
#include <stdlib.h>

void ajoutdeb(Liste* l, Tache t) {
    Element *e = (Element*)malloc(sizeof(Element));
    e -> t = t;
    e -> suivant = *l;
    *l = e;
}
