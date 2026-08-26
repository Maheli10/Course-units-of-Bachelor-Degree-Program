#include <unistd.h>
#include <stdio.h>
#include <string.h>

int main(){
    int pipe1[2];   //pipe1 = parent -> child
    int pipe2[2];   //pipe2 = child -> parent

    pipe(pipe1);
    pipe(pipe2);

    if(fork() == 0){
        //child
        char msg1[50];
        char msg2[] = "Hello Parent! from child";

        //pipe1 = parent -> child
        close(pipe1[1]);
        read(pipe1[0], msg1, sizeof(msg1));
        printf("Child Received: %s\n", msg1);

        //pipe2 = child -> parent
        close(pipe2[0]);
        write(pipe2[1], msg2, strlen(msg2));

    }else{
        //parent
        char msg1[] = "Hello Child! from parent";
        char msg2[50];

        //pipe1 = parent -> child
        close(pipe1[0]);
        write(pipe1[1], msg1, strlen(msg1));

        //pipe2 = child -> parent
        close(pipe2[1]);
        read(pipe2[0], msg2, sizeof(msg2));
        printf("Parent Received: %s\n", msg2);
    }

    return 0;
}