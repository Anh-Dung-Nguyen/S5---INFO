/* 1.1 */
add1(zero, X, X).
add1(s(X), Y, s(Z)) :- add1(X, Y, Z).

/* 1.2 */
sub1(X, zero, X).
sub1(s(X), s(Y), Z) :- sub1(X, Y, Z).

/* 1.3 */
prod1(zero, X, zero).
prod1(1, X, X).
prod1(s(X), Y, Z) :- prod1(X, Y, W),
		     add1(W, Y, Z).
		     
/* 1.4 */
factorial(0, s(zero)).
factorial(s(X), Y) :- factorial(X, Z),
		      prod1(s(X), Z, Y).
		      
/* 2.1 */
add2(X,Y,Z) :- add2c(X,Y,Z,0).

add2c([],Y,Y,0).
add2c(X,[],X,0).
add2c(X,[],Z,1) :- add2c(X,[1],Z,0).
add2c([],Y,Z,1) :- add2c([1],Y,Z,0).

add2c([X|Xs],[Y|Ys],[Z|Zs],Cin) :- add_bit(X,Y,Cin,Z,Cout),
				   add2c(Xs,Ys,Zs,Cout).

/* 2.2 */
sub2(X,Y,Z) :- add2(Y,Z,X).

/* 2.3 */
