package BinaryTrees.Basics;

public class SizeOfTree {
    // thoda bada code
    /*private static int size(Node root){
        if(root == null) return 0;
        int leftSize = size(root.left);
        int rightSize = size(root.right);
        return 1 + leftSize + rightSize;
    }*/

    // slightly chhota
    /*private static int size(Node root){
        if(root == null) return 0;
        return 1 + size(root.left) + size(root.right);
    }*/

    // ekdum chhota, using ternary operator
    private static int size(Node root){
        return root == null ? 0 : 1 + size(root.left) + size(root.right);
    }

    public static void main(String[] args) {
        //         3
        //       /   \
        //      4     2
        //     / \    / \
        //   -1   1  6   9

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

        System.out.println("the size is: "+ size(a)); // 7
    }
}
