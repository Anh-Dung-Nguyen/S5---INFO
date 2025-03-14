# Q5

vitesse <- read.csv2("~/Nguyen Anh Dung/S5 - INFO/TP Proba/TP3/vitesse.csv", sep = ";")

# Q6
moyenne <- tapply(X = vitesse$vecVitesses, INDEX = vitesse$vecNum, FUN = mean)
print(moyenne)

# Q7
borneInf <- 0
borneSup <- 0
for (i in moyenne){
  borneInf <- moyenne - (qnorm(1-0.025) * (sqrt(100)/sqrt(6)))
  borneSup <- moyenne - (qnorm(0.025) * (sqrt(100)/sqrt(6)))
}
print(borneInf)
print(borneSup)

# Q8
