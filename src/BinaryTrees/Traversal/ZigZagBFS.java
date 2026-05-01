package BinaryTrees.Traversal;

import java.util.*;

public class ZigZagBFS {
    //method 1: using a Pair class
    /*static class Pair{
        Node node;
        int level;
        Pair(Node node, int level){
            this.node = node;
            this.level = level;
        }
    }
    
    private static List<List<Integer>> zigzagLevelOrder(Node root){
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        List<Integer> temp = new ArrayList<>();

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int currLevel = 0;

        while(!q.isEmpty()){
            Pair front = q.remove();

            if(front.level != currLevel){
                ans.add(temp);
                temp = new ArrayList<>();
                currLevel++;
            }

            if(currLevel % 2 == 0) temp.add(front.node.val);
            else temp.add(0, front.node.val);

            if(front.node.left != null) q.add(new Pair(front.node.left, front.level+1));
            if(front.node.right != null) q.add(new Pair(front.node.right, front.level+1));
        }

        ans.add(temp);
        return ans;
    }*/

    //method 2: iterative without using a Pair class
    /*private static List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        boolean leftToRight = true;

        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> temp = new ArrayList<>();

            for(int i = 0; i < size; i++){
                Node front = q.remove();

                if(leftToRight) temp.add(front.val);
                else temp.add(0, front.val);

                if(front.left != null) q.add(front.left);
                if(front.right != null) q.add(front.right);
            }

            ans.add(temp);
            leftToRight = !leftToRight;
        }

        return ans;
    }*/

    //method 3: Same as 2, but using Deque
    /*private static List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        boolean leftToRight = true;

        while(!q.isEmpty()){
            int size = q.size();
            Deque<Integer> temp = new LinkedList<>();

            for(int i = 0; i < size; i++){
                Node front = q.remove();

                if(leftToRight) temp.add(front.val);
                else temp.addFirst(front.val);

                if(front.left != null) q.add(front.left);
                if(front.right != null) q.add(front.right);
            }

            ans.add(new ArrayList<>(temp));
            leftToRight = !leftToRight;
        }

        return ans;
    }*/

    //method 4: recursive
    private static List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root, 0, ans);
        return ans;
    }

    private static void helper(Node node, int level, List<List<Integer>> ans){
        if(node == null) return;
        if(level == ans.size()) ans.add(new ArrayList<>());

        if(level % 2 == 0) ans.get(level).add(node.val);
        else ans.get(level).addFirst(node.val);

        helper(node.left, level + 1, ans);
        helper(node.right, level + 1, ans);
    }

    public static void main(String[] args) {
        //          3
        //       /     \
        //      4        2
        //     / \      /  \
        //    8   1    6    9
        //   /  \          /  \
        //  5    11       7    10

        // output
        // 3
        // 2 4
        // 8 1 6 9
        // 10 7 11 5

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

        System.out.println("The ZigZag BFS result is: ");
        for(List<Integer> l : zigzagLevelOrder(a)){
            System.out.println(l);
        }
    }
}
