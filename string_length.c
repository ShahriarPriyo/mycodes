#include<stdio.h>
int main()
{

    int i,n;
    scanf("%d",&n);
    for(i=0;i<=n;i++)
    {
        char ch[100];
        int length;
        gets(ch);
        length=0;
        while(ch[length] !='\0')
        {
            length++;
        }
     printf("%d\n",length);

    }
}
