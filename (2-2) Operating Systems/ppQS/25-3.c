#include<stdio.h>
#include<unistd.h>
#include<stdlib.h>
#include<sys/wait.h>

struct patient{
	char name[50];
	int heartRate;
	int oxygen;
};

int main(){
	int n;
	struct patient p;
	pd_t f1,f2;
	
	int pipeM[2],pipeD[2];
	
	pipe(pipeM);
	pipe(pipeD);
	
	
	printf("==========Hospital Patient Monitoring System===========\n");
	f1= fork();
	if(f1==0){
		//monitoring unit
		
		exit(0);
	}
	
	f2= fork();
	if(f2==0){
		//Decision unit
		
		exit(0);
	}
	
	close(pipeM[0]);
	write(pipeM[1], &n, sizeof(n));
	write(pipeM[1], arr, n*sizeof(int));
	close(pipeM[1]);
	
	
	wait(NULL);
	wait(NULL);
	return 0;
}