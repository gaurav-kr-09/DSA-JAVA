package BinarySearchTree;

public class PracticeSizeMInMaxSum {
    static class Quad{
        int max;
        int min;
        int size;
        int sum;
        Quad(int max, int min, int size, int sum){
            this.max = max;
            this.min = min;
            this.size = size;
            this.sum = sum;
        }
    }

    private static Quad maxMinSizeSum(Node root){
        if(root == null) return new Quad(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);

        Quad lst = maxMinSizeSum(root.left);
        Quad rst = maxMinSizeSum(root.right);

        int max = Math.max(root.val, Math.max(lst.max, rst.max));
        int min = Math.min(root.val, Math.min(lst.min, rst.min));
        int size = 1 + lst.size + rst.size;
        int sum = root.val + lst.sum + rst.sum;

        return new Quad(max, min, size, sum);
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

        a.left = b;
        a.right = c;

        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        d.left = h;
        d.right = i;
        e.left = j;
        e.right = k;

        f.left = l;
        f.right = m;
        g.left = n;
        g.right = o;

        h.left = p;
        j.left = q;

        System.out.println("For the given tree: ");
        Quad ans = maxMinSizeSum(a);
        System.out.println("Max is: " + ans.max);
        System.out.println("Min is: " + ans.min);
        System.out.println("size is: " + ans.size);
        System.out.println("sum is: " + ans.sum);
    }
}
