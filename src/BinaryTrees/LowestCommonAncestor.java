package BinaryTrees;

public class LowestCommonAncestor {
    // Method 1: check karenge ki  dono val kis subtree me hai, not good worst case me O(n^2)
    /*private static  Node LCA(Node root, Node p, Node q) {
        if(root == null || p.val == root.val || q.val == root.val) return root;

        if(exists(root.left, p) && exists(root.left, q)) // dono left me
            return LCA(root.left, p, q);
        else if(!exists(root.left, p) && !exists(root.left, q)) // dono right me
            return LCA(root.right, p, q);
        else
            return root;
    }

    private static  boolean exists(Node root, Node p){
        if(root == null) return false;
        if(root.val == p.val) return true;

        return exists(root.left, p) || exists(root.right, p);
    }*/

    // Method 2: root se p and q node tak ka  path store kara lete hai
    // and the last matching node will be answer
    /*private static  Node LCA(Node root, Node p, Node q) {
        if(root == null || p.val == root.val || q.val == root.val) return root;

        List<List<Node>> ans = new ArrayList<>();
        List<Node> temp = new ArrayList<>();
        path(root, p, q, temp, ans);

        List<Node> one = ans.getFirst();
        List<Node> two = ans.getLast();

        int i = 0, j = 0;
        while(i < one.size() && j < two.size()){
            if(one.get(i) != two.get(j)) break;
            i++;j++;
        }

        return one.get(i-1);
    }

    private static void path(Node root, Node p, Node q, List<Node> temp, List<List<Node>> ans){
        if(root == null) return;
        temp.add(root);
        if(root.val == p.val || root.val == q.val){
            List<Node> copy = new ArrayList<>(temp);
            ans.add(copy);
        }

        path(root.left, p, q, temp, ans);
        path(root.right, p, q, temp, ans);
        temp.removeLast();
    }*/

    // Method 3: best among them
    private static  Node LCA(Node root, Node p, Node q) {
        if(root == null || p == root || q == root) return root;

        Node left = LCA(root.left, p, q);
        Node right = LCA(root.right, p, q);

        if(left != null && right != null) return root;

        return (left == null) ? right : left;
    }
    
    public static void main(String[] args) {
        //         1
        //       /   \
        //      2     3
        //     / \    / \
        //    4   5  6   7
        //         \
        //          8
        //           \
        //            9

        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);


        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = f; c.right = g;

         Node h = new Node(8);
         e.right = h;
         Node i = new Node(9);
         h.right = i;

        System.out.println("Lowest common ancestor is: "+ LCA(a, d, e).val); // 2
        System.out.println("Lowest common ancestor is: "+ LCA(a, d, g).val); // 1
        System.out.println("Lowest common ancestor is: "+ LCA(a, d, i).val); // 2
    }
}
