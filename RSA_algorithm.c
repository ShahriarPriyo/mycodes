#include<stdio.h>
#include<math.h>

//finding GCD

int gcd(int a, int b)
{
    int rem;
    while(b !=0 )
    {
        rem=a%b;
        if(rem == 0)
            return b;
        a=b;
        b=rem;
    }
}

int main()
{
    //two prime number

    double p=7;
    double q=11;

    //public key
    double n=p*q;
    double e = 13;

    double x=(p-1)*(q-1);
    while(e<x)          // e must be smaller than x
    {

        if(gcd(e,x) == 1)
            break;
        else
            e++;
    }
    int k=2;
    double d = (1+(k*x))/e;
        //law of finding private key
    double m= 50;
    printf("plain text = %lf",m);

    //encryption
    double c= pow(c,d);
    c= fmod (c,n);

    printf("\n Cipher Text: %lf",c);

    //decryption
    double l=pow(c,d);
    l=fmod(m,n);
    printf("\n Original Message after decryption: %lf",l);

    return 0;

}
