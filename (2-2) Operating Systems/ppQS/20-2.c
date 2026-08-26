#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/wait.h>

int main(){
	pid_t fb,fc,fd,fe,ff,fg;
	int n;
	
	int pAB[2] , pAC[2];
	int pBD[2] , pBE[2];
	int pCF[2] , pCG[2];
	
	pipe(pAB);
	pipe(pAC);
	pipe(pBD);
	pipe(pBE);
	pipe(pCF);
	pipe(pCG);
	
	printf("Enter number: ");
	scanf("%d",&n);
	printf("\n");
	
	int arr[100];
	for(int i=0; i<100; i++){
		arr[i]= n+i;
	}
	
	
	
	printf("A: Process ID- %d and Parent Process ID- %d\n",getpid(),getppid());
		
	fb= fork();
	if(fb==0){
		int arrB[100];
		
		close(pAB[1]);
		read(pAB[0], arrB , sizeof(arrB));
		close(pAB[0]);
		
		int arrEven[50];
		int k=0;

		for(int i=0;i<100;i++){
			if(arrB[i]%2==0){
				arrEven[k++] = arrB[i];
			}
		}
		printf("Even numbers:\n");

		for(int i=0;i<k;i++){
			printf("%d ", arrEven[i]);
		}
		printf("\n");
			
		fd= fork();
		if(fd==0){
			
			int arrEven[50];
		
			close(pBD[1]);
			read(pBD[0], arrEven , sizeof(arrEven));
			close(pBD[0]);
			
			int sum=0;
			for(int i=0; i<50; i++){
				sum+=arrEven[i];
			}
			printf("\n summation of even numbers received from process B: %d\n",sum);
			printf("D: Process ID- %d and Parent Process ID- %d\n",getpid(),getppid());
			exit(0);
		}
		
		fe= fork();
		if(fe==0){
			
			int arrEven[50];
		
			close(pBE[1]);
			read(pBE[0], arrEven , sizeof(arrEven));
			close(pBE[0]);
			
			int max=0;
			for(int i=0; i<50; i++){
				if(max<arrEven[i]){
					max= arrEven[i];
				}
			}
			
			printf("\n maximum of even numbers received from process B: %d\n",max);
			
			printf("E: Process ID- %d and Parent Process ID- %d\n",getpid(),getppid());
			exit(0);
		}
		
		close(pBD[0]);
		write(pBD[1], arrEven , sizeof(arrEven));
		close(pBD[1]);
		
		close(pBE[0]);
		write(pBE[1], arrEven, sizeof(arrEven));
		close(pBE[1]);
	
		wait(NULL);
		wait(NULL);
		
		printf("B: Process ID- %d and Parent Process ID- %d\n",getpid(),getppid());
		exit(0);
	}
	
	fc= fork();
	if(fc==0){
		int arrC[100];
			
		close(pAC[1]);
		read(pAC[0], arrC , sizeof(arrC));
		close(pAC[0]);
		
		int arrOdd[50];
		int k=0;
		for(int i=0; i<100; i++){
			if(arrC[i]%2==1){
				arrOdd[k++]= arrC[i];
			}
		}
		
		printf("Odd numbers:\n");

		for(int i=0;i<k;i++){
			printf("%d ", arrOdd[i]);
		}
		printf("\n");
		
		ff= fork();
		if(ff==0){
			
			int arrOdd[50];
		
			close(pCF[1]);
			read(pCF[0], arrOdd , sizeof(arrOdd));
			close(pCF[0]);
			
			int sum=0;
			for(int i=0; i<50; i++){
				sum+=arrOdd[i];
			}
			
			printf("\n summation of odd numbers received from process C: %d\n",sum);
			printf("F: Process ID- %d and Parent Process ID- %d\n",getpid(),getppid());
			exit(0);
		}
		
		fg= fork();
		if(fg==0){
			int arrOdd[50];
		
			close(pCG[1]);
			read(pCG[0], arrOdd , sizeof(arrOdd));
			close(pCG[0]);
			
			int min= arrOdd[0];
			for(int i=1;i<50;i++){
				if(arrOdd[i] < min){
					min = arrOdd[i];
				}
			}
			
			printf("\n minimum of odd numbers received from process C: %d\n",min);
			
			printf("G: Process ID- %d and Parent Process ID- %d\n",getpid(),getppid());
			exit(0);
		}
		
		close(pCF[0]);
		write(pCF[1], arrOdd , sizeof(arrOdd));
		close(pCF[1]);
		
		close(pCG[0]);
		write(pCG[1], arrOdd, sizeof(arrOdd));
		close(pCG[1]);
		
		wait(NULL);
		wait(NULL);
	
		printf("C: Process ID- %d and Parent Process ID- %d\n",getpid(),getppid());
		exit(0);
	}
	
	close(pAB[0]);
	write(pAB[1], arr , sizeof(arr));
	close(pAB[1]);
	
	close(pAC[0]);
	write(pAC[1], arr , sizeof(arr));
	close(pAC[1]);
	
	wait(NULL);
	wait(NULL);
	return 0;
}

/* 
#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/wait.h>

int main(){
    pid_t fb,fc,fd,fe,ff,fg;
    int n;

    int pAB[2] , pAC[2];
    int pBD[2] , pBE[2];
    int pCF[2] , pCG[2];

    if(pipe(pAB)==-1 || pipe(pAC)==-1 || pipe(pBD)==-1 ||
       pipe(pBE)==-1 || pipe(pCF)==-1 || pipe(pCG)==-1){
        perror("Pipe creation failed");
        exit(1);
    }

    printf("Enter number: ");
    scanf("%d",&n);
    printf("\n");

    int arr[100];
    for(int i=0; i<100; i++){
        arr[i]= n+i;
    }

    printf("A: Process ID- %d and Parent Process ID- %d\n",
           getpid(),getppid());

    fb= fork();

    if(fb<0){
        perror("Fork failed");
        exit(1);
    }

    if(fb==0){

        int arrB[100];

        close(pAB[1]);

        if(read(pAB[0], arrB , sizeof(arrB))==-1){
            perror("Read failed");
            exit(1);
        }

        close(pAB[0]);

        int arrEven[50];
        int k=0;

        for(int i=0;i<100;i++){
            if(arrB[i]%2==0){
                arrEven[k++] = arrB[i];
            }
        }

        printf("Even numbers:\n");

        for(int i=0;i<k;i++){
            printf("%d ", arrEven[i]);
        }
        printf("\n");

        fd= fork();

        if(fd<0){
            perror("Fork failed");
            exit(1);
        }

        if(fd==0){

            int arrEven[50];

            close(pBD[1]);

            if(read(pBD[0], arrEven , sizeof(arrEven))==-1){
                perror("Read failed");
                exit(1);
            }

            close(pBD[0]);

            int sum=0;

            for(int i=0; i<50; i++){
                sum+=arrEven[i];
            }

            printf("\nSummation of even numbers received from process B: %d\n",sum);
            printf("D: Process ID- %d and Parent Process ID- %d\n",
                   getpid(),getppid());

            exit(0);
        }

        fe= fork();

        if(fe<0){
            perror("Fork failed");
            exit(1);
        }

        if(fe==0){

            int arrEven[50];

            close(pBE[1]);

            if(read(pBE[0], arrEven , sizeof(arrEven))==-1){
                perror("Read failed");
                exit(1);
            }

            close(pBE[0]);

            int max = arrEven[0];

            for(int i=1; i<50; i++){
                if(max < arrEven[i]){
                    max = arrEven[i];
                }
            }

            printf("\nMaximum of even numbers received from process B: %d\n",max);

            printf("E: Process ID- %d and Parent Process ID- %d\n",
                   getpid(),getppid());

            exit(0);
        }

        close(pBD[0]);

        if(write(pBD[1], arrEven , sizeof(arrEven))==-1){
            perror("Write failed");
            exit(1);
        }

        close(pBD[1]);

        close(pBE[0]);

        if(write(pBE[1], arrEven, sizeof(arrEven))==-1){
            perror("Write failed");
            exit(1);
        }

        close(pBE[1]);

        wait(NULL);
        wait(NULL);

        printf("B: Process ID- %d and Parent Process ID- %d\n",
               getpid(),getppid());

        exit(0);
    }

    fc= fork();

    if(fc<0){
        perror("Fork failed");
        exit(1);
    }

    if(fc==0){

        int arrC[100];

        close(pAC[1]);

        if(read(pAC[0], arrC , sizeof(arrC))==-1){
            perror("Read failed");
            exit(1);
        }

        close(pAC[0]);

        int arrOdd[50];
        int k=0;

        for(int i=0; i<100; i++){
            if(arrC[i] % 2 != 0){
                arrOdd[k++] = arrC[i];
            }
        }

        printf("Odd numbers:\n");

        for(int i=0;i<k;i++){
            printf("%d ", arrOdd[i]);
        }

        printf("\n");

        ff= fork();

        if(ff<0){
            perror("Fork failed");
            exit(1);
        }

        if(ff==0){

            int arrOdd[50];

            close(pCF[1]);

            if(read(pCF[0], arrOdd , sizeof(arrOdd))==-1){
                perror("Read failed");
                exit(1);
            }

            close(pCF[0]);

            int sum=0;

            for(int i=0; i<50; i++){
                sum+=arrOdd[i];
            }

            printf("\nSummation of odd numbers received from process C: %d\n",sum);

            printf("F: Process ID- %d and Parent Process ID- %d\n",
                   getpid(),getppid());

            exit(0);
        }

        fg= fork();

        if(fg<0){
            perror("Fork failed");
            exit(1);
        }

        if(fg==0){

            int arrOdd[50];

            close(pCG[1]);

            if(read(pCG[0], arrOdd , sizeof(arrOdd))==-1){
                perror("Read failed");
                exit(1);
            }

            close(pCG[0]);

            int min= arrOdd[0];

            for(int i=1;i<50;i++){
                if(arrOdd[i] < min){
                    min = arrOdd[i];
                }
            }

            printf("\nMinimum of odd numbers received from process C: %d\n",min);

            printf("G: Process ID- %d and Parent Process ID- %d\n",
                   getpid(),getppid());

            exit(0);
        }

        close(pCF[0]);

        if(write(pCF[1], arrOdd , sizeof(arrOdd))==-1){
            perror("Write failed");
            exit(1);
        }

        close(pCF[1]);

        close(pCG[0]);

        if(write(pCG[1], arrOdd, sizeof(arrOdd))==-1){
            perror("Write failed");
            exit(1);
        }

        close(pCG[1]);

        wait(NULL);
        wait(NULL);

        printf("C: Process ID- %d and Parent Process ID- %d\n",
               getpid(),getppid());

        exit(0);
    }

    close(pAB[0]);

    if(write(pAB[1], arr , sizeof(arr))==-1){
        perror("Write failed");
        exit(1);
    }

    close(pAB[1]);

    close(pAC[0]);

    if(write(pAC[1], arr , sizeof(arr))==-1){
        perror("Write failed");
        exit(1);
    }

    close(pAC[1]);

    wait(NULL);
    wait(NULL);

    return 0;
}
*/