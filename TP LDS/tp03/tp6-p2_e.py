# -*- coding: utf-8 -*-

"""
QWidget : La classe de base pour toutes les interfaces graphiques.
QHBoxLayout : Un gestionnaire de disposition en ligne horizontale.
QMessageBox : Pour afficher une boîte de message en cas d'erreur.
QLabel : Pour afficher du texte ou des images.
QApplication : Pour gérer l'application et son événement principal.
QPixmap : Pour charger et manipuler des images.
"""

from PyQt5.QtWidgets import QWidget, QHBoxLayout, QMessageBox, QLabel
from PyQt5.QtWidgets import QApplication
from PyQt5.QtGui import QPixmap


# Classe Exemple hérite QWidget
class Exemple(QWidget):
    def __init__(self, parent=None):
        QWidget.__init__(self, parent)
        self.initUI()
        self.show()
  
    def initUI(self):
        self.setWindowTitle("Visualisation d'une image")
        self.move(250, 200)

        hbox = QHBoxLayout()
        # L'image affichée n'ayant pas besoin d'être manipulée, on n'utilise pas le widget QImage
        pixmap = QPixmap("ville.jpg")
        if pixmap.isNull():
                QMessageBox.information(self,u"Problème",u"Image non trouvée")
        label = QLabel()
        label.setPixmap(pixmap)
        self.setLayout(hbox)
        hbox.addWidget(label)

if __name__ == "__main__":
    app=QApplication([])
    mf=Exemple()
    app.exec_()


# widget là tien ich
# layout là bo cuc
# label là nhan