#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/wait.h>

int main(){
    int pipeA[2];
    int pipeB[2];
    pipe(pipeA);
    pipe(pipeB);

    //child-1///////////////////////////////////////////////////////////////////////
    pid_t A = fork();
    if(A == 0){
        int num1;
        close(pipeA[1]);
        read(pipeA[0], &num1, sizeof(num1));
        close(pipeA[0]);
        printf("\nPID: %d, PPID: %d, Child-1 Received: %d\n",getpid(), getppid(), num1);

        int pow = num1*num1;
        printf("Power of %d is : %d\n", num1, pow);

        exit(0);
    }

    //child-2///////////////////////////////////////////////////////////////////////
    pid_t B = fork();
    if(B == 0){
        int num2;
        close(pipeB[1]);
        read(pipeB[0], &num2, sizeof(num2));
        close(pipeB[0]);
        printf("\nPID: %d, PPID: %d, Child-2 Received: %d\n",getpid(), getppid(), num2);

        if(num2 % 2 == 0){
            printf("%d is an Even Number\n", num2);
        }else{
            printf("%d is an Odd Number\n", num2);
        }

        exit(0);
    }

    //parent////////////////////////////////////////////////////////////////////////
    int num1, num2;

    printf("Please Enter Number 1: ");
    scanf("%d", &num1);
    printf("Please Enter Number 2: ");
    scanf("%d", &num2);

    close(pipeA[0]);
    write(pipeA[1], &num1, sizeof(num1));
    close(pipeA[1]);

    close(pipeB[0]);
    write(pipeB[1], &num2, sizeof(num2));
    close(pipeB[1]);

    printf("\nParentID: %d", getpid());

    wait(NULL);
    wait(NULL);

}