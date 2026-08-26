#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <stdlib.h>

int main(){
    int pipeA[2];
    int pipeB[2];

    pipe(pipeA);
    pipe(pipeB);

    //child1
    if (fork() == 0){
        char msg[50];

        close(pipeA[1]);
        read(pipeA[0], msg, sizeof(msg));
        printf("Child 1 Received: %s\n", msg);
        return 0;
    }

    //child2
    if (fork() == 0){
        char msg[50];

        close(pipeB[1]);
        read(pipeB[0], msg, sizeof(msg));
        printf("Child 2 Received: %s\n", msg);
        return 0;
    }

    //parent
    char msg1[] = "Hello Child-1! from parent";
    char msg2[] = "Hello Child-2! from parent";

    close(pipeA[0]);
    write(pipeA[1], msg1, strlen(msg1));

    close(pipeB[0]);
    write(pipeB[1], msg2, strlen(msg2));

    return 0;
}