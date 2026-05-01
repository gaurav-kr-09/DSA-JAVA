package LinkedList;

import java.util.Scanner;

public class SortLinkedList {
    private static Node mergeSort(Node head) {
        if(head == null) return null;
        if(head.next == null) return head;
        Node fast = head, slow = head;

        // Finding the left middle for even and middle for odd
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        Node head2 = slow.next;
        slow.next = null;

        head = mergeSort(head);
        head2 = mergeSort(head2);

        return merge(head, head2);
    }

    private static Node merge(Node head1, Node head2) {
        Node dummy = new Node(-1);
        Node i = head1, j = head2, k = dummy;

        while(i != null && j != null){
            if(i.val > j.val){
                k.next = j;
                j = j.next;
            }else{
                k.next = i;
                i = i.next;
            }
            k = k.next;
        }

        if(i == null) k.next = j;
        else k.next = i;

        return dummy.next;
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

        Node sortedHead = mergeSort(head);

        System.out.print("\nThe Sorted linked list is: ");
        for (Node temp = sortedHead; temp != null; temp = temp.next) {
            System.out.print(temp.val+ " ");
        }
    }
}
