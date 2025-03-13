#include <stdio.h>
#include <stdlib.h>
#include "limits.h"

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

void display_fact() {
    int i = 1;
    int max = 20;

    while(i <= max) {
        printf("%d\n", myfact(i));
        i = i + 1;
    }
}

int rang() {
    int i = 0;
    while (myfact(i) < INT_MAX/(i + 1)) {
        i = i + 1;
    }
    return i;
}

int main(void) {
    printf("%d\n", myfact(5));
    display_fact();
    printf("%d\n", rang());
    return 0;
}
