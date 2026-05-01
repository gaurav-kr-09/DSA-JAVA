package LinkedList;

//class Node{
//    int val;
//    Node next; // iska default value null hai.
//    Node(int val){
//        this.val = val;
//    }
//}

public class Basics2 {
    public static void main(String[] args) {
        // Node
        Node a = new Node(10);
        Node b = new Node(20);
        Node c = new Node(30);
        Node d = new Node(40);
        Node e = new Node(50);

        System.out.println(a.val);
        System.out.println(a.next);

        // Connecting / Linking the Node
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        System.out.println(a); // LinkedList.Node@8efb846
        System.out.println(b); // LinkedList.Node@2a84aee7
        System.out.println(a.next); // Same as b

        System.out.println(c);
        System.out.println(b.next);

        System.out.println(a.next.next); // same as c

        System.out.println(a.next.next.next.val); // value of d -> 40
    }
}
