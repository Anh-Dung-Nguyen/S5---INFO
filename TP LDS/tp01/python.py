from random import randint

def initialiserAleatoire():
    vmin = 1
    vmax = 10
    val = randint(vmin, vmax)
    print(val)

def tri_selection(t, n):
    i = 0
    while (i <= n - 1):
        min = i
        j = i + 1
        while (j < n):
            if (t[j] < t[min]):
                min = j
            j+=1
        if min != i:
            a = t[i]
            t[i] = t[min]
            t[min] = a
        i+=1
    print(t)

def tri_insertion(t, n):
    i = 1
    while (i <= n - 1):
        x = t[i]
        j = i
        while (j > 0 and t[j - 1] > x):
            t[j] = t[j - 1]
            j = j - 1
        t[j] = x
        i+=1
    print(t)

if __name__ == "__main__":
    initialiserAleatoire()

    t1 = [1, 2, 10, 9, 7, 4, 6, 8, 3, 5]
    tri_selection(t1, 10)

    t2 = [2, 5, 10, 9, 7, 4, 6, 8, 3, 1]
    tri_insertion(t2, 10)
