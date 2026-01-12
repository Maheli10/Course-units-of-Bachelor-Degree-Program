public class Vehicle {
	String brand;
	int speed;
	
	void display() {
	System.out.println("Brand "+brand+" . Speed "+speed);
	}
}



class Car extends Vehicle {
	String model;


void display() {

System.out.println("Brand "+brand+" . Speed "+speed+" . Model "+model);
}

}
