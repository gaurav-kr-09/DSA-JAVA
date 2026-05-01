package LinkedList;

import java.util.Scanner;

public class SegregateEvenAndOdd {
    private static Node segregatedList(Node head) {
        if(head == null || head.next == null) return head;
        Node d1 = new Node(-1); // odd
        Node d2 = new Node(-1); // even
        Node t1 = d1, t2 = d2, t = head;

        int i = 1;
        while(t != null){
            if(i % 2 != 0){
                t1.next = t;
                t1 = t1.next;
            }else{
                t2.next = t;
                t2 = t2.next;
            }
            t = t.next;
            i++;
        }
        t2.next = null;
        t1.next = d2.next;

        return d1.next;
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

        head = segregatedList(head);
        System.out.print("\nThe segregated linked list is: ");
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.val+ " ");
        }
    }
}
