#include <iostream>
using namespace std;

int main() {
    int a, b;

    // Asking the user to enter two values
    cout << "Enter the first value (a): ";
    cin >> a;
    cout << "Enter the second value (b): ";
    cin >> b;

    // Displaying values before the swap
    cout << "Before swap:" << endl;
    cout << "a = " << a << ", b = " << b << endl;

    // Swapping the values without using a third variable
    a = a + b;
    b = a - b;
    a = a - b;

    // Displaying values after the swap
    cout << "After swap:" << endl;
    cout << "a = " << a << ", b = " << b << endl;

    return 0;
}
