from Q2 import Automate

class AutomateNomProf(Automate):
    # Constructeur
    def __init__(self):
        super().__init__()

        # Description de l'automate
        self.reIndi = [r"(\bINDI\b)",1, self.traitIndi]
        self.reName = [r"^1 NAME ((.+)/(.+))",2, self.traitName]
        self.reOccu = [r"^1 OCCU (.*?sabot.*?)(?:\s*\(.*?\))*$",3, self.traitOccu]
        self.automateDon = {0: [self.reIndi],
                            1: [self.reName, self.reIndi],
                            2: [self.reOccu, self.reIndi],
                            3: [self.reIndi]}
        
        self.current_nom = None

    # Traitement spécifique pour une ligne donnée
    def traitIndi(self, m1):
        self.current_nom = None
        return
    def traitName(self, m1):
        prenom, nom = m1.split("/", 1)
        self.current_nom = f"{nom.strip()}"
        if self.current_nom not in self.struct:
            self.struct[self.current_nom] = {}
            return
    def traitOccu(self, m1):
        # Gestion du cas où le nom n’est pas présent
        if not self.current_nom:
            return
        # Séparation des professions
        prof = [prof.strip() for prof in m1.split(",")]
        # Balayage des professions séparées
        for p in prof:
            # Cas d'une profession existante
            if (p in self.struct[self.current_nom]):
                self.struct[self.current_nom][p] += 1
            else:
                # Cas où la profession qui n'existe pas
                self.struct[self.current_nom][p] = 1

    # Impression de la structure
    def afficher(self):
        for cle1 in self.struct.keys():
            print(cle1," : ",end="")
            for cle2 in self.struct[cle1].keys():
                print(cle2+" ("+str(self.struct[cle1][cle2])+")",end=", ")
            print("\n")

if __name__ == "__main__":
    automateNomProf = AutomateNomProf()
    automateNomProf.analyser("sabotier.txt")
    automateNomProf.afficher()
