#taking vector as input

vector1<-c(1,2,3)
vector2<-c(6,10,12,14,16,18)

#vector as input to array
#dim is (row,col,array number)

result<-array(c(vector1,vector2),dim = c(3,3,2))
print(result)

#manipulating array and extracting values from array
print(result[1,,1])

#using value from the created array
mat1<-result[2,2,1]
print(mat1)

mat2<-result[3,3,1]
print(mat2)

result2<-mat1+mat2
print(result2)