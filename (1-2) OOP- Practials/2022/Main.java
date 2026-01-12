import java.util.*;

abstract class Person{
	private String name;
	private String city;
	
	Person(String name,String city){
		this.name= name;
		this.city=city;
		
	}
	
	public String getName(){
		return name;
	}
	
	public String getCity(){
		return city;
	}
	
	abstract void displayInfo();
	
	abstract int getTotalMarks();
	
}	
class Student extends Person{
String[] subject;
	int[] marks;
	String gender;
	int age;
	
	Student(String name,String city,String gender,int age,String[] subject,int[] marks){
		super(name,city);
		this.gender=gender;
		this.age=age;
		this.subject=subject;
		this.marks=marks;
		
	}
	
	public String[] getsubject(){
		return subject;
	}
	
	public int[] getmarks(){
		return marks;
	}
	
	@Override
	void displayInfo(){
		System.out.println("Student name: "+getName());
		System.out.println("Student age: "+age);
		System.out.println("Student gender: "+gender);
		System.out.println("Student city: "+getCity());
	}
	
	@Override
	
	int getTotalMarks(){
		System.out.println("aaaaa");
		return 55;
		//for(i=0; 0<=i<=100; i++){
			
		//}
	}
}

class Teacher extends Person{
	String subject;
	String gender;
	int age;
	
	Teacher(String name,String city,String gender, int age,String subject){
		super(name,city);
		
		this.gender=gender;
		this.age=age;
		this.subject=subject;
		
	}
	
	public String getsubject(){
		return subject;
	}
	
	@Override
	void displayInfo(){
		System.out.println("Student name: ");
		System.out.println("Student city: ");
		System.out.println("Student subject: ");
		
	}
	
	@Override
	
	int getTotalMarks(){
		System.out.println("aaaaa");
		return 55;
		//for(i=0; 0<=i<=100; i++){
			
		//}
	}
	
}

class Main{
	
	public static void main(String [] args){
		
	//Subject array
	String []subject={"Mathematics", "Physics", "Chemistry", "English"};

	
	//students object array	
	Student[] students={ 	
		
		new Student("Harry","Gryffindor","Male",15,subject,new int[]{}),
		new Student("Hermoine","Gryffindor","Female",14,subject,new int[]{}),
		new Student("Draco","Slytherin","Male",14,subject,new int[]{}),
		new Student("Luna","Ravenclaw","Female",16,subject,new int[]{}),
		new Student("Cedric","Hufflepuff","Male",17,subject,new int[]{}),
		new Student("Cho","Ravenclaw","Female",16,subject,new int[]{}),
		new Student("Gregory","Slytherin","Male",15,subject,new int[]{}),
		new Student("Wayne","Hufflepuff","Male",17,subject,new int[]{}),
	};
	
	//teacher object array
	Teacher[] teachers={
		new Teacher("McGonagall","Gryffindor","Female",54,"Chemistry"),
		new Teacher("Snape","Slytherin","Male",45,"English"),
		new Teacher("Sprout","Hufflepuff","Female",50,"Biology"),
		new Teacher("Flittwick","Ravenclaw","Male",40,"Mathematics")
	};
		
		for(Student s: students){
			/*if (s.gender.equalsIgnoreCase("Male") && s.age >= 17) {
                s.displayInfo();
                System.out.println();
            }*/
			 s.displayInfo();
			 System.out.println();
		}
	
	
		
		
	}
}
 

