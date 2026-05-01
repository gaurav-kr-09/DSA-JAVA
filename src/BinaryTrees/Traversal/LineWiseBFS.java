package BinaryTrees.Traversal;

import java.util.ArrayList;
import java.util.List;

public class LineWiseBFS {
    // Method 1: works but not good, using a extra class
    /*private static class Pair{
        Node node;
        int level;
        Pair(Node node, int level){
            this.node = node;
            this.level = level;
        }
    }

    private static void levelOrderLine(Node root){
        if(root == null) return;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int currLevel = 0;

        while(!q.isEmpty()){
            Pair front = q.remove();

            if(front.level != currLevel){
                currLevel++;
                System.out.println();
            }

            System.out.print(front.node.val + " ");

            if(front.node.left != null) q.add(new Pair(front.node.left, front.level+1));
            if(front.node.right != null) q.add(new Pair(front.node.right, front.level+1));
        }
    }*/

    // Method 2: using size, without  using a extra class
    /*private static void levelOrderLine(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while ((!q.isEmpty())){
            int size = q.size();

            for(int i = 0; i < size; i++){
                Node front = q.remove();
                System.out.print(front.val + " ");

                if(front.left !=  null) q.add(front.left);
                if(front.right !=  null) q.add(front.right);
            }
            System.out.println();
        }
    }*/

    // aab se print store karenge arayLis me
    
    // Method 3: recursively (not good here, will optimize later)
    /*private static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        for(int i = 0; i < maxDepth(root); i++){
            List<Integer> temp = new ArrayList<>();
            helper(root, temp, 0, i);
            ans.add(temp);
        }

        return ans;
    }

    private static void helper(Node root, List<Integer> ans, int currLvl, int reqLvl){
        if(root == null) return;
        if(currLvl == reqLvl){
            ans.add(root.val);
            return;
        }

        helper(root.left, ans, currLvl+1, reqLvl);
        helper(root.right, ans, currLvl+1, reqLvl);
    }

    private static int maxDepth(Node root) {
        if(root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }*/

    // Method 4: recursively optimized
    private static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root, 0, ans);
        return ans;
    }

    private static void helper(Node node, int level, List<List<Integer>> ans){
        if(node == null) return;
        if(level == ans.size()) ans.add(new ArrayList<>());

        ans.get(level).add(node.val);

        helper(node.left, level + 1, ans);
        helper(node.right, level + 1, ans);
    }

    public static void main(String[] args) {
        //         3
        //       /   \
        //      4     2
        //     / \    / \
        //    8   1  6   9

        // output
        // 3
        // 4 2
        // 8 1 6 9

        Node a = new Node(3);
        Node b = new Node(4);
        Node c = new Node(2);
        Node d = new Node(8);
        Node e = new Node(1);
        Node f = new Node(6);
        Node g = new Node(9);


        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = f; c.right = g;

        // Without arraylist wala pahla do soln
        // System.out.println("The line wise BFS result is: ");
        // levelOrderLine(a);

        // Without arraylist wala baad ka do soln
        System.out.println("The line wise BFS result is: ");
        for(List<Integer> l: levelOrder(a)){
            System.out.println(l);
        }
    }
}