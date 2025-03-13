# -*- coding: utf-8 -*-
"""
Created on Sat Jan  6 08:55:06 2018

@author: leplumey

Module de gestion de la base de données de DVD
"""

# Importation interface de bases de données
from BDRegMat import BDRegMat

class BaseDonneesDVD(BDRegMat):
    def __init__(self,nom='tp4.db'):
        super().__init__(nom)
        self.nom=nom
        
    def creerBase(self):
        self.requete('DROP TABLE TProduits');
        self.requete('DROP TABLE TPays');
        self.requete("CREATE TABLE TPays \
                            (CBPays TEXT PRIMARY KEY, \
                            Pays TEXT)")
        self.requete('CREATE TABLE TProduits \
                            (CBPays TEXT REFERENCES TPays, \
                             CBProduit TEXT, \
                             Titre TEXT, \
                             Annee TEXT, \
                             Type TEXT, \
                             Duree TEXT, \
                             PRIMARY KEY(CBPays, CBProduit))')
                             
    def remplirTPays(self,nom="codesBarresSA.csv"):                            
        # Ouverture du fichier
        f=open(nom,"r")
        txt="c"
        # Boucle de lecture du fichier
        while txt!="":
            # Lire une ligne
            txt=f.readline()
            # Supprime les éventuels caractères de fin de ligne
            txt=txt.rstrip('\r\n')
            # Séparer par ;
            tab=txt.split(";")
            # Vérifie si la ligne contient 3 champs
            if (len(tab)==3):
                if tab[1]=="":
                    # Insertion d'une ligne dans la table TPays
                    self.requete("INSERT INTO TPays VALUES ('{0}', '{1}')".format(tab[0], tab[2]))
                else:
                    deb=int(tab[0])
                    fin=int(tab[1])
                    for i in range(deb,fin+1):
                        ti=str(i)
                        # Si le premier caractère de la borne inférieure (tab[0]) est un zéro ('0'), 
                        # le formatage ajoute des zéros en début de chaîne pour obtenir une longueur standard de trois caractères.
                        if (tab[0][0]=='0'):
                            # Ajout 000 devant ti
                            ti="000"+ti
                            # Extrait les trois derniers caractères de la chaîne.
                            # Cette opération garantit que les codes résultants sont toujours au format XXX
                            ti=ti[len(ti)-3:len(ti)]
                        # Insertion d'une ligne dans la table TPays
                        self.requete("INSERT INTO TPays VALUES ('{0}', '{1})".format(ti, tab[2]))
        f.close()
    
    def enregistrer(self,cPays, cProduit, titre, annee, duree, support):
        # Insertion d'un film dans la base de données
        self.requete("INSERT INTO TProduits VALUES ('{0}', '{1}', '{2}', '{3}', '{4}', '{5}')".format(cPays, cProduit, titre, annee, support, duree))

    def interrogerParCB(self,cPays, cProduit):
        # Récupération des informations d'un film
        tbl = self.question("SELECT Titre, Annee, Type, Duree, Pays" +
                            "FROM TPays, TProduits" +
                            "WHERE TPays.CBPays = '{0}' AND TProduits.CBProduits = '{1}' AND TProduits.CBPays = '{0}'".format(cPays, cProduit))
        return(tbl)
                             
    def interroger(self):
        # Récupération de l'ensemble des films
        tbl = self.question("SELECT Titre, Annee, Type, Duree, Pays" +
                            "FROM TPays, TProduits" +
                            "WHERE TProduits.CBPays = TPays.CBPays")
        return(tbl)

# Programme principal
if __name__ == "__main__":
    bd=BaseDonneesDVD("DVD.db")
    bd.creerBase()
    bd.remplirTPays()
    bd.enregistrer("333","3299304137","La Tour sombre","2017","1h35","Blu-ray")
    t=bd.interrogerParCB("333","3299304137")
    print(t)
    t=bd.interroger()
    print(t)
    bd.fermeture()