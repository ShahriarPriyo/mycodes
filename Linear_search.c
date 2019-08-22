#include<stdio.h>
int main()
{
    int arr[100],search,c,n;
    printf("Enter the number of elements in array:");
    scanf("%d",&n);

    for(c=0 ;c<=n ; c++)
    {
        scanf("%d",&arr[c]);

    }

    printf("Enter the number to search:\n");
    scanf("%d",&search);

    for(c=0 ;c<=n; c++)
    {
        if(arr[c]==search)
        {
            printf("%d is present at location %d",search,c+1);
            break;
        }

    }
    if(c==n)
    {
        printf("%d isn't present in the array \n",search);
    }
    return 0;
}
