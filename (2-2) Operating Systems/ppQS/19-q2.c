#include<stdio.h>
#include<unistd.h>
#include<stdlib.h>
#include<sys/wait.h>


int largest(int n){}

int oddeven(int n){}
int main(){
	pid_t f1,f2,f3,f4,f5,f6;
	
	int x;
	int largestOd,largestEven;
	
	printf("A: PID: %d, PPID: %d \n",getpid(),getppid());
	
	printf("Enter a decimmal number :\n");
	scanf("%d",&x);
	
	if(x%2==0){
		largestOdd = x-1;
	}
	else{
		largestOdd = x-2;
	}
	if(x%2==0){
		largestEven= x-2;
		
	}
	else{
		largestEven = x-1;
	}

	f1=fork();
	if(f1<0){
		perror("fork error \n");
		exit(1);
		
	}
	if(f1==0){
		printf("\nB: PID: %d, PPID: %d \n",getpid(),getppid());
		
			f3= fork();
			if(f3<0){
				perror("fork error \n");
				exit(1);
			}
			if(f3==0){
				printf("D: PID: %d, PPID: %d \n",getpid(),getppid());
				exit(0);
			}
			else{
			f4=fork();
			if(f4<0){
				perror("fork error \n");
				exit(1);
			}
			if(f4==0){
				printf("E: PID: %d, PPID: %d \n",getpid(),getppid());
				exit(0);
			}
			}
		wait(NULL);
		wait(NULL);
		exit(0);
	}
	else{
		f2=fork();
		if(f2==0){
			printf("C: PID: %d, PPID: %d \n",getpid(),getppid());
			
			f5= fork();
			if(f5==0){
				printf("F: PID: %d, PPID: %d \n",getpid(),getppid());
				exit(0);
			}
			else{
				f6=fork();
				if(f6==0){
					printf("G: PID: %d, PPID: %d \n",getpid(),getppid());
					exit(0);
				}
			}
			wait(NULL);
			wait(NULL);
			exit(0);
		}
	}
	
	wait(NULL);
	wait(NULL);
	
	return 0;
}