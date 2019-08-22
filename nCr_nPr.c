#include<stdio.h>

long factorial(int);
long find_ncr(int,int);
long find_npr(int,int);
int main()
{
    int n,r;
    long ncr,npr;

    printf("Enter the value of n and r: ");
    scanf("%d %d",&n,&r);

    ncr=find_ncr(n,r);
    npr=find_npr(n,r);

    printf("The value of ncr: %ld\n",ncr);
     printf("The value of npr: %ld",npr);

}
long find_ncr(int n,int r)
{
    long result;
    result=factorial(r)/factorial(n)*factorial(n-r);

    return result;
}

long find_npr(int n,int r)
{
    long result;
    result=factorial(n)/factorial(n-r);

    return result;
}

long factorial(int n)
{
    int a;
    long result=1;
    for(a=1;a<n;a++)
    {
        result=result*a;
    }
    return result;
}
