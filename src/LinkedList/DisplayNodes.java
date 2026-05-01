package LinkedList;

//class Node{
//    int val;
//    Node next;
//    Node(int val){
//        this.val = val;
//    }
//}

public class DisplayNodes {
    //Stupid way - works only whn no. of heads are known
    /*public static void display(Node head){
        System.out.print(head.val+ " ");
        System.out.print(head.next.val+ " ");
        System.out.print(head.next.next.val+ " ");
        System.out.print(head.next.next.next.val+ " ");
        System.out.print(head.next.next.next.next.val+ " ");
    }*/

    //Good way - Using while loop
    /*public static void display(Node head){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }*/

    //Good way - Using for loop
    /*public static void display(Node head){
        for(Node temp = head; temp != null; temp = temp.next){
            System.out.print(temp.val + " ");
        }
        System.out.println();
    }*/

    // Using recursion
    public static void display(Node head){
        if(head == null) return;
        System.out.print(head.val + " ");
        display(head.next);
    }

    // printing a specific node - 0 indexed
    public static int get(Node head, int idx){
        Node temp = head;
        for(int i = 0; i < idx; i++){
            temp = temp.next;
        }
        return temp.val;
    }

    public static void main(String[] args) {
        Node a = new Node(10);
        Node b = new Node(20);
        Node c = new Node(30);
        Node d = new Node(40);
        Node e = new Node(50);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        display(a);

        // Checking null - if something is null it's parameter can't be assigned
        /*Node n = null;
        System.out.println(n.val); // NullPointerException
        System.out.println(n.next);  // NullPointerException
        n.val = 10;  // Same NullPointerException error*/

        System.out.println();
        System.out.println(get(a, 2));
    }
}