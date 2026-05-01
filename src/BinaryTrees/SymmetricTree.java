package BinaryTrees;

public class SymmetricTree {
    // method -1, 3 steps
    /*private static boolean isSymmetric(Node root){
        mirror(root.left);
        return isSame(root.left, root.right);
    }

    private static void mirror(Node root){
        if(root == null) return;

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirror(root.left);
        mirror(root.right);
    }

    private static boolean isSame(Node r1, Node r2){
        if(r1 == null && r2 == null) return true;
        if(r1 == null || r2 == null) return false;
        if(r1.val!= r2.val) return false;

        return isSame(r1.left, r2.left) && isSame(r1.right, r2.right);
    }*/

    // Method -2: 1 step
    private static boolean isSymmetric(Node root){
        if(root == null) return true;
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(Node r1, Node r2){
        if(r1 == null && r2 == null) return true;
        if(r1 == null || r2 == null) return false;
        if(r1.val != r2.val) return false;

        return isMirror(r1.left, r2.right) && isMirror(r1.right, r2.left);
    }

    public static void main(String[] args) {
        //         3
        //       /   \
        //      4     4
        //     / \    / \
        //   -1   1  1   -1

        Node a = new Node(3);
        Node b = new Node(4);
        Node c = new Node(4);
        Node d = new Node(-1);
        Node e = new Node(1);
        Node f = new Node(1);
        Node g = new Node(-1);


        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = f; c.right = g;

        System.out.println(isSymmetric(a) ? "symmetric tree" : "not symmetric");
    }
}