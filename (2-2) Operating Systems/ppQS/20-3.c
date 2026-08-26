#include<stdio.h>
#include<stdlib.h>
#include<pthread.h>

void *binary(void *arg){

    int x = *(int *)arg;

    int bin[32];
    int i=0;

    while(x>0){
        bin[i] = x % 2;
        x = x / 2;
        i++;
    }

    printf("Binary: ");

    for(int j=i-1; j>=0; j--){
        printf("%d",bin[j]);
    }

    printf("\n");

    pthread_exit(NULL);
}

void *octal(void *arg){

    int x = *(int *)arg;

    printf("\nOctal: %o\n",x);

    pthread_exit(NULL);
}

int main(){

    int n1,n2;
    int max,min;

    pthread_t t1,t2;

    printf("Enter two numbers: ");
    scanf("%d %d",&n1,&n2);

    if(n1>n2){
        max=n1;
        min=n2;
    }
    else{
        max=n2;
        min=n1;
    }

    printf("Maximum = %d\n", max);
    printf("Minimum = %d\n", min);

    pthread_create(&t1,NULL,binary,&max);
    pthread_create(&t2,NULL,octal,&max);

    pthread_join(t1,NULL);
    pthread_join(t2,NULL);

    return 0;
}