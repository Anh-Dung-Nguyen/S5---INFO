open LIST

type coul = Coeur | Trefle | Pique | Carreau
type haut = Sept | Huit | Neuf | Dix | Valet | Dame | Roi | As
type carte = {h: haut; c: coul}

let coul c = c.c
let haut c = c.h
(*
let coul c = match c with
|{c = a; h = _} -> a
*)
(*
let haut c = match c with
|{c = _; h = b} -> b*)

let haut_of_int i = match i with
| 7 -> Sept
| 8 -> Huit
| 9 -> Neuf
| 10 -> Dix
| 11 -> Valet
| 12 -> Dame
| 13 -> Roi
| 14 -> As
| _ -> failwith "Error: votre numéro n'existe pas"

(* TEST *)
(* doit retourner Dame *)
let _ = haut_of_int 12
(* END TEST *)

let coul_of_string s = match s with
| "Coeur" -> Coeur
| "Trefle" -> Trefle
| "Pique" -> Pique
| "Carreau" -> Carreau
| _ -> failwith "Error: votre couleur n'existe pas"

(* TEST *)
(* doit retourner Pique *)
let _ = coul_of_string "Pique"
(* END TEST *)

let carte i s = {c = coul_of_string s; h = haut_of_int i}
(* TEST *)
(* ces tests doivent retourner true *)
let _ = (haut (carte 8 "Trefle")) = Huit
let _ = (coul (carte 14 "Trefle")) = Trefle
(* END TEST *)

let string_of_carte c = begin match c.h with
| Sept -> "7"
| Huit -> "8"
| Neuf -> "9"
| Dix -> "10"
| Valet -> "Valet"
| Dame -> "Dame"
| Roi -> "Roi"
| As -> "As" end
^ " de " ^
begin match c.c with
| Coeur -> "Coeur"
| Trefle -> "Trefle"
| Pique -> "Pique"
| Carreau -> "Carreau" end


(* TEST *)
(* ceci doit retourner la chaîne "Valet de Pique" *)
let res = string_of_carte (carte 11 "Pique")

(* ceci doit retourner la chaîne "9 de Trefle" *)
let res = string_of_carte (carte 9 "Trefle")
(* END TEST *)

let random_carte () = {c = (let x = Random.int(3) in match x with
																		| 0 -> Coeur
																		| 1 -> Trefle
																		| 2 -> Pique
																		| 3 -> Carreau
																		| _ -> failwith "Error");
											h = haut_of_int(Random.int(7) + 7)}

let _ = random_carte()
let rec ajtcarte l = 

(* TEST *)
(* ceci doit retourner true *)
let res =
  let l1 = ajtcarte Nil in
  let l2 = ajtcarte l1 in
  match l1,l2 with
  | Cons(c,Nil),Cons(c1,Cons(c2,Nil)) -> c = c2 && c1 <> c2
  | _ -> false
(* END TEST *)

let rec faitjeu n = if n = 0 then Nil else ajtcarte(faitjeu(n - 1))

let rec reduc l = failwith "à faire"

let p1 = Cons(carte 14 "Trefle",Cons(carte 10 "Coeur",Nil))
let p2 = Cons(carte 7 "Pique",Cons(carte 11 "Carreau",Nil))
let p3 = Cons(carte 14 "Carreau",Cons(carte 8 "Pique",Nil))
let p4 = Cons(carte 7 "Carreau", Cons(carte 10 "Trefle",Nil))

let p'1 = append p2 p1

(* TEST *)
(* ceci doit retourner true *)
let _ = (reduc (Cons(p1,Cons(p2,Cons(p3,Cons(p4,Nil)))))) = (Cons(p'1,Cons(p3,Cons(p4,Nil))))
(* END TEST *)

let rec reussite l = failwith "à faire"

let p''1 = append p3 p'1
(* TEST *)
(* ceci doit retourner true *)
let res = (reussite (Cons(p1,Cons(p2,Cons(p3,Cons(p4,Nil))))) = Cons(p''1,Cons(p4,Nil)))
(* END TEST *)

open Graphics

let b = white
let n = black
let r = red

let carr   = [| [|b;b;b;b;b;r;b;b;b;b;b|];
		[|b;b;b;b;r;r;r;b;b;b;b|];
		[|b;b;b;r;r;r;r;r;b;b;b|];
		[|b;b;r;r;r;r;r;r;r;b;b|];
		[|b;r;r;r;r;r;r;r;r;r;b|];
		[|b;b;r;r;r;r;r;r;r;b;b|];
		[|b;b;b;r;r;r;r;r;b;b;b|];
		[|b;b;b;b;r;r;r;b;b;b;b|];
		[|b;b;b;b;b;r;b;b;b;b;b|] |]

let tref   = [| [|b;b;b;b;b;n;n;b;b;b;b|];
		[|b;b;b;b;n;n;n;n;b;b;b|];
		[|b;b;b;b;n;n;n;n;b;b;b|];
		[|b;b;n;n;b;n;n;b;n;n;b|];
		[|b;n;n;n;n;n;n;n;n;n;n|];
		[|b;n;n;n;n;n;n;n;n;n;n|];
		[|b;b;n;n;b;n;n;b;n;n;b|];
		[|b;b;b;b;b;n;n;b;b;b;b|];
		[|b;b;b;b;n;n;n;n;b;b;b|] |]

let coeu   = [| [|b;b;r;r;b;b;b;r;r;b;b|];
		[|b;r;r;r;r;b;r;r;r;r;b|];
		[|b;r;r;r;r;r;r;r;r;r;b|];
		[|b;r;r;r;r;r;r;r;r;r;b|];
		[|b;b;r;r;r;r;r;r;r;b;b|];
		[|b;b;b;r;r;r;r;r;b;b;b|];
		[|b;b;b;b;r;r;r;b;b;b;b|];
		[|b;b;b;b;b;r;b;b;b;b;b|];
		[|b;b;b;b;b;r;b;b;b;b;b|] |]


let piqu   = [| [|b;b;b;b;b;n;b;b;b;b;b|];
		[|b;b;b;b;b;n;b;b;b;b;b|];
		[|b;b;b;b;n;n;n;b;b;b;b|];
		[|b;b;n;n;n;n;n;n;n;b;b|];
		[|b;n;n;n;n;n;n;n;n;n;b|];
		[|b;n;n;n;n;n;n;n;n;n;b|];
		[|b;n;n;n;b;n;b;n;n;n;b|];
		[|b;b;b;b;b;n;b;b;b;b;b|];
		[|b;b;b;b;n;n;n;b;b;b;b|] |]

let draw_haut h = match h with
  | Sept -> draw_string " 7"
  | Huit -> draw_string " 8"
  | Neuf -> draw_string " 9"
  | Dix -> draw_string "10"
  | Valet -> draw_string " V"
  | Dame -> draw_string " D"
  | Roi -> draw_string " R"
  | As -> draw_string " A"

let draw_coul c l coul = match coul with
  | Carreau -> draw_image (make_image carr) c (l+2)
  | Trefle -> draw_image (make_image tref) c (l+2)
  | Coeur -> draw_image (make_image coeu) c (l+2)
  | Pique -> draw_image (make_image piqu) c (l+2)

let draw_carte ca =
  let (c,l) = current_point() in
  draw_haut (haut ca); draw_coul (c+12) l (coul ca); moveto c (l+14)

let draw_pile l = failwith "à faire"
(* TEST *)
let () = Graphics.open_graph ""
let _ = draw_pile p''1
let () = Graphics.close_graph ()
(* END TEST *)

let draw_jeu j = failwith "à faire"

let draw_reussite () = failwith "à faire"
(* TEST *)
let res = draw_reussite ()
(* END TEST *)
