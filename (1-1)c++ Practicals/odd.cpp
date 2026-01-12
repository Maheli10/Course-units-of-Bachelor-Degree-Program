#include <iostream>
using namespace std;

void oddd(int arr[], int oddd[], int &co)
{
    for (int i = 0; i < 10; i++)
    {
        if (arr[i] % 2 != 0)
        {
            oddd[co] = arr[i];
            co++;
        }
    }
}

void evenn(int arr[], int evenn[], int &ce)
{
    for (int i = 0; i < 10; i++)
    {
        if (arr[i] % 2 == 0)
        {
            evenn[ce] = arr[i];
            ce++;
        }
    }
}

void display(int arr[], int n, string title)
{
    cout << title << " numbers: ";
    for (int i = 0; i < n; i++) // Iterate only up to the count of elements
    {
        cout << arr[i] << " ";
    }
    cout << endl;
}

int main()
{
    int arr[10] = {500, 409, 205, 202, 305, 204, 200, 150, 155, 245};
    int d1[10], d2[10];
    int co = 0, ce = 0;

    oddd(arr, d1, co);
    evenn(arr, d2, ce);

    display(d1, co, "Odd");
    display(d2, ce, "Even");

    return 0;
}
