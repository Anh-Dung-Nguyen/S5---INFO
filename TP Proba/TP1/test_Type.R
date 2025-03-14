txt <- "33"
print(class(txt))

# modifier le type de variable txt de character à int
nbr <- as.integer(txt)
print(is.numeric(nbr))

# paste() pour créer un text à partir de plusieurs variables
mot <- "petite"
text1 <- paste("une", mot, "phrase")
text2 <- paste(text1, "compte", nchar(text1), "lettres")

# paste() function concatenates values as strings
tmp <- 3/0
nsp <- NA
resultat <- paste(tmp, tmp + 1, tmp + nsp)

#declare a vector and index starts from 1, not 0
vecteur1 <- c(1, 3, 5, 7, 9)
vecteur2 <- seq(from = 0, to = 10, by = 2)
vecteur3 <- 0 : 10
vecteur4 <- rep(1:2, 5)

length(vecteur1)

# rnorm () génère des valeurs aléatoires suivant une distribution normale
# la majorité des valeurs se concentrent autour de la moyenne
valeurs_normales <- rnorm(10, mean = 0, sd = 1)
print(valeurs_normales)

# runif() génère des valeurs aléatoires suivant une distribution uniforme
# chaque valeur dans un intervalle donné a la même probabilité d'être sélectionnée
valeurs_uniforme <- runif(10, min = 0, max = 1)
print(valeurs_uniforme)

# data.frames
v1 <- c(175, 182, 165, 187, 158)
v2 <- c(19, 18, 21, 22, 20)
v3 <- c("Louis", "Paule", "Pierre", "Rémi", "Claude")
tableau <- data.frame(prenom = v3, taille = v1, age = v2)
# names() renvoie les noms des colonnes du data frame
print(names(tableau))
# $ permet d'accéder à une colonne spécifique dans un data frame
print(tableau$prenom)
# write.table() permet de sauvegarder le data frame dans un fichier externe
# par défault, R inclut les numéros de ligne et les colonnes de ligne mais on les supprime en mettant FALSE
write.table(tableau, "sortie.csv", sep = ";", row.names = FALSE, col.names = FALSE)

# Loi normale en un point
dnorm(3, mean = 1, sd = sqrt(0.2))

#Loi normale en plusieurs points
dnorm(c(2, 3, 4), mean = 0, sd = 1)

# utiliser "curve" pour représenter la fct de densité d'une variable continue
curve(dnorm(x, mean = 1, sd = 0.3), from = -1, to = 3, ylab = "dnorm(x, mean = 1)")
# add = T cad add = TRUE -> ajouter la courbe à un graphique déjà existant
curve(dnorm(x, mean = 1, sd = 0.5), add = T, col = "red") 
curve(dnorm(x, mean = 1, sd = 0.7), add = T, col = "green")
curve(dnorm(x, mean = 1, sd = 1.1), add = T, col = "blue")
legend(-1, 1.1, legend = c("sigma = 0.3", "sigma = 0.5", "sigma = 0.7", "sigma = 1.1"), 
                            col = c("black", "red", "green", "blue"),
                            lty = c(1.1), cex = 0.8, title = "Légende", text.font = 2, bg = "lightgrey")

# utiliser "plot" pour représenter la fonction de densité d'une variable discrète
n <- 10
p <- 0.2

x <- 0 : n

y <- dbinom(x, size = n, prob = p)

plot (x, y, type = 'h', lwd = 30, col = "blue",
      xlab = "Nombre de succès",
      ylab = "Probabilité P(X=x)",
      main = "Densité de la loi binomiale (n = 10, p = 0.2)")

# Exo 4.1.3
curve(dexp(x, rate = 2), from = 0, to = 3, col = "red", lwd = 2, 
      ylab = "Densité", main = "Fonctions exponentielles pour différents λ")
curve(dexp(x, rate = 1), add = TRUE, col = "green", lwd = 2)
curve(dexp(x, rate = 0.5), add = TRUE, col = "blue", lwd = 2)
legend("topright", legend = c("λ = 2", "λ = 1", "λ = 0.5"), 
       col = c("red", "green", "blue"), lwd = 2)

set.seed(123)
exemples <- rexp(80, rate = 2)

hist(exemples, probability = TRUE, col = "lightblue", 
     xlab = "Valeurs", main = "Histogramme des exemples et courbe théorique")

curve(dexp(x, rate = 2), add = TRUE, col = "red", lwd = 2)

# Tirage aléatoire d'élement
de <- 1 : 6
# sample(x, replace, size) permet de tirer size élément dans le vecteur x avec remise si replace est vrai et vice versa
sample(de, replace = TRUE, size = 10)

# Tirage aléatoire selon un loi
N <- 1000
n <- 10
p <- 0.3

each <- rbinom(N, n, p)
each

barplot(table(each)/N)

# Exo 4.2.4
Urne <- function (k, p, q){
  if (k > (p + q)){
    stop("Erreur")
  }
  boules <- c(rep("Rouge", p), rep("Noire", q))
  tirages <- sample(boules, k, replace = FALSE)
  return (tirages)
}

resultat <- Urne(6, 8, 5)
print(resultat)

# Exo 4.2.5
Freq <- function(n){
  if (n < 0){
    stop("Erreur")
  }
  de <- 1 : 6
  tirages <- sample(de, size = 7, replace = TRUE)
  diviser <- sum(tirages == n) / length(tirages)
}

resultat <- Freq(5)
print(resultat)