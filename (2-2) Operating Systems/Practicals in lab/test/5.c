 #include <unistd.h>
 #include <stdio.h>
 #include <stdlib.h>
 #include <string.h>

 int main() {
    int pipeA[2];
    int pipeB[2];

    pipe(pipeA);
    pipe(pipeB);

    pid_t pid1, pid2;

    //Child 1
    pid1 = fork();
    if (pid1 == 0){
        char msg[50];

        close(pipeA[1]);
        read(pipeA[0], msg, sizeof(msg));
        printf("Child-1 (PID: %d) Received: %s\n", getpid(), msg);

        return 0;
    }

    //Child 2
    pid2 = fork();
    if (pid2 == 0){
        char msg[50];

        close(pipeB[1]);
        read(pipeB[0], msg, sizeof(msg));
        printf("Child-2 (PID: %d) Received: %s\n", getpid(), msg);

        return 0;
    }

    //parent
    char msg1[] = "Hello Child-1! from parent";
    char msg2[] = "Hello Child-2! from parent";

    printf("Parent PID: %d\n", getpid());

    close(pipeA[0]);
    write(pipeA[1], msg1, strlen(msg1));

    close(pipeB[0]);
    write(pipeB[1], msg2, strlen(msg2));

    return 0;
 }