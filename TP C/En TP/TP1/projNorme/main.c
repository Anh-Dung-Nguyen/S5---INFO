#include <stdio.h>
#include <math.h>

float norme(float x, float y) {
    return sqrt(x*x + y*y);
}

int main(void) {
    float x, y, t;
    printf("Vecteur: ");
    scanf("%f %f", &x, &y);
    t = norme(x, y);
    printf("%f", t);
    return 0;
}
