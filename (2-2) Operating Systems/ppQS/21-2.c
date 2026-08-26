#include <stdio.h>
#include<pthread.h>

int num1,num2;

void *add(void *arg){
	printf("Addition = %d\n", num1 + num2);
	pthread_exit(NULL);
}

void *substract(void *arg){
	printf("Substraction = %d\n", num1 - num2);
	pthread_exit(NULL);
}

void *multiply(void *arg){
	printf("Multiplication = %d\n", num1 * num2);
	pthread_exit(NULL);
}

void *division(void *arg)
{
    if(num2 != 0)
        printf("Division = %.2f\n", (float)num1 / num2);
    else
        printf("Division not possible (divide by zero)\n");

    pthread_exit(NULL);
}

int main(){

pthread_t t1,t2,t3,t4;

printf("Enter 2 integers: ");
scanf("%d %d",&num1,&num2);

pthread_create(&t1,NULL,add,NULL);
pthread_create(&t2,NULL,substract,NULL);
pthread_create(&t3,NULL,multiply,NULL);
pthread_create(&t4,NULL,division,NULL);

pthread_join(t1,NULL);
pthread_join(t2,NULL);
pthread_join(t3,NULL);
pthread_join(t4,NULL);

return 0;

}