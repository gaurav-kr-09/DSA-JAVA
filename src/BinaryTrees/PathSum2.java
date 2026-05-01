package BinaryTrees;

import java.util.ArrayList;

public class PathSum2 {
    private static ArrayList<ArrayList<Integer>> pathsWithSum(Node root, int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        dfs(root, ans, temp, sum);
        return ans;
    }

    private static void dfs(Node root, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> temp, int sum){
        if(root == null) return;

        temp.add(root.val);

        if(root.left == null && root.right == null && sum == root.val) ans.add(new ArrayList<>(temp));

        dfs(root.left, ans, temp, sum - root.val);
        dfs(root.right, ans, temp, sum - root.val);

        temp.removeLast();
    }

    public static void main(String[] args) {
        //          10
        //       /     \
        //     28       13
        //           /     \
        //         14       15
        //        /   \     /  \
        //       21   22   23   24

        Node a = new Node(10);
        Node b = new Node(28);
        Node c = new Node(13);
        Node d = new Node(14);
        Node e = new Node(15);
        Node f = new Node(21);
        Node g = new Node(22);

        a.left = b;
        a.right = c;

        c.left = d;
        c.right = e;

        d.left = f;
        d.right = g;

        Node h = new Node(23);
        Node i = new Node(24);

        e.left = h;
        e.right = i;

        int sum = 38; // paths: abb sirf [10, 28]

        System.out.println("paths with given sum is");
        for (ArrayList<Integer> l : pathsWithSum(a, sum)) {
            System.out.println(l);
        }
    }
}