package BinarySearchTree;

public class PracticeTreeDP {
    // 1. validate bst normal
    // 2. validate bst Pair
    // 3. validate bst triplet
    // 4. largest BST
    // 5. Maximum sum BST

    // ------->  VALID BST <-------
    // M-1
    static int minLeftFirst = Integer.MIN_VALUE;
    private static boolean validBSTLeftFirst(Node root){
        if(root == null) return true;
        boolean leftValid = validBSTLeftFirst(root.left);
        if(root.val > minLeftFirst) minLeftFirst = root.val;
        else return false;
        boolean rightValid = validBSTLeftFirst(root.right);
        return leftValid && rightValid;
    }

    // M-2
    static int maxRightFirst = Integer.MAX_VALUE;
    private static boolean validBSTRightFirst(Node root){
        if(root == null) return true;
        boolean rightValid = validBSTRightFirst(root.right);
        if(root.val < maxRightFirst) maxRightFirst = root.val;
        else return false;
        boolean leftValid = validBSTRightFirst(root.left);
        return  rightValid && leftValid;
    }

    // M-3
    private static boolean validBST(Node root){
        return valid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean valid(Node root, int min, int max) {
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        return valid(root.left, min, root.val) && valid(root.right, root.val, max);
    }

    // ------->  VALID BST USING PAIR <-------
    static class Pair{
        int max;
        int min;
        Pair(int max, int min){
            this.max = max;
            this.min = min;
        }
    }

    static boolean flag;
    private static boolean validBSTByPair(Node root){
        flag = true;
        validPair(root);
        return flag;
    }

    private static Pair validPair(Node root) {
        if(root == null) return new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE);

        Pair lst = validPair(root.left);
        Pair rst = validPair(root.right);

        int max = Math.max(root.val, Math.max(lst.max, rst.max));
        int min = Math.min(root.val, Math.min(lst.min, rst.min));

        if(lst.max >= root.val || rst.min <= root.val) flag = false;

        return new Pair(max, min);
    }

    // -------> VALID BST USING TRIPLET <-------
    static class Triplet{
        int max;
        int min;
        boolean isBst;
        Triplet(int max, int min, boolean isBst){
            this.max = max;
            this.min = min;
            this.isBst = isBst;
        }
    }

    private static boolean validBSTByTriplet(Node root){
        return validTriplet(root).isBst;
    }

    private static Triplet validTriplet(Node root){
        if(root == null) return new Triplet(Integer.MIN_VALUE, Integer.MAX_VALUE, true);

        Triplet lst = validTriplet(root.left);
        Triplet rst = validTriplet(root.right);

        int max = Math.max(root.val, Math.max(lst.max, rst.max));
        int min = Math.min(root.val, Math.min(rst.min, lst.min));
        boolean isBst = lst.isBst && rst.isBst && root.val > lst.max && root.val < rst.min;

        return  new Triplet(max, min, isBst);
    }

    // ---------> LARGEST BST <---------
    static class Quad{
        int max;
        int min;
        int size;
        boolean isBst;
        Quad(int max, int min, int size, boolean isBst){
            this.max = max;
            this.min = min;
            this.size = size;
            this.isBst = isBst;
        }
    }

    static int maxSize;
    private static int largestBSTGFG(Node root){
        maxSize = 0;
        largestGFG(root);
        return maxSize;
    }

    private static Quad largestGFG(Node root){
        if(root == null) return new Quad(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, true);

        Quad lst = largestGFG(root.left);
        Quad rst = largestGFG(root.right);

        // int max = Math.max(root.val, Math.max(lst.max, rst.max));
        // int min = Math.min(root.val, Math.min(lst.min, rst.min));
        // int size = 1 + lst.size + rst.size;
        // boolean isBst = lst.isBst && rst.isBst && root.val > lst.max && root.val < rst.min;
        // if(isBst) maxSize = Math.max(maxSize, size);

        // A bit optimized
        if(lst.isBst && rst.isBst && root.val < rst.min && root.val > lst.max){
            int max = Math.max(root.val, Math.max(lst.max, rst.max));
            int min = Math.min(root.val, Math.min(lst.min, rst.min));
            int size = 1 + lst.size + rst.size;
            maxSize = Math.max(size, maxSize);
            return new Quad(max, min, size, true);
        }

        return new Quad(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, false);
    }

    // ---------> MAXIMUM SUM BST <---------
    static class QuadLC {
        int max;
        int min;
        int currSum;
        boolean isBst;
        QuadLC(int max, int min, int currSum, boolean isBst){
            this.max = max;
            this.min = min;
            this.currSum = currSum;
            this.isBst = isBst;
        }
    }

    static int maxVal = 0;
    private static int largestSumBSTLC(Node root){
        maxVal = 0;
        largestLC(root);
        return maxVal;
    }

    private static QuadLC largestLC(Node root){
        if(root == null) return new QuadLC(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, true);

        QuadLC lst = largestLC(root.left);
        QuadLC rst = largestLC(root.right);

        int max = Math.max(root.val, Math.max(lst.max, rst.max));
        int min = Math.min(root.val, Math.min(lst.min, rst.min));
        if(lst.isBst && rst.isBst && lst.max < root.val && rst.min > root.val){
            int currSum = root.val + lst.currSum + rst.currSum;
            maxVal = Math.max(currSum, maxVal);
            return new QuadLC(max, min, currSum, true);
        }

        return new QuadLC(max, min, 0, false);
    }

    // we can also solve it using triplet
    static class TripletLC {
        int max;
        int min;
        int currSum;
        TripletLC(int max, int min, int currSum){
            this.max = max;
            this.min = min;
            this.currSum = currSum;
        }
    }

    static int maxValTrip = 0;
    private static int largestSumBSTLCTrip(Node root){
        maxValTrip = 0;
        largestLCTrip(root);
        return maxValTrip;
    }

    private static TripletLC largestLCTrip(Node root){
        if(root == null) return new TripletLC(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);

        TripletLC lst = largestLCTrip(root.left);
        TripletLC rst = largestLCTrip(root.right);

        if(lst.max < root.val && rst.min > root.val){
            int max = Math.max(root.val, Math.max(lst.max, rst.max));
            int min = Math.min(root.val, Math.min(lst.min, rst.min));
            int currSum = root.val + lst.currSum + rst.currSum;
            maxValTrip = Math.max(currSum, maxValTrip);
            return new TripletLC(max, min, currSum);
        }

        return new TripletLC(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
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

        System.out.print("Valid BST left first: ");
        System.out.println(validBSTLeftFirst(a));

        System.out.print("Valid BST right first: ");
        System.out.println(validBSTRightFirst(a));

        System.out.print("Valid BST two fns: ");
        System.out.println(validBST(a));

        System.out.print("Valid BST by pair: ");
        System.out.println(validBSTByPair(a));

        System.out.print("Valid BST by pair: ");
        System.out.println(validBSTByTriplet(a));

        System.out.println("Size of largest BST is: "+ largestBSTGFG(a));
        System.out.println("Sum of largest BST is: "+ largestSumBSTLC(a));
        System.out.println("Sum of largest BST using triplet is: "+ largestSumBSTLCTrip(a));
    }
}
