package BinaryTrees;

public class BalancedBinaryTree {
    // Method 1: not good, worst case me O(n^2)
    /*private static boolean isBalanced(Node root) {
        if(root == null) return true;
        int leftLevels = levels(root.left);
        int rightLevels = levels(root.right);

        if(Math.abs(leftLevels - rightLevels) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private static int levels(Node root){
        if(root == null) return 0;
        return 1 + Math.max(levels(root.left), levels(root.right));
    }*/

    // Method 2: good, worst case me v O(n)
    // O(n) DP based - since ham levels nikalne k time
    // har node ka levels nikal hi rhe hai recursively,
    // to kyu na usi ka fayda uthaye and wahi pe check kar le
    // ki kahi levels ka diff > 1 nahi hai na.

    /*static boolean flag;
    private static boolean isBalanced(Node root) {
        if(root == null) return true;
        flag = true;
        levels(root);
        return flag;
    }

    private static int levels(Node root){
        if(root == null) return 0;
        int leftLevels = levels(root.left);
        int rightLevels = levels(root.right);

        if(Math.abs(leftLevels - rightLevels) > 1) flag = false; // important line

        return 1 + Math.max(leftLevels, rightLevels);
    }*/

    // Method 3: same as 2 but used int instead of global variable
    private static boolean isBalanced(Node root) {
        if(root == null) return true;
        return levels(root) != -1;
    }

    private static int levels(Node root){
        if(root == null) return 0;

        int leftLevels = levels(root.left);
        if(leftLevels == -1) return -1;

        int rightLevels = levels(root.right);
        if(rightLevels == -1) return -1;

        if(Math.abs(leftLevels - rightLevels) > 1) return -1; // important line

        return 1 + Math.max(leftLevels, rightLevels);
    }

    public static void main(String[] args) {
        //         3
        //       /   \
        //      4     2
        //     / \    / \
        //   -1   1  6   9

        // agar ye attach kar denge to not Balanced
        //         \
        //          7
        //           \
        //            8

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

        // Node h = new Node(7);
        // e.right = h;
        // Node i = new Node(8);
        // h.right = i;

        System.out.println(isBalanced(a) ? "yes Balanced" : "not Balanced");
    }
}
