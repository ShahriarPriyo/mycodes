#structure of matrix in R is matrix(data,nrow,byrow,dimnames)


P<- matrix(c(3:14), nrow = 3,byrow = TRUE)
print(P)

Q<- matrix(c(14:25), nrow=3 ,byrow= TRUE)
print(Q)

print(P+Q)


#factors in R 
#useful when there is lot of repeating values in dataset
