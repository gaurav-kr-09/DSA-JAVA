package DynamicProgramming.TreeDP;

import java.util.HashMap;
import java.util.Map;

public class DiameterOfBinaryTree {
    // Method 1 works but TC O(n^2)
    /*private static int diameter(Node root){
        if(root == null) return 0;
        
        int ownDia = levels(root.left) + levels(root.right); // root ko include kar k dia
        int leftDia = diameter(root.left); // left ka diameter
        int rightDia = diameter(root.right); // right ka diameter

        return Math.max(ownDia, Math.max(leftDia, rightDia));
    }

    private static int levels(Node root){
        if(root == null) return 0;
        return 1 + Math.max(levels(root.left), levels(root.right));
    }*/

    // nsq wale ko memoize karke better bana sakte hai
    /*private static int diameter(Node root){
        Map<Node, Integer> dp = new HashMap<>();
        return calDia(root, dp);
    }

    private static int calDia(Node root, Map<Node, Integer> dp) {
        if(root == null) return 0;

        int ownDia = levels(root.left, dp) + levels(root.right, dp);
        int leftDia = calDia(root.left, dp);
        int rightDia = calDia(root.right, dp);

        return Math.max(ownDia, Math.max(leftDia, rightDia));
    }

    private static int levels(Node root, Map<Node, Integer> dp){
        if(root == null) return 0;

        if(dp.containsKey(root)) return dp.get(root);
        dp.put(root, 1 + Math.max(levels(root.left, dp), levels(root.right, dp)));

        return dp.get(root);
    }*/

    // Most optimal
    private static int maxDia;
    private static int diameter(Node root){
        if(root == null) return 0;
        maxDia = 0;
        levels(root);
        return maxDia;
    }

    private static int levels(Node root){
        if(root == null) return 0;

        int leftLevels = levels(root.left);
        int rightLevels = levels(root.right);

        maxDia = Math.max(maxDia, leftLevels + rightLevels);
        return 1 + Math.max(leftLevels, rightLevels);
    }

    public static void main(String[] args) {
        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);

        System.out.println(diameter(root1)); // Expected: 3


        //        1
        //         \
        //          2
        //           \
        //            3
        //             \
        //              4
        Node root2 = new Node(1);
        root2.right = new Node(2);
        root2.right.right = new Node(3);
        root2.right.right.right = new Node(4);

        System.out.println(diameter(root2)); // Expected: 3


        // Single node
        Node root3 = new Node(1);

        System.out.println(diameter(root3)); // Expected: 0


        // Empty tree
        System.out.println(diameter(null)); // Expected: 0

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

        // Node h = new Node(7);
        // e.right = h;
        // Node i = new Node(8);
        // h.right = i;

        System.out.println(diameter(a)); // expected 4

        //         3
        //       /   \
        //      4     2
        //     / \    / \
        //   -1   1  6   9
        //         \
        //          7
        //           \
        //            8

        Node a1 = new Node(3);
        Node b1 = new Node(4);
        Node c1 = new Node(2);
        Node d1 = new Node(-1);
        Node e1 = new Node(1);
        Node f1 = new Node(6);
        Node g1 = new Node(9);
        Node h1 = new Node(7);
        Node i1 = new Node(8);

        a1.left = b1; a1.right = c1;
        b1.left = d1; b1.right = e1;
        c1.left = f1; c1.right = g1;
        e1.right = h1; h1.right = i1;

        System.out.println(diameter(a1)); // expected 6
    }
}