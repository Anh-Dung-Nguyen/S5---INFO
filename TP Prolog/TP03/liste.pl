/* 1.1 */
membre(X, [X|A]).
membre(X, [B|A]) :- membre(X, A).

/* 1.2 */
compte(A, [], 0).
compte(A, [A|X], N) :- compte(A, X, M),
		       N is M + 1.
compte(A, [B|X], N) :- A \== B,
		       compte(A, X, N).

/* 1.3 */
/* Méthode avec une fonction auxiliaire */
reverser(X, Y) :- renv(X, [], Y).
renv([], A, A).
renv([B|X], A, Y) :- renv(X, [B|A], Y).

/* Méthode avec une fonction directe */
renverser2([], []).
renverser2([A|R], Y) :- renverser(R, RV)
			append(RV, [A], Y).

/* 1.4 */
palind(X) :- renverser(X, X)

/* 1.5 */
enieme(1, [A|X], A).
enieme(N, [B|X], A) :- N > 1,
		       N1 is N - 1,
		       enieme(N1, X, A).
		       
/* 1.6 */
hors_de(A, []).
hors_de(A, [B|X]) :- A \== B,
		     hors_de(A, X).
		     
/* 1.7 */
tous_diff([]).
tous_diff([A|X]) :- hors_de(A, X),
		    tous_diff(X).

/* 1.8 */
conc3([], [], [], []).
conc3([], [], Z, Z).
conc3([], [E|Y], Z, [E|T]) :- conc3([], Y, Z, T).
conc3([E|X], Y, Z, [E|T]) :- conc3(X, Y, Z, T).

/* 1.9 */
debute_par(X, []).
debute_par([A|X], [A|Y]) :- debute_par(X, Y)

/* 1.10 */
sous_liste(X, Y) :- debute_par(X, Y).
sous_liste([A|X], Y) :- debute_par(X, Y)

/* 1.11 */
elim([], []).
elim([A|X], [A|Y]) :- hors_de(A, X),
		      elim(X, Y).
elim([A|X], Y) :- membre(A, X),
		  elim(X, Y).
		  
/* 1.12 */
inserer(E, [], [E]).
inserer(E, [E|L1], [E, E|L1]).
inserer(E, [A|L1], [E, A|L1]) :- A > E.
inserer(E, [A|L1], [A, E|L1]) :- A < E.

tri([], []).
tri([A|X], Y) :- tri(X, Z),
		 inserer(X, Z, Y).

/* 2.1 */

/* 2.2 */
/* 2.3 */
