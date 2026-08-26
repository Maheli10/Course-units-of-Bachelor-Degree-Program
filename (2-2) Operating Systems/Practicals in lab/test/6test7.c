#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

int main(){
    int pipeA[2];
    pipe(pipeA);

    pid_t A = fork();

    if(A == 0){
        //Child
        char msg[50];

        close(pipeA[1]);
        read(pipeA[0], msg, sizeof(msg));
        close(pipeA[0]);

        printf("PID: %d, PPID: %d, Child Received: %s\n",getpid(), getppid(), msg);

    }else{
        //Parent
        char msg[] = "Hello Child! from Parent";

        close(pipeA[0]);
        write(pipeA[1], msg, strlen(msg));
        close(pipeA[1]);
    }
    return 0;
}