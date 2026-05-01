package BinarySearchTree;

public class KthSmallestNodeInBST {
    // good but not best
    /*private static int kthSmallest(Node root, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root, arr);
        return arr.get(k-1);
    }

    private static void inorder(Node root, ArrayList<Integer> arr){
        if(root == null) return;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
    }*/

    // better
    static int cnt, ans = -1;
    private static int kthSmallest(Node root, int k) {
        cnt = k;
        inorder(root);
        return ans;
    }

    private static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        cnt--;
        if (cnt == 0){
            ans = root.val;
            return;
        }
        inorder(root.right);
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

        int kth = 3;

        System.out.println("kth smallest element is: "+ kthSmallest(a, kth));
    }
}