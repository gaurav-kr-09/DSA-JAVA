package BinaryTrees;

public class FlattenBTToLinkedList {
    // Method 1: not good space complexity O(n)
    /*private static void flatten(Node root) {
        if(root == null) return;
        List<Integer> temp = new ArrayList<>();
        dfs(root, temp);

        Node tempRoot = root;
        for(int i = 1; i < temp.size(); i++){
            tempRoot.right = new Node(temp.get(i));
            tempRoot.left = null;
            tempRoot = tempRoot.right;
        }

        tempRoot.left = null;
        tempRoot.right = null;
    }
    
    private static void dfs(Node root, List<Integer> temp){
        if(root == null) return;

        temp.add(root.val);
        dfs(root.left, temp);
        dfs(root.right, temp);
    }*/

    // Method 2: best SC O(1) and TC O(n)
    /*private static void flatten(Node root) {
        if(root == null) return;

        Node lst = root.left;
        Node rst = root.right;

        root.left = null;

        flatten(lst);
        flatten(rst);

        root.right = lst;

        Node last = root;
        while (last.right != null) last = last.right;

        last.right = rst;
    }*/

    // Method 3: even better
    /*static Node nextRight = null;
    private static void flatten(Node root) {
        if(root == null) return;

        flatten(root.right);
        flatten(root.left);

        root.right = nextRight;
        root.left = null;

        nextRight = root;
    }*/

    // using morris traversal (modified)
    private static void flatten(Node root) {
        if(root == null) return;

        Node curr = root;
        while(curr != null){
            if(curr.left != null){
                Node pred = curr.left;
                while(pred.right != null) pred = pred.right;

                pred.right = curr.right;
                curr.right = curr.left;
                curr.left = null;

                curr = curr.right;
            }else{
                curr = curr.right;
            }
        }
    }

    private static void displayPreOrder(Node root){
        if(root == null) return;
        System.out.print(root.val + " ");
        displayPreOrder(root.left);
        displayPreOrder(root.right);
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

        // Answer is
        // 1 -> 2 -> 4 -> 5 -> 8 -> 9 -> 3 -> 6 -> 7 -> and sabka left null

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

        System.out.print("Abhi wala tree: ");
        displayPreOrder(a);
        System.out.println();
        System.out.println(a.left); // ye abhi bina flattening k null nahi hoga

        flatten(a);

        System.out.print("Flattened tree is: ");
        displayPreOrder(a);
        System.out.println();
        System.out.println(a.left); // // ye aab null ho gaya hoga flattening k bad
    }
}
