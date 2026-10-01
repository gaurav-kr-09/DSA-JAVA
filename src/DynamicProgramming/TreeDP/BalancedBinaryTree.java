package DynamicProgramming.TreeDP;

public class BalancedBinaryTree {
    // Method 1: not good, worst case me O(n^2) BASIC RECURSION
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

    // Method 1 ko memoize kar sakte hai levels store kar k
    /*private static boolean isBalanced(Node root) {
        Map<Node, Integer> dp = new HashMap<>();
        return check(root, dp);
    }

    private static boolean check(Node root, Map<Node, Integer> dp){
        if(root == null) return true;

        int leftLevels = levels(root.left, dp);
        int rightLevels = levels(root.right, dp);

        if(Math.abs(leftLevels - rightLevels) > 1) return false;
        return check(root.left, dp) && check(root.right, dp);
    }

    private static int levels(Node root, Map<Node, Integer> dp){
        if(root == null) return 0;

        if(dp.containsKey(root)) return dp.get(root);
        dp.put(root, 1 + Math.max(levels(root.left, dp), levels(root.right, dp)));

        return dp.get(root);
    }*/

    // Method 2: good, worst case me v O(n)
    // O(n) DP based - since ham levels nikalne k time
    // har node ka levels nikal hi rhe hai recursively,
    // to kyu na usi ka fayda uthaye and wahi pe check kar le
    // ki kahi levels ka diff > 1 nahi hai na.

    /*private static boolean flag;
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

        if(Math.abs(leftLevels - rightLevels) > 1) flag = false;

        return 1 + Math.max(leftLevels, rightLevels);
    }*/

    // Method 3: same as 2 but used int instead of global variable
    private static boolean isBalanced(Node root) {
        return levels(root) != -1;
    }

    private static int levels(Node root){
        if(root == null) return 0;

        int leftLevels = levels(root.left);
        if(leftLevels == -1) return -1;

        int rightLevels = levels(root.right);
        if(rightLevels == -1) return -1;

        if(Math.abs(leftLevels - rightLevels) > 1) return -1;

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

        System.out.println(isBalanced(root1)); // Expected: true


        //        1
        //       /
        //      2
        //     /
        //    3
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.left.left = new Node(3);

        System.out.println(isBalanced(root2)); // Expected: false


        // Single node
        Node root3 = new Node(1);

        System.out.println(isBalanced(root3)); // Expected: true


        // Empty tree
        System.out.println(isBalanced(null)); // Expected: true


        //         3
        //       /   \
        //      4     2
        //     / \   / \
        //   -1   1 6   9
        Node root4 = new Node(3);
        root4.left = new Node(4);
        root4.right = new Node(2);
        root4.left.left = new Node(-1);
        root4.left.right = new Node(1);
        root4.right.left = new Node(6);
        root4.right.right = new Node(9);

        System.out.println(isBalanced(root4)); // Expected: true


        //         3
        //       /   \
        //      4     2
        //     / \   / \
        //   -1   1 6   9
        //           \
        //            7
        //             \
        //              8
        Node root5 = new Node(3);
        root5.left = new Node(4);
        root5.right = new Node(2);
        root5.left.left = new Node(-1);
        root5.left.right = new Node(1);
        root5.right.left = new Node(6);
        root5.right.right = new Node(9);

        // Attach 7 and 8
        root5.left.right.right = new Node(7);
        root5.left.right.right.right = new Node(8);

        System.out.println(isBalanced(root5)); // Expected: false
    }
}
