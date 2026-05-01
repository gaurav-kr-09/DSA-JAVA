package BinaryTrees.Traversal;

import java.util.LinkedList;
import java.util.Queue;

public class BFSorLevelOrder {
    private static void levelOrder(Node root){
        if(root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node front = q.remove();
            System.out.print(front.val + " ");
            if(front.left != null) q.add(front.left);
            if(front.right != null) q.add(front.right);
        }
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

        System.out.print("The BFS result is: ");
        levelOrder(a); // 3 4 2 -1 1 6 9
    }
}
