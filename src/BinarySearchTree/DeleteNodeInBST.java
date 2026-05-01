package BinarySearchTree;

public class DeleteNodeInBST {
    // tarika one:  without copying the value

    // Method 1: USING PREDECESSOR
    /*private static Node deleteNode(Node root, int key) {
        if(root == null) return null;

        if(root.val > key) root.left = deleteNode(root.left, key);
        else if(root.val < key) root.right = deleteNode(root.right, key);
        else{
            // leaf node (0 child)
            if(root.left == null && root.right == null) return null;
            // one side null (1 child)
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;

            // both child - root ko uske predecessor se replace karo
            // since left hai hi isiliye predecessor pakka hoga
            // step 1: find the predecessor
            Node pred = root.left;
            while(pred.right != null) pred = pred.right;
            // step 2: delete the predecessor as it's stored in pred
            root.left = deleteNode(root.left, pred.val);
            // step 3: now make the pred root
            pred.left = root.left;
            pred.right = root.right;
            return pred;
        }

        return root;
    }*/

    // Method 2: USING SUCCESSOR
    /*private static Node deleteNode(Node root, int key) {
        if(root == null) return null;

        if(root.val > key) root.left = deleteNode(root.left, key);
        else if(root.val < key) root.right = deleteNode(root.right, key);
        else{
            // leaf node (0 child)
            if(root.left == null && root.right == null) return null;
            // one side null (1 child)
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;

            // both child - root ko uske sucecessor se replace karo
            // since right hai hi isiliye sucecesor pakka hoga
            // step 1: find the sucecessor
            Node suc = root.right;
            while(suc.left != null) suc = suc.left;
            // step 2: delete the sucecessor as it's stored in suc
            root.right = deleteNode(root.right, suc.val);
            // step 3: now make the suc root
            suc.right = root.right;
            suc.left = root.left;
            return suc;
        }

        return root;
    }*/

    // tarika two copying the value -> isko v dono predecessor and successor se bana sakte hai
    private static Node deleteNode(Node root, int key) {
        if(root == null) return null;

        if(root.val > key) root.left = deleteNode(root.left, key);
        else if(root.val < key) root.right = deleteNode(root.right, key);
        else{
            // leaf node (0 child)
            if(root.left == null && root.right == null) return null;
            // one side null (1 child)
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;

            // both child - root me uske predecessor ka value daldo
            // since left hai hi isiliye predecesor pakka hoga
            // step 1: find the predecessor
            Node pred = root.left;
            while(pred.right != null) pred = pred.right;
            // step 2: copy the value of pred in root
            root.val = pred.val;
            // step 3: delete the pred node
            root.left = deleteNode(root.left, pred.val);
        }
        return root;
    }
    
    private static void display(Node root){
        if(root == null) return;
        System.out.print(root.val + " ");
        display(root.left);
        display(root.right);
    }
    
    public static void main(String[] args) {
        //                     50
        //                /           \
        //               /             \
        //             25                75
        //          /      \          /       \
        //        10        35       60        90
        //       /  \      /  \     /  \      /  \
        //     -5   15    30  40   55  65    80  100
        //    /          /
        //  -10        28

        Node a = new Node(50);
        Node b = new Node(25);
        Node c = new Node(75);
        Node d = new Node(10);
        Node e = new Node(35);
        Node f = new Node(60);
        Node g = new Node(90);
        Node h = new Node(-5);
        Node i = new Node(15);
        Node j = new Node(30);
        Node k = new Node(40);
        Node l = new Node(55);
        Node m = new Node(65);
        Node n = new Node(80);
        Node o = new Node(100);
        Node p = new Node(-10);
        Node q = new Node(28);

        a.left = b;  a.right = c;

        b.left = d;  b.right = e;
        c.left = f;  c.right = g;

        d.left = h;  d.right = i;
        e.left = j;  e.right = k;

        f.left = l;  f.right = m;
        g.left = n;  g.right = o;

        h.left = p;
        j.left = q;

        System.out.print("Current BST is: ");
        display(a);

        int leafKey = 100;
        a = deleteNode(a, leafKey);
        System.out.print("\nThe deleted BST is: ");
        display(a);

        int oneChildKey = 30;
        a = deleteNode(a, oneChildKey);
        System.out.print("\nThe deleted BST is: ");
        display(a);

        int midRootKey = 25;
        a = deleteNode(a, midRootKey);
        System.out.print("\nThe deleted BST is: ");
        display(a);

        int mainRootKey = 50;
        a = deleteNode(a, mainRootKey);
        System.out.print("\nThe deleted BST is: ");
        display(a);
    }
}
