package BinaryTrees.Traversal;

public class PreInPostRecursiveDFS {
    private static void preOrder(Node root){
        if(root == null) return;

        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private static void inOrder(Node root){
        if(root == null) return;

        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    private static void postOrder(Node root){
        if(root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
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

        System.out.print("The preorder tree is: ");
        preOrder(a); // 3 4 -1 1 2 6 9
        System.out.println();

        System.out.print("The inorder tree is: ");
        inOrder(a); // -1 4 1 3 6 2 9
        System.out.println();

        System.out.print("The postorder tree is: ");
        postOrder(a); // -1 1 4 6 9 2 3
        System.out.println();
    }
}
