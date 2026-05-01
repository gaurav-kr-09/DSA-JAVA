package LinkedList;

public class RemoveDuplicateNodesFromSortedLLLc82 {
    private static Node removeDuplicateNodes(Node head) {
        if(head == null) return null;

        Node dummy = new Node(-1);
        Node current = head, prev = dummy;

        while(current != null){
            if(current.next != null && current.val == current.next.val){ // Matlab duplicate hai
                while(current.next != null && current.val == current.next.val){
                    current = current.next;
                }
                prev.next = current.next; // prev ka next current ka agla kar diye kyuki ho sakta hai wo v duplicate ho
                current = current.next;
            }else{ // matlab duplicate nahi hai
                prev = current;
                current = current.next;
            }
        }

        return dummy.next;
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
        Node i = new Node(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
        h.next = i;
        i.next = null;

        Node head = removeDuplicateNodes(a);
        System.out.print("New list is: ");
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.val+ " ");
        }
    }
}
