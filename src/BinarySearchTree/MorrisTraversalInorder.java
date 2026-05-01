package BinarySearchTree;

import java.util.ArrayList;

public class MorrisTraversalInorder {
    private static ArrayList<Integer> morris(Node root){
        ArrayList<Integer> ans = new ArrayList<>();

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
                    ans.add(curr.val);
                    curr = curr.right;
                }

            }else{
                ans.add(curr.val);
                curr = curr.right;
            }
        }

        return ans;
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

        // inorder -> -10 -5 10 15 25 28 30 35 40 50 55 60 65 75 80 90 100

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

        System.out.println("Inorder using Morris traversal is: "+ morris(a));
    }
}
