#include <stdio.h>

int carre(int n) {
    return n * n;
}

int main(void)
{
    int n, res;
    printf("Entrez une valeur n: \n");
    scanf("%d", &n);
    res = carre(n);
    printf("%d\n", res);
    return 0;
}
