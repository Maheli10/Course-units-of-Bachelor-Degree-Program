//find the maximum and minimum element in a given binary tree
import java.util.*;

class Node{
	int value;
	Node left,right;
	
	
	Node(int value)
	{
		this.value= value;
		left= right= null;
	}

}
class MinMax
{
	Node root;
	MinMax()
	{root= null;}
	
	public int findMax()
	{
		Node current = root;
		while(current.right != null)
		current= current.right;
		return current.value;
	}
	
	public int findMin()
	{
		Node current = root;
		while(current.left != null)
		current= current.left;
		return current.value;
	}
	
	public static void main(String [] args)
	{
		MinMax tree = new MinMax();
		
		//create nodes manually
		tree.root = new Node(15);
		tree.root.left = new Node(5);
		tree.root.right = new Node(20);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(5);
		
		System.out.println("Tree created succcessfully");
		System.out.println("Max : "+tree.findMax());
		System.out.println("Min : "+tree.findMin());
	}
}