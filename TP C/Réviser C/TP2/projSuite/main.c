#include <math.h>
#include <stdio.h>

double suite(int n, int verbose) {
    double res;
    if (n == 0) {
        res = M_E - 1;
    } else if (n == 1) {
        res = M_E;
    } else {
        res = M_E - n * suite(n - 1, verbose);
    }
    if (verbose) {
        printf("Suite(%d) = %lf\n", n, res);
    }
    return res;
}

double suiteDecroissante() {
    double res = 0;
    int i;
    for (i = 49; i >= 0; i--) {
        res = (M_E - res)/ (i + 1);
    }
    return res;
}

int main(void)
{
    suite(20, 1);
    printf("suiteDecroissante() = %lf\n", suiteDecroissante());

    return 0;
}
