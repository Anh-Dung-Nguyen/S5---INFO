import re
# Fonction de recherche des sabotiers
def listePatronymes(nomfichier, dct):
    f = open(nomfichier,'r')
    etat = 0
    reg_INDI = re.compile(r"\bINDI\b") 
    # …
    reg_NAME = re.compile(r"^1 NAME (.+)/(.+)")
    reg_OCCU = re.compile(r"^1 OCCU .*sabot.*")

    current_name = None

    for ligne in f:
        ligne = ligne.strip()
        if (etat == 0):     # Etat initial
            res_indi = reg_INDI.search(ligne)
            if res_indi != None: # Etat individu détecté
                etat=1
        elif (etat==1):
            res_nom = reg_NAME.match(ligne)
            if res_nom:
                prenom = res_nom.group(1).strip()
                nom = res_nom.group(2).strip()
                current_name = f"{prenom} {nom}"
                etat = 2
        elif (etat==2):
            if reg_OCCU.match(ligne):
                if current_name:
                    if current_name in dct:
                        dct[current_name] += 1
                    else:
                        dct[current_name] = 1
                current_name = None
                etat = 3
        elif (etat==3):
                res = reg_INDI.search(ligne)
                if res != None: # Etat individu détecté
                    etat=1
    f.close()
# Affichage d’un dictionnaire
def affichageDict(dct):
    for c in dct.keys():
        print(c," : ",dct[c])

# Programme principal
if __name__ == "__main__":
    dct={}
    listePatronymes("sabotier.txt",dct)
    affichageDict(dct)
