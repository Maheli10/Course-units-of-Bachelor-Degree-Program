class Shape {
	void area() {
		System.out.println("Area not defined");
				}
			}
			
class Circle extends Shape {
	double radius;
	
	Circle(double radius) {
	this.radius = radius;}


void area() {
	double area=3.14*radius*radius;
	System.out.println("Area of circle "+area);
}
}

