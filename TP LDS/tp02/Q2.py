import re

# Automate générique
class Automate:
    # Constructeur
    def __init__(self):
        self.etat = 0
        self.struct = {}        
        # Description de l'automate
        self.automateDon = {0: [[r"^(.*?)\\s*$", 0, self.traitDefaut]]}
    
    # Traitements liés à l'automate
    def traitDefaut(self, m1):
        print(m1)
        return

    # Boucle d'analyse du fichier d'entrée à l'aide d'un automate
    def analyser(self, nom):
        f = open(nom,'r')
        for ligne in f: # boucle de balayage de lecture des lignes du fichier
            for i in range(len(self.automateDon[self.etat])): # boucle de balayage des expressions régulières associées à l'état courant
                # Recherche des expressions régulières disponibles 
                # pour l'état courant 
                regexp = re.compile(self.automateDon[self.etat][i][0]) # test de correspondance de la ligne avec l'expression régulière
                result = regexp.search(ligne)
                if result != None:
                    # Les expressions régulières capture TOUTE une zone
                    m1 = result.group(1) # extraction de la zone capturée
                    # Appel de la fonction prévue par l'automate
                    self.automateDon[self.etat][i][2](m1) # appel de la fct de traitement associée
                    # Changement de l'état de l'automate
                    self.etat = self.automateDon[self.etat][i][1] # évoluer l'état courant
                    # Sortir de la boucle i, le changement d'état ayant
                    # une influence sur le résultat du range
                    break
        f.close()
        return self.struct
    
    # Impression de la structure (un niveau pas défaut)
    def afficher(self):
       for cle1 in self.struct.keys():
           print(cle1+" : "+str(self.struct[cle1]))

if __name__ == "__main__":
    automate = Automate()
    automate.analyser("sabotier.txt")
