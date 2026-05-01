package BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class LeftViewOfBinaryTree {
    // Method 1: okayish - using BFS SC O(n) TC O(n)
    /*private static List<Integer> leftView(Node root) {
        List<List<Integer>> temp = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        helper(root, temp, 0);
        for(List<Integer> l : temp){
            ans.add(l.getFirst());
        }

        return ans;
    }

    private static void helper(Node root, List<List<Integer>> temp, int level){
        if(root == null) return;
        if(level == temp.size()) temp.add(new ArrayList<>());

        temp.get(level).add(root.val);

        helper(root.left, temp, level+1);
        helper(root.right, temp, level+1);
    }*/

    // Method 2: good - using DFS SC O(h) TC O(n)
    private static List<Integer> leftView(Node root) {
        List<Integer> ans = new ArrayList<>();
        view(root, 0, ans);
        return ans;
    }

    // tarika 1 -> agar left se right traverse karenge to array k andar k value ko bar - bar overwrite nahi karna padega
    private static void view(Node root, int level, List<Integer> ans) {
        if(root == null) return;

        if(level == ans.size()) ans.add(root.val);

        view(root.left, level + 1, ans);
        view(root.right, level + 1, ans);
    }

    // tarika 2 -> agar isme right se left traverse karte to array k andar k value ko bar - bar overwrite karna padta
    /*private static void view(Node root, int level, List<Integer> ans) {
        if(root == null) return;

        if(level >= ans.size()) ans.add(root.val);
        else ans.set(level, root.val);

        view(root.right, level + 1, ans);
        view(root.left, level + 1, ans);
    }*/

    public static void main(String[] args) {
        //         3
        //       /   \
        //      4     2
        //     / \    / \
        //   -1   1  6   9

        // abhi ans [3, 4, -1] hai

        // agar ye attach kar denge to ans [3, 4, -1, 7, 8] ho jayega
        //         \
        //          7
        //           \
        //            8

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

         // Node h = new Node(7);
         // e.right = h;
         // Node i = new Node(8);
         // h.right = i;

        System.out.println("right view is: "+ leftView(a));
    }
}
