#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

int main(){
    int pipeA[2];
    int pipeB[2];
    pipe(pipeA);
    pipe(pipeB);

    pid_t A = fork();
    if(A == 0){
        //child
        char msg1[] = "Hello Parent! from child";
        close(pipeA[0]);
        write(pipeA[1], msg1, strlen(msg1));
        close(pipeA[1]);

        char msg2[50];
        close(pipeB[1]);
        read(pipeB[0], msg2, sizeof(msg2));
        close(pipeB[0]);
        printf("Received Child: %s, PID: %d\n", msg2, getpid());
        
    }else{
        pid_t B = fork();
        if(B == 0){
            //parent
            char msg1[50];
            close(pipeA[1]);
            read(pipeA[0], msg1, sizeof(msg1));
            close(pipeA[0]);
            printf("Received Parent : %s, PID: %d\n",msg1 , getppid());

            char msg2[] = "Hello Child! from parent";
            close(pipeB[0]);
            write(pipeB[1], msg2, strlen(msg2));
            close(pipeB[1]);
        }
    }
}