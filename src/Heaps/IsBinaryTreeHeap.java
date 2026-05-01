package Heaps;

import java.util.LinkedList;
import java.util.Queue;

public class IsBinaryTreeHeap {
    // Iterative version
    /*private static boolean isMaximumHeap(Node root) {
        return isCBT(root, size(root), 1) && isMaxHeap(root);
    }

    private static boolean isMinimumHeap(Node root) {
        return isCBT(root, size(root), 1) && isMinHeap(root);
    }

    private static int size(Node root){
        if(root == null) return 0;
        return 1 + size(root.left) + size(root.right);
    }

    private static boolean isCBT(Node root, int size, int currIdx){
        if(root == null) return true;
        if(currIdx > size) return false;
        return isCBT(root.left, size, 2 * currIdx) && isCBT(root.right, size, 2 * currIdx + 1);
    }

    private static boolean isMaxHeap(Node root){
        if(root == null) return true;

        // int leftVal = root.left != null ? root.left.val : Integer.MIN_VALUE;
        // int rightVal = root.right != null ? root.right.val : Integer.MIN_VALUE;
        // if(root.val <= leftVal || root.val <= rightVal) return false;

        // upar wale 3 line ki jagah ye v likh sakte hai
        if(root.left != null && root.val <= root.left.val) return false;
        if(root.right != null && root.val <= root.right.val) return false;

        return isMaxHeap(root.left) && isMaxHeap(root.right);
    }

    private static boolean isMinHeap(Node root){
        if(root == null) return true;

        if(root.left != null && root.val >= root.left.val) return false;
        if(root.right != null && root.val >= root.right.val) return false;

        return isMinHeap(root.left) && isMinHeap(root.right);
    }*/

    // recursive version
    private static boolean isMaximumHeap(Node root) {
        Queue<Node> q = new LinkedList<>();
        if(root == null) return true;
        q.add(root);
        boolean isCBT = true;

        while (!q.isEmpty()){
            Node top = q.poll();
            if(top == null) isCBT = false;
            else{
                if(!isCBT) return false;

                if(top.left != null && top.val <= top.left.val) return false;
                if(top.right != null && top.val <= top.right.val) return false;

                q.add(top.left);
                q.add(top.right);
            }
        }

        return true;
    }

    private static boolean isMinimumHeap(Node root) {
        Queue<Node> q = new LinkedList<>();
        if(root == null) return true;
        q.add(root);
        boolean isCBT = true;

        while (!q.isEmpty()){
            Node top = q.poll();
            if(top == null) isCBT = false;
            else{
                if(!isCBT) return false;

                if(top.left != null && top.val >= top.left.val) return false;
                if(top.right != null && top.val >= top.right.val) return false;

                q.add(top.left);
                q.add(top.right);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        //         15
        //       /    \
        //      9      8
        //     / \     / \
        //   -1   1   6   5

        Node a = new Node(15);
        Node b = new Node(9);
        Node c = new Node(8);
        Node d = new Node(-1);
        Node e = new Node(1);
        Node f = new Node(6);
        Node g = new Node(5);


        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = f; c.right = g;

        System.out.println("Is given binary tree max heap: "+ isMaximumHeap(a));
        System.out.println("Is given binary tree min heap: "+ isMinimumHeap(a));
    }
}