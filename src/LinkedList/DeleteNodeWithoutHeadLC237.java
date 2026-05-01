package LinkedList;

import java.util.Scanner;

public class DeleteNodeWithoutHeadLC237 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the list elements separated by a single space (a/c to qn demand): ");
        String[] input = sc.nextLine().split(" ");

        Node head = null, current = null;

        for(String s: input){
            Node newNode = new Node(Integer.parseInt(s));

            if(head == null) head = newNode;
            else current.next = newNode;

            current = newNode;
        }

        System.out.print("The linked list is: ");
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.val+ " ");
        }

        // # se kam element me kam nahi karega
        Node toDelete = head.next.next;
        deleteNode(toDelete);
        System.out.print("\nNow, the linked list is: ");
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.val+ " ");
        }
    }

    private static void deleteNode(Node toDelete) {
        toDelete.val = toDelete.next.val;
        toDelete.next = toDelete.next.next;
    }
}
