package BinaryTrees;

// CHECK KARO KI BINARY TREE FULL HAI YA NAHI, YANI KI SARE NODE KA YA TO DO CHILD HAI YA 0 CHILD HAI
// AKA PROPER BINARY TREE OR STRICT BINARY TREE
public class FullBinaryTree {
    private static boolean isFull(Node root) {
        if(root== null) return true;
        if((root.left != null && root.right == null) || (root.left == null && root.right != null)) return false;
        return isFull(root.left) && isFull(root.right);
    }

    public static void main(String[] args) {
        //         3
        //       /   \
        //      4     2
        //     / \    / \
        //   -1   1  6   9

        // agar ye attach kar denge to not full
        //         \
        //          7
        // Node h = new Node(7);
        // e.right = h;

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

        System.out.println(isFull(a) ? "yes full" : "not full");
    }
}
