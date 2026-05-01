package BinarySearchTree;


public class ValidateBST {
    // Naive approach
    /*private static boolean isValidBST(Node root) {
        if(root == null) return true;
        List<Integer> arr = new ArrayList<>();
        inorder(root, arr);
        for(int i = 1; i < arr.size(); i++){
            if(arr.get(i-1) >= arr.get(i)) return false;
        }
        return true;
    }

    private static void inorder(Node root, List<Integer> arr){
        if(root == null) return;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
    }*/
    
    // Better
    /*private static boolean isValidBST(Node root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean valid(Node root, long min, long max){
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        return valid(root.left, min, root.val) && valid(root.right, root.val, max);
    }*/

    // Easy to understand and better
    /*static long min = Long.MIN_VALUE;
    private static boolean isValidBST(Node root) {
            if(root == null) return true;
            boolean leftValid = isValidBST(root.left);
            if(root.val > min) min = root.val;
            else return false;
            boolean rightValid = isValidBST(root.right);
            return leftValid && rightValid;
    }*/

    // Not ideal but good for understanding further concepts
    /*private static class Pair{
        long max;
        long min;
        Pair(long max, long min){
            this.max = max;
            this.min = min;
        }
    }
    
    private static boolean flag;
    private static boolean isValidBST(Node root) {
        flag = true;
        maxMin(root);
        return flag;
    }

    private static Pair maxMin(Node root){
        if(root == null) return new Pair(Long.MIN_VALUE, Long.MAX_VALUE);
        Pair lst = maxMin(root.left);
        Pair rst = maxMin(root.right);
        long max = Math.max(root.val, Math.max(lst.max, rst.max));
        long min = Math.min(root.val, Math.min(lst.min, rst.min));
        if(lst.max >= root.val || rst.min <= root.val) flag = false;
        return new Pair(max, min);
    }*/
    
    // using morris traversal
    private static boolean isValidBST(Node root) {
        long prev = Long.MIN_VALUE;
        Node curr = root;
        while (curr != null){
            if(curr.left != null){
                Node pred = curr.left;

                while (pred.right != null && pred.right != curr) pred = pred.right;

                if(pred.right == null){ // link
                    pred.right = curr;
                    curr = curr.left;
                }else{ // pred.right == curr, unlink and print
                    pred.right = null;
                    if(curr.val <= prev) return false;
                    prev = (long)curr.val;
                    curr = curr.right;
                }

            }else{
                if(curr.val <= prev) return false;
                prev = (long)curr.val;
                curr = curr.right;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        //                     50
        //                /           \
        //               /             \
        //             25                75
        //          /      \          /       \
        //        10        35       60        90
        //       /  \      /  \     /  \      /  \
        //     -5   15    30  40   55  65    80  100
        //    /          /
        //  -10        28

        Node a = new Node(50);
        Node b = new Node(25);
        Node c = new Node(75);
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

        System.out.println(isValidBST(a));
    }
}
