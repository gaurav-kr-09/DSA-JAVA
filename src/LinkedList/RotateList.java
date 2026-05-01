package LinkedList;

// Lc - 61
public class RotateList {
    // Method 1 - 3 pass
    /*public static Node rotateRight(Node head, int k) {
        if(head == null || head.next == null || k == 0) return head;

        Node slow = head, fast = head;
        int length = 0;
        while(fast != null){
            fast = fast.next;
            length++;
        }

        fast = head;
        k %= length;
        if(k == 0) return head;
        for(int i = 0; i <= k; i++){ // Move the fast one more than k 
            fast = fast.next;
        }

        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        Node tempHead = slow.next;
        fast = tempHead;
        slow.next = null;

        while(fast.next != null){
            fast = fast.next;
        }

        fast.next = head;
        return tempHead;
    }*/

    // Method 2 - 2 pass
    public static Node rotateRight(Node head, int k) {
        if(head == null || head.next == null || k == 0) return head;

        Node temp = head;
        int length = 1;
        while(temp.next != null){
            temp = temp.next;
            length++;
        }
        temp.next = head;

        k %= length;
        temp = head;

        // pichh se k - 1 st node
        int newTail = length - k - 1;
        for(int i = 0; i < newTail; i++){
            temp = temp.next;
        }

        Node newHead = temp.next;
        temp.next = null;
        return newHead;
    }

    // Left Rotation
    public static Node rotateLeft(Node head, int k) {
        if(k == 0 || head == null || head.next == null) return head;

        int length = 1;
        Node temp = head;

        while(temp.next != null){
            temp = temp.next;
            length++;
        }
        k %= length;


        temp.next = head;
        for(int i = 0; i < k; i++){
            temp = temp.next;
        }

        Node newHead = temp.next;
        temp.next = null;
        return newHead;
    }
    
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = null;

        Node head = rotateRight(a, 3);
        System.out.print("Right rotated array is: ");
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.val+ " ");
        }

        head = rotateLeft(e, 3);
        System.out.print("\nLeft rotated array is: ");
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.val+ " "); // Purana List wapas mil jayega.
        }
    }
}
