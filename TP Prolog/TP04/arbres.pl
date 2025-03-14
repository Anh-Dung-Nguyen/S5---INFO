/* 2.1 */
integer(zero).
integer(suc(X)) :- integer(X).

arbre_binaire(vide).
arbre_binaire(arb_bin(R, G, D)) :- integer(R),
				   arbre_binaire(G),
				   arbre_binaire(D).
				   
/* 2.2 */
dans_arbre_binaire(R, arb_bin(R, G, D)) :- !.
dans_arbre_binaire(E, arb_bin(R, G, D)) :- dans_arbre_binaire(E, G),
					   !.
dans_arbre_binaire(E, arb_bin(R, G, D)) :- dans_arbre_binaire(E, D),
					   !.
					   
/* 2.3 */
sous_arbre_binaire(arb_bin(R, G, D), arb_bin(R, G, D)) :- !.
sous_arbre_binaire(arb_bin(R, G, D), arb_bin(R1, G1, D1)) :- sous_arbre_binaire(arb_bin(R, G, D), G1),
							     !.
sous_arbre_binaire(arb_bin(R, G, D), arb_bin(R1, G1, D1)) :- sous_arbre_binaire(arb_bin(R, G, D), D1),
							     !.

/* 2.4 */
remplacer(arb_bin(R1, G1, D1), arb_bin(R2, G2, D2), vide, vide).
remplacer(arb_bin(R1, G1, D1), arb_bin(R2, G2, D2), arb_bin(R1, G1, D1), arb_bin(R2, G2, D2)).
remplacer(arb_bin(R1, G1, D1), arb_bin(R2, G2, D2), arb_bin(R3, G3, D3), arb_bin(R4, G4, D4)) :- remplacer(arb_bin(R1, G1, D1), arb_bin(R2, G2, D2), G3, G4).
												 remplacer(arb_bin(R1, G1, D1), arb_bin(R2, G2, D2), D3, D4).

/* 2.5 */
isomorphes(vide, vide).
isomorphes(arb_bin(R, G, D), arb_bin(R, G, D)).
isomorphes(arb_bin(R, G, D), arb_bin(R, D, G)).
isomorphes(arb_bin(R, G, D), arb_bin(R1, G1, D1)) :- ismorphes(G, G1),
						     ismorphes(D, D1).
isomorphes(arb_bin(R, G, D), arb_bin(R1, G1, D1)) :- ismorphes(G, D1),
						     ismorphes(G1, D).
/* isomorphes corrigé par le prof */
isomorphes(vide, vide).
isomorphes(arb_bin(R, G1, D1), arb_bin(R, G2, D2)) :- isomorphes(G1, G2),
						      isomorphes(D1, D2).
isomorphes(arb_bin(R, G1, D1), arb_bin(R, G2, D2)) :- isomorphes(G1, D2),
						      isomorphes(D1, G2).

/* 2.6 */
ajouter(P, [], [P]).
ajouter(P, [P|L], [L]).
ajouter(P, [E|L], [E|Res] :- ajouter(P, L, Res).

infixe(vide, []).
infixe(arb_bin(R, G, D), L) :- infixe(G, L1),
			       infixe(D, L2),
			       ajouter(L1, 
			       
												 
												 
												 
												 
