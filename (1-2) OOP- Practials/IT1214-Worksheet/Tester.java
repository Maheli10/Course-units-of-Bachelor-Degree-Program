public class Tester{
		public static void main(String[] args){
			
			Student student=new Student("John Doe",202501,"Information Technology");
			student.display();
			
	System.out.println();
			
			Rectangle rect1=new Rectangle();
			Rectangle rect2=new Rectangle(5,10);
			System.out.println("Area of rect2: "+rect2.area());

	System.out.println();
	
			Calculator calc = new Calculator();
			System.out.println("Add two integers: " + calc.add(2, 3));
			System.out.println("Add three integers: " + calc.add(2, 3, 4));
			System.out.println("Add two doubles: " + calc.add(2.5, 3.5));
			
	System.out.println();
	
			Car car=new Car();
			car.brand = "Toyota";
			car.speed = 120;
			car.model = "Corolla";
			car.display();
			
	System.out.println();
				
			BankAccount account = new BankAccount();
			account.deposit(5000);
			account.withdraw(1500);
			account.displayBalance();
	
	System.out.println();
	
			Book book1 = new Book("Java Basics", "Author A", 300.0);
			Book book2 = new Book("Python Essentials", "Author B");
			
		System.out.println();
		
			Circle circle = new Circle(5.0);
			circle.area();
	
	System.out.println();
	
			Person person = new Person();
			person.setName("Alice");
			person.setAge(25);
			System.out.println("Person Name: " + person.getName());
			System.out.println("Person Age: " + person.getAge());
	
	System.out.println();
		
			TemperatureConverter converter = new TemperatureConverter();
			System.out.println("30 Celsius to Fahrenheit: " + converter.toFahrenheit(30));
			System.out.println("86 Fahrenheit to Celsius: " + converter.toCelsius(86));
			
	System.out.println();
		
			Manager manager = new Manager("Bob", 201, 75000);
			manager.displayDetails();

		}
}