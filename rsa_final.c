#include<stdio.h>
#include<stdbool.h>
#include<stdlib.h>
#include<math.h>


void encrypt();
void decrypt();
void compute();
void display();


int p,q,n,fn,d,e,temp,dt;
int pt=1,ct=1;
bool x;

int main()
{

	printf("\n ENTER FIRST PRIME NUMBER : ");
	scanf("%d",&p);

	x=isPrime(p);

	if (x==false)
	{
		printf("\n Wrong input \n");
		exit(0);
	}

	printf("\n ENTER SECOND PRIME NUMBER : ");
	scanf("%d",&q);
    x=isPrime(q);

    if(x==false)
    {
    	printf("\n Wrong input \n ");
    	exit(0);
    }

    compute();

    printf("\n\n ENTER YOUR TEXT : ");
    scanf("%d",&pt);

    encrypt();
    decrypt();
    display();

 return 0;

}

void compute()
{
 n=p*q;
 fn=(p-1)*(q-1);



 TryAgain:
 printf("\n ENTER PUBLIC KEY WHICH MUST BE PRIME NUMBER AND LESS THAN %d : ",fn);
 scanf("%d",&e);
 x=isPrime(e);

 if(x==false || e>=fn)

  {
  	printf("\n INVALID INPUT \n");
    goto TryAgain;
  }



d = 1;

do
{
temp = (d*e)%fn;
d++;
} while(temp!=1);

d = d-1;


printf("\n PUBLIC KEY : %d , %d ",e,n);
printf("\n Generating PRIVATE KEY. : : ");
printf("\n PRIVATE KEY : %d , %d ",d,n);

}

void encrypt()
{
  int k;
	k=pow(pt,e);
  ct=(k%n);
}

void decrypt()
{
  long int l;
  l=pow(ct,d);
  dt=(l%n);
}

void display()
{

  printf("\n PLAIN TEXT : %d ",pt);
  printf("\n ENCRYPTED TEXT : %d ",ct);
  printf("\n DECRYPTED TEXT : %d ",dt);

}

int isPrime(int x)
{
     int n, i, flag = 0;
    printf("Enter a positive integer: ");
    scanf("%d", &n);
    for(i = 2; i <= n/2; ++i)
    {
        // condition for nonprime number
        if(n%i == 0)
        {
            flag = 1;
            break;
        }
    }
    if (n == 1)
    {
      printf("1 is neither a prime nor a composite number.");
    }
    else
    {
        if (flag == 0)
          return n;
        else
          return -1;
    }
}
