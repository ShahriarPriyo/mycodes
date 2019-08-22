#include<stdio.h>
int main()
{
    char str[20];
    char ch;
    //printf("Enter the string:\n ");
    //scanf("%s\n",&str);
    printf("Enter the character to be searched: ");
    scanf("%c\n",&ch);

    int count=0;
    int i;
    for(i=0;str[i] != '\0' ;i++)
    {
        if(str[i] == ch)
        {
            count++;
        }

    }
    printf("%d\n",count);

}
