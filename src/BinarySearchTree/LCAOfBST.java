package BinarySearchTree;

public class LCAOfBST {
    // method -1 , wahi binary tree wala
    /*private static Node LCA(Node root, Node p, Node q){
        if(root == null || root == p || root == q) return root;

        Node l = LCA(root.left, p, q);
        Node r = LCA(root.right, p, q);

        if(l != null && r != null) return root;

        return l == null ? r : l;
    }*/

    // method -2, log in most cases but n in worst case
    private static Node LCA(Node root, Node p, Node q){
        if(root.val < p.val && root.val < q.val) return LCA(root.right, p, q);
        else if(root.val > p.val && root.val > q.val) return LCA(root.left, p, q);
        else return root;
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

        System.out.println("LCA of p and q is: "+ LCA(a, p, q).val);
    }
}
