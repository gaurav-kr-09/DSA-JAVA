package LinkedList;

public class FindingFirstNodeOfLoop {
    public static Node findNode(Node head){
        Node slow = head, fast = head, temp = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }

        if(fast == null || fast.next == null) return null;

        while (slow != temp){
            slow = slow.next;
            temp = temp.next;
        }

        return slow; // temp
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
        f.next = d; // loop
//        f.next = null; // no loop

        Node ans = findNode(a);
        if(ans != null) System.out.println(ans.val);
        else System.out.println("Not a cycle");
    }
}
