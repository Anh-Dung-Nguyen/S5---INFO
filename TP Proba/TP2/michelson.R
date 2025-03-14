library(MASS)

summary(michelson)
head(michelson)

print(michelson$Speed)

# 1.1
ecartType <- sd(michelson$Speed)
moyenne <- mean(michelson$Speed)

print(ecartType)
print(moyenne)

# 1.2
plot(x = 1:100, y = cumsum(michelson$Speed)/(1:100))

# 1.3
# La loi de grandes nombres

# 1.4
hist(x = michelson$Speed, col = "yellow", freq = F)
curve(dnorm(x, mean = moyenne, sd = ecartType),
      add = T,
      col = "red")

# 1.5
data <- data.frame(
  list(C1 = c(michelson$Speed),
       C2 = c(michelson$Expt))
)
exp <- tapply(data$C1, data$C2, mean)

hist(exp, add = T, col = "gray", freq = F)

curve(dnorm(x, mean = mean(michelson$Speed), sd = sd(michelson$Speed)/sqrt(20)),
      add = T,
      col = "purple")
