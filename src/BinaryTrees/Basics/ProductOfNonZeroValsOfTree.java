package BinaryTrees.Basics;

public class ProductOfNonZeroValsOfTree {
    // Isme tree ka value change ho jayega
    /*private static int productNonZero(Node root){
        if(root == null) return 1;
        root.val = (root.val == 0) ? 1: root.val;
        return root.val * productNonZero(root.left) * productNonZero(root.right);
    }*/

    // Isme tree ka value change nahi hoga
    private static int productNonZero(Node root){
        if(root == null) return 1;

        int leftProd = productNonZero(root.left);
        int rightProd = productNonZero(root.right);

        if(root.val == 0) return leftProd*rightProd;
        return root.val * leftProd * rightProd;
    }

    public static void main(String[] args) {
        //         3
        //       /   \
        //      4     0
        //     / \    / \
        //   -1   1  6   9

        Node a = new Node(3);
        Node b = new Node(4);
        Node c = new Node(0);
        Node d = new Node(-1);
        Node e = new Node(1);
        Node f = new Node(6);
        Node g = new Node(9);


        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = f; c.right = g;

        System.out.println("The product of all non zero values of nodes is: "+ productNonZero(a)); // -648
    }
}
