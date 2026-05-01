package LinkedList;

import java.util.Scanner;

public class AddNumberLinkedList {
    public static Node sumList(Node l1, Node l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        Node dummy = new Node(-1);
        Node travel = dummy;
        int carry = 0;
        while(l1 != null || l2 != null){
            if(l1 != null){
                carry += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                carry += l2.val;
                l2 = l2.next;
            }

            Node temp = new Node(carry % 10);
            temp.next = null;
            travel.next = temp;
            travel = travel.next;

            carry /= 10;
        }

        if(carry != 0) {
            travel.next = new Node(carry);
            travel.next = null;
        }

        return reverse(dummy.next);
    }

    public static Node reverse(Node head){
        if(head== null || head.next == null) return head;
        Node prev = null, fwd = null, curr = head;
        while(curr != null){
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }

        return prev;
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

        Node sortedHead = sumList(head1, head2);
        System.out.println("\nThe Sum linked list is: ");
        for (Node temp = sortedHead; temp != null; temp = temp.next) {
            System.out.print(temp.val+ " ");
        }
    }
}
