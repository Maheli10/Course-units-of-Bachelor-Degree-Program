#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <sys/wait.h>

int main (){
    int pipeA[2];
    int pipeB[2];

    pipe(pipeA);
    pipe(pipeB);

    pid_t pid1, pid2;

    //Child-1 - Process B/////////////////////////////////////////////////////////////////////////
    pid1 = fork();
    if(pid1 == 0){
        int msg;
        int sum=0;

        close(pipeA[1]);
        read(pipeA[0], &msg, sizeof(msg));
        close(pipeA[0]);

        printf("Child-1 (PID: %d, PPID: %d) Received: %d\n", getpid(), getppid(), msg);
        
        while (msg > 0){
            sum = sum+(msg%10);
            msg = msg/10;
        }
        printf("Sum of Digits: %d\n", sum);
        printf("\n");
        exit(0);

    } else {
        //Child-2 - Process C/////////////////////////////////////////////////////////////////////
        pid2 = fork();
        if(pid2 == 0){
            int msg;

            close(pipeB[1]);
            read(pipeB[0], &msg, sizeof(msg));
            close(pipeB[0]);
            
            printf("Child-2 (PID: %d, PPID: %d) Received: %d\n", getpid(), getppid(), msg);

            if (msg % 2 == 0){
                printf("%d is Even.\n", msg);
            }else{
                printf("%d is Odd.\n",msg);
            }
            exit(0);

        }
    }

    //Parent - Process A/////////////////////////////////////////////////////////////////////////
    int msg1;
    printf("Please Enter Num 1: ");
    scanf("%d",&msg1);
    
    int msg2;
    printf("Please Enter Num 2: ");
    scanf("%d",&msg2);

    close(pipeA[0]);
    write(pipeA[1], &msg1, sizeof(msg1));
    close(pipeA[1]);

    close(pipeB[0]);
    write(pipeB[1], &msg2, sizeof(msg2));
    close(pipeB[1]);

    printf("Parent PID: %d\n", getpid());

    wait(NULL);
    wait(NULL);


    return 0;
}