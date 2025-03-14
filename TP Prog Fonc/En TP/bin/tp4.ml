open LIST

let rec split v l = match l with
                    |Nil -> (Nil, Nil) (*Si l est vide*)
                    |Cons(x,r) ->      (*Si l non vide, x est le premier élément et r est la reste*)
                      let (v1,v2) = split v r in (*split r en deux sous listes v1 et v2*)
                                      if (x < v) then (Cons(x,v1), v2)
                                      else (v1, Cons(x, v2))


(* TEST *)
(* doit retourner (Cons(-12,Cons(1,Cons(3,Nil)))), (Cons(12,Cons(27,Cons(7,Cons(8,Cons(6,Cons(12,Cons(42,Nil)))))))) *)
let res1,res2 = split 4 (Cons(12,Cons(27,Cons(-12,Cons(7,Cons(8,Cons(1,Cons(3,Cons(6,Cons(12,Cons(42,Nil)))))))))))
(* END TEST *)

let rec qs l = match l with 
              |Nil -> Nil
              |Cons(x,r) -> 
                let (l1, l2) = split x r in 
                  let sorted_l1 = qs l1 in
                    let sorted_l2 = qs l2 in
                      append sorted_l1(Cons(x, sorted_l2))

(* TEST *)
(* doit retourner (Cons(-12,Cons( 1,Cons( 3,Cons( 4,Cons( 6,Cons( 7,Cons( 8,Cons( 12,Cons( 12,Cons( 27,Cons(42,Nil)))))))))))) *)
let res = qs (Cons(4,Cons( 12,Cons( 27,Cons( -12,Cons( 7,Cons( 8,Cons( 1,Cons( 3,Cons( 6,Cons( 12,Cons(42,Nil))))))))))))
(* END TEST *)

let rec jqastable x f = if (f x) = x then x else jqastable (f x) f

(* TEST *)
(* doit retourner 1 *)
let res = jqastable 13 (fun x -> if (x = 1) then 1 else if (x mod 2 = 1) then 3 * x + 1 else x / 2)
(* END TEST *)

let rec unebulle l = match l with
                    |Nil -> Nil
                    |Cons(x, Nil) -> Cons(x, Nil)
                    |Cons(e1, Cons(e2, r)) -> 
                      if (e1 > e2) then Cons(e2, unebulle(Cons(e1, r))) else Cons(e1, unebulle(Cons(e2, r)))

(* TEST *)
(* doit retourner (Cons(4,Cons( 12,Cons( -12,Cons( 7,Cons( 8,Cons( 1,Cons( 3,Cons( 6,Cons( 27,Cons( 12,Cons(42,Nil)))))))))))) *)
let res = unebulle (Cons(4,Cons( 12,Cons( 27,Cons( -12,Cons( 7,Cons( 8,Cons( 1,Cons( 3,Cons( 6,Cons( 42,Cons(12,Nil))))))))))))
(* END TEST *)

let tribulle l = failwith "à faire"

(* TEST *)
(* doit retourner (Cons(-12,Cons( 1,Cons( 3,Cons( 4,Cons( 6,Cons( 7,Cons( 8,Cons( 12,Cons( 12,Cons( 27,Cons(42,Nil)))))))))))) *)
let res = tribulle (Cons(4,Cons( 12,Cons( 27,Cons( -12,Cons( 7,Cons( 8,Cons( 1,Cons( 3,Cons( 6,Cons( 12,Cons(42,Nil))))))))))))
(* END TEST *)

let rec merge ll = failwith "à faire"

(* TEST *)
(* doit retourner (Cons(1,Cons(2,Cons(3,Cons(5,Nil))))) *)
let res = merge (Cons(Cons(1,Nil),Cons(Cons(2,Cons(3,Nil)),Cons(Cons(5,Nil),Nil))))
(* END TEST *)

let create f k = failwith "à faire"

(* TEST *)
(* doit retourner (Cons(2,Cons(3,Cons(4,Cons(5,Nil))))) *)
let res = create (fun x -> x+1) 4
(* END TEST *)

let rec insert j ll = failwith "à faire"

(* TEST *)
(* doit retourner Cons(Cons(1,Cons(3,Cons(5,Nil))),Cons(Cons(1,Cons(7,Cons(3,Cons(9,Nil))))))),Cons(Cons(1,Nil),Cons(Cons(1,Cons(6,Nil)),Nil)))*)
let res = insert 1 (Cons(Cons(3,Cons(5,Nil)),Cons(Cons(7,Cons(3,Cons(9,Nil))),Cons(Nil,Cons(Cons(6,Nil),Nil)))))
(* END TEST *)

let partition n = failwith "à faire"

(* TEST *)
(* doit retourner une liste contenant (Cons(5,Nil)), (Cons(4,Cons(1,Nil))), Cons(3,Cons(2,Nil)),
   Cons(3,Cons(1,Cons(1,Nil))), Cons(2,Cons(2,Cons(1,Nil)))
   Cons(2,Cons(1,Cons(1,Cons(1,Nil)))), Cons(1,Cons(1,Cons(1,Cons(1,Cons(1,Nil))))) dans un ordre arbitraire *)
let res = partition 5
(* END TEST *)

let rec kieme k l = failwith "à faire"

(* TEST *)
(* doit retourner 8 *)
let res = kieme 7 (Cons(4,Cons( 12,Cons( 27,Cons( -12,Cons( 7,Cons( 8,Cons( 1,Cons( 3,Cons( 6,Cons( 12,Cons( 42,Nil))))))))))))
(* END TEST *)
