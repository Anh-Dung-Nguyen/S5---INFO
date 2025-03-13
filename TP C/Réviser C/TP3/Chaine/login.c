/*
// Created by nguyen-anh-dung on 10/30/24.
*/

#include <ctype.h>
#include <stdio.h>
#include "chaine.h"

void identifiant(char* prenom, char* nom, char* id) {
    int i;
    id[0] = prenom[0];
    for (i = 0; i < MAX_ID; i++) {
        id[i + 1] = nom[i];
        if (nom[i] == '\0') {
            break;
        }
    }
}

void identifiant2(char* prenom, char* nom, char* id) {
    int i;
    id[0] = tolower(prenom[0]);
    for (i = 0; i < MAX_ID; i++) {
        id[i + 1] = tolower(nom[i]);
        if (nom[i] == '\0') {
            break;
        }
    }
}