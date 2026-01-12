#include <iostream>
using namespace std;

int main() {
    // Define the gravitational constant as a constant variable
    const double gravity = 9.81; // gravitational constant in m/s^2

    // Declare a variable to hold the mass
    double mass;

    // Ask the user to input the mass in kilograms
    cout << "Enter the mass of the object in kilograms: ";
    cin >> mass;

    // Calculate the weight using the formula: Weight = mass × gravity
    double weight = mass * gravity;

    // Display the calculated weight
    cout << "The weight of the object on Earth is: " << weight << " newtons" << endl;

    return 0;
}
