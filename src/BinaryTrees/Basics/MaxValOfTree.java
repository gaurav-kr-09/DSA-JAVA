package BinaryTrees.Basics;

public class MaxValOfTree {
    // root ka operation  do bar
    /*private static int maxVal(Node root){
        if(root == null) return Integer.MIN_VALUE;
        int leftMax = Math.max(root.val, maxVal(root.left));
        int rightMax = Math.max(root.val, maxVal(root.right));
        return Math.max(leftMax, rightMax);
    }*/

    // root ka operation  ek bar
    /*private static int maxVal(Node root){
        if(root == null) return Integer.MIN_VALUE;
        int leftAndRootMax = Math.max(root.val, maxVal(root.left));
        return Math.max(leftAndRootMax, maxVal(root.right));
    }*/

    // ek aur common tarika
    private static int maxVal(Node root){
        if(root == null) return Integer.MIN_VALUE;
        int leftMax = maxVal(root.left);
        int rightMax = maxVal(root.right);

        return Math.max(root.val,Math.max(leftMax, rightMax));
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

        System.out.println("the maximum value of node is: "+ maxVal(a)); // 9
    }
}
