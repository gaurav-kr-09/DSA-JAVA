package BinaryTrees.Traversal;

import java.util.ArrayList;

public class TreeBoundaryTraversal {
    // method 1: recursive
    /*private static ArrayList<Integer> boundaryNodes(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(root.val);
        if(root.left == null && root.right == null) return ans;

        leftBoundary(root.left, ans);
        leafNodes(root, ans);
        rightBoundary(root.right, ans);

        return ans;
    }

    private static void leftBoundary(Node root, ArrayList<Integer> ans){
        if(root == null) return;
        if(root.left == null && root.right == null) return; // dont add the leaf node
        ans.add(root.val);
        if(root.left != null) leftBoundary(root.left, ans);
        else leftBoundary(root.right, ans);
    }

    private static void leafNodes(Node root, ArrayList<Integer> ans){
        if(root == null) return;
        if(root.left == null && root.right == null) ans.add(root.val);
        leafNodes(root.left, ans);
        leafNodes(root.right, ans);
    }

    private static void rightBoundary(Node root, ArrayList<Integer> ans){
        if(root == null) return;
        if(root.left == null && root.right == null) return; // dont add the leaf node
        if(root.right != null) rightBoundary(root.right, ans);
        else rightBoundary(root.left, ans);
        ans.add(root.val);
    }*/

    // method 2: iterative
    private static ArrayList<Integer> boundaryNodes(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(root.val);
        if(root.left == null && root.right == null) return ans;

        leftBoundary(root.left, ans);
        leafNodes(root, ans);
        rightBoundary(root.right, ans);

        return ans;
    }

    private static void leftBoundary(Node root, ArrayList<Integer> ans){
        while(root != null){
            if(root.left == null && root.right == null) break;
            ans.add(root.val);
            if(root.left != null) root = root.left;
            else root = root.right;
        }
    }

    private static void leafNodes(Node root, ArrayList<Integer> ans){
        if(root == null) return;
        if(root.left == null && root.right == null) ans.add(root.val);
        leafNodes(root.left, ans);
        leafNodes(root.right, ans);
    }

    private static void rightBoundary(Node root, ArrayList<Integer> ans){
        ArrayList<Integer> temp = new ArrayList<>();
        while(root != null){
            if(root.left == null && root.right == null) break;
            temp.add(root.val);
            if(root.right != null) root = root.right;
            else root = root.left;
        }

        for(int i = temp.size() - 1; i >= 0; i--) ans.add(temp.get(i));
    }

    public static void main(String[] args) {
        //         3
        //       /   \
        //      4     2
        //     / \    / \
        //   -1   1  6   9
        //          /
        //         8

        Node a = new Node(3);
        Node b = new Node(4);
        Node c = new Node(2);
        Node d = new Node(-1);
        Node e = new Node(1);
        Node f = new Node(6);
        Node g = new Node(9);
        Node h = new Node(8);


        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = f; c.right = g;
        f.left = h;

        System.out.println("The postorder tree is: " + boundaryNodes(a)); // 3 4 -1 1 8 9 2
    }
}
