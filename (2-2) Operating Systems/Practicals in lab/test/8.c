//develop a C program to perfrom the following tasks using one parent, grand child, and one unnamed pipe;
    //(a) - Reads the number of integers N from the user in the parent process. Reads and sends N number of integers to its child process using pipeA
    //(b) - The child p[rovess reads the N number of integer values from pipeA, calculates the sum and sends it along with the numbe of integers to its child proces
    //(c) - The grandchild process read s the sum value from pipeV calculates the average and sends it back to its grand parent(parent) process through pipeC
    //(d) - The parent process reads the value form the Grandchild using pipeC and prints the calculated average value.

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main() {
    pid_t child = fork();
    if (child == 0) {
        //Child process////////////////////////////////////////////////////////////////
        printf("Child PID: %d, Parent PID: %d\n", getpid(), getppid());

        pid_t grandchild = fork();
        if (grandchild == 0) {
            //Grandchild process//////////////////////////////////////////////////////
            printf("Grandchild PID: %d, Parent PID: %d\n", getpid(), getppid());
            exit(0);
        } else {
            wait(NULL);
            exit(0);
        }
    } else {
        //Parent process//////////////////////////////////////////////////////////////
        printf("Parent PID: %d\n", getpid());



        

        wait(NULL);
    }
    return 0;
}
