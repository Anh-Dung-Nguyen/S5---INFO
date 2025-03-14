# Q1
# Loi binomiale, espérance = 0.75 * n, écart-type = sqrt(n * 0.75 * 0.25)

# Q2
nbPersonne <- qbinom(p = 0.95, prob = 0.75, size = 150)
print(nbPersonne)

# Q3
ticketVendu <- 0
nbPersonne <- 0
while (nbPersonne < 150){
  ticketVendu <- ticketVendu + 1
  nbPersonne <-qbinom(p = 0.95, prob = 0.75, size = ticketVendu)
}
print(ticketVendu)

# Q4
ticketVendu <- 0
nbPersonne <- 0
while (nbPersonne < 300){
  ticketVendu <- ticketVendu + 1
  nbPersonne <-qbinom(p = 0.95, prob = 0.5, size = ticketVendu)
}
print(ticketVendu)

ticketVendu <- 0
nbPersonne <- 0
while (nbPersonne < 300){
  ticketVendu <- ticketVendu + 1
  nbPersonne <-qbinom(p = 0.95, prob = 0.8, size = ticketVendu)
}
print(ticketVendu)
