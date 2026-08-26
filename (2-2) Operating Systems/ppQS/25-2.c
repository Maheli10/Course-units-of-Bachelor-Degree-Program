#include<stdio.h>
#include<unistd.h>
#include<stdlib.h>
#include<sys/wait.h>


int main(){
	pid_t f1,f2,f3;
	
	sleep(1);
	printf("Main task Manager, PID: %d, PPID: %d, Level: 0\n",getpid(),getppid());
	
	f1= fork();
	if(f1== 0){
		pid_t sub1,sub2;
		
		printf("File Backup Task, PID: %d, PPID: %d, Level: 1\n",getpid(),getppid());
		
		sub1= fork();
		if(sub1==0){
			sleep(2);
			printf("Read Files, PID: %d, PPID: %d, Level: 1\n",getpid(),getppid());
			exit(0);
		}
		
		sub2= fork();
		if(sub2==0){
			sleep(2);
			printf("Read Files, PID: %d, PPID: %d, Level: 1\n",getpid(),getppid());
			exit(0);
		}
		
		wait(NULL);
		wait(NULL);
		exit(0);
	}
	
	f2= fork();
	if(f2== 0){
		printf("Network Monitoring Task, PID: %d, PPID: %d, Level: 1\n",getpid(),getppid());
		exit(0);
	}
	
	f3= fork();
	if(f3== 0){
		printf("Log Cleanup Task, PID: %d, PPID: %d, Level: 1\n",getpid(),getppid());
		exit(0);
	}
	
	wait(NULL);
	wait(NULL);
	wait(NULL);
	return 0;
}