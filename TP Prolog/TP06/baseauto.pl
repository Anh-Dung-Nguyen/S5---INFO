/**
TP Base de Données Déductives (BDD) - Prolog

@author Prenom1 NOM1
@author Prenom2 NOM2
@version Annee scolaire 20__/20__
*/


% =========================================================================================== 
% PARTIE 1 : Base de données
% =========================================================================================== 

assemblage(voiture, porte, 4).
assemblage(voiture, roue, 4).
assemblage(voiture, moteur, 1).
assemblage(roue, jante, 1).
assemblage(porte, tole, 1).
assemblage(porte, vitre, 1).
assemblage(roue, pneu, 1).
assemblage(moteur, piston, 4).
assemblage(moteur, soupape, 16).

piece(p1, tole, lyon).
piece(p2, jante, lyon).
piece(p3, jante, marseille).
piece(p4, pneu, clermont_ferrand).
piece(p5, piston, toulouse).
piece(p6, soupape, lille).
piece(p7, vitre, nancy).
piece(p8, tole, marseille).
piece(p9, vitre, marseille).

demandeFournisseur(dupont, lyon).
demandeFournisseur(michel, clermont_ferrand).
demandeFournisseur(durand, lille).
demandeFournisseur(dupond, lille).
demandeFournisseur(martin, rennes).
demandeFournisseur(smith, paris).
demandeFournisseur(brown, marseille).
          
fournisseurReference(f1, dupont, lyon).
fournisseurReference(f2, durand, lille).
fournisseurReference(f3, martin, rennes).
fournisseurReference(f4, michel, clermont_ferrand).
fournisseurReference(f5, smith, paris).
fournisseurReference(f6, brown, marseille).

livraison(f1, p1, 300).
livraison(f2, p2, 200).
livraison(f3, p3, 200).
livraison(f4, p4, 400).
livraison(f6, p5, 500).
livraison(f6, p6, 1000).
livraison(f6, p7, 300).
livraison(f1, p2, 300).
livraison(f4, p2, 300).
livraison(f4, p1, 300).


% ============================================================================= 
% PARTIE 2 : Opération relationnelles
% ============================================================================= 

/* 2.1 */
selection (X, Y) :- piece (X, Y, lyon).

/* 2.2 */
projection (X, Y) :- piece (_, X, Y).

/* 2.3 */
intersection (X, Y) :- demandeFournisseur(X, Y),
		       fournisseurReference(_, X, Y).

notIntersection (X, Y) :- intersection(X, Y),
			  !,
			  fail.
notIntersection (_, _).

union (X, Y) :- demandeFournisseur(X, Y).
union (X, Y) :- fournisseurReference(_, X, Y),
		notIntersection (X, Y).

difference (X, Y) :- demandeFournisseur(X, Y),
		     notIntersection(X, Y).
		     
/* 2.4 */
produit_cartesien(Num1, Nom, Ville, Num2, Piece, Quantite) :- fournisseurReference(Num1, Nom, Ville),
							      livraison(Num2, Piece, Quantite).
							      
/* 2.5 */
jointure(NumF, Nom, Ville, Piece, Quantite) :- fournisseurReference(NumF, Nom, Ville),
					       livraison(NumF, Piece, Quantite).

jointure_sup(NumF, Nom, Ville, Piece, Quantite) :- jointure(NumF, Nom, Ville, Piece, Quantite),
						   piece > 350.

/* 2.6 */
fournitToutDeLyon(F) :-
    piece(P, _, lyon),
    not(livraison(F, P, _)),
    !,
    fail.
fournitToutDeLyon(_).

division(F) :- fournisseurReference(F, _, _),
	       fournitToutDeLyon(F).
	       
/* 2.7 */


% ============================================================================= 
% PARTIE 3 : Au delà de l’algèbre relationnelle
% ============================================================================= 

/* 3.1 */
est_compose_de(X, Y) :- assemblage(X, Y, _).
est_compose_de(X, Y) :- assemblage(X, Z, _),
			est_compose_de(Z, Y).
					  
/* 3.2 */

