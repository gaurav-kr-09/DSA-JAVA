package LinkedList;

public class CloneListWithRandom2 {
    static class RNode {
        int val;
        RNode next;
        RNode random;
        RNode(int val) {this.val = val;}
    }

    public static RNode copyRandomList(RNode head) {
        if(head == null) return null;

        // Step 1: Insert the copy of each node
        RNode curr = head;
        while(curr != null){
            RNode copy = new RNode(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Step 2: Connecting random
        curr = head;
        while (curr != null){
            RNode copy = curr.next;
            if(curr.random != null) copy.random = curr.random.next;
            curr = copy.next;
        }

        // Step 3: Separate the original and copied List
        curr = head;
        RNode copyHead = curr.next;
        while(curr != null){
            RNode copy = curr.next;
            curr.next = copy.next;
            if(curr.next != null) copy.next = curr.next.next;
            curr = curr.next;
        }

        return copyHead;
    }

    public static void main(String[] args) {
        RNode a = new RNode(7);
        RNode b = new RNode(13);
        RNode c = new RNode(11);
        RNode d = new RNode(10);
        RNode e = new RNode(1);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;

        a.random = c;
        b.random = b;
        c.random = e;
        d.random = c;
        e.random = a;

        RNode head = a;
        System.out.print("The original linked list is: ");
        for (RNode temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.val+ " R " + temp.random.val + " -> ");
        }

        RNode head2 = copyRandomList(head);

        System.out.print("\nThe deep copied linked list is: ");
        for (RNode temp = head2; temp != null; temp = temp.next) {
            System.out.print(temp.val+ " R " + temp.random.val + " -> ");
        }
    }
}
