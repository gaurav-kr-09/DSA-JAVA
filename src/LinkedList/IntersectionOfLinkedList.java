package LinkedList;

import java.util.Scanner;

public class IntersectionOfLinkedList {
    // Method - 1, 3 pass soln - isse intersected ll print nahi ho pa rha hai
    /*public static Node interSectionPoint(Node head1, Node head2) {
        Node t1 = head1, t2 = head2;
        int l1 = 0, l2 = 0;

        while(t1 != null) {
            t1 = t1.next;
            l1++;
        }

        while(t2 != null) {
            t2 = t2.next;
            l2++;
        }

        t1 = head1;
        t2 = head2;

        if(l1 > l2){
            for (int i = 0; i < l1 - l2; i++) {
                t1 = t1.next;
            }
        }else{
            for (int i = 0; i < l2 - l1; i++) {
                t2 = t2.next;
            }
        }

        while(t1 != t2){
            t1 = t1.next;
            t2 = t2.next;
        }

        return t1; // t2
    }*/

    // Method - 2, 1 pass soln - isse intersected ll print nahi ho pa rha hai kyuki ye sirf current jagah ka address bhej rha hai pura list nahi.
    public static Node interSectionPoint(Node head1, Node head2) {
        if(head1 == null || head2 == null) return null;

        Node t1 = head1, t2 = head2;

        while(t1 != t2){
            t1 = (t1 == null) ? head2 : t1.next;
            t2 = (t2 == null) ? head1 : t2.next;
        }

        return t1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the list elements separated by a single space for list1: ");
        String[] input1 = sc.nextLine().split(" ");

        Node head1 = null, current1 = null;

        for(String s: input1){
            Node newNode = new Node(Integer.parseInt(s));

            if(head1 == null) head1 = newNode;
            else current1.next = newNode;

            current1 = newNode;
        }

        System.out.print("The linked list1 is: ");
        for (Node temp = head1; temp != null; temp = temp.next) {
            System.out.print(temp.val+ " ");
        }

        System.out.print("\nEnter the list elements separated by a single space for list2: ");
        String[] input2 = sc.nextLine().split(" ");

        Node head2 = null, current2 = null;

        for(String s: input2){
            Node newNode = new Node(Integer.parseInt(s));

            if(head2 == null) head2 = newNode;
            else current2.next = newNode;

            current2 = newNode;
        }

        System.out.print("The linked list2 is: ");
        for (Node temp = head2; temp != null; temp = temp.next) {
            System.out.print(temp.val+ " ");
        }
    }
}
