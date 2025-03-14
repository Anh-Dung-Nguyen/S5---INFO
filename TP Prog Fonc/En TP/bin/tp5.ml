open LIST

let rec appartient e l = match l with
                    |Nil -> false
                    |Cons(e1, t1) ->
                      if e1 = e then true
                      else appartient e t1

(* TEST *)
(* Ceci doit retourner false *)
let res = appartient 4 (Cons(1,Cons(2,Cons(3,Nil))))
(* END TEST *)

let rec concatl l1 l2 = match l1, l2 with
                    |Nil, l2 -> l2
                    |l1, Nil -> l1
                    |(Cons(e1, t1)), l2 ->
                      Cons(e1, concatl t1 l2)

(* TEST *)
(* Ceci doit retourner (Cons(1,Cons(2,Cons(3,Cons(4,Cons(5,Cons(6,Nil))))))) *)
let res = concatl (Cons(1,Cons(2,Cons(3,Nil)))) (Cons(4,Cons(5,Cons(6,Nil))))
(* END TEST *)

let rec debliste l n = if n > 0 then 
                          match l with
                            |Nil -> Nil
                            |Cons(e1, t1) -> Cons(e1, debliste t1 (n-1))
                       else Nil

(* TEST *)
(* Ceci doit retourner (Cons(1,Cons( 2,Cons(3,Nil)))) *)
let res = debliste (Cons(1,Cons(2,Cons(3,Cons(4,Cons(5,Cons(6,Cons(7,Nil)))))))) 3
(* END TEST *)

let rec remplace x y l = match l with
                    |Nil -> Nil
                    |Cons(e1, t1) -> 
                      if e1 = x then Cons(y, remplace x y t1) 
                      else Cons(e1, remplace x y t1)

(* TEST *)
(* Ceci doit retourner Cons(1,Cons( 42,Cons( 3,Cons( 42,Cons(5,Nil))))) *)
let res = remplace 2 42 (Cons(1,Cons(2,Cons(3,Cons(2,Cons(5,Nil))))))
(* END TEST *)

let rec rang_opt e l = match l with
                    |Nil -> None
                    |Cons(x, _) when x = e -> Some 0
                    |Cons(x, r) ->
                      match rang_opt e r with
                        |None -> None
                        |Some i -> Some (i + 1)

(* TEST *)
(* Ceci doit retourner Some 1 *)
let res = rang_opt 2 (Cons(3,Cons(2,Cons(1,Nil))))
(* Ceci doit retourner None *)
let res = rang_opt 0 (Cons(3,Cons(2,Cons(1,Nil))))
(* END TEST *)

type 'a nemptyl = Elt of 'a | Add of 'a * 'a nemptyl
let of_list l = 

(* TEST *)
(* Ceci doit retourner None *)
let res = of_list Nil
(* Ceci doit retourner Some(Add(3,Add(2,(Elt 1)))) *)
let res = of_list (Cons(3,Cons(2,Cons(1,Nil))))
(* END TEST *)

let to_list l = failwith "à faire"
(* TEST *)
(* Ceci doit retourner Cons(1,Cons(0,Nil)) *)
let res = to_list (Add(1,Elt 0))
(* END TEST *)

let entete l l1 = failwith "à faire"

(* TEST *)
(* Ceci doit retourner true *)
let res = entete (Cons(1,Cons(2,Cons(3,Nil)))) (Cons(1,Cons(2,Cons(3,Cons(2,Cons(5,Nil))))))
(* END TEST *)

let sousliste l l1 = failwith "à faire"

(* TEST *)
(* Ceci doit retourner true *)
let res = sousliste (Cons(2,Cons(3,Cons(2,Nil)))) (Cons(1,Cons(2,Cons(3,Cons(2,Cons(5,Nil))))))
(* END TEST *)

let oter l l1 = failwith "à faire"

(* TEST *)
(* Ceci doit retourner (Cons(2,Cons( 5,Nil))) *)
  let res = oter (Cons(1,Cons(2,Cons(3,Nil)))) (Cons(1,Cons(2,Cons(3,Cons(2,Cons(5,Nil))))))
(* END TEST *)

let all_pairs l1 l2 = failwith "à faire"

(* TEST *)
(* Ceci doit retourner
Cons ((1, 3),Cons ((1, 4), Cons ((1, 5), Cons ((2, 3), Cons ((2, 4), Cons ((2, 5), Nil)))))) *)
     let res = all_pairs (Cons(1,Cons(2,Nil))) (Cons(3,Cons(4,Cons(5,Nil))))
(* END TEST *)

let insert ki e l = failwith "à faire"

(* TEST *)
(* Ceci doit retourner Cons ((true, Cons (5, Cons (3, Cons (1, Nil)))),  Cons ((false, Cons (4, Cons (2, Nil))), Nil)) *)
let res = insert true 5 (Cons((true, Cons(3,Cons(1,Nil)))),Cons((false, Cons(4,Cons(2,Nil)))))
(* Ceci doit retourner Cons ((true, Cons (3, Cons (1, Nil))), Cons ((false, Cons (2, Nil)), Nil)) *)
let res = insert false 2 (Cons((true, Cons(3,Cons(1,Nil)))))
(* END TEST *)

let group_by f l = failwith "à faire"

(* TEST *)
(* Ceci doit retourner Cons ((1, Cons ((1, 2), Cons ((1, 4), Nil))),Cons ((3, Cons ((3, 5), Nil)), Nil))  *)
let res = group_by fst (Cons((1,2) ,Cons( (3,5) ,Cons( (1,4),Nil))))
(* END TEST *)
