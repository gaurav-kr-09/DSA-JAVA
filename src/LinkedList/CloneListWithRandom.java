package LinkedList;

public class CloneListWithRandom {
    static class RNode {
        int val;
        RNode next;
        RNode random;
        RNode(int val) {this.val = val;}
    }
    
    public static RNode copyRandomList(RNode head) {
        if(head == null) return null;
        // Step 1: Creating a deep copy without random
        RNode head2 = deepCopy(head);
        // Step 2: Alternatively connecting lists
        merge(head,head2);
        // Step 3: making the random connections
        randomConnection(head, head2);
        // Step 4: Split the list
        split(head);

        return head2;
    }

    public static RNode deepCopy(RNode head){
        RNode dummy = new RNode(-1);
        RNode t1 = head, t2 = dummy;
        while(t1 != null){
            t2.next = new RNode(t1.val);
            t2 = t2.next;
            t1 = t1.next;
        }
        return dummy.next;
    }

    public static void merge(RNode h1, RNode h2){
        RNode dummy = new RNode(-1);
        RNode t = dummy, t1 = h1, t2 = h2;

        while(t1 != null && t2 != null){
            t.next = t1;
            t1 = t1.next;
            t = t.next;

            t.next = t2;
            t2 = t2.next;
            t = t.next;
        }
    }

    public static void randomConnection(RNode h1, RNode h2){
        RNode t1 = h1, t2 = h2;
        while(t1 != null && t2 != null){
            if(t1.random == null) t2.random = null;
            else t2.random = t1.random.next;

            t1 = t1.next.next;
            if(t2.next != null)t2 = t2.next.next;
        }
    }

    public static void split(RNode h1){
        RNode d1 = new RNode(-1), d2 = new RNode(-1);
        RNode t1 = d1, t2 = d2, t = h1;

        while(t != null){
            t1.next = t;
            t1 = t1.next;
            t = t.next;

            t2.next = t;
            t2 = t2.next;
            t = t.next;
        }
        t1.next = null;
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
