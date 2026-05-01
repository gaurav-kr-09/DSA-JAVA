package BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths{
    // version 1: GFG wala sara path ka array store karna hai
    // i.e [[a,b], [c,d,e],.....]
    /*private static List<List<Integer>> paths(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        helper(root, temp, ans);
        return ans;
    }

    private static void helper(Node root, List<Integer> temp, List<List<Integer>> ans) {
        if(root == null) return;
        temp.add(root.val); // agar null nahi hai to val andar wale arrayList me add karo
        // agar leaf node hai to
        if(root.left == null && root.right == null){
            List<Integer> copy = new ArrayList<>(temp);
            ans.add(copy);
        }

        helper(root.left, temp, ans);
        helper(root.right, temp, ans);
        temp.removeLast(); // backtracking to remove the last added value from temp before going to upper branch
    }*/

    // version 2: LeetCode wala sara path ka string arrow dal k store karna hai
    // i.e [[a->b], [c->d->e],.....]

    // method 1
    /*private static List<String> paths(Node root) {
        List<String> ans = new ArrayList<>();
        helper(root, "", ans);
        return ans;
    }

    private static void helper(Node root, String path, List<String> ans) {
        if(root == null) return;

        path += root.val; // adding values of each node
        if(root.left == null && root.right == null) ans.add(path); // agar leaf node hai to path add karo ans me

        path += "->"; // agar leaf node nahi hai to -> add ar do

        helper(root.left, path, ans);
        helper(root.right, path, ans);

        // since strings immutable hai isiliye no need to backtrack
    }*/

    // method 2
    /*private static List<String> paths(Node root) {
        List<String> ans = new ArrayList<>();
        helper(root, "", ans);
        return ans;
    }

    private static void helper(Node root, String path, List<String> ans) {
        if(root == null) return;
        path += root.val;
        if(root.left == null && root.right == null){
            ans.add(path);
            return;
        }

        helper(root.left, path + "->", ans);
        helper(root.right, path + "->", ans);
    }*/

    // method 3
    private static List<String> paths(Node root) {
        List<String> ans = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        helper(root, path, ans);
        return ans;
    }

    private static void helper(Node root, StringBuilder path, List<String> ans) {
        if(root == null) return;
        int len = path.length(); // store length before changes
        path.append(root.val);
        if(root.left == null && root.right == null){
            ans.add(path.toString());
        }else{
            path.append("->");
            helper(root.left, path, ans);
            helper(root.right, path, ans);
        }

        // since stringBuilder is mutable so we have to backtrack
        // purane wale length pe wapas le gaye

        path.setLength(len);
    }

    public static void main(String[] args) {
        //         3
        //       /   \
        //      4     2
        //     / \    / \
        //   -1   1  6   9
        //         \
        //          7

        Node a = new Node(3);
        Node b = new Node(4);
        Node c = new Node(2);
        Node d = new Node(-1);
        Node e = new Node(1);
        Node f = new Node(6);
        Node g = new Node(9);
        Node h = new Node(7);

        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = f; c.right = g;
        e.right = h;

        // System.out.println("paths from root to leaf GFG style is: ");
        // for(List<Integer> l: paths(a)) System.out.println(l);

         System.out.println("paths from root to leaf LeetCode style is: ");
        System.out.println(paths(a));
    }
}
