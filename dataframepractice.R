df=data.frame(col1= 1:4, col2=4:7, col3=7:10)

#check row and column numbers
dim(df)

#check rownames
rownames(df)

#check colnames
colnames(df)

#check datatypes or structures
str(df)

#summary of full datasets
summary(df)

#creating new dataframe
df2=df[,2:3]

#get 1 column
df$col1
df[,1]#same meaning as previous

#creating matrix
mat = matrix(1:10 , ncol=5 , nrow=5)

class(mat)
class(df)
class(mat)

x<-"dataset"
typeof(x)
#one dimensional data
onedim = df$col1
onedim
class(onedim)

letters[1:5]
