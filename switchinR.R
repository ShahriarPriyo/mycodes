x<-switch(
  4,
  "first",
  "second",
  "third",
  "fourth"
)
print(x)
month.name
month.abb
#months.Date()
pi

y<-LETTERS[1:7]
for(i in y)
{
  print(i)
}

#repeat loop in R
z<-1
repeat{
  print(z)
  z=z+1
  if(z == 6){
    break
  }
}
