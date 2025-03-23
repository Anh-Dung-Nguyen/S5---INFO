
# Sujets des TP de CPOO1

Pour les TP, je vous conseille d'utiliser IntelliJ car bien meilleure sur l'exécution des tests et la couverture du code que VSCode.

**Pour ouvrir le projet avec IntelliJ, dans IntelliJ sélectionnez le dossier tp-CPOO1, et chargez le projet.**

Pour utiliser ce dépôt, si vous n'avez pas de clé SSH :
téléchargez le dépôt, mais pensez à télécharger de nouveau le README.md du TP au début de chaque TP.


Pour ceux qui ont déposé une clé SSH sur le gitlab :
`git clone ssh://git@gitlab.insa-rennes.fr:16022/arnaud-blouin/cpoo1-3info.git`

Faire un `git clone` permet de mettre à jour à la volée votre clone si j'applique des changements sur le sujet pendants les TP.
Au début de chaque TP (sauf le premier), faire un :
```
git fetch
git merge
```
Ces commandes git permettent de récupérer les changements que j'ai réalisés et des les appliquer sur votre clone (ne modifiez pas ce README pour éviter les conflits de fusion).

J'ajouterai des exercices en fonction de votre avancement.


## Exercice 1

Une forêt se compose de deux types d'arbres :
le chêne et le pin.
Un arbre se caractérise par son prix (euros/m3, une valeur int, mais pas forcément un attribut), son âge (années, double) ;
son volume (m3, double) ;
son âge minimum pour être coupé (années, double).
Le prix d'un chêne et de 1000 euros/m3 tandis que celle d'un pin est de 500 euros/m3.
Un chêne doit avoir au moins 10 ans pour être coupé, et 5 ans pour un pin.
L'âge minimum de la coupe est le même pour chaque type d'arbre.


1. Dessinez le diagramme de classes correspondant au texte ci-dessus.

1. Implémentez en Java ce diagramme.
Ajouter des getters dans `Arbre` pour age et volume.
Écrire les tests nécessaires. Est-ce utile de créer des tests pour des getters et des setters ?

1. Implémenter un constructeur dans `Arbre` prenant en paramètres les caractéristiques d'un arbre (age et volume).
Cela impliquera des ajouts dans les sous-classes.
Écrire les tests nécessaires.

1. Écrire une opération `vieillir` dans `Arbre` pour ajouter une année à l'âge d'un arbre.
Écrire les tests nécessaires.

1. Ajouter une opération `getPrix` dans `Arbre` pour retourner le prix d'un arbre (en fonction de son volume et de son prix au m3).
Écrire les tests nécessaires.

1. Ajouter une opération `peutEtreCoupé` dans `Arbre` pour retourner `true` si l'arbre en question peut être coupé.
Écrire les tests nécessaires.

1. Définir la classe `Foret` contenant deux listes d'arbres :
une liste contenant les arbres de la forêt ;
une liste contenant les arbres coupés.
Ajouter des getters pour ces deux listes.
Écrire les tests nécessaires.

1. Dans `Foret`, ajouter une opération `planterArbre` qui ajoute à la forêt un arbre donné en paramètre.
Écrire les tests nécessaires.

1. Dans `Foret`, ajouter une opération `getPrixTotal` qui retourne le prix de tous les arbres de la forêt pouvant être coupé.
Écrire les tests nécessaires.

1. Dans `Foret`, ajouter une opération `couperArbre` qui prend le premier `Arbre` de la forêt pouvant être coupé et qui le coupe. Couper un arbre de la forêt revient à le supprimer de la lite des arbres de la forêt et à le mettre dans celle des arbres coupés.
Écrire les tests nécessaires.

1. Ajouter une opération `getNombreChene` dans `Foret` retournant le nombre de chênes présents dans la forêt.
Écrire les tests nécessaires.


Questions bonus de programmation orientée objet (à réaliser chez vous) :

1. Il existe deux types d'animaux. Les écureuils et les cochons.
Il existe deux types de fruits d'arbres : les glands produits par les chênes, et les cônes produits par les pins.
Créer ces six classes.

1. Ajouter dans les classes d'arbres une méthode `produireFruit` qui retournera un fruit d'arbre du bon type.
Nous supposerons que tous les arbres produisent des fruits d'arbres.
Il vous faudra ajouter un générique (*generics* Java) aux classes d'arbres.

1. Tous les animaux mangent certains fruits d'arbres. Les écureuils mangent des cônes et les cochons mangent des glands.
Ajouter une méthode `manger` (qui ne fera rien) aux classes des animaux.
Cette méthode prendra en paramètre un fruit d'arbre du bon type.
Il vous faudra ajouter un générique aux classes d'animaux.


## Exercice 2

Vous devez tester la classe `Exo2` (la classe de tests est déjà créée).

1. Tester comme dans l'exercice précédent.
2. Utiliser des tests paramétrés pour tester le `if(!regex.matcher(address).matches())`.
Attention, le(s) test(s) utilisant une mauvaise adresse IP doivent échouer parce que le format de l'IP n'est pas bon (et non pas parce que `network.ping(address)` retourne `false` par défaut).
Dans ce cas, il vous faut donc configurer `network.ping(address)` pour qu'elle retourne `true`.
3. Même si vous avez une couverture de 100%, un de vos tests doit vérifier que la méthode `sendGetHTTPQuery` est bien appelée avec la valeur `address`.



## Exercice 3

```
val a := 1
val b := 2
a + b + 3
```


Le code ci-dessus illustre le texte suivant. Ce code est cependant uniquement à but illustratif.

Une formule arithmétique se compose d'un ensemble de constantes définies et d'un nœud racine de la formule (exemple : le premier + dans le code ci-dessus).
Une constante a un nom et une valeur.
Un nœud est soit un opérateur arithmétique, soit une valeur, soit une référence vers une constante.
Un opérateur arithmétique est soit une addition, soit une soustraction.
Ces deux opérateurs ont deux opérandes : gauche et droite.
Une référence vers une constante, comme son nom l'indique, fait référence à une constante déjà définie.
Une valeur a un nombre de type 'double'.
Une formule arithmétique et les nœuds sont calculables (et retournent une valeur de type 'double').
Par exemple la formule arithmétique ci-dessus est un arbre qui donne un nœud racine '+' dont le premier opérande est une référence vers 'a' et le second un autre '+', dont l'opérande gauche est une référence vers 'b' et l'opérande droit un litéral 3.

1. Donnez le diagramme de classes du texte ci-dessus.



## Exercice 4

Le code de cet exercice se trouve dans le dossier `exo4`. Il concerne une classe `Client` qui utilise des objets `Service`.
Pour rappel, une latence est le temps entre une demande et la réponse.

1. Quelle est la différence entre les opérateurs `&&` et `&` (idem pour `||` et `|`) ? Exemple ligne 23.

1. En tenant compte de la question précédente, donnez la table de vérité effective de la condition ligne 23. Pourquoi est-ce utile lors de l'écriture de tests ?

1. En utilisant cette table de vérité, donnez maintenant la graphe de flot de contrôles de la méthode `addService`.

1. En lien avec la question précédente, quels sont les classes d'équivalence du paramètre `s` de la méthode `addService` ?

1. Donnez le graphe de flot de contrôle (cf. le graphe du code vu dans le cours) représentant le code de la méthode `getTotalLatency`.
Utilisez les lettres mises en commentaires pour nommer les nœuds.

1. Donnez le code Java d'une classe de tests unitaires `ClientTest` testant la classe `Client` avec une couverture de conditions et de branches de 100 %.
Vous ne disposez pas d'implémentations de l'interface `Service`.



## Exercice 5

Le code de cet exercice se trouve dans le dossier `exo5`. Il concerne une classe `PlateauJeu` qui utilise des objets `Pion`.

1. En Java, que signifie le mot-clé `final` posé sur l'attribut `pions` ? Quel est la différence entre un attribut de type primitif *final*
(exemple `SIZE`) et un attribut de type complexe (exemple `pions`) ? 

1. Étudiez le code de la classe `PlateauJeu` et inférez quels sont les classes d'équivalence de la coordonnée `x` (idem pour `y`) d'un pion ?

1. Donnez le graphe de flot de contrôle de la méthode `isFree`.

1. Testez la méthode `isOut` en utilisant des tests paramétrés.


## Exercice 6

Un démarreur de voiture est la pièce qui utilise la batterie de la voiture pour obtenir le courant nécessaire à la mise en rotation du volant moteur qui permet à son tour de mettre en mouvement le moteur (et donc de démarrer). Le schéma suivant montre comment le volant moteur (une roue crantée) permet d'actionner le moteur via un pignon.

![image moteur](pics/demarreur.jpg)

Un moteur à combustion de voiture se compose d'une batterie, d'un pignon, d'un volant moteur et d'un démarreur.
Il existe deux types possibles de moteurs à combustion : le moteur diesel et le moteur essence.
Un moteur peut avoir un turbo.
Le moteur essence se possède un filtre à essence.
Le moteur diesel possède des filtres : un filtre à gasoil et un filtre à particule.
Le pignon utilise le volant moteur.
Le démarreur utilise la batterie et le pignon.
Un moteur à une puissance (une valeur entière).

1. Donnez le diagramme de classes modélisant le texte ci-dessus.

## Exercice 7

Une suite de tests contient des classes de tests.
Une même classe de tests peut être dans plusieurs suites de tests.
Une classe de tests se compose :
de méthodes de test ;
éventuellement d'une méthode `setUp` pour configurer les tests.
Une classe de tests peut avoir une classe de tests parente.
Une méthode de test peut utiliser des assertions.
Il existe deux types d'assertions dans notre cas :
le `assertEquals` et le `assertNotNull`.
Une classe de tests, une méthode `setUp` ainsi que les méthodes de tests peuvent être exécutées.

1. Donnez le diagramme de classes modélisant le texte ci-dessus. 
Attention, la difficulté de cet exercice est qu'une méthode de test est un concept (donc une classe), 
et non une méthode dans une classe du diagramme.


## Exercice 8

La classe `Exo8` présente deux problèmes pour tester ses méthodes.

1. Cette classe instancie dans son constructeur l'objet `Random`. 
Nous ne pouvons donc pas mocker un `Random` et le donner à l'objet `Exo8`.
Utilisez cette technique pour pallier ce problème et tester la méthode `uneFonctionInutile`.
https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html#49

1. L'autre méthode de la classe `Exo8`, `uneAutreFonctionInutile`, utilise directement une méthode 
statique de la classe `RandomGenerator`. 
Utilisez cette autre technique pour pallier ce nouveau problème :
https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html#48


## Exercice 9

Étudier le code de la classe `Exo9` ainsi que celui de sa classe de test `TestExo9`.
Cette dernière teste très mal la classe `Exo9`.

1. Quelles sont les trois raisons ? La première est assez évidente, les deux autres moins.

1. Pour trouver les trois problèmes :
commentez le contenu des trois méthodes, et pour `estVide`, écrivez `return true;`.
Ré-exécutez les tests. Essayez de comprendre pourquoi le fait de changer le code et que la suite de tests
passe toujours est un problème.

1. En ligne de commande (placez-vous dans le dossier du tp), exécutez Pitest 
(cela demande d'avoir mis à jour le pom.xml avec mes changements récents) :
`mvn clean install test org.pitest:pitest-maven:mutationCoverage`
puis ouvrez le fichier `index.html` se trouvant dans `target/pi-reports` et cliquez pour arriver à la classe `Exo9`.
Pitest est un outil de score de *mutation testing*. Essayez de comprendre le principe à partir des résultats indiqués
dans `index.html`.

1. Lisez les slides sur le mutation testing:
https://moodleng.insa-rennes.fr/mod/resource/view.php?id=59026
Et modifiez la suite de tests de `TestExo9` pour arriver à un score de mutation de 100% 
(corrigez également les éventuels défaults présents dans la classe `Exo9`).
