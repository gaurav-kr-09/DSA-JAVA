package BinarySearchTree;

public class BSTtoGST {
    // Method 1: using an extra array
    /*private static Node convert(Node root){
        ArrayList<Node> arr = new ArrayList<>();
        inorder(root, arr);
        int sum = 0;
        for(int i = 0; i < arr.size(); i++){
            sum += arr.get(i).val;
            arr.get(i).val = sum;
        }
        return root;
    }

    private static void inorder(Node root, ArrayList<Node> arr) {
        if(root == null) return;
        inorder(root.right, arr);
        arr.add(root);
        inorder(root.left, arr);
    }*/

    // Method 2: without using extra array
    static int sum = 0;
    private static Node convert(Node root){
        if(root == null) return root;
        convert(root.right);
        sum += root.val;
        root.val = sum;
        convert(root.left);
        return root;
    }

    // GFG wala
    static int sum2;
    private static Node convert2(Node root){
        sum2 = 0;
        solve(root);
        return root;
    }

    private static void solve(Node root) {
        if(root == null) return;
        solve(root.right);
        int temp = root.val;
        root.val = sum2;
        sum2 += temp;
        solve(root.left);
    }

    private static void display(Node root){
        if(root == null) return;
        System.out.print(root.val+" ");
        display(root.left);
        display(root.right);
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

        System.out.print("original tree is: ");
        display(a);

//        a = convert(a); // leetcode
        a = convert2(a); // GFG

        System.out.print("\nGST is: ");
        display(a);
    }
}
