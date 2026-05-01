package LinkedList;

import java.util.Scanner;

public class ReorderListLC143 {
    private static void reorder(Node head) {
        if(head == null || head.next == null) return;

        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        Node head2 = reverse(slow.next);
        slow.next = null;

        Node head1 = head;
        while(head2 != null){
            Node temp1 = head1.next;
            Node temp2 = head2.next;

            head1.next = head2;
            head2.next = temp1;

            head1 = temp1;
            head2 = temp2;
        }
    }

    public static Node reverse(Node head){
        if(head == null || head.next == null) return head;
        Node prev = null, fwd = null, curr = head;
        while (curr != null){
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        return prev;
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

        reorder(head);
        System.out.print("\nThe swapped linked list is: ");
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.val+ " ");
        }
    }
}
