class Employee {
	String name;
	int id;
	double salary;


Employee(String name, int id, double salary) {
	this.name=name;
	this.id=id;
	this.salary=salary;
}
void displayDetails() {
System.out.println("Employee name : "+name);
System.out.println("Employee id: "+id);
System.out.println("Employee salary : "+salary);
}
}
class Manager extends Employee {
Manager(String name, int id, double salary) {
super(name, id, salary);
}

void displayDetails() {
super.displayDetails();
double bonus=0.1*salary;
System.out.println("Bonus: "+bonus);
}
}