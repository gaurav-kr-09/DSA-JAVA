package LinkedList.Doubly;

import java.util.Scanner;

public class RotateDoublyList {
    // Using Reverse
    /*public static Node leftRotate(Node head, int k){
        if(head == null || head.next == null) return head;

        Node head1 = head, tail1 = head;
        for(int i = 1; i < k; i++){
            tail1 = tail1.next;
        }

        Node head2 = tail1.next;
        tail1.next = null;
        head2.prev = null;

        tail1 = reverse(head1);
        Node tail2 = reverse(head2);

        head1.next = tail2;
        tail2.prev = head1;

        tail1.prev = null;
        head2.next = null;

        return reverse(tail1);
    }*/

    /*public static Node rightRotate(Node head, int k){
        if(head == null || head.next == null) return head;

        Node head1 = reverse(head);
        Node tail2 = head;
        Node tail1 = head1;

        for(int i = 1; i < k; i++){
            tail1 = tail1.next;
        }

        Node head2 = tail1.next;
        head2.prev = null;
        tail1.next = null;
        tail2.next = null;
        head1.prev = null;

        tail1 = reverse(head1);
        tail2 = reverse(head2);

        tail1.prev = null;
        head1.next = tail2;
        tail2.prev = head1;
        head2.next = null;

        return tail1;
    }*/

    // Without using reverse
    public static Node leftRotate(Node head, int k) {
        if (head == null || head.next == null) return head;

        Node tail = head;
        int length = 1;
        while(tail.next != null){
            tail = tail.next;
            length++;
        }
        k %=  length;
        if(k == 0) return head;

        // moving to kth node
        Node newTail = head;
        for (int i = 1; i < k; i++) {
            newTail = newTail.next;
        }

        Node newHead = newTail.next;
        newTail.next = null;
        newHead.prev = null;

        tail.next = head;
        head.prev = tail;

        return newHead;
    }

    public static Node rightRotate(Node head, int k) {
        if (head == null || head.next == null) return head;

        Node tail = head;
        int length = 1;
        while(tail.next != null){
            tail = tail.next;
            length++;
        }
        k %=  length;
        if(k == 0) return head;

        // moving to new tail node
        /*Node newTail = head;
        for (int i = 1; i < length - k; i++) {
            newTail = newTail.next;
        }

        Node newHead = newTail.next;
        newTail.next = null;
        newHead.prev = null;

        tail.next = head;
        head.prev = tail;
        return newHead;*/

        // upar wala pura k jagah pe ye v likh sakte hai
        return leftRotate(head, length - k);
    }

    public static Node reverse(Node head){
        if(head == null || head.next == null) return head;

        Node temp = null, curr = head;
        while(curr != null){
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;

            curr = curr.prev;
        }
        return temp.prev;
    }

    public static void display(Node head){
        if(head == null) return;
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp .next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the list elements separated by a single space for doubly list: ");
        String[] input = sc.nextLine().split(" ");

        Node head = null, current = null;
        for(String s: input){
            Node newNode = new Node(Integer.parseInt(s));
            if(head == null){
                head = newNode;
                head.prev = null;
            }
            else{
                current.next = newNode;
                newNode.prev = current;
            }

            current = newNode;
        }

        System.out.print("The original Doubly list is: ");
        display(head);

        // Assuming k must be less than no. of nodes
        System.out.print("Enter k: ");
        int k = sc.nextInt();

//        head = leftRotate(head, k);
//        System.out.print("The left rotated doubly list is: ");
//        display(head);

        head = rightRotate(head, k);
        System.out.print("The right rotated doubly list is: ");
        display(head);

    }
}
