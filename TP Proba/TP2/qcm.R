# 2.1
# Loi de Bernouilli

# 2.2
# Loi binomiale

# 2.3
psucc <- sum(dbinom(6:10, size = 10, prob = 0.25))

# 2.4
nbQuestionOk <- rbinom(5000, size = 10, prob = 0.25)

# 2.5
lesSucces <- as.integer(nbQuestionOk >= 6)

# 2.6
plot(x = 1:length(lesSucces),
     y = cumsum(lesSucces)/(1:length(lesSucces)))

# 2.7
# Loi normale

# 2.8
x10 <- rnorm(length(lesSucces)/10,
             mean = 0.25,
             sd = sqrt(0.25 * 0.75))

# 2.9
hist(x10, col = "gray", freq = F)
