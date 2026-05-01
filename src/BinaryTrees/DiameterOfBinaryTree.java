package BinaryTrees;

public class DiameterOfBinaryTree {
    // Galat approach - ye fail kar jayega jab
    // ek hi side me mil jaye sabse lamba route bina dusre side gaye
    // i.e. Diameter may or may not pass through root
    /*private static int diameter(Node root){
        if(root == null) return 0;
        return levels(root.left) + levels(root.right);
    }

    private static int levels(Node root){
        if(root == null) return 0;
        return 1 + Math.max(levels(root.left), levels(root.right));
    }*/

    // Method 1 works but TC O(n^2)
    /*private static int diameter(Node root){
        if(root == null) return 0;

        int ownDia = levels(root.left) + levels(root.right);
        int leftDia = diameter(root.left);
        int rightDia = diameter(root.right);

        return Math.max(ownDia, Math.max(leftDia, rightDia));
    }

    private static int levels(Node root){
        if(root == null) return 0;
        return 1 + Math.max(levels(root.left), levels(root.right));
    }*/

    // method 1 optimized TC O(n)
    static int maxDia = 0;
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
        //         3
        //       /   \
        //      4     2
        //     / \    / \
        //   -1   1  6   9

        // abhi diameter 4 hai

        // agar ye attach kar denge to diameter 6
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

        System.out.println("Diameter is: "+ diameter(a));
    }
}