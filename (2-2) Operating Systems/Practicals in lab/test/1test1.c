#include <unistd.h>
#include <stdio.h>
#include <string.h>

int main(){
    int fd[2];
    pipe(fd);

    if(fork() == 0){
        //child
        char msg[50];
        close(fd[1]);
        read(fd[0], msg, sizeof(msg));
    } else{
        //parent
        char *text = "hello Child!";
        close(fd[0]);
        write(fd[1], text, strlen(text));

    }
    return 0;
}