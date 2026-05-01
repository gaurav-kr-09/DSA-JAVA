package LinkedList;

import java.util.Scanner;

public class PartitionList {
    private static Node part(Node head, int x) {
        if(head == null || head.next == null) return head;
        Node dummy1 = new Node(-1);
        Node dummy2 = new Node(-1);
        // t1 for smaller values, t2 for larger and equal and t for traversing
        Node t1 = dummy1, t2 = dummy2, t = head;

        while(t != null){
            if(t.val < x){
                t1.next = t;
                t1 = t1.next;
            }else{
                t2.next = t;
                t2 = t2.next;
            }
            t = t.next;
        }

        t1.next = dummy2.next;
        t2.next = null;

        return dummy1.next;
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

        System.out.print("\nEnter k: ");
        int x = sc.nextInt();

       head = part(head, x);
        System.out.print("The Parted linked list is: ");
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.val+ " ");
        }
    }
}
