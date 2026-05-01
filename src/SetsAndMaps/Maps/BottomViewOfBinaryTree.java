package SetsAndMaps.Maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BottomViewOfBinaryTree {
    private static class Pair{
        int dist;
        Node node;
        Pair(int dist, Node node){
            this.dist = dist;
            this.node = node;
        }
    }

    private static ArrayList<Integer> bottomView(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>(); // map of horizontal dist & node.val

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, root));

        // tracking the min and max value of dist for traversal, we can use LinkedHashMap Instead
        int minDist = Integer.MAX_VALUE, maxDist = Integer.MIN_VALUE;

        while(!q.isEmpty()){
            Pair front = q.remove();
            int dist = front.dist;

            maxDist = Math.max(maxDist, dist);
            minDist = Math.min(minDist, dist);

            map.put(dist, front.node.val);

            if(front.node.left != null) q.add(new Pair(dist-1, front.node.left));
            if(front.node.right != null) q.add(new Pair(dist+1, front.node.right));
        }

        for (int i = minDist; i <= maxDist; i++) {
            ans.add(map.get(i));
        }

        return ans;
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

        System.out.println(bottomView(a));
    }
}
