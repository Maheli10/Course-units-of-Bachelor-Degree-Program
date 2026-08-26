#include<unistd.h>
#include<stdio.h>
#include<stdlib.h>
#include<sys/wait.h>

int main(){
	
	pid_t f1,f2;
	
	int pipeA[2];
	int pipeB[2];
	int pipeC[2];
	
	pipe(pipeA);
	pipe(pipeB);
	pipe(pipeC);
	
	int N;
	printf("Enter the amount of numbers");
	scanf("%d",&N);
	
	int num[N];
	printf("\nEnter the numbers");
	for(int i=0; i<N; i++){
		scanf("%d",&num[i]);
	}
	
	f1=fork();
	if(f1<0){
		perror("fork error");
		exit(1);
	}
	if(f1>0){
		
		
		close(pipeA[0]);
		write(pipeA[1], &N, sizeof(N));
		write(pipeA[1], num, sizeof(int)*N);
		close(pipeA[1]);
		
		float avg;
		close(pipeC[1]);
		read(pipeC[0], &avg, sizeof(avg));
		close(pipeC[0]);
		
		printf("\ncalculated average vaule: %.2f\n",avg);
		printf("Process ID: %d, ParentProcess ID: %d ,activity: , value: %.2f\n",getpid(),getppid(),avg);
		wait(NULL);
	}
	
	if(f1==0){
		f2= fork();
		if(f2<0){
			perror("error messsage");
			exit(1);
		}
		if(f2>0){
			int sum=0;
			int N;

			close(pipeA[1]);
			read(pipeA[0], &N, sizeof(N));

			int value[N];
			read(pipeA[0], value, sizeof(int)*N);
			close(pipeA[0]);
			
			for(int i=0; i<N; i++){
				sum= sum+value[i];	
			}
			
			close(pipeB[0]);
			write(pipeB[1], &N, sizeof(N));1
			write(pipeB[1], &sum, sizeof(sum));
			close(pipeB[1]);
			printf("Process ID: %d, ParentProcess ID: %d ,activity: Finding sum , value: %d\n",getpid(),getppid(),sum);

			wait(NULL);
		}
		if(f2==0){
			float avg;
			int sumr;
			int N;
			
			close(pipeB[1]);
			read(pipeB[0], &N, sizeof(N));
			read(pipeB[0], &sumr, sizeof(sumr));
			close(pipeB[0]);
			
			avg= (float)sumr/N;
			
			close(pipeC[0]);
			write(pipeC[1], &avg, sizeof(avg));
			close(pipeC[1]);
			printf("Process ID: %d, ParentProcess ID: %d ,activity:Finding average , value: %.2f\n",getpid(),getppid(),avg);


			exit(0);
		}
		exit(0);
	}

	return 0;
}