(* TP1. Nguyen Anh Dung. *)

(* Compléter, en enlevant le "failwith" et tout ce qui suit et en mettant votre code.
   Évaluer en sélectionnant puis shift-enter *)
let mul2 = fun n -> n * 2

(* Tester, en tapant shift-enter et en sélectionnant la phrase suivante *)
(* La valeur attendue est indiquée en commentaire *)
(* TEST *)
let _ = mul2 21

(* 42 *)
(* END TEST *)

(* Compléter *)
let vabs = fun n -> if n > 0 then n else (-n)

(* TEST *)
let _ = vabs (-5) (* 5 *)
let _ = vabs 12

(* 12 *)
(* END TEST *)

(* Compléter *)
let test1 = fun n -> if n >= 12 && n <=29 then true else false

(* TEST *)
let _ = test1 25 (* true *)
let _ = test1 (-8)

(* false *)
(* END TEST *)

(* Compléter *)
let test2 = fun n -> if n = 2 || n = 5 || n = 9 || n = 53 then true else false

(* 
let test2 n = match n with
                  |2 -> true
                  |5 -> true
                  |9 -> true
                  |53 -> true
                  |_ -> false
*)

(* TEST *)
let _ = test2 5 (* true *)
let _ = test2 6

(* false *)
(* END TEST *)

(* Compléter *)
let test3 = fun n -> if fst n = 12 then true else false

(* 
let test3 p = match p with
                  |(12,_) -> true
                  |(_,_) -> false
*)

(* TEST *)
let _ = test3 (12, "foo") (* true *)
let _ = test3 (12, 42) (* true *)
let _ = test3 (13, true)

(* false *)
(* END TEST *)

(* Compléter *)
let bissext y = if y mod 400 = 0 || (y mod 100 != 0 && y mod 4 = 0) then true else false

(* TEST *)
let _ = bissext 2000 (* true *)
let _ = bissext 1900 (* false *)
let _ = bissext 2016 (* true *)
let _ = bissext 2017

(* false *)
(* END TEST *)

(* Compléter *)
let proj1 (a, b, c) = a
let proj23 (a, b, c) = (b, c)

(*
let proj1 (a, b, c) = fst(a, (b, c))
let proj23 (a, b, c) = snd(a, (b, c))
*)

(* TEST *)
let _ = proj1 (1, "foo", true) (* 1 *)
let _ = proj23 (1, "foo", true)

(* ("foo",true) *)
(* END TEST *)

(* Compléter *)
let inv2 ((a, b), (c, d)) = (d, c)

(* TEST *)
let _ = inv2 ((true, 'a'), (1, "un"))

(* ("un",1) *)
(* END TEST *)

(* Compléter *)
let incrpaire (a, b) = (a + 1, b + 1)

(* TEST *)
let _ = incrpaire (12, 42)

(* (13,43) *)
(* END TEST *)

(* Compléter *)
let appliquepaire f (x, y) = (f(x), f(y))

(* TEST *)
let _ = appliquepaire (fun x -> not x) (false, true)

(* (true,false) *)
(* END TEST *)

(* Compléter *)
let incrpaire2 p = appliquepaire (fun x -> x + 1) p

(* TEST *)
let _ = incrpaire2 (4, 18)

(* (5,19) *)
(* END TEST *)

(* Compléter *)
let rapport (f, g) x = f x /. g x

(* TEST *)
let _ = rapport ((fun x -> x +. 1.), fun x -> x -. 1.) 2.

(* 3. *)
(* END TEST *)

(* Compléter *)
let mytan x = rapport(sin, cos) x

(* TEST *)
let _ = mytan 0.

(* 0. *)
(* END TEST *)

(* Compléter *)
let premier n = 

(* TEST *)
let _ = premier 1 (* false *)
let _ = premier 2 (* true *)
let _ = premier 6 (* false *)
let _ = premier 13

(* true *)
(* END TEST *)

(* Compléter *)
let n_premier n = failwith "optionnel"

(* TEST *)
let _ = n_premier 10
(* 29 *)
(* END TEST *)
