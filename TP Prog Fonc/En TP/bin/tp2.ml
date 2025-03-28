(* TP2 *)

(* Compléter *)
let rec pair n = if n = 0 then true else impair (pred n)
and impair n = if n = 0 then false else pair (pred n)

(* TEST *)
let res = pair 12   (* true *)
let res = impair 12 (* false *)
(* END TEST *)

(* Compléter *)
let rec sigma (a,b) = if a > b then 0 else a + sigma(succ a, b)

(* TEST *)
let res = sigma (-2,4) (* 7 *)
(* END TEST *)

(* Compléter *)
let rec sigma2 f (a,b) = if a > b then 0 else f a + sigma2 f (succ a, b)

(* TEST *)
let res = sigma2 (fun x -> 2 * x) (-2,4) (* 14 *)
(* END TEST *)

(* Compléter *)
let rec sigma3 (f,fc) i acc (a,b)  = if a > b then acc else fc (f a) (sigma3 (f,fc) i acc (a + i, b))

(* TEST *)
let res = sigma3 ((fun x -> 2 * x),(fun v acc -> v + acc)) 2 0 (2,6)  (* 24 *)
(* END TEST *)

(* TEST *)
let res = sigma3 ((fun x -> x * x),(fun x acc -> LIST.Cons(x,acc))) 2 LIST.Nil (0,10)  (* Cons(0,Cons(4,Cons(16,Cons(36,Cons(64,Cons(100,Nil)))))) *)
(* END TEST *)

(* Compléter *)
let rec sigma4 (f,fc) (p,fi) acc a  = if p a then acc else fc (f a) (sigma4 (f, fc) (p,fi) acc (fi a))

(* TEST *)
let res = sigma4 ((fun x -> 2 * x),(fun v acc -> v + acc)) ((fun v -> v > 6),(fun v -> v + 2)) 0 2 (* 24 *)
(* END TEST *)

(* Compléter *)
let cum f (a,b) dx = sigma4 ((f, fun a b -> a +.b)) ((fun a -> a > b), fun v -> v +.dx) 0. a

(* TEST *)
let res = cum (fun x -> 2. *. x) (0.2,0.7) 0.2 (* 2.4 *)
(* END TEST *)

(* Compléter *)
let integre f (a,b,dx) = failwith "à faire"

(* TEST *)
let res = integre (fun x -> 1. /. x) (1., 2., 0.001) (* 0.693897243059959257 *)
(* END TEST *)

(* Compléter *)
let rec maxi f (a,b) p = failwith "à faire"

(* TEST *)
let res = maxi (fun x -> 1. -. x *. x) (0.,2.) 0.0001 (* 1. *)
(* END TEST *)
