package BinaryTrees;

public class InvertBinaryTree {
    // preorder style
    /*private static Node invert(Node root){
        if(root == null) return null;

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        invert(root.left);
        invert(root.right);

        return root;
    }*/

    // inorder style
    /*private static Node invert(Node root){
        if(root == null) return null;

        invert(root.left);

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        invert(root.left); // Important

        return root;
    }*/

    // postorder style
    private static Node invert(Node root){
        if(root == null) return null;

        Node invertedLeft  = invert(root.left);
        Node invertedRight  = invert(root.right);

        root.right = invertedLeft;
        root.left = invertedRight;

        return root;
    }

    private static void display(Node root){
        if(root == null) return;
        System.out.print(root.val + " ");
        display(root.left);
        display(root.right);
    }

    public static void main(String[] args) {
        //         3            |         3
        //       /   \          |       /   \
        //      4     2         |      2     4
        //     / \    / \       |     / \    / \
        //   -1   1  6   9      |    9   6  1  -1

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

        System.out.print("The inverted tree is: ");
        display(invert(a));
    }
}