package BinarySearchTree;

public class LargestBSTLC {
    // method 1 : will give TLE O(n^2)
    /*static int max = 0;
    private static int maxSumBST(Node root) {
        dfs(root);
        return max;
    }

    private static void dfs(Node root){
        if(root == null) return;
        if(isValidBST(root)) max = Math.max(max, sum(root));

        dfs(root.left);
        dfs(root.right);
    }

    private static boolean isValidBST(Node root){
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean valid(Node root, long min, long max){
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        return valid(root.left, min, root.val) && valid(root.right, root.val, max);
    }

    private static int sum(Node root){
        if(root == null) return 0;
        return root.val + sum(root.left) + sum(root.right);
    }*/
    
    // Method 2: better
    /*static class Quad{
        long max;
        long min;
        int currSum;
        boolean isBST;
        Quad(long max, long min, int currSum, boolean isBST){
            this.max = max;
            this.min = min;
            this.currSum = currSum;
            this.isBST = isBST;
        }
    }

    static int maxVal;
    private static int maxSumBST(Node root) {
        maxVal = 0;
        helper(root);
        return maxVal;
    }

    private static Quad helper(Node root){
        if(root == null) return new Quad(Long.MIN_VALUE, Long.MAX_VALUE, 0, true);
        Quad lst = helper(root.left);
        Quad rst = helper(root.right);

        if(lst.isBST && rst.isBST && (lst.max < root.val) && (rst.min > root.val)){
            long max = Math.max(root.val, Math.max(lst.max, rst.max));
            long min = Math.min(root.val, Math.min(lst.min, rst.min));
            int currSum = root.val + lst.currSum + rst.currSum;
            maxVal = Math.max(currSum, maxVal);
            return new Quad(max, min, currSum, true);
        }

        return new Quad(Long.MIN_VALUE, Long.MAX_VALUE, 0, false);
    }*/

    // method 3 : we can do it in triplet also
    static class Triplet {
        long max;
        long min;
        int currSum;
        Triplet(long max, long min, int currSum){
            this.max = max;
            this.min = min;
            this.currSum = currSum;
        }
    }

    static int maxVal;
    private static int maxSumBST(Node root) {
        maxVal = 0;
        helper(root);
        return maxVal;
    }

    private static Triplet helper(Node root){
        if(root == null) return new Triplet(Long.MIN_VALUE, Long.MAX_VALUE, 0);
        Triplet lst = helper(root.left);
        Triplet rst = helper(root.right);

        if(lst.max < root.val && rst.min > root.val){
            long max = Math.max(root.val, Math.max(lst.max, rst.max));
            long min = Math.min(root.val, Math.min(lst.min, rst.min));
            int currSum = root.val + lst.currSum + rst.currSum;
            maxVal = Math.max(currSum, maxVal);
            return new Triplet(max, min, currSum);
        }

        return new Triplet(Long.MAX_VALUE, Long.MIN_VALUE, 0);
    }
        
    public static void main(String[] args) {
        //                     50
        //                /           \
        //               /             \
        //             75                22
        //          /      \          /       \
        //        10        35       60        90
        //       /  \      /  \     /  \      /  \
        //     -5   15    30  40   55  65    80  100
        //    /          /
        //  -10        28

        Node a = new Node(50);
        Node b = new Node(75);
        Node c = new Node(22);
        Node d = new Node(10);
        Node e = new Node(35);
        Node f = new Node(60);
        Node g = new Node(90);
        Node h = new Node(-5);
        Node i = new Node(15);
        Node j = new Node(30);
        Node k = new Node(40);
        Node l = new Node(55);
        Node m = new Node(65);
        Node n = new Node(80);
        Node o = new Node(100);
        Node p = new Node(-10);
        Node q = new Node(28);

        a.left = b;  a.right = c;

        b.left = d;  b.right = e;
        c.left = f;  c.right = g;

        d.left = h;  d.right = i;
        e.left = j;  e.right = k;

        f.left = l;  f.right = m;
        g.left = n;  g.right = o;

        h.left = p;
        j.left = q;

        System.out.println("Largest sum of valid BST is: " + maxSumBST(a)); // 4
    }
}
