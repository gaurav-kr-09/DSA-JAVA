package LinkedList.Circular;

import java.util.Scanner;

public class ReverseCircularList {
    public static void display(Node head){
        System.out.print(head.val + " ");
        Node temp = head.next;
        while(temp != head){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Method - 1, converting circular to simple i.e making the last connection from head to null
    /*public static Node reverse(Node head){
        if(head == null || head.next == head) return head;

        // Step 1 making the list singly ie removing circular
        Node tail =  head;
        while(tail.next != head) tail = tail.next;
        tail.next = null;

        // step - 2 reversing
        Node curr = head, prev = null, fwd = null;
        while(curr != null){
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }

        //Connecting the new last node to the new head
        head.next = prev;

        // returning the new head
        return prev;
    }*/

    // Method - 2 using do while loop in single pass
    /*public static Node reverse(Node head){
        if(head == null || head.next == head) return head;

        Node curr = head, prev = null, fwd;

        do{
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        while(curr != head);

        // now connecting new tail to new head i.e head to prev
        head.next = prev;

        // returning the new head
        return prev;
    }*/

    // Method - 3 similar to method 1 but in single pass
    public static Node reverse(Node head){
        if(head == null || head.next == head) return head;

        Node prev = head, curr = head.next;

        while(curr != head){
            Node fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        head.next = prev;

        // returning the new head
        return prev;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the singly list elements separated by a single space: ");
        String[] input = sc.nextLine().split(" ");

        Node head = null, current = null;
        for(String s: input){
            Node newNode = new Node(Integer.parseInt(s));
            if(head == null) head = newNode;
            else current.next = newNode;
            current = newNode;
        }
        //Assuming it's not empty
        current.next = head;

        // DISPLAY THE ORIGINAL LIST
        System.out.print("The original list is: ");
        display(head);

        head = reverse(head);
        System.out.print("The reversed circular list is: ");
        display(head);
    }
}
