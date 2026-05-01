package BinaryTrees.Basics;

public class HeightOfTree {
    private static int height(Node root){
        if(root == null) return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void main(String[] args) {
        //         3
        //       /   \
        //      4     2
        //     / \    / \
        //   -1   1  6   9
        //          /
        //         5

        Node a = new Node(3);
        Node b = new Node(4);
        Node c = new Node(2);
        Node d = new Node(-1);
        Node e = new Node(1);
        Node f = new Node(6);
        Node g = new Node(9);
        Node h = new Node(5);


        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = f; c.right = g;
        d.left = h;

        System.out.println("the height is: "+ height(a)); // 3
    }
}
