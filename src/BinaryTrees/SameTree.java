package BinaryTrees;

public class SameTree {
    private static boolean isSameTree(Node r1, Node r2){
        if(r1 == null && r2 == null) return true;
        if(r1 == null || r2 == null) return false;
        if(r1.val != r2.val) return false;

        return isSameTree(r1.left, r2.left) && isSameTree(r1.right, r2.right);
    }

    public static void main(String[] args) {
        //       TREE 1         &&       TREE 2
        //         3            &&         3
        //       /   \          &&       /   \
        //      4     2         &&      4     2
        //     / \    / \       &&     / \    / \
        //   -1   1  6   9      &&   -1   1  6   9

        // TREE 1
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

        // TREE 2
        Node p = new Node(3);
        Node q = new Node(4);
        Node r = new Node(2);
        Node s = new Node(-1);
        Node t = new Node(1);
        Node u = new Node(6);
        Node v = new Node(9);


        p.left = q; p.right = r;
        q.left = s; q.right = t;
        r.left = u; r.right = v;

        System.out.println(isSameTree(a, p) ? "same tree" : "not same");
    }
}