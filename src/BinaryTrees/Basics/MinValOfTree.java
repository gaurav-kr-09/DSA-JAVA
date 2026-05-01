package BinaryTrees.Basics;

public class MinValOfTree {
    private static int minVal(Node root){
        if(root == null) return Integer.MAX_VALUE;
        int leftMax = minVal(root.left);
        int rightMax = minVal(root.right);

        return Math.min(root.val,Math.min(leftMax, rightMax));
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

        System.out.println("the minimum value of node is: "+ minVal(a)); // -1
    }
}
