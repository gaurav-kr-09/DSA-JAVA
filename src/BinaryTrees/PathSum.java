package BinaryTrees;

public class PathSum {
    private static boolean hasPathSum(Node root, int target){
        // null tak chale gaye and path nhi mila matlab no path
        if(root == null) return false;

        // agar leaf node hai to target - val = 0 hona chahiye i.e target = val
        if(root.left == null && root.right == null) return target == root.val;

        return hasPathSum(root.left, target - root.val) || hasPathSum(root.right, target - root.val);
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

        int target = 11; // true;
        // int target = 13; // false;
        System.out.println(hasPathSum(a, target) ? "has path sum" : "not have path sum");
    }
}
