#include<stdio.h>
#include<stdbool.h>
#include<math.h>
long long int power(long long int b,int exp,int mod)
{
    b=b%mod;
    if(exp==0)
    {
        return 0;
    }
    if(exp==1)
    {
        return b;
    }
    if(exp %2 == 0 )
    {
         return (power((b* b) % mod, exp / 2, mod) % mod);
    }
    if (exp% 2 == 1)
    {
         return (b * power(b, (exp - 1), mod) % mod);
    }
    return -1;
}
int primefac(int s[],int n)
{
    int index=0;
    for (int i = 2; i <= sqrt(n); i = i+2)
    {
        while (n%i == 0)
        {
            s[index]=i;
            n = n/i;
        }
        index++;
    }

    if (n > 2)
    {
        s[index]=n;
    }
    return index;
}
int findprimitive(int n)
{
    int Factor[n];
    int limit, e, temp;
    unsigned long long int res;
    limit = n-1;

    e=primefac(Factor, limit);

    for (int r=2; r<=limit; r++)
    {
        bool flag = false;
        for (int i = 0; i<=e; i++)
        {
            temp=limit/(Factor[i]);
            res=power(r,temp,n);
            if (res==1)
            {
                flag = true;
                break;
            }
        }
        if(flag == false)
            return r;
    }
    return -1;
}
int main()
{
	long long int n, g, Ia, a, Ib, b, Ka, Kb;
	n = 193;
	printf("The value of n: %lld\n", n);
	g=findprimitive(n);
	printf("The value of g: %lld\n\n", g);

	a = 5;
	printf("The private key a for Alice: %lld\n",a);
	Ia = power(g, a, n);

	b = 6;
	printf("The private key b for Bob : %lld\n\n",b);
	Ib = power(g, b, n);

	Ka = power(Ib, a, n);
	Kb = power(Ia, b, n);

	printf("Secret key for the Alice is: %lld\n",Ka);
	printf("Secret Key for the Bob is: %lld\n",Kb);

	return 0;
}
