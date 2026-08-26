#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <sys/wait.h>

int main() {
    int pipeA[2];
    pipe(pipeA);

    pid_t pid = fork();

    if(pid == 0){
        char msg[50];

        close(pipeA[1]);
        read(pipeA[0], msg, sizeof(msg));
        printf("Child (PID: %d, PPID: %d) Received : %s\n", getpid(), getppid(), msg);

    }else{
        char msg[] = "Hello Child! from Parent";

        close(pipeA[0]);
        write(pipeA[1], msg, strlen(msg));
        printf("Parent PID: %d\n",getpid());

        close(pipeA[1]);
        wait(NULL);

    }
    return 0;
}