package BinaryTrees.Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AvgOfLevels {
    private static List<Double> average(Node root) {
        List<Double> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            long sum = 0;
            int size = q.size();
            for(int i = 0; i < size; i++){
                Node front = q.remove();
                sum += front.val;
                if(front.left != null) q.add(front.left);
                if(front.right != null) q.add(front.right);
            }
            ans.add((double)sum/size);
        }

        return ans;
    }
    
    public static void main(String[] args) {
        //          3              | 3
        //       /     \           |
        //      4        2         | 3
        //     / \      /  \       |
        //    8   1    6    9      | 6
        //   /  \          /  \    |
        //  5    11       7    10  | 8.25

        Node a = new Node(3);
        Node b = new Node(4);
        Node c = new Node(2);
        Node d = new Node(8);
        Node e = new Node(1);
        Node f = new Node(6);
        Node g = new Node(9);
        Node h = new Node(5);
        Node i = new Node(11);
        Node j = new Node(7);
        Node k = new Node(10);

        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = f; c.right = g;
        d.left = h; d.right = i;
        g.left = j; g.right = k;

        System.out.println("The average of each level is: " + average(a));
    }
}
