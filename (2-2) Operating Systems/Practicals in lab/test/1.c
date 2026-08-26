#include <stdio.h>
#include <unistd.h>
#include <string.h>

//fd[0]     = read
//fd[1]     = write

int main() {
    //create pipe
    int fd[2];
    pipe(fd);

    if (fork() == 0) {
        // Child process
        char msg[50];

        close(fd[1]); // close write end of child
        read(fd[0], msg, sizeof(msg));  //read from pipe parent's write end

        printf("Child received: %s\n", msg);
    } else {
        // Parent process
        char *text = "Hello Child!";

        close(fd[0]); // close read end parent
        write(fd[1], text, strlen(text) + 1);   //write to pipe child's read end
    }

    return 0;
}