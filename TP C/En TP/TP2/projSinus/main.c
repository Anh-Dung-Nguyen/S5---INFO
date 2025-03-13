#include <math.h>
#include <stdio.h>

int myfact(int n) {
    if(n > 0) {
        if(n == 1) {
            return 1;
        }
        return n * myfact(n - 1);
    } else {
        return -1;
    }
}

double puissance(double x, int n) {
    double res = 1.0;
    int i;
    for (i = 0; i < n; i++) {
        res = res * x;
    }
    return res;
}

double terme(double x, int n) {
    return (puissance(x, n))/(myfact(n));
}

double sinus(double x, int n) {
    double res = 0;
    int i;
    int signe = 1;
    for (i = 1; i < n; i += 2) {
        res = res + signe * terme(x, i);
        signe = -signe;
    }
    return res;
}

double suiv(double t, double x, int n) {
    return t * (x * x)/(n * (n - 1));
}

double sinus2(double x, int n) {
    double res = 0;
    double t = terme(x, 1);
    int i;
    int signe = 1;
    for (i = 3; i < n; i += 2) {
        res = res + signe * suiv(t, x, i);
        signe = -signe;
    }
    return res;
}

int main(void) {
    int i;
    for (i = 1; i < 41; i+=2) {
        printf("sinus(PI/2) au rang %d = %g\n", i, sinus(M_PI/2, i));
    }
    printf("sin(PI/2) = %g\n", sin(M_PI/2));

    printf("%lf\n", puissance(3, 3));
    printf("%lf\n", terme(3, 3));
    printf("%lf\n", sinus(M_PI/2, 5));
    printf("%lf\n", suiv(terme(3, 3), 3, 5));
    printf("%lf\n", sinus2(M_PI/2, 5));

    return 0;
}
