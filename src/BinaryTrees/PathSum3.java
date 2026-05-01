package BinaryTrees;

import java.util.ArrayList;

public class PathSum3 {
    // basic wahi paths from root with specified sum ko har node k liye chala diye
    // but ye O(n^2) hoga and nd space v O(n) and ye bade value k liye overflow ho rha hai
    /*private static int pathsCountWithSum(Node root, int sum) {
        if(root == null) return 0;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        dfs(root, ans, temp, sum);

        return ans.size() + pathsCountWithSum(root.left, sum) + pathsCountWithSum(root.right, sum);
    }

    private static void dfs(Node root, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> temp, int sum){
        if(root == null) return;

        temp.add(root.val);

        if(sum == root.val) ans.add(new ArrayList<>(temp));

        dfs(root.left, ans, temp, sum - root.val);
        dfs(root.right, ans, temp, sum - root.val);

        temp.removeLast();
    }*/

    // better bruteforce O(n^2) without storing the path
    private static int pathsCountWithSum(Node root, int sum) {
        if(root == null) return 0;
        return dfs(root, sum) + pathsCountWithSum(root.left, sum) + pathsCountWithSum(root.right, sum);
    }

    private static int dfs(Node root, int sum){
        if(root == null) return 0;
        int count = 0;

        if(sum == root.val) count++;

        count += dfs(root.left, sum - root.val);
        count += dfs(root.right, sum - root.val);
        return count;
    }

    public static void main(String[] args) {
        //          10
        //       /     \
        //     28       13
        //           /     \
        //         25       15
        //        /   \     /  \
        //       21   22   23   24

        Node a = new Node(10);
        Node b = new Node(28);
        Node c = new Node(13);
        Node d = new Node(25);
        Node e = new Node(15);
        Node f = new Node(21);
        Node g = new Node(22);
        Node h = new Node(23);
        Node i = new Node(24);

        a.left = b; a.right = c;
        c.left = d; c.right = e;
        d.left = f; d.right = g;
        e.left = h; e.right = i;

        int sum = 38; // paths: abb 4 , [10, 28], [10, 13, 15], [13, 25], [15, 23]

        System.out.println("no of paths are: "+ pathsCountWithSum(a, sum));
    }
}