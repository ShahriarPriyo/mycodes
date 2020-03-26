library(ggplot)
install.packages("ggplot2")
library(ggplot2)
#calling function in r
ggplot2::mpg  


#making the ggplot in r
ggplot(data = mpg)+
  geom_point(mapping = aes(x=displ,y=hwy))
ggplot(data=mpg)

#not working because not aesthetic
ggplot(data = mpg)+
  geom_bar(mapping = aes(x=cyl,y=year))

#for checking error
rlang::last_error()
ggplot(data = mpg)+
  geom_point(mapping = aes(x=displ,y=year))

ggplot(data = mpg)+
  geom_smooth(mapping = aes(x=displ,y=hwy))
