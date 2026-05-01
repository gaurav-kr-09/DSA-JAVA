package BinaryTrees;

public class MinDistBetweenGivenNodesOfBinaryTree {
    // Method 1: two passes
    /*static int disA = 0, disB = 0;
    private static int findDist(Node root, int a, int b) {
        Node lcan = LCA(root, a, b);
        distance(lcan, a, b, 0);
        return disA + disB;
    }

    private static Node LCA(Node root, int a, int b){
        if(root == null || root.val == a || root.val == b) return root;
        Node l = LCA(root.left, a, b);
        Node r = LCA(root.right, a, b);

        if(l != null && r != null) return root;
        return (l == null) ? r : l;
    }

    // distance from lca using dfs
    private static void distance(Node root, int a, int b, int depth){
        if(root == null) return;
        if(root.val == a) disA = depth;
        if(root.val == b) disB = depth;

        distance(root.left, a, b, depth+1);
        distance(root.right, a, b, depth+1);
    }*/

    // Method 2: single pass
    static int disA = -1, disB = -1, lcaDepth = -1;
    private static int findDist(Node root, int a, int b) {
        LCA(root, a, b, 0);
        return disA + disB - 2 * lcaDepth;
    }

    private static Node LCA(Node root, int a, int b, int depth){
        if(root == null) return null;

        if(root.val == a) disA = depth;
        if(root.val == b) disB = depth;

        Node l = LCA(root.left, a, b, depth+1);
        Node r = LCA(root.right, a, b, depth+1);

        // root hi lca hai agar root hi ek node hai given node me se
        if(root.val == a || root.val == b){
            lcaDepth = depth;
            return root;
        }

        // root hi lca hai agar dono side ek ek mila to
        if(l != null && r != null){
            lcaDepth = depth;
            return root;
        }

        return (l == null) ? r : l;
    }
    
    public static void main(String[] args) {
        //         1
        //       /   \
        //      2     3
        //     / \    / \
        //    4   5  6   7
        //         \
        //          8
        //           \
        //            9

        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);


        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = f; c.right = g;

        Node h = new Node(8);
        e.right = h;
        Node i = new Node(9);
        h.right = i;

        System.out.println("Distance bw 4 and 5 is: "+ findDist(a, 4, 5)); // 2
        System.out.println("Distance bw 9 and 7 is: "+ findDist(a, 9, 7)); // 6
        System.out.println("Distance bw 6 and 4 is: "+ findDist(a, 6, 4)); // 4
    }
}