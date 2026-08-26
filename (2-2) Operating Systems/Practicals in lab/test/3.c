#include <unistd.h>
#include <stdio.h>
#include <string.h>

int main(){
    int pipeA[2];
    int pipeB[2];

    pipe(pipeA);
    pipe(pipeB);

    if(fork() == 0){
        //child
        char msg1[50];
        char msg2[] = "Hello Parent! from child";

        close(pipeA[1]);
        read(pipeA[0], msg1, sizeof(msg1));
        printf("Child Received: %s\n", msg1);

        close(pipeB[0]);
        write(pipeB[1], msg2, strlen(msg2));
    }else{
        //parent
        char msg1[] = "Hello Child! from parent";
        char msg2[50];

        close(pipeA[0]);
        write(pipeA[1], msg1, strlen(msg1));

        close(pipeB[1]);
        read(pipeB[0], msg2, sizeof(msg2));
        printf("Parent Received: %s\n", msg2);
    }
    return 0;
}