#include <stdio.h>
#include <math.h>

float norme(float a, float b) {
    return sqrt(a*a + b*b);
}

int main(void) {
    float x, y, res;
    printf("Please enter two numbers: ");
    scanf("%f %f", &x, &y);
    res = norme(x, y);
    printf("The result is: %f\n", res);
    return 0;
}
