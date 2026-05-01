package LinkedList;

import java.util.Scanner;

public class SwapNodesInPairs {
    private static Node swapAdjacent(Node head) {
        Node dummy = new Node(-1);
        dummy.next = head;
        Node prev = dummy;

        while(prev.next != null && prev.next.next != null){
            Node first = prev.next;
            Node second = prev.next.next;

            // Swapping
            first.next = second.next;
            second.next = first;
            prev.next = second;

            prev = first;
        }

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

        head = swapAdjacent(head);
        System.out.print("\nThe swapped linked list is: ");
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.val+ " ");
        }
    }
}
