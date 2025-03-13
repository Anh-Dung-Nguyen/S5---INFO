#include <math.h>
#include <stdio.h>

double suite(double x, int n) {
    double xn = x / 2.0;    /** La première valeur, ici u0 */
    int i;
    for (i = 1; i <= n; i++) {
        xn = (xn + x/xn)/2.0;
    }
    return xn;
}

double racine(double x, double precision) {
    double x0 = x / 2.0;
    double xn = x0;     /** Pour commencer, mettre la dernière valeur en la première valeur */
    do {
        x0 = xn;        /** Chaque fois, mettre à jour la valeur x de (n - 1) en x0 */
        xn = (xn + x/xn)/2.0;
    } while (fabs(xn - x0) > precision);
    return xn;
}

int main(void)
{
    double x, xx, yy, res, resu;
    int n;

    printf("Entrez 2 chiffres: \n");
    scanf("%lf %d", &x, &n);
    res = suite(x, n);
    printf("Suite: %f\n", res);

    printf("Entrez x et précision: \n");
    scanf("%lf %lf", &xx, &yy);
    resu = racine(xx, yy);
    printf("Racine: %f\n", resu);
}
