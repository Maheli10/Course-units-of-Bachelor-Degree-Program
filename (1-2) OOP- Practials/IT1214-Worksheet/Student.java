 public class Student{
	private String name;
	private int regNo;
	private String course;
	
	Student(String name,int regNo,String course){
	this.name=name;
	this.regNo=regNo;
	this.course=course;}
	
	public String getName(){
		return name;}
	public void setName(String name){
		this.name=name;
	}
	
	public int getRegNo(){
		return regNo;}
	public void setRollno(int regNo){
		this.regNo=regNo;
	}
	
	public String getCourse(){
		return course;}
	public void setCourse(String course){
		this.course=course;
	}
		
	public void display(){
		System.out.println("The name of the student : "+name);
		System.out.println("The regNo of the student : "+regNo);
		System.out.println("The course of the student : "+course);
	}
}
	
