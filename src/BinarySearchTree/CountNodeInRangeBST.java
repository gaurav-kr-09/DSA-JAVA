package BinarySearchTree;

public class CountNodeInRangeBST {
    private static int countNodes(Node root, int low, int high){
        if(root == null) return 0;

        if(root.val < low) return countNodes(root.right, low, high);
        else if(root.val > high) return countNodes(root.left, low, high);
        else return 1 + countNodes(root.left, low, high) +  countNodes(root.right, low, high); // root.val >= l && root.val <= h
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

        int low = 28, high = 90;
        System.out.println("No. of nodes in given range is :"+ countNodes(a, low, high));
    }
}
