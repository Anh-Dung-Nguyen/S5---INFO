open LIST

let rec split v l = match l with
                    |Nil -> (Nil, Nil)
                    |Cons(p, r) ->
                      let (v1, v2) = split v r in 
                                      if p < v then (Cons(p, v1), v2)
                                      else (v1, Cons(p, v2))

(* TEST *)
(* doit retourner (Cons(-12,Cons(1,Cons(3,Nil)))), (Cons(12,Cons(27,Cons(7,Cons(8,Cons(6,Cons(12,Cons(42,Nil)))))))) *)
let res1,res2 = split 4 (Cons(12,Cons(27,Cons(-12,Cons(7,Cons(8,Cons(1,Cons(3,Cons(6,Cons(12,Cons(42,Nil)))))))))))
(* END TEST *)

let rec qs l = match l with
                |Nil -> Nil
                |Cons(p, r) ->
                  let (l1, l2) = split p r in
                    let sorted_l1 = qs l1 in
                      let sorted_l2 = qs l2 in
                        append sorted_l1(Cons(p, sorted_l2))

(* TEST *)
(* doit retourner (Cons(-12,Cons( 1,Cons( 3,Cons( 4,Cons( 6,Cons( 7,Cons( 8,Cons( 12,Cons( 12,Cons( 27,Cons(42,Nil)))))))))))) *)
let res = qs (Cons(4,Cons( 12,Cons( 27,Cons( -12,Cons( 7,Cons( 8,Cons( 1,Cons( 3,Cons( 6,Cons( 12,Cons(42,Nil))))))))))))
(* END TEST *)

let rec jqastable x f = if f x = x then x
                        else jqastable (f x) f

(* TEST *)
(* doit retourner 1 *)
let res = jqastable 13 (fun x -> if (x = 1) then 1 else if (x mod 2 = 1) then 3 * x + 1 else x / 2)
(* END TEST *)

let rec unebulle l = match l with
                      |Nil -> Nil
                      |Cons(x, Nil) -> Cons(x, Nil)
                      |Cons(p1, Cons(p2, r)) ->
                        if p1 < p2 then Cons(p1, unebulle(Cons(p2, r)))
                        else Cons(p2, unebulle(Cons(p1, r)))

(* TEST *)
(* doit retourner (Cons(4,Cons( 12,Cons( -12,Cons( 7,Cons( 8,Cons( 1,Cons( 3,Cons( 6,Cons( 27,Cons( 12,Cons(42,Nil)))))))))))) *)
let res = unebulle (Cons(4,Cons( 12,Cons( 27,Cons( -12,Cons( 7,Cons( 8,Cons( 1,Cons( 3,Cons( 6,Cons( 42,Cons(12,Nil))))))))))))
(* END TEST *)

let tribulle l = jqastable l unebulle

(* TEST *)
(* doit retourner (Cons(-12,Cons( 1,Cons( 3,Cons( 4,Cons( 6,Cons( 7,Cons( 8,Cons( 12,Cons( 12,Cons( 27,Cons(42,Nil)))))))))))) *)
let res = tribulle (Cons(4,Cons( 12,Cons( 27,Cons( -12,Cons( 7,Cons( 8,Cons( 1,Cons( 3,Cons( 6,Cons( 12,Cons(42,Nil))))))))))))
(* END TEST *)

let rec merge ll = match ll with
                    |Nil -> Nil
                    |Cons(p, r) -> append p (merge r)

(* TEST *)
(* doit retourner (Cons(1,Cons(2,Cons(3,Cons(5,Nil))))) *)
let res = merge (Cons(Cons(1,Nil),Cons(Cons(2,Cons(3,Nil)),Cons(Cons(5,Nil),Nil))))
(* END TEST *)

let rec create f k = if k = 1 then f 1
                  else append (create f (k - 1))(f k)

(* TEST *)
(* doit retourner (Cons(2,Cons(3,Cons(4,Cons(5,Nil))))) *)
let res = create (fun x -> x + 1) 4
(* END TEST *)

let rec insert j ll = match ll with
                      |Nil -> Cons(j, Nil)
                      |Cons(p, r) -> Cons(j, Cons(p, insert j r))

(* TEST *)
(* doit retourner Cons(Cons(1,Cons(3,Cons(5,Nil))),Cons(Cons(1,Cons(7,Cons(3,Cons(9,Nil))))))),Cons(Cons(1,Nil),Cons(Cons(1,Cons(6,Nil)),Nil)))*)
let res = insert 1 (Cons(Cons(3,Cons(5,Nil)),Cons(Cons(7,Cons(3,Cons(9,Nil))),Cons(Nil,Cons(Cons(6,Nil),Nil)))))
(* END TEST *)

let partition n = let rec partition_faible m k =
                    match (m,k) with
                    | (0,0)-> [[]]
                    | (_,0) -> []
                    | (a,b) -> begin if b > a then partition_faible a a
                                      else merge (create (fun c -> insert c (partition_faible (a-c) c))b) end 
                    in partition_faible n n

(* TEST *)
(* doit retourner une liste contenant (Cons(5,Nil)), (Cons(4,Cons(1,Nil))), Cons(3,Cons(2,Nil)),
   Cons(3,Cons(1,Cons(1,Nil))), Cons(2,Cons(2,Cons(1,Nil)))
   Cons(2,Cons(1,Cons(1,Cons(1,Nil)))), Cons(1,Cons(1,Cons(1,Cons(1,Cons(1,Nil))))) dans un ordre arbitraire *)
let res = partition 5
(* END TEST *)

let rec kieme k l = List.nth (qs l) k

(* TEST *)
(* doit retourner 8 *)
let res = kieme 7 (Cons(4,Cons( 12,Cons( 27,Cons( -12,Cons( 7,Cons( 8,Cons( 1,Cons( 3,Cons( 6,Cons( 12,Cons( 42,Nil))))))))))))
(* END TEST *)
