package LinkedList.Doubly;

public class FlattenMultilevelDoublyList {
    static class SpecialNode {
        public int val;
        public SpecialNode prev;
        public SpecialNode next;
        public SpecialNode child;
    }

    public static  SpecialNode flatten(SpecialNode head) {
        if(head == null) return head;
        SpecialNode curr = head;
        while(curr != null){
            if(curr.child == null) curr = curr.next;
            else{
                SpecialNode fwd = curr.next;

                // Recursively flattening the child 
                SpecialNode c = flatten(curr.child);

                // making the child of current to null, as it's now included in the main answer list
                curr.child = null;

                // connecting child to current
                curr.next = c;
                c.prev = curr;

                //connecting tail of the list to fwd
                SpecialNode temp = c;
                while(temp.next != null) temp = temp.next;

                // Connecting to the forward node
                temp.next = fwd;
                if(fwd != null) fwd.prev = temp;

                // Moving current to forward
                curr = fwd;
            }
        }
        return head;
    }

    public static  SpecialNode flatten2(SpecialNode head){
        if(head == null) return null;

        SpecialNode curr = head;
        while (curr != null){
            // agar child ho to
            if(curr.child != null){
                SpecialNode fwd = curr.next;
                SpecialNode childHead = curr.child;

                // Connecting to the child
                curr.next = childHead;
                childHead.prev = curr;
                curr.child = null;

                // Finding the tail of child branch
                SpecialNode tail = childHead;
                while (tail.next != null) tail = tail.next;

                // Connecting the child tail to original fwd
                tail.next = fwd;
                if(fwd != null) fwd.prev = tail;
            }
            curr = curr.next;
        }
        return head;
    }
}
