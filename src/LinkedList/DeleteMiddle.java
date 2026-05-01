package LinkedList;

import java.util.Scanner;

public class DeleteMiddle {
    //2 pass solution
    /*public static Node delete(Node head){
        // If only one element is present
        if(head.next == null){
            return null;
        }

        Node temp = head;
        int length = 0;
        while(temp != null){
            temp = temp.next;
            length ++;
        }

        int middle = length/2;
        temp = head;
        for(int i = 0; i < middle - 1; i++){
            temp = temp.next;
        }

        temp.next = temp.next.next;
        return head;
    }*/

    //1 pass solution
    public static Node delete(Node head){
        // If only one element is present
        if(head.next == null){
            return null;
        }
//        Node fast = head.next.next, slow = head;

        // This will also work
         Node fast = head, slow = new Node(-1);
         slow.next = head;

        while(fast!= null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the list elements separated by a single space: ");
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

        head = delete(head);

        System.out.print("\nThe updated linked list is: ");
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.val+ " ");
        }
    }
}
