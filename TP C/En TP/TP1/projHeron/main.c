#include <stdio.h>
#include <math.h>

double suite(double x, int n) {
    double xn = x/2.0;
    int i;
    for (i = 1; i < n; i+=1) {
        xn = (xn + x/xn)/2.0;
    }
    return xn;
}

double racine(double x, double precision) {
    double x0 = x/2.0;
    double xn = x0;
    do {
        x0 = xn;
        xn = (xn + x/xn)/2.0;
    } while (fabs(xn -x0) > precision);
    return xn;
}

int main(void) {
    double x, xx, res, resu, precision;
    int n;

    //
    printf("Enter number: ");
    scanf("%lf %d", &x, &n);
    res = suite(x, n);
    printf("%f\n", res);

    printf("Enter number: ");
    scanf("%lf %d", &xx, &precision);
    resu = racine(xx, precision);
    printf("%f\n", resu);

    return 0;
}
