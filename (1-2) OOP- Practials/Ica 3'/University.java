import java.util.*;

abstract class Staff{
	String name;
	Int staffId;
	String department;
	double salary;
	
	abstract void calculateSalary();
}

class PermenentStaff extends Staff{
	double basicSalary;
	double allowance;
	
	PermenentStaff(String name,int staffId, String department,
	double basicSalary,double allowance){
		this.name=name;
		this.staffID=staffID;
		this.department=department;
		this.basicSalary=basicSalary;
		this.allowance=allowance;
	}
	
	void calculateSalary(){
		salary=basicSalary+allowance;
	}
	
}

class TemporaryStaff extends Staff{
	double dailyWage;
	int workingDays;
	
	TemporaryStaff(String name,int staffID,String department,double dailyWage,
		int workingDays){
		this.name=name;
		this.staffID=staffID;
		this.department=department;
		this.dailyWage=dailyWage;
		this.workingDays=workingDays;
		}
	
	void calculateSalary(){
		salary=dailyWage*workingDays;
	}
	
}

class University{
	List<Staff>slist= new ArrayList<>();
	
	void addStaff(Staff s){
		slist.add(s);
	}
	
	
	void displaySalary(){
		for(Staff s: slist){
			s.calculateSalary();
			System.out.println("Salay of "+s.name+" is "+s.salary);
		}
	}
	
	
	static Staff createPStaff(){
		Scanner sc =new Scanner(System.in);
		String name,department;
		int staffID,basicSalary,allowance;
		
		System.out.println("Enter name: ");
		name=sc.nextLine();
		
		return new PermenentStaff(name,staffID);
	}
	
	
	public static void main(String[] args){
		Scanner sc1=new Scanner(System.in);
		
		
		Staff p1=new PermenentStaff();
		Staff p2=new PermenentStaff();
		
		Staff t1=new TemporaryStaff();
		Staff t2=new TemporaryStaff();
		
		
		addStaff(t1);
		addStaff.get(1).calculateSalary();
		displaySalary();
	}
	
}

char w;
do{System.out
	String str=sc1.nextLine();
	o=str.charAt(0);
	if(o=="P"){
		
	}
	
}