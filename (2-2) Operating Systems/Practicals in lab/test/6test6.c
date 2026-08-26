#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/wait.h>

int main (){
    int pipeA[2];
    int pipeB[2];
    pipe(pipeA);
    pipe(pipeB);

    pid_t pid1, pid2;

    //child-1
    pid1 = fork();
    if (pid1 == 0){
        char msg[50];

        close(pipeA[1]);
        read(pipeA[0], msg, sizeof(msg));
        printf("Child-1 (PID: %d, PPID: %d) Received: %s\n", getpid(), getppid(), msg);
        exit(0);
    }else{
        //child-2
        pid2 = fork();
        if (pid2 == 0){
            char msg[50];

            close(pipeB[1]);
            read(pipeB[0], msg, sizeof(msg));
            printf("Child-2 (PID: %d, PPID: %d) Received: %s\n", getpid(), getppid(), msg);
            exit(0);
        }
    }

    

    //Parent
    char msg1[] = "Hello Child-1! from Parent";
    char msg2[] = "Hello Child-2! from Parent";

    close(pipeA[0]);
    write(pipeA[1], msg1, strlen(msg1));

    close(pipeB[0]);
    write(pipeB[1], msg2, strlen(msg2));

    printf("Parent PID: %d\n",getpid());

    close(pipeA[1]);
    close(pipeB[1]);
    wait(NULL);
    wait(NULL);

    return 0;
}