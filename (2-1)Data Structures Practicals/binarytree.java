class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

class binarytree {

    int findmin(Node node) {
        if (node == null)
            return Integer.MAX_VALUE;  // return big number so it won't affect minimum

        int leftMin = findmin(node.left);
        int rightMin = findmin(node.right);

        return Math.min(node.data, Math.min(leftMin, rightMin));
    }

    void preTraversal(Node node) {
        if (node == null)
            return;
        System.out.println(node.data);
        preTraversal(node.left);
        preTraversal(node.right);
    }

    void postTraversal(Node node) {
        if (node == null)
            return;
        postTraversal(node.left);
        postTraversal(node.right);
        System.out.println(node.data);
    }

    void intraversal(Node node) {
        if (node == null)
            return;
        intraversal(node.left);
        System.out.println(node.data);
        intraversal(node.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.right = new Node(2);
        root.left = new Node(3);
        root.right.right = new Node(4);
        root.right.left = new Node(5);

        binarytree tree1 = new binarytree();

        System.out.println("Preorder:");
        tree1.preTraversal(root);

        int minimum = tree1.findmin(root);
        System.out.println("Minimum value in the tree = " + minimum);
    }
}
