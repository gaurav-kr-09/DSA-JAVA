package LinkedList;

import java.util.Scanner;

public class OddEvenLinkedList {
    // according to index
    /*public static Node updatedListIndex(Node head){
        if(head == null || head.next == null) return head;

        Node deven = new Node(-1);
        Node dodd = new Node(-1);

        Node t1 = deven, t2 = dodd, t = head;

        int i = 1;
        while(t != null){
            if(i % 2 != 0){
                t2.next = t;
                t2 = t2.next;
            } else {
                t1.next = t;
                t1 = t1.next;
            }
            t = t.next;
            i++;
        }

        t2.next = deven.next;
        t1.next = null;

        return dodd.next;
    }*/

    // this will also work but only for according to index
    public static Node updatedListIndex(Node head) {
        if (head == null || head.next == null) return head;

        Node odd = head;
        Node even = head.next;
        Node evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }

    // according to value
    public static Node updatedListValue(Node head){
        if(head == null || head.next == null) return head;

        Node deven = new Node(-1);
        Node dodd = new Node(-1);

        Node t1 = deven, t2 = dodd, t = head;

        while(t != null){
            if(t.val % 2 != 0){
                t2.next = t;
                t2 = t2.next;
            } else {
                t1.next = t;
                t1 = t1.next;
            }
            t = t.next;
        }

        t2.next = deven.next;
        t1.next = null;

        return dodd.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the list elements separated by a single space for list: ");
        String[] input = sc.nextLine().split(" ");

        Node head = null, current = null;

        for(String s: input){
            Node newNode = new Node(Integer.parseInt(s));

            if(head == null) head = newNode;
            else current.next = newNode;

            current = newNode;
        }

        System.out.print("The linked list1 is: ");
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.val+ " ");
        }

        head = updatedListIndex(head);
        System.out.print("\nThe odd even linked list a/c to index is: ");
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.val+ " ");
        }

        head = updatedListValue(head);
        System.out.print("\nThe odd even linked list a/c to value is: ");
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.val+ " ");
        }
    }
}
