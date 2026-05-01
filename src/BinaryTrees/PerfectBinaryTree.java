package BinaryTrees;

public class PerfectBinaryTree {
    private static boolean isPerfect(Node root) {
        int levels = levels(root);
        int reqSize = (int) Math.pow(2, levels) - 1;

        return size(root) == reqSize;
    }

    private static int levels(Node root){
        if(root == null) return 0;
        return 1 + Math.max(levels(root.left), levels(root.right));
    }

    private static int size(Node root){
        if(root == null) return 0;
        return 1 + size(root.left) + size(root.right);
    }

    public static void main(String[] args) {
        //         3
        //       /   \
        //      4     2
        //     / \    / \
        //   -1   1  6   9

        // agar ye attach kar denge to not perfect
        //         \
        //          7

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

        System.out.println(isPerfect(a) ? "yes perfect" : "not perfect");
    }
}
