#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/wait.h>

int main()
{
    pid_t f1,f2,f3,f4,f5,f6;
    int x;

    int pAB[2], pAC[2];
    int pBD[2], pBE[2];
    int pCF[2], pCG[2];

    pipe(pAB);
    pipe(pAC);
    pipe(pBD);
    pipe(pBE);
    pipe(pCF);
    pipe(pCG);

    printf("Enter a decimal number: ");
    scanf("%d",&x);

    if(x <= 1)
    {
        printf("Enter a number greater than 1\n");
        return 1;
    }

    printf("\nA - Process ID: %d , Parent Process ID: %d\n",
           getpid(), getppid());

    /* Process B */
    f1 = fork();

    if(f1 == 0)
    {
        int b, odd;

        close(pAB[1]);
        read(pAB[0], &b, sizeof(b));
        close(pAB[0]);

        if(b % 2 == 1)
            odd = b - 2;
        else
            odd = b - 1;

        printf("Largest odd number less than x is %d\n", odd);

        write(pBD[1], &odd, sizeof(odd));
        write(pBE[1], &odd, sizeof(odd));

        close(pBD[1]);
        close(pBE[1]);

        printf("B - Process ID: %d , Parent Process ID: %d\n",
               getpid(), getppid());

        /* D */
        f3 = fork();

        if(f3 == 0)
        {
            int d;
            int bin[32];
            int i = 0;

            close(pBD[1]);
            read(pBD[0], &d, sizeof(d));
            close(pBD[0]);

            while(d > 0)
            {
                bin[i++] = d % 2;
                d /= 2;
            }

            printf("Binary value of largest odd number: ");

            for(int j=i-1; j>=0; j--)
                printf("%d", bin[j]);

            printf("\nD - Process ID: %d , Parent Process ID: %d\n",
                   getpid(), getppid());

            exit(0);
        }

        /* E */
        f4 = fork();

        if(f4 == 0)
        {
            int e;

            close(pBE[1]);
            read(pBE[0], &e, sizeof(e));
            close(pBE[0]);

            printf("Octal value of largest odd number: %o\n", e);

            printf("E - Process ID: %d , Parent Process ID: %d\n",
                   getpid(), getppid());

            exit(0);
        }

        wait(NULL);
        wait(NULL);
        exit(0);
    }

    /* Process C */
    f2 = fork();

    if(f2 == 0)
    {
        int c, even;

        close(pAC[1]);
        read(pAC[0], &c, sizeof(c));
        close(pAC[0]);

        if(c % 2 == 0)
            even = c - 2;
        else
            even = c - 1;

        printf("Largest even number less than x is %d\n", even);

        write(pCF[1], &even, sizeof(even));
        write(pCG[1], &even, sizeof(even));

        close(pCF[1]);
        close(pCG[1]);

        printf("C - Process ID: %d , Parent Process ID: %d\n",
               getpid(), getppid());

        /* F */
        f5 = fork();

        if(f5 == 0)
        {
            int f;
            int bin[32];
            int i = 0;

            close(pCF[1]);
            read(pCF[0], &f, sizeof(f));
            close(pCF[0]);

            while(f > 0)
            {
                bin[i++] = f % 2;
                f /= 2;
            }

            printf("Binary value of largest even number: ");

            for(int j=i-1; j>=0; j--)
                printf("%d", bin[j]);

            printf("\nF - Process ID: %d , Parent Process ID: %d\n",
                   getpid(), getppid());

            exit(0);
        }

        /* G */
        f6 = fork();

        if(f6 == 0)
        {
            int g;

            close(pCG[1]);
            read(pCG[0], &g, sizeof(g));
            close(pCG[0]);

            printf("Octal value of largest even number: %o\n", g);

            printf("G - Process ID: %d , Parent Process ID: %d\n",
                   getpid(), getppid());

            exit(0);
        }

        wait(NULL);
        wait(NULL);
        exit(0);
    }

    /* Parent A sends x to B and C */
    write(pAB[1], &x, sizeof(x));
    write(pAC[1], &x, sizeof(x));

    close(pAB[1]);
    close(pAC[1]);

    wait(NULL);
    wait(NULL);

    return 0;
}