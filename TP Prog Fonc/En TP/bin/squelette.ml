(* Donner vos noms et prénoms *)
let prenom1 = "Anh-Dung" and nom1 = "Nguyen"


let prenom2 =  "Valentin" and nom2 =  "Gouraud Chung"

open LIST 
(** Polynomes en forme développée *)

type variable = string
type product  = { var : variable ; exp : int } 
type monomial = product list
type polynome = (float * monomial) list

(* Q1 - 1pt *)
let x2y1 : monomial   = 
  let x = {var = "x"; exp = 2} in
    let y = {var = "y"; exp = 1} in
      Cons(x,Cons(y, Nil)) (* x^2y^1 *) 
let x1 : monomial = 
  let x = {var = "x"; exp = 1} in
    Cons(x, Nil)(* x^1 *) 
let poly : polynome = Cons((2.0, x2y1), Cons((1.0, x1),Nil))(* 2.0 * x^2y^1 + 1.0*x^1 *)

(* Q2 - 1pt *)
let degree (m:monomial) : int = LIST.fold_right (fun prod acc -> prod.exp + acc) m 0

let res = degree x2y1 = 3

(* Q3 - 1pt *)
let rec mult (x: variable) (m: monomial) : monomial =
  match m with
  | Nil -> let x = {var = "x"; exp = 1} in Cons(x, Nil)
  | Cons(h, t) when h.var = "x" -> let y = {var = "x"; exp = h.exp + 1}in Cons(y, t) 
  | Cons(h, t) -> Cons(h, mult x t) 

let res = mult "x" x2y1 = Cons({var="x";exp=3},Cons({var= "y";exp=1},Nil))
let res = mult "x" Nil  = Cons({var="x";exp=1},Nil)


(* Q4 - 1pt *)
let prod (x:variable) (p:polynome) : polynome = LIST.map (fun (coeff, mono) -> (coeff, mult x mono)) p

let res = prod "x" (Cons((2.0,mult "x" (mult "y" Nil)),Cons((1.0,Nil),Nil))) =
            Cons((2.0,mult "x" (mult "x" (mult "y" Nil))),Cons((1.0,(mult "x" Nil)),Nil)) 

(* Q5 - 1pt*)
let is_monomial (m:monomial) : bool = LIST.for_all (fun prod -> prod.exp > 0) m

let res = is_monomial (Cons({var ="x";exp =0},Nil)) = false


(* Q6 - 2pt *)
let rec factor (x:variable) (m:monomial) : monomial option = 
  let rec aux acc = function
                    | [] -> 
                      if acc = [] then None 
                      else Some (List.rev acc) 
                    | h :: t when h.var = x -> 
                      if h.exp > 1 then 
                        aux (h :: acc) ({var = x; exp = h.exp - 1} :: t)
                      else 
                        aux acc t  
                    | h :: t -> aux (h :: acc) t 
  in aux [] m

let res = factor "x" (mult "y" (mult "y" (mult "z" (mult "z" (mult "z" Nil))))) = None
let res = factor "x" (mult "y" (mult "y" (mult "x" (mult "x" (mult "z" (mult "z" (mult "z" Nil))))))) =
            Some (mult "y" (mult "y" (mult "x" (mult "z" (mult "z" (mult "z" Nil))))))


(* Q7 - 2pt *)
let rec factorise (x:variable) (p:polynome) : polynome * polynome = 
  let rec aux acc1 acc2 = function
                          | [] -> (List.rev acc1, List.rev acc2)
                          | (coeff, monom) :: t ->
                            match factor x monom with
                            | None -> aux acc1 ((coeff, monom) :: acc2) t
                            | Some m' -> 
                              let new_coeff = coeff in
                              aux ((new_coeff, m') :: acc1) acc2 t
  in
  aux [] [] p

let res = factorise "x" (Cons((2.0,mult "y" (mult "x" (mult "x" Nil))),
                              Cons((1.0,mult "x" Nil), Cons((4.0,mult "y" Nil),Nil)))) =
            (Cons((2.0,mult "y" (mult "x" Nil)),
                              Cons((1.0,Nil), Nil)) , Cons((4.0,mult "y" Nil),Nil))


(** Polynômes sous forme d'expressions *)
type poly =
  | Const of float
  | Var of variable
  | Add of  poly * poly
  | Mult of poly * poly 

(* Q8 - 1pt *)
let p =  Add (
          Mult (
            Mult (Const 2.0, Var "y"), 
            Mult (Var "x", Var "x") 
          ),
          Mult (Const 1.0, Var "x") 
)

(* Q9 - 2pt *)
let rec eval (value:variable -> float) (p:poly) : float = 
  match p with
  | Const c -> c                          
  | Var v -> value v                      
  | Add (p1, p2) -> eval value p1 +. eval value p2
  | Mult (p1, p2) -> eval value p1 *. eval value p2

let res = eval (fun x -> match x with | "x" -> 2.0 | "y" -> 3.0 | _ -> 0.0) p = 26.0
          

(* Q10 - 1pt *)
let rec exp (p:poly) (n:int) : poly = 
  if n = 1 then p
  else
    Mult (p, exp p (n - 1))

let res =
  let x3 = Mult (Const 2.0,Var "x") in
  exp x3 3 = Mult(x3,Mult(x3, x3))

(* Q11 - 1pt *)
let rec of_monomial (m:monomial) : poly = 
  match m with
  | Nil -> Const 1.0
  | Cons(h, t) -> 
      Mult (of_product h, of_monomial t)
and of_product (p: product) : poly =
  Mult (Const(float_of_int p.exp), Var p.var)

(* Q12 - 1pt *)
let rec of_polynomial (p:polynome) : poly = 
  match p with
  | Nil -> Const 0.0
  | Cons((coeff, monom), tail) ->
      let current_poly = Mult (Const coeff, of_monomial monom) in 
        let remaining_poly = of_polynomial tail in
          Add (current_poly, remaining_poly)

(* Q13 - 1pt *)
let  sadd (p1:poly) (p2:poly) : poly = 
  match (p1, p2) with
  | (Const 0.0, _) -> p2 
  | (_, Const 0.0) -> p1
  | (Const a, Const b) -> Const (a +. b)
  | _ -> Add (p1, p2)

(* Q14 - 1pt *)
let smul (p1:poly) (p2:poly) : poly = 
  match (p1, p2) with
  | (Const 0.0, _) | (_, Const 0.0) -> Const 0.0
  | (Const 1.0, _) -> p2 
  | (_, Const 1.0) -> p1
  | _ -> Mult (p1, p2)
  
(* Q15 - 1pt *)
let rec simplify (p:poly) : poly = 
  match p with
  | Const 0.0 -> Const 0.0
  | Const c -> Const c 
  | Add (p1, p2) ->
    let sp1 = simplify p1 in
    let sp2 = simplify p2 in
    (match (sp1, sp2) with
    | (Const 0.0, _) -> sp2 
    | (_, Const 0.0) -> sp1  
    | _ -> Add (sp1, sp2)) 
| Mult (p1, p2) ->
    let sp1 = simplify p1 in
    let sp2 = simplify p2 in
    (match (sp1, sp2) with
    | (Const 0.0, _) | (_, Const 0.0) -> Const 0.0  
    | (_, Const 1.0) -> sp1  
    | _ -> Mult (sp1, sp2))

let res = simplify (Add (Add (Const 4.0, Const 2.0), Mult(Add(Const 0.0,Var "x"),Const 1.0))) =
            Add(Const 6.0,Var "x")


(* Q16 - 2pt *)
let rec factorise2 (x:variable) (p:poly) : poly * poly = failwith "TODO"
                   
                  
