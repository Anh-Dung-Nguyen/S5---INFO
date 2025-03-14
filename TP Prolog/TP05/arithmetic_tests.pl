% Tests automatiques

tests :-
    test( test_add1_1 ),
    test( test_add1_2 ),
    test( test_add1_3 ),
    test( test_add1_4 ),
    test( test_add1_5 ),
    test( test_add1_6 ),

    test( test_sub1_1 ),
    test( test_sub1_2 ),
    test( test_sub1_3 ),

    test( test_prod1_1 ),
    test( test_prod1_2 ),
    test( test_prod1_3 ),
    test( test_prod1_4 ),
    test( test_prod1_5 ),

    test( test_factorial1_1 ),
    test( test_factorial1_2 ),
    test( test_factorial1_3 ),

    test( test_add2_1 ),
    test( test_add2_2 ),
    test( test_add2_3 ),
    test( test_add2_4 ),
    test( test_add2_5 ),

    test( test_sub2_1 ),
    test( test_sub2_2 ),
    test( test_sub2_3 ),

    test( test_prod2_1 ),
    test( test_prod2_2 ),
    test( test_prod2_3 ),
    test( test_prod2_4 ),

    test( test_factorial2_1 ),
    test( test_factorial2_2 ),
    test( test_factorial2_3 ),
    test( test_factorial2_4 ),

    test( test_factorial3_1 ),
    test( test_factorial3_2 ),
    test( test_factorial3_3 ),
    test( test_factorial3_4 ).

test_add1_1 :-
    assert_true( add1(zero, s(s(zero)), s(s(zero))) ).

test_add1_2 :-
    assert_true( add1(s(s(s(zero))), s(s(s(s(zero)))), s(s(s(s(s(s(s(zero)))))))) ).

test_add1_3 :-
    assert_true( count(test_add1_3_aux, 8) ).
test_add1_3_aux :-
    (X = zero; X = s(zero); X = s(s(zero)); X = s(s(s(zero))); X = s(s(s(s(zero))));
     X = s(s(s(s(s(zero))))); X = s(s(s(s(s(zero))))); X = s(s(s(s(s(s(zero))))))),
    add1(X, s(zero), s(X)).

test_add1_4 :-
    assert_true( count(test_add1_4_aux, 8) ).
test_add1_4_aux :-
    (X = zero; X = s(zero); X = s(s(zero)); X = s(s(s(zero))); X = s(s(s(s(zero))));
     X = s(s(s(s(s(zero))))); X = s(s(s(s(s(zero))))); X = s(s(s(s(s(s(zero))))))),
    add1(s(X), s(s(zero)), s(s(s(X)))).

test_add1_5 :-
    assert_true( count(test_add1_5_aux, 64) ).
test_add1_5_aux :-
    (X = zero; X = s(zero); X = s(s(zero)); X = s(s(s(zero))); X = s(s(s(s(zero))));
     X = s(s(s(s(s(zero))))); X = s(s(s(s(s(zero))))); X = s(s(s(s(s(s(zero))))))),
    (Y = zero; Y = s(zero); Y = s(s(zero)); Y = s(s(s(zero))); Y = s(s(s(s(zero))));
     Y = s(s(s(s(s(zero))))); Y = s(s(s(s(s(zero))))); Y = s(s(s(s(s(s(zero))))))),
    add1(X, Y, Z),
    add1(Y, X, Z).

test_add1_6 :-
    assert_true( sortall((X, Y), add1(X, Y, s(s(s(zero)))),
                         [(zero, s(s(s(zero)))), (s(zero), s(s(zero))), (s(s(zero)), s(zero)), (s(s(s(zero))), zero)]) ).

test_sub1_1 :-
    assert_true( count(test_sub1_1_aux, 8) ).
test_sub1_1_aux :-
    (X = zero; X = s(zero); X = s(s(zero)); X = s(s(s(zero))); X = s(s(s(s(zero))));
     X = s(s(s(s(s(zero))))); X = s(s(s(s(s(zero))))); X = s(s(s(s(s(s(zero))))))),
    sub1(X, X, zero).

test_sub1_2 :-
    assert_true( count(test_sub1_2_aux, 15) ).
test_sub1_2_aux :-
    (X = zero; X = s(zero); X = s(s(zero))),
    (Y = s(s(s(zero))); Y = s(s(s(s(zero))));
     Y = s(s(s(s(s(zero))))); Y = s(s(s(s(s(zero))))); Y = s(s(s(s(s(s(zero))))))),
    add1(X, Y, Z),
    sub1(Z, Y, X).

test_sub1_3 :-
    assert_true( count(test_sub1_3_aux, 64) ).
test_sub1_3_aux :-
    (X = zero; X = s(zero); X = s(s(zero)); X = s(s(s(zero))); X = s(s(s(s(zero))));
     X = s(s(s(s(s(zero))))); X = s(s(s(s(s(zero))))); X = s(s(s(s(s(s(zero))))))),
    (Y = zero; Y = s(zero); Y = s(s(zero)); Y = s(s(s(zero))); Y = s(s(s(s(zero))));
     Y = s(s(s(s(s(zero))))); Y = s(s(s(s(s(zero))))); Y = s(s(s(s(s(s(zero))))))),
    add1(X, Y, Z),
    sub1(Z, Y, X).

test_prod1_1 :-
    assert_true( prod1(s(s(s(zero))), s(s(s(s(s(zero))))), s(s(s(s(s(s(s(s(s(s(s(s(s(s(s(zero)))))))))))))))) ).

test_prod1_2 :-
    assert_true( count(test_prod1_2_aux, 8) ).
test_prod1_2_aux :-
    (X = zero; X = s(zero); X = s(s(zero)); X = s(s(s(zero))); X = s(s(s(s(zero))));
     X = s(s(s(s(s(zero))))); X = s(s(s(s(s(zero))))); X = s(s(s(s(s(s(zero))))))),
    prod1(zero, X, zero).

test_prod1_3 :-
    assert_true( count(test_prod1_3_aux, 8) ).
test_prod1_3_aux :-
    (X = zero; X = s(zero); X = s(s(zero)); X = s(s(s(zero))); X = s(s(s(s(zero))));
     X = s(s(s(s(s(zero))))); X = s(s(s(s(s(zero))))); X = s(s(s(s(s(s(zero))))))),
    prod1(X, s(s(zero)), Res),
    add1(X, X, Res).

test_prod1_4 :-
    assert_true( count(test_prod1_4_aux, 8) ).
test_prod1_4_aux :-
    (X = zero; X = s(zero); X = s(s(zero)); X = s(s(s(zero))); X = s(s(s(s(zero))));
     X = s(s(s(s(s(zero))))); X = s(s(s(s(s(zero))))); X = s(s(s(s(s(s(zero))))))),
    prod1(X, s(zero), X).

test_prod1_5 :-
    assert_true( count(test_prod1_5_aux, 64) ).
test_prod1_5_aux :-
    (X = zero; X = s(zero); X = s(s(zero)); X = s(s(s(zero))); X = s(s(s(s(zero))));
     X = s(s(s(s(s(zero))))); X = s(s(s(s(s(zero))))); X = s(s(s(s(s(s(zero))))))),
    (Y = zero; Y = s(zero); Y = s(s(zero)); Y = s(s(s(zero))); Y = s(s(s(s(zero))));
     Y = s(s(s(s(s(zero))))); Y = s(s(s(s(s(zero))))); Y = s(s(s(s(s(s(zero))))))),
    prod1(X, Y, Z),
    prod1(Y, X, Z).

test_factorial1_1 :-
    assert_true( factorial1(zero, s(zero)) ).

test_factorial1_2 :-
    assert_true( factorial1(s(s(s(zero))), s(s(s(s(s(s(zero))))))) ).

test_factorial1_3 :-
    assert_true( factorial1(s(s(s(s(zero)))), s(s(s(s(s(s(s(s(s(s(s(s(s(s(s(s(s(s(s(s(s(s(s(s(zero))))))))))))))))))))))))) ).


equivalent(N1, N2) :-
    reverse(N1, RN1),
    reverse(N2, RN2),
    remove_zeroes(RN1, RN11),
    remove_zeroes(RN2, RN22),
    RN11 = RN22.

remove_zeroes([], []).
remove_zeroes([1|Ns], [1|Ns]).
remove_zeroes([0|Ns], Res) :-
    remove_zeroes(Ns, Res).

test_add2_1 :-
    assert_true( (add2([0,1,1,0,1], [1,0,1,1,1,1,1,1,1], Res), equivalent(Res, [1, 1, 0, 0, 1, 0, 0, 0, 0, 1])) ).

test_add2_2 :-
    assert_true( (add2([1,1,1,1,1], [1], Res), equivalent(Res, [0, 0, 0, 0, 0, 1])) ).

test_add2_3 :-
    assert_true( (add2([1,1,0,0,1,1,0,1,0,1,0,1,1,1,1], [1,1,1,0,0,1,1,1,1,0,0,0,0,0,0,1,1,1], Res),
                  equivalent(Res, [0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1])) ).

test_add2_4 :-
    assert_true( (add2([0,0,0,0,1], Y, [0,1,1,0,1,1]),
                  equivalent(Y, YY),
                  YY = [0, 1, 1, 0, 0, 1]) ).

test_add2_5 :-
    assert_true( (add2(X, X, [0,0,1,1,0,0,1]),
                  equivalent(X, XX),
                  XX = [0, 1, 1, 0, 0, 1]) ).

test_sub2_1 :-
    assert_true( (sub2([1,1,0,0,1,1], [1,1,0,0,1,1], Res),
                  equivalent(Res, [])) ).

test_sub2_2 :-
    assert_true( (sub2([0,0,0,0,0,0,1], [1], Res),
                  equivalent(Res, [1,1,1,1,1,1])) ).

test_sub2_3 :-
    assert_true( (sub2([1,1,1,0,1,1,1,0,1], [1,0,0,1,1,1], Res),
                  equivalent(Res, [0, 1, 1, 1, 1, 1, 0, 0, 1])) ).

test_prod2_1 :-
    assert_true( (prod2([1,0,1,1,0,1], [1,1,1,1,1,0,1], Res),
                  equivalent(Res, [1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1])) ).

test_prod2_2 :-
    assert_true( (prod2([1,0,1,1,1,1,1,0,1], [0,0,0,0,0,0,1,1,1,1,1], Res),
                  equivalent( Res, [0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1])) ).

test_prod2_3 :-
    assert_true( (prod2([1,1,0,1,1,1,0,0,0,0,0,1], [1,1,1,1,1,1], Res),
                  equivalent( Res, [1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1])) ).

test_prod2_4 :-
    assert_true( (prod2([1,0,1], [1,0,0,1], Res), equivalent( Res, [1, 0, 1, 1, 0, 1])) ).

test_factorial2_1 :-
    assert_true( (factorial2([1,0,0,1,1,1], Res), reverse(Res, R1), remove_zeroes(R1, R2), length(R2, 255)) ).

test_factorial2_2 :-
    assert_true( (factorial2([1,1], Res), equivalent(Res, [0,1,1])) ).

test_factorial2_3 :-
    assert_true( (factorial2([0,0,1], Res), equivalent(Res, [0,0,0,1,1])) ).

test_factorial2_4 :-
    assert_true( (factorial2([1,0,1], Res), equivalent(Res, [0,0,0,1,1,1,1])) ).

test_factorial3_1 :-
    assert_true( factorial3(0, 1) ).

test_factorial3_2 :-
    assert_true( factorial3(3, 6) ).

test_factorial3_3 :-
    assert_true( factorial3(4, 24) ).

test_factorial3_4 :-
    assert_true( factorial3(5, 120) ).


count(P, N) :-
    findall(_, P, R),
    length(R, N).

/* Outils auxiliaires pour les tests. */

% SortedList donne la liste triee de toutes les solutions de Term dans le but Goal 
sortall(Term, Goal, SortedList) :-
	findall(Term, Goal, List),
	msort(List, SortedList).

% Teste la propriete P et affiche ensuite "OK : P" ou "echec : P"
% (pour un test unitaire, càd un bloc de clauses à vérifier)
test(P) :- P, !, print_resul("OK", P).
test(P) :- print_resul("echec", P), fail.

% Assertions sur une propriété P qui n'affichent quelque chose que si non vérifiées
% (pour une clause au sein d'un test unitaire)
assert_true(P) :- P, !.
assert_true(P) :- print_resul("echec", P), fail.

assert_false(P) :- assert_true(not(P)).

% Affiche un texte suivi du but concerné
print_resul(Msg, Goal) :- write(Msg), write(" : "), writeln(Goal).

% Fin des tests
