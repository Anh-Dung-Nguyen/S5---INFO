(* TP1. Mettez vos noms ici. *)

(* Compléter, en enlevant le "failwith" et tout ce qui suit et en mettant votre code.
   Évaluer en sélectionnant puis shift-enter *)
let mul2 n = n * 2

(* Tester, en tapant shift-enter et en sélectionnant la phrase suivante *)
(* La valeur attendue est indiquée en commentaire *)
(* TEST *)
let _ = mul2 21 (* 42 *)
(* END TEST *)

(* Compléter *)
let vabs n = if n < 0 then -n
             else n

(* TEST *)
let _ = vabs (-5) (* 5 *)
let _ = vabs 12 (* 12 *)
(* END TEST *)

(* Compléter *)
let test1 n = if n >= 12 && n <= 29 then true
              else false

(* TEST *)
let _ = test1 25 (* true *)
let _ = test1 (-8) (* false *)
(* END TEST *)

(* Compléter *)
let test2 n = if n = 2 || n = 5 || n = 9 || n = 53 then true
              else false

(* TEST *)
let _ = test2 5 (* true *)
let _ = test2 6 (* false *)
(* END TEST *)

(* Compléter *)
let test3 p = match p with
               |(12,_) -> true
               |(_,_) -> false

(* TEST *)
let _ = test3 (12,"foo") (* true *)
let _ = test3 (12,42) (* true *)
let _ = test3 (13,true) (* false *)
(* END TEST *)

(* Compléter *)
let bissext y = if (y mod 400 = 0 || y mod 4 = 0) && (y mod 400 = 0 || y mod 100 != 0) then true 
                  else false
(* TEST *)
let _ = bissext 2000 (* true *)
let _ = bissext 1900 (* false *)
let _ = bissext 2016 (* true *)
let _ = bissext 2017 (* false *)
(* END TEST *)

(* Compléter *)
let proj1 t = match t with
               |(a,_,_) -> a
let proj23 t = match t with
               |(_, b, c) -> (b, c)

(* TEST *)
let _ = proj1 (1,"foo",true) (* 1 *)
let _ = proj23 (1,"foo",true) (* ("foo",true) *)
(* END TEST *)

(* Compléter *)
let inv2 arg = match arg with
               |((_, _), (c, d)) -> (d, c)

(* TEST *)
let _ = inv2 ((true,'a'),(1,"un")) (* ("un",1) *)
(* END TEST *)

(* Compléter *)
let incrpaire p = match p with
                  |(a, b) -> (a + 1, b + 1)

(* TEST *)
let _ = incrpaire (12,42) (* (13,43) *)
(* END TEST *)

(* Compléter *)
let appliquepaire f p = match p with
                        |(a, b) -> (f a, f b)

(* TEST *)
let _ = appliquepaire (fun x -> not x) (false,true) (* (true,false) *)
(* END TEST *)

(* Compléter *)
let incrpaire2 x = appliquepaire(fun p -> p + 1) x

(* TEST *)
let _ = incrpaire2 (4,18) (* (5,19) *)
(* END TEST *)

(* Compléter *)
let rapport (f,g) x = (f x)/.(g x)

(* TEST *)
let _ = rapport ((fun x -> x +. 1.), (fun x -> x -. 1.)) 2. (* 3. *)
(* END TEST *)

(* Compléter *)
let mytan x = rapport(sin, cos)x

(* TEST *)
let _ = mytan 0. (* 0. *)
(* END TEST *)

(* Compléter *)
let premier n = 
   let rec aux d = 
      d * d > n || (n mod d <> 0 && aux(d + 1))
   in
   n > 1 && aux 2
                

(* TEST *)
let _ = premier 1 (* false *)
let _ = premier 2 (* true *)
let _ = premier 6 (* false *)
let _ = premier 13 (* true *)
(* END TEST *)

(* Compléter *)
let n_premier n = 
   let rec est_premier x =
      let rec aux d =
        d * d > x || (x mod d <> 0 && aux (d + 1))
      in
      x > 1 && aux 2
    in
    let rec trouve_premiers count p current =
      if count = n then current
      else if est_premier p then trouve_premiers (count + 1) (p + 1) p
      else trouve_premiers count (p + 1) current
    in
    trouve_premiers 0 2 0

(* TEST *)
let _ = n_premier 10 (* 29 *)
(* END TEST *)
