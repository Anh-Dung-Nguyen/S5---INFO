#include "liste.h"
#include "tache.h"

void ajoutdeb(Liste* l, Tache t) {
    Element* e = (Element*)malloc(sizeof(Element));
    e -> t = t;
    e -> suivant = *l;
    *l = e;
}

int nbelement(Liste l) {
    int sum;
    Element* e = l;
    while (e != NULL) {
        sum = sum + 1;
        e = e -> suivant;
    }
    return sum;
}

void afficheListe(Liste l) {
    Element* e = l;
    while (e != NULL) {
        afficheTache(&e -> t);
        e = e -> suivant;
    }
}

void ajoutTri(Liste* l, Tache t) {
    Element* e = (Element*)malloc(sizeof(Element));
}