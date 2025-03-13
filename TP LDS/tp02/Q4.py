from Q2 import Automate

class AutomateComptage(Automate):
    def __init__(self):
        super().__init__()
        self.struct["Nombre d'occurence"] = 0
        self.automateDon = {0: [[r"(\bINDI\b)", 0, self.trait]]}
    
    def trait(self, m1):
        self.struct["Nombre d'occurence"] += 1


if __name__ == "__main__":   
    automateComptage = AutomateComptage()
    automateComptage.analyser("sabotier.txt")
    automateComptage.afficher()