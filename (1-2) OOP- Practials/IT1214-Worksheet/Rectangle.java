public class Rectangle{
	private int length;
	private int breadth;
	
	
Rectangle(){
	length=0;
	breadth=0;
}
Rectangle(int length, int breadth){
	this.length=length;
	this.breadth=breadth;
}

public int area(){
	return length*breadth;
}



}