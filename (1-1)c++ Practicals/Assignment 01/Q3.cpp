#include <iostream>
using namespace std;

int main() {
    int num1, num2;

    // Input two integers
    cout << "Enter the first integer: ";
    cin >> num1;
    cout << "Enter the second integer: ";
    cin >> num2;

    // Perform arithmetic operations and display results
    cout << "Sum: " << num1 + num2 << endl;
    cout << "Difference: " << num1 - num2 << endl;
    cout << "Product: " << num1 * num2 << endl;

    // Check for division by zero
    if (num2 != 0) {
        cout << "Quotient: " << num1 / num2 << endl;
        cout << "Modulus: " << num1 % num2 << endl;
    } else {
        cout << "Error: Division by zero is not allowed." << endl;
    }

    return 0;
}
