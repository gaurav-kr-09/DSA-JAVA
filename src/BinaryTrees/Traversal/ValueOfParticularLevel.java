package BinaryTrees.Traversal;

import java.util.ArrayList;
import java.util.List;

public class ValueOfParticularLevel {
    // method 1: using a Pair class
    /*static class Pair{
        Node node;
        int level;
        Pair(Node node, int level){
            this.node = node;
            this.level = level;
        }
    }

    private static List<Integer> particularLevel(Node root, int lvl){
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while(!q.isEmpty()){
            Pair front = q.remove();

            if(front.level == lvl) ans.add(front.node.val);

            if(front.node.left != null) q.add(new Pair(front.node.left, front.level+1));
            if(front.node.right != null) q.add(new Pair(front.node.right, front.level+1));
        }

        return ans;
    }*/

    // method 2: without using a Pair class
    /*private static List<Integer> particularLevel(Node root, int lvl) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        for(int i = 0; i < lvl; i++){
            int size = q.size();
            for(int j = 0; j < size; j++){
                Node front = q.remove();
                if(front.left != null) q.add(front.left);
                if(front.right != null) q.add(front.right);
            }
        }

        while (!q.isEmpty()) ans.add(q.remove().val);
        return ans;
    }*/

    // method 3: recursive -- clean and elegant
    private static List<Integer> particularLevel(Node root, int lvl){
        List<Integer> ans = new ArrayList<>();
        int currLvl = 0;
        helper(root, ans, currLvl, lvl);
        return ans;
    }

    private static void helper(Node root,List<Integer> ans, int currLvl, int reqLvl){
        if(root == null) return;
        if(currLvl == reqLvl){
            ans.add(root.val);
            return;
        }

        helper(root.left, ans, currLvl+1, reqLvl);
        helper(root.right, ans, currLvl+1, reqLvl);
    }

    public static void main(String[] args) {
        //          3
        //       /     \
        //      4        2
        //     / \      /  \
        //    8   1    6    9
        //   /  \          /  \
        //  5    11       7    10


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

        // int level = 0; // 3
        int level = 2; // 5 11 7 10

        System.out.println("The elements of level " + level +" is: " + particularLevel(a, level));
    }
}
