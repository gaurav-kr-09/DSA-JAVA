package DynamicProgramming.TreeDP;

public class BinaryTreeMaximumPathSum {
    private static int maxSum;
    // Ye sahi v hai and LC pe pas v kar jayega but
    // when root is nul tab ye -INF de dega
    /*private static int maxPathSum(Node root) {
        maxSum = Integer.MIN_VALUE;
        findSum(root);
        return maxSum;
    }*/

    private static int maxPathSum(Node root) {
        maxSum = Integer.MIN_VALUE;
        findSum(root);
        return maxSum == Integer.MIN_VALUE ? 0 : maxSum;
    }

    private static int findSum(Node root){
        if(root == null) return 0;

        int lSum = findSum(root.left); // leftSum
        int rSum = findSum(root.right); // rightSum

        int throughRoot  = lSum + rSum + root.val; // C1: niche hi achha sum mil gaya
        int oneSide = Math.max(lSum, rSum) + root.val; // C2: koi ek better kar rha hai sum ko
        int rootOnly = root.val; // C3: dono -ve hai to sirf root

        // max wale me tino consider hoga
        maxSum = Math.max(maxSum, Math.max(throughRoot , Math.max(oneSide, rootOnly)));

        // return sirf case 2 and 3 ko for valid path
        return Math.max(oneSide, rootOnly);
    }

    public static void main(String[] args) {
        //        1
        //       / \
        //      2   3
        //
        // Expected: 6
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);

        System.out.println(maxPathSum(root1)); // 6


        //        -10
        //        / \
        //       9  20
        //          / \
        //         15  7
        //
        // Expected: 42
        Node root2 = new Node(-10);
        root2.left = new Node(9);
        root2.right = new Node(20);
        root2.right.left = new Node(15);
        root2.right.right = new Node(7);

        System.out.println(maxPathSum(root2)); // 42


        // Single negative node
        Node root3 = new Node(-3);

        System.out.println(maxPathSum(root3)); // -3


        // All negative
        //
        //       -10
        //       / \
        //     -20  -3
        Node root4 = new Node(-10);
        root4.left = new Node(-20);
        root4.right = new Node(-3);

        System.out.println(maxPathSum(root4)); // -3


        // Empty tree
        // LeetCode constraints normally guarantee at least one node,
        // but this handles it safely.
        System.out.println(maxPathSum(null)); // 0
    }
}