#include <math.h>
#include <stdio.h>

double puissance(double x, int n) {
    int i;
    double res = 1;
    if (n == 0) {
        return 1;
    }
    for (i = 0; i < n; i++) {
        res = res * x;
    }
    return res;
}

int myfact(int n) {
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

double terme(double x, int n) {
    return puissance(x, n) / myfact(n);
}

double sinus(double x, int n) {
    int i;
    int signe = 1;
    double res = 0;
    for(i = 1; i <= n; i = i + 2) {
        res = res + signe * terme(x, i);
        signe = -signe;
    }
    return res;
}

double suiv(double t, double x, int n) {
    return t * (x * x) / (n * (n - 1));
}

double sinus2(double x, int n) {
    double res = 0;
    int i;
    int signe = -1;
    double t = terme(x, 1);
    for(i = 1; i <= n; i = i + 2) {
        res = res + signe * suiv(t, x, i);
        signe = -signe;
    }
    return res;
}

int main(void)
{
    double x = 5;
    int n = 2;

    int i;
    for (i = 1; i <= 41; i = i + 2) {
        printf("sinus(PI/2) au rang %d = %g\n", i, sinus(M_PI/2, i));
    }
    printf("sin(PI/2) = %g\n", sin(M_PI/2));

    printf("%lf\n", puissance(x, n));
    printf("%lf\n", terme(x, n));
    printf("%lf\n", suiv(terme(3, 3), 3, 5));
    printf("%lf\n", sinus2(M_PI/2, 1));

    return 0;

}
