package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class IsBinaryTreeComplete {
    // recursive version
    /*private static boolean isCompleteTree(Node root) {
        int size = size(root);
        return isTreeComplete(root, size, 1);
    }

    private static int size(Node root){
        if(root == null) return 0;
        return 1 + size(root.left) + size(root.right);
    }

    private static boolean isTreeComplete(Node root, int size, int currIdx){
        if(root == null) return true;
        if(currIdx > size) return false;
        return isTreeComplete(root.left, size, 2*currIdx) &&
                isTreeComplete(root.right, size, 2*currIdx+1);
    }*/

    // Iterative version
    private static boolean isCompleteTree(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean isCBT = true;
        while (!q.isEmpty()){
            Node top = q.remove();

            if(top == null) isCBT = false;
            else{
                if(!isCBT) return false;
                q.add(top.left);
                q.add(top.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //         3
        //       /   \
        //      4     2
        //     / \      \
        //   -1   1      9

        Node a = new Node(3);
        Node b = new Node(4);
        Node c = new Node(2);
        Node d = new Node(-1);
        Node e = new Node(1);
        // Node f = new Node(6);
        Node g = new Node(9);


        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = null; c.right = g;

        System.out.println("Is Binary Tree complete: "+ isCompleteTree(a));
    }
}
