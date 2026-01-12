import java.util.*;

class Person
{
	String name;
	int age;
	String city;

	Person(String name,int age,String city)
	{
		this.name=name;
		this.age=age;
		this.city=city;
	}
	
	@Override
	public String toString(){
		return name+"("+age+","+city +")";
		
	}
}
public class undirectedGraph{
	//create graph: each vertex has a list of Person objects it's connected toString
	
	static ArrayList<ArrayList<Person>> createGraph(ArrayList<Person> vertices, int[][] edges)
	ArrayList<ArrayList<Person>> adj= new ArrayList<>();
	//create empty list for each vertex
	for(int i=[0; i<vertices; i++){
		adj.add(new ArrayList<>());
	}
	
	//add
	for(int i=0; i<edges.length; i++){
		adj.add(new ArrayList<>());
	}
	
	
	
	
	
	
	
	
	
	/*public int[] [] adjMatrix;
	public int numVertices;
	
	public undirectedGraph(int numVertices)
	{
		this.numVertices= numVertices;
		adjMatrix = new int [numVertices][numVertices];
	}
	
	public void addEdge(int i , int j){
		if(i>=0 && i<numVertices && j>=0 && j<numVertices){
			adjMatrix [i][j]= 1;
			adjMatrix [i][j]= 1;
		}
	}
	
	public void removeEdge (int i, int j){
        if(i>=0 && i<numVertices && j>=0 && j<numVertices){
            adjMatrix[i][j] = 0;
            adjMatrix[i][j] = 0;
        }
    }
	
	public void displayMatrix(){
		System.out.println("--Graph--");
		
		for (int i=0; i<numVertices; i++){
			for (int j=0; j<numVertices; j++){
				System.out.print(adjMatrix[i][j]+", ");
			}
			System.out.println();
		}
	}*/
	
	public static void main(String[] args)
	{
		
		Person b= new Person("Bala",25,"Jaffna");
		Person a= new Person("Kumar",23,"Vavuniya");
		Person c= new Person("Perera",22,"Colombo");
		Person d= new Person("Silva",24,"Galle");
		
		vertices.add(a);
		vertices.add(b);
		vertices.add(b);
		vertices.add(c);
		
		//3:define edged between vertics using indices
		int [][] edges={
			{0,1}, //kumar-bala
			{0,2}, //kumar-prera
			{1,3},//bala- silva
			{2,3}// perera - silva
		};
		
		//create adjcency list
		ArrayList<ArrayList<Person>>adj = createGraph(vertices, edges);
		
		//5: display the graph
		for (int i=0; i<vertices.size; i++){
			System.out.print(vertices.get(i)+"->");
			for(Person p: adj.get(i)){
				System.out.print(p+" ");
			}
			System.out.println();
		}
	}
	
	
}