package LinkedList;

import java.util.Scanner;

public class MergeTwoSortedList {
    public static Node merge(Node head1, Node head2) {
        Node dummy = new Node(-1);

        Node temp1 = head1, temp2 = head2, travelNode = dummy;
        while(temp1 != null && temp2 != null){
            if(temp1.val > temp2.val){
                travelNode.next = temp2;
                travelNode = travelNode.next;
                temp2 = temp2.next;
            }
            else{
                travelNode.next = temp1;
                travelNode = travelNode.next;
                temp1 = temp1.next;
            }
        }

        if(temp1 == null) travelNode.next = temp2;
        else travelNode.next = temp1;

        return dummy.next;
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

        Node sortedHead = merge(head1, head2);
        System.out.println("\nThe Merged linked list is: ");
        for (Node temp = sortedHead; temp != null; temp = temp.next) {
            System.out.print(temp.val+ " ");
        }
    }
}
