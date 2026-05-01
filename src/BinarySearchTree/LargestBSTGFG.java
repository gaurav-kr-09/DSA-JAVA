package BinarySearchTree;

public class LargestBSTGFG {
    // method -1 : O(n^2)
    /*private static int largestBst(Node root) {
        if(root == null) return 0;
        if(isValidBST(root)) return size(root);
        return Math.max(largestBst(root.left), largestBst(root.right));
    }

    private static boolean isValidBST(Node root){
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean valid(Node root, long min, long max){
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        return valid(root.left, min, root.val) && valid(root.right, root.val, max);
    }

    private static int size(Node root){
        if(root == null) return 0;
        return 1 + size(root.left) + size(root.right);
    }*/
    
    // Better O(n)
    static class Quad{
        long max;
        long min;
        int size;
        boolean isBST;
        Quad(long max, long min, int size, boolean isBST){
            this.max = max;
            this.min = min;
            this.size = size;
            this.isBST = isBST;
        }
    }

    private static int maxSize;
    private static int largestBst(Node root) {
        maxSize = 0;
        helper(root);
        return maxSize;
    }

    private static Quad helper(Node root){
        if(root == null) return new Quad(Long.MIN_VALUE, Long.MAX_VALUE, 0, true);
        Quad lst = helper(root.left);
        Quad rst = helper(root.right);

        if(lst.isBST && rst.isBST && (lst.max < root.val) && (rst.min > root.val)){
            long max = Math.max(root.val, Math.max(lst.max, rst.max));
            long min = Math.min(root.val, Math.min(lst.min, rst.min));
            int size = 1 + lst.size + rst.size;
            maxSize = Math.max(size, maxSize);
            return new Quad(max, min, size, true);
        }

        return new Quad(Long.MIN_VALUE, Long.MAX_VALUE, 0, false);
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

        System.out.println("Largest BST size is: " + largestBst(a)); // 4
    }
}
