package Heaps;

import java.util.ArrayList;

public class BSTToSpecialMaxHeap {
    public static int i;
    private static void convertToMaxHeapUtil(Node root) {
        ArrayList<Integer> inorder = new ArrayList<>();
        inorder(root, inorder);
        i = 0;
        postorder(root, inorder);
    }

    private static void inorder(Node root, ArrayList<Integer> arr) {
        if(root == null) return;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
    }

    private static void postorder(Node root, ArrayList<Integer> in) {
        if(root==null) return;
        postorder(root.left, in);
        postorder(root.right, in);
        root.val = in.get(i++);
    }

    private static void preorder(Node root){
        if(root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        //         15
        //       /    \
        //      9      8
        //     / \     / \
        //   -1   1   6   5

        Heaps.Node a = new Heaps.Node(15);
        Heaps.Node b = new Heaps.Node(9);
        Heaps.Node c = new Heaps.Node(8);
        Heaps.Node d = new Heaps.Node(-1);
        Heaps.Node e = new Heaps.Node(1);
        Heaps.Node f = new Heaps.Node(6);
        Heaps.Node g = new Heaps.Node(5);


        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = f; c.right = g;

        System.out.print("Current tree is: ");
        preorder(a);

        convertToMaxHeapUtil(a);

        System.out.print("\nSpecial max heap is: ");
        preorder(a);
    }
}