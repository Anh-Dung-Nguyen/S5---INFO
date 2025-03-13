/*!
* \file main.c
* \brief Test du calcul de la factorielle
* \author
* \date
*/
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

/*! \func int myfact(int n)
 *
 * @param n l'entier dont on veut calculer la factorielle
 * @return la factorielle de n
 */
int myfact(int n) {
    /* a compléter*/
    if (n >= 0) {
        if (n == 0) {
            return 1;
        } else {
            return n * myfact(n - 1);
        }
    } else {
        return -1;
    }
}

void display_fact() {
    int i;
    for(i = 1; i <= 20; i++) {
        printf("%d\n", myfact(i));
    }
}

int rang() {
    int i = 0;
    while (myfact(i) < INT_MAX / (i + 1)) {
        i = i + 1;
    }
    return i;
}

int main()
{
  /*à compléter*/
    int n, result;

    printf("Entrez une valeur de n: \n");
    scanf("%d", &n);
    result = myfact(n);
    printf("Result: %d\n", result);

    display_fact();

    printf("%d\n", rang());

    return EXIT_SUCCESS;
}
