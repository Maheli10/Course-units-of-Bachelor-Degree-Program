//check if 2 trees are identical

class Node{
	int value;
	Node left,right;
	
	Node(int value)
	{
		this.value= value;
		left= right= null;
	}
}
class Identical
{
	
	Node root;
	Identical()
	{root= null;}
	
	boolean areIdentical (Node r1,Node r2)
	{
		if(r1== null && r2==null)
			return true;
		if(r1== null || r2==null)
			return false;
		return (r1.value ==r2.value)&& areIdentical(r1.left,r2.left)&&
			areIdentical(r1.right,r2.right);
	}
	
	
	public static void main(String [] args)
	{
		Identical tree = new Identical();
		
		
		Node r1 = new Node(10);
		r1.left = new Node(5);
		r1.right = new Node(2);
		
		Node r2 = new Node(10);
		r2.left = new Node(5);
		r2.right = new Node(2);
		
		System.out.println("Are the trees idntical : "+ tree.areIdentical(r1,r2));
		
	}
}