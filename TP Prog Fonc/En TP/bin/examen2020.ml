(* Examen Ocaml 2020 *)
(* Nom:              *)
(* Prénom:           *)
open LIST

(** {Nombre en représentation binaire} **)

(* Q1 *)

type bit = B0 |B1 (* remplacer unit par votre définition *)

type bint = bit list

(* Q2  *)

let int_of_bit b = match b with
                    | B0 -> 0
                    | B1 -> 1

let _ = int_of_bit B0 = 0 && int_of_bit B1 = 1;;

(* Q3 *)
let int_of_bint l = LIST.fold_right(fun b acc -> int_of_bit b + 2 * acc) l 0

let _ = int_of_bint (Cons(B1,Nil)) = 1 && int_of_bint (Cons(B1,Cons(B0,Cons(B1,Nil)))) = 5;;

(* Q4 *)

let rec count_zeros l = match l with
                        | Nil -> 0
                        | Cons(B0, r) -> 1 + count_zeros r
                        | Cons(B1,_) -> 0

let _ = count_zeros (Cons(B0,Cons(B0,Cons(B0,Cons(B1,Cons(B0,Cons(B1,Nil))))))) = 3;;

(* Q5 *)

let rec count_and_remove l = match l with
                              | Nil -> (Nil, 0)
                              | Cons(B0, r) -> 
                                  let (l1, n) = count_and_remove r in (l1, n + 1)
                              | Cons(B1,_) -> (l, 0)

let _ = count_and_remove (Cons(B0,Cons(B0,Cons(B0,Cons(B1,Cons(B0,Cons(B1,Nil))))))) = (Cons(B1,Cons(B0,Cons(B1,Nil))), 3);;

(* Q6 *)

let normalise l = let (l1, _) = count_and_remove (LIST.rev l) in LIST.rev l1


let _ =
  let n1 = normalise (Cons(B0,Cons(B1,Cons(B1,Nil)))) in
  let n2 = normalise (Cons(B0,Cons(B1,Cons(B1,Cons(B0,Nil))))) in
  let n3 = normalise (Cons(B0,Cons(B1,Cons(B1,Cons(B0,Cons(B0,Nil)))))) in
  n1 = n2 && n2 = n3 && n3 = (Cons(B0,Cons(B1,Cons(B1,Nil))));;


(** {Bibliothèque d'ensembles} *)
let cmp_int = fun i j -> if i = j then Eq else if i < j then Lt else Gt;;

(* Q7 *)

let rec is_sorted cmp l = match l with
                          | Nil -> true
                          | Cons(_, Nil) -> true
                          | Cons(x, Cons(y, r)) -> 
                              (cmp x y = Lt || cmp x y = Eq) && 
                              is_sorted cmp(Cons(y, r))

let _ = (is_sorted cmp_int (Cons(1,Cons(5,Cons(7,Nil)))) && not (is_sorted cmp_int (Cons(1,Cons(7,Cons(5,Nil))))))

(** Q8 *)

let rec add_elt cmp e l = match l with
                          | Nil -> Cons(e, Nil)
                          | Cons(l1, _) when cmp e l1 = Eq -> l
                          | Cons(l1, _) when cmp e l1 = Lt -> Cons(e, l)
                          | Cons(l1, r) -> Cons(l1, add_elt cmp e r)


let _ = add_elt cmp_int 6 (Cons(1,Cons(5,Cons(7,Nil)))) = Cons(1,Cons(5,Cons(6,Cons(7,Nil))));;

(* Q9 *)

let rec union cmp l1 l2 = match (l1, l2) with
                          | (Nil, Nil) -> Nil
                          | (l1, Nil) -> l1
                          | (Nil, l2) -> l2
                          | (Cons(x, r1), Cons(y, r2)) when cmp x y = Eq -> union cmp r1 l2
                          | (Cons(x, r1), Cons(y, r2)) when cmp x y = Lt -> Cons(x, union cmp r1 l2)
                          | (Cons(x, r1), Cons(y, r2)) -> Cons(y, union cmp l1 r2)


let _ = union cmp_int (Cons(1,Cons(5,Cons(7,Nil)))) (Cons(2,Cons(5,Cons(6,Nil)))) =
        Cons(1,Cons(2,Cons(5,Cons(6,Cons(7,Nil)))))


(** {Représentation d'ensembles d'entiers} *)

type intset = Empty | Node of intset * bool * intset;;

(* Soit la liste d'entiers binaires l qui représente l'ensemble {0;2;3;4;7}. *)
let l =
  let zero  = Nil in
  let two   = Cons(B0,Cons(B1,Nil)) in
  let three = Cons(B1,Cons(B1,Nil)) in
  let four  = Cons(B0,Cons(B0,Cons(B1,Nil))) in
  let seven = Cons(B1,Cons(B1,Cons(B1,Nil))) in
  Cons(zero , Cons(two , Cons(three,Cons(four, Cons(seven,Nil)))))

(* L'arbre a reprśente la liste l sous forme de intset *)
let a = Node
          (Node (Node (Empty, false, Node (Empty, true, Empty)), false,
                 Node (Empty, true, Empty)),
           true, Node (Empty, false, Node (Empty, true, Node (Empty, true, Empty))))

(* Q10 *)

let rec cardinal s = match s with
                      | Empty -> 0
                      | Node(left, b, right) -> 
                          (if b then 1 else 0) + cardinal left + cardinal right

let _ = cardinal Empty = 0 && cardinal a = 5

(* Q11 *)

let rec mem s x = match s, x with
                  | (Empty, _) -> false
                  | (Node(_, true, _), Nil) -> true
                  | (Node(left, _, _), Cons(B0, r)) -> mem left r
                  | (Node(_, _, right), Cons(B1, r)) -> mem right r
                  | _ -> false

let _ = mem a Nil && mem a (Cons(B0,Cons(B0,Cons(B1,Nil)))) && not (mem a (Cons(B1,Nil)));;

(* Q12 *)

let rec singleton l = match l with
                      | Nil -> Node(Empty, true, Empty)
                      | Cons(B0, r) -> 
                          Node(singleton r, false, Empty)
                      | Cons(B1, r) -> Node(Empty, false, singleton r)

let _ = singleton (Cons(B0,Cons(B1,Nil))) = Node (Node (Empty, false, Node (Empty, true, Empty)), false, Empty);;

(* Q13 *)

let rec add_elt i s = failwith "TODO"


let a1 = Node
 (Node (Node (Empty, false, Node (Empty, true, Empty)), false,
   Node (Empty, true, Node (Empty, true, Empty))),
 true, Node (Empty, false, Node (Empty, true, Node (Empty, true, Empty))));;

let _ = add_elt (Cons(B1,Cons(B1,Nil))) a = a &&  add_elt (Cons(B0,Cons(B1,Cons(B1,Nil)))) a = a1;;


(* Q14 *)

let rec remove_elt i s = failwith "TODO"

let _ = remove_elt Nil Empty = Empty &&
          remove_elt (Cons(B1,Cons(B1,Cons(B1,Nil)))) Empty = Empty &&
            remove_elt Nil a  = Node
          (Node (Node (Empty, false, Node (Empty, true, Empty)), false,
                 Node (Empty, true, Empty)),
           false, Node (Empty, false, Node (Empty, true, Node (Empty, true, Empty)))) &&
              remove_elt (Cons(B1,Cons(B1,Cons(B1,Nil)))) a = 
                Node
                  (Node (Node (Empty, false, Node (Empty, true, Empty)), false,
                         Node (Empty, true, Empty)),
                   true, Node (Empty, false, Node (Empty, true, Node (Empty, false, Empty))))

(* Q15 *)

let rec is_empty s = failwith "TODO"

let _ = is_empty Empty = true  &&
        is_empty (Node(Empty, false, Empty)) = true &&
          is_empty (Node(Empty, true, Empty)) = false &&
            is_empty a = false;;

(* Q16 *)


let rec minimise s = failwith "TODO"

let _ = minimise Empty = Empty &&
          minimise (Node(Empty,false,Empty)) = Empty &&
            minimise
              (Node
                 (Node (Node (Empty, false, Node (Empty, false, Empty)), false,
                     Node (Empty, false, Empty)),
                  false, Node (Empty, false, Node (Empty, true, Node (Empty, false, Empty))))) =
              Node (Empty, false, Node (Empty, false, Node (Empty, true, Empty)));;

(* Q17 *)

let rec union s1 s2 = failwith "TODO"

let u1 =
  Node (Node (Empty, false, Node (Empty, true, Empty)), true,
               Node (Empty, false, Node (Empty, false, Node (Empty, true, Empty))));;
let u2 = 
  Node (Node (Node (Empty, false, Node (Empty, true, Empty)), false, Empty),
        false, Node (Empty, false, Node (Empty, true, Node (Empty, true, Empty))));;

let _ = union u1 Empty = u1 && union Empty u2 = u2 && union u1 u2 = a;;


(* Q18 *)

let div2 s = failwith "TODO"

let _ =
  div2 Empty = Empty
  && div2 (Node(Empty, true, Empty)) = Empty
  && div2 (Node(Node(Empty, true, Empty),false,Empty)) = Node(Empty, true, Empty)
  && div2 (Node(Empty,false,Node(Empty, true, Empty))) = Node(Empty, true, Empty)
  && div2 a = Node (Node (Empty, false, Node (Empty, true, Empty)), false,
   Node (Empty, true, Node (Empty, true, Empty)));;

(* Q19 *)

let rec elements s = failwith "TODO"
    
let _ =
  elements Empty = Nil &&
  elements (Node(Empty, true, Empty)) = Cons(Nil,Nil)  &&
    elements (Node (Node(Empty,true, Empty), false, Empty)) = Cons(Cons(B0,Nil),Nil)  &&
      elements (Node(Empty, false, (Node(Empty, true, Empty)))) = Cons(Cons(B1,Nil),Nil)  &&
        LIST.sort compare (elements a) = LIST.sort compare l;;




