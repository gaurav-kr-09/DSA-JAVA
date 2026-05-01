package LinkedList;

public class CycleDetection {
    public static boolean detect(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return  true;
        }
        return false;
    }

    public static void main(String[] args) {
        Node a = new Node(5);
        Node b = new Node(12);
        Node c= new Node(0);
        Node d = new Node(2);
        Node e = new Node(4);
        Node f = new Node(8);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = c; // loop
//        f.next = null; // no loop

        System.out.println(detect(a));
    }
}