#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>

int main()
{
    pid_t f1, f2;

    int pipeA[2];
    int pipeB[2];
    int pipeC[2];

    pipe(pipeA);
    pipe(pipeB);
    pipe(pipeC);

    int N;
    float avg;

    printf("Enter the number of integers: ");
    scanf("%d", &N);

    int arr[N];

    printf("Enter the values: ");
    for (int i = 0; i < N; i++)
    {
        scanf("%d", &arr[i]);
    }

    f1 = fork();

    /* CHILD PROCESS */
    if (f1 == 0)
    {
        int N;
        int sum = 0;

        close(pipeA[1]);

        read(pipeA[0], &N, sizeof(N));

        int arr[N];
        read(pipeA[0], arr, N * sizeof(int));

        close(pipeA[0]);

        for (int i = 0; i < N; i++)
        {
            sum += arr[i];
        }

        printf("\n[CHILD PROCESS]\n");
        printf("PID = %d, PPID = %d\n", getpid(), getppid());
        printf("Calculated Sum = %d\n", sum);

        f2 = fork();

        /* GRANDCHILD PROCESS */
        if (f2 == 0)
        {
            int N;
            int sum;
            float avg;

            close(pipeB[1]);

            read(pipeB[0], &N, sizeof(N));
            read(pipeB[0], &sum, sizeof(sum));

            close(pipeB[0]);

            avg = (float)sum / N;

            close(pipeC[0]);

            write(pipeC[1], &avg, sizeof(avg));

            close(pipeC[1]);

            printf("\n[GRANDCHILD PROCESS]\n");
            printf("PID = %d, PPID = %d\n", getpid(), getppid());
            printf("Calculated Average = %.2f\n", avg);

            exit(0);
        }

        /* CHILD sends N and SUM to GRANDCHILD */
        close(pipeB[0]);

        write(pipeB[1], &N, sizeof(N));
        write(pipeB[1], &sum, sizeof(sum));

        close(pipeB[1]);

        wait(NULL);

        exit(0);
    }

    /* PARENT PROCESS */

    close(pipeA[0]);

    write(pipeA[1], &N, sizeof(N));
    write(pipeA[1], arr, N * sizeof(int));

    close(pipeA[1]);

    close(pipeC[1]);

    read(pipeC[0], &avg, sizeof(avg));

    close(pipeC[0]);

    printf("\n[PARENT PROCESS]\n");
    printf("PID = %d, PPID = %d\n", getpid(), getppid());
    printf("Received Average = %.2f\n", avg);

    wait(NULL);

    return 0;
}