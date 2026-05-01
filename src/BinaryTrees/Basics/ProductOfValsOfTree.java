package BinaryTrees.Basics;

public class ProductOfValsOfTree {
    private static int product(Node root){
        if(root == null) return 1;
        return root.val * product(root.left) * product(root.right);
    }

    public static void main(String[] args) {
        //         3
        //       /   \
        //      4     2
        //     / \    / \
        //   -1   1  6   9

        Node a = new Node(3);
        Node b = new Node(4);
        Node c = new Node(2);
        Node d = new Node(-1);
        Node e = new Node(1);
        Node f = new Node(6);
        Node g = new Node(9);


        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = f; c.right = g;

        // g.left = new Node(0);  // agar ye laga denge to 0

        System.out.println("The product of all values of nodes is: "+ product(a)); // -1296
    }
}
