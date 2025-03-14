/*
TP Base Menu

@author Prenom1 NOM1
@author Prenom2 NOM2
@version Annee scolaire 20__/20__
*/

hors_d_oeuvre(artichauts_Melanie).
hors_d_oeuvre(truffes_sous_le_sel).
hors_d_oeuvre(cresson_oeuf_poche).

viande(grillade_de_boeuf).
viande(poulet_au_tilleul).

poisson(bar_aux_algues).
poisson(saumon_oseille).

dessert(sorbet_aux_poires).
dessert(fraises_chantilly).
dessert(melon_en_surprise).

calories(artichauts_Melanie, 150).
calories(truffes_sous_le_sel, 202).
calories(cresson_oeuf_poche, 212).
calories(grillade_de_boeuf, 532).
calories(poulet_au_tilleul, 400).
calories(bar_aux_algues, 292).
calories(saumon_oseille, 254).
calories(sorbet_aux_poires, 223).
calories(fraises_chantilly, 289).
calories(melon_en_surprise, 122).

plat(X) :- viande(X).
plat(X) :- poisson(X).

repas(X,Y,Z) :- 
hors_d_oeuvre(X),
plat(Y),
dessert(Z).

plat200_400(X) :- calories(X,Y), Y > 200, Y < 400.

plat_bar(X) :- 
calories(bar_aux_algues,Cbar), 
calories(X,C),
C > Cbar.

val_cal(X,Y,Z,W) :- 
repas(X,Y,Z),
calories(X,A),
calories(Y,B),
calories(Z,C),
W is A + B + C.

repas_eq(X,Y,Z) :-
val_cal(X,Y,Z,W),
W < 800.


