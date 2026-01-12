import java.util.*;

public class bfsTraversal
{
	static ArrayList <Integer> bfs (ArrayList<ArrayList<Integer>>adj)
	{
		int V= adj.size();
		boolean [] visited= new boolean[V];
		ArrayList <Integer> res = new ArrayList<>();
		Queue  <Integer> q= new LinkedList<>();
		
		
		int src= 0;
		//TODO: mark src as visited
		//TODO: Add src to queue
		
		while (!q.isEmpty())
		{
			//TODO: removew a node from queue
			//TODO: Add it to result,check all neighbours of this code
			//if neighbour not visited mark and add to queue
			
		}
		
		return res;
		
	}
	
	static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v)
	{
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	
	public static void main(String [] ars)
	{}
}