open LIST
(* remplacer par votre type *)
type 'a arbin = 
   |Feuille of 'a
   |Noeud of 'a arbin * 'a * 'a arbin

let feuille v = Feuille v
let noeud v g d = Noeud(g, v, d)

let rec compter a = match a with
                     |Feuille v -> 1
                     |Noeud(g, _, d) ->
                        compter g + compter d

(* TEST *)
(* ceci doit retourner 3 *)
let arbre_test = noeud 12 (feuille 5) (noeud 7 (feuille 6) (feuille 8))
let _ = compter arbre_test
(* END TEST *)

let rec to_list a = match a with
                     |Feuille b -> Cons(b, Nil)
                     |Noeud(g, v, d) ->
                        append(to_list g)(Cons(v, to_list d))

(* TEST *)
(* ceci doit retourner Cons(5,Cons( 12,Cons( 6,Cons( 7,Cons( 8,Nil))))) *)
let _ = to_list arbre_test
(* END TEST *)

let rec insere produit arbre = match arbre with
                                 |Feuille _ -> Noeud(Feuille "Nil", produit, Feuille "Nil")
                                 |Noeud(g, v, d) ->
                                    if produit < v then Noeud(insere produit g, v, d)
                                    else Noeud(g, v, insere produit d)
let rec constr l = match l with
                     |Nil -> Feuille "Nil"
                     |Cons(e, r) -> 
                        insere e (constr r)

let l = Cons("celeri",Cons("orge",Cons("mais",Cons("ble",Cons("tomate",Cons( "soja",Cons( "poisson",Nil)))))))
(* TEST *)
(* Ceci doit retourner true *)
let _ = LIST.filter (fun s -> s <> "Nil") (to_list (constr l)) = sort compare l
(* END TEST *)

type coord = int * int
type 'a arbinp = (coord * 'a) arbin
let d = 5
let e = 4

let placer a = 
   let rec aux (x, y) l = match l with
                           |Noeud(g, v, d) ->
                               let (g', x') = aux(x, y + d) g in

let t =
  noeud 'a'
    (feuille 'j')
    (noeud 'b'
       (noeud 'c'
          (noeud 'd' (feuille 'w') (feuille 'k'))
          (feuille 'z'))
       (feuille 'y'))

(* Pour tester *)
let res = placer t

(* TEST *)
(* Ceci doit retourner true *)
let res = (placer t = noeud ((8, 5), 'a')
     (feuille ((4, 10), 'j'))
     (noeud ((32, 10), 'b')
        (noeud ((24, 15), 'c')
           (noeud ((16, 20), 'd') (feuille ((12, 25), 'w')) (feuille ((20, 25), 'k')))
           (feuille ((28, 20), 'z')))
        (feuille ((36, 15), 'y'))))
(* END TEST *)
