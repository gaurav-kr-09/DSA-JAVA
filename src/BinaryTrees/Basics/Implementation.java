package BinaryTrees.Basics;

public class Implementation {
    private static void display(Node root){
        if(root == null) return;
        System.out.print(root.val + " ");
        display(root.left);
        display(root.right);
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

        // ye sab optional hai kyuki ye default me hi hoga
        // d.left = null; d.right = null;
        // e.left = null; e.right = null;
        // f.left = null; f.right = null;
        // g.left = null; g.right = null;

        System.out.println("The tree is: ");
        display(a);
    }
}