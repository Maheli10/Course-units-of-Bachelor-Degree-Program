import java.util.*;
class Node{
    int data;
    Node left,right;

    Node(int data){
        data= data;
        left=right= null;
    }
}
public class Bfs{
    Node root;

    int height(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public void bfsTraversal(Node node){
        int h = height(node);
        for (int i = 1; i <= h; i++) {
            printLevel(node, i);
        }
    }

    void printLevel(Node node, int level) {
        if (node == null) return;
        if (level == 1) {
            System.out.print(node.data + " ");
        } else {
            printLevel(node.left, level - 1);
            printLevel(node.right, level - 1);
        }
    }

    public static void main(String [] args){
        //ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        Bfs bfs = new Bfs();
        bfs.root = new Node(1);
        bfs.root.left = new Node(2);
        bfs.root.right = new Node(3);
        bfs.root.left.left = new Node(4);
        bfs.root.left.right = new Node(5);
        bfs.root.right.left = new Node(6);
        bfs.root.right.right = new Node(7);

        System.out.println("BFS Traversal:");
        bfs.bfsTraversal(bfs.root);

    }
}