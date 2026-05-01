package LinkedList;

public class RemoveDuplicatesFromSortedLL {
    // Using two pointers
    /*private static Node removeDuplicate(Node head) {
        if(head == null) return null;

        Node back = head, front = head;
        while(front != null){
            if(front.val == back.val) front = front.next;
            else{
                back.next = front;
                back = front;
                // ye niche wala line de ya na de koi fark nahi parega but dena jyada better hai
                front = front.next;
            }
        }
        back.next = null; //fast
        return head;
    }*/

    // Using a single pointer
    private static Node removeDuplicate(Node head) {
        if (head == null) return null;

        Node current = head;

        while (current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;  // skip duplicate
            } else {
                current = current.next;  // move forward
            }
        }

        return head;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(1);
        Node c = new Node(1);
        Node d = new Node(2);
        Node e = new Node(2);
        Node f = new Node(3);
        Node g = new Node(4);
        Node h = new Node(4);
        Node i = new Node(4);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = f;
        e.next = f;
        f.next = g;
        g.next = h;
        h.next = i;
        i.next = null;

        Node head = removeDuplicate(a);
        System.out.print("New list is: ");
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.val+ " ");
        }
    }
}
