import java.util.ArrayList;

class Person{
	String name;
	int age;
	String city;
	Arraylist<Person>children;
	

	Person(String name,int age,String city)
	{
		this.name=name;
		this.age=age;
		this.city=city;
	}
	
	void addChild(person child)
	{
		//add child to the children list
	}
	
	
	@Override
	public String toString(){
		return name+"("+age+","+city +")";
		
	}
}

public class TreeObjects
{
	//recursve method to display tree structure
	
	ststic void displayTree(person root, String indent){
		//print the current node
		//recursively dispaly each child with increased indentation
		
	}
	
	public static void main(Strin[] args)
	{
		//step 1: create person objects(tree nodes)
		
		//step 2: build the tree structure
		
		//step 3: display the tree
	}
}