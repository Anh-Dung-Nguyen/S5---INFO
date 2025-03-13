# -*- coding: utf-8 -*-
# ...

from random import randint
from time import time

# La classe TriTablau contient un tableau de valeurs numériques et des méthodes
# travaillant sur ce tableau
class TableauTri:

    # Le constructeur qui alloue un tableau vide ou d'une certaine taille
    # en fonction du paramètre
    def __init__(self, taille=10):
        self.taille = taille
        if (taille >= 0):
            self.t = [0] * taille
        else:
            self.t = []

    # Initialisation d'un tableau avec l'ajout de valeurs
    def initialiserTableau(self, *t):
         self.t = list(t)
         self.taille = len(t)

    # Initialisation d'un tableau déjà dimmensionné avec des valeurs aléatoires
    def initialiserAleatoire(self, mini, maxi):
        i = 0
        for i in range(self.taille):
            self.t[i] = randint(mini, maxi) 

    # Création d'un nouveau tableau identique à celui qui sert à appeler la méthode
    def copie(self):
        nvTab=TableauTri(self.taille)
        nvTab.t = self.t.copy()
        return nvTab
    
    # Affichage du tableau
    def afficher(self):
        print(self.t) 

    # Tri par sélection du tableau contenu dans la classe
    def triSelection(self):
        i = 0
        while (i <= self.taille - 1):
            min = i
            j = i + 1
            while (j < self.taille):
                if (self.t[j] < self.t[min]):
                    min = j
                j+=1
            if min != i:
                a = self.t[i]
                self.t[i] = self.t[min]
                self.t[min] = a
            i+=1
    
    # Tri par insertion
    def triInsertion(self):
        i = 1
        while (i <= self.taille - 1):
            x = self.t[i]
            j = i
            while (j > 0 and self.t[j - 1] > x):
                self.t[j] = self.t[j - 1]
                j = j - 1
            self.t[j] = x
            i+=1
    
    # Tri a bulle
    def tri_a_bulles_optimise(self):
        i = self.taille - 1
        while (i >= 1):
            tableau_trie = True
            j = 0
            while (j < i - 1):
                if (self.t[j + 1] < self.t[j]):
                    a = self.t[j + 1]
                    self.t[j + 1] = self.t[j]
                    self.t[j] = a
                    tableau_trie = False
                j+=1
            if (tableau_trie):
                pass
            i-=1

    # Fonction partitionner
    def partitionner(self, tab, pre, der, piv):
        a = tab[piv]
        tab[piv] = tab[der]
        tab[der] = a

        j = pre
        i = pre

        while (i <= der - 1):
            if(tab[i] <= tab[der]):
                a = tab[i]
                tab[i] = tab[j]
                tab[j] = a
                j+=1
            i+=1

        b = tab[der]
        tab[der] = tab[j]
        tab[j] = b

        return j

    # Tri rapide
    def tri_rapide(self, pre, der):
        if (pre < der):
            pivot = randint(pre, der)
            pivot = self.partitionner(self.t, pre, der, pivot)
            self.tri_rapide(pre, pivot - 1)
            self.tri_rapide(pivot + 1, der)

    # Temps
    def instrumentaliser(text, fct):
        debut = time()
        fct()
        print("Durée d'exécution " + text + ": " + str(time() - debut))
    
if __name__ == "__main__":
    # Test constructeur d'un tableau vide   
    t1=TableauTri()
    # Test ajout de valeurs au tableau    
    t1.initialiserTableau(5,4,3,7,6,2,1,10,8,9)
    # Test tri par sélection    
    t1.triSelection()
    # Test tri et affichage    
    t1.afficher()
    # Test constructeur d'un tableau d'une taille donnée   
    t2=TableauTri(10)
    # Test remplissage aléatoire d'un tableau dimensionné    
    t2.initialiserAleatoire(0,50)
    # Test copie de tableau    
    t3=t2.copie()
    # Test tri et affichage sur la copie    
    t3.triSelection()
    # Les deux affichages suivants doivent donner des valeurs différentes
    t2.afficher()
    t3.afficher()
    
    t4 = TableauTri()
    t4.initialiserTableau(2, 5, 10, 9, 7, 4, 6, 8, 3, 1)
    t4.triInsertion()
    t4.afficher()

    t5 = TableauTri()
    t5.initialiserTableau(2, 5, 9, 7, 4, 6, 8, 3, 1, 10)
    t5.tri_a_bulles_optimise()
    t5.afficher()

    t6 = TableauTri()
    t6.initialiserTableau(1, 2, 4, 3, 5, 10, 6, 8, 9, 7)
    t6.tri_rapide(0, 9)
    t6.afficher()

    t7 = TableauTri(10)
    t7.initialiserAleatoire(0, 20)
    t8 = t7.copie()
    t9 = t7.copie()
    t10 = t7.copie()

    TableauTri.instrumentaliser("tri selection", t7.triSelection)
    TableauTri.instrumentaliser("tri insertion", t8.triInsertion)
    TableauTri.instrumentaliser("tri à bulles", t9.tri_a_bulles_optimise)
    TableauTri.instrumentaliser("tri rapide", lambda: t10.tri_rapide(0, t10.taille - 1))

    t7.afficher()
    t8.afficher()
    t9.afficher()
    t10.afficher()