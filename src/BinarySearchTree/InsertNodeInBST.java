package BinarySearchTree;

public class InsertNodeInBST {
    // Using a helper fn
    /*private static Node insert(Node root, int data){
        if(root == null) return new Node(data);
        attach(root, data);
        return root;
    }

    private static void attach(Node root, int data){
        if(root == null) return;

        if(data > root.val){
            if(root.right == null) root.right = new Node(data);
            else attach(root.right, data);
        }else{ // data < root.val
            if(root.left == null) root.left = new Node(data);
            else attach(root.left, data);
        }
    }*/

    // without helper fn And better
    /*private static Node insert(Node root, int data){
        if(root == null) return new Node(data);
        if(data > root.val) root.right = insert(root.right, data);
        else root.left = insert(root.left, data);
        return root;
    }*/

    // Iterative
    private static Node insert(Node root, int data){
        if(root == null) return new Node(data);
        Node temp = root;

        while(true){
            if(data > temp.val){
                if(temp.right == null){
                    temp.right = new Node(data);
                    break;
                }
                temp = temp.right;
            }else{ // data < root.val
                if(temp.left == null){
                    temp.left = new Node(data);
                    break;
                }
                temp = temp.left;
            }
        }
        return root;
    }

    // Displaying
    private static void preOrder(Node root){
        if(root == null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
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

        System.out.print("Original Tree is: ");
        preOrder(a);

        int data = 1500;
        System.out.print("\nInserted Tree is: ");
        preOrder(insert(a, data));
    }
}
