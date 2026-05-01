package LinkedList.Circular;

import java.util.Scanner;

public class DeleteANode {
    //Method -1 last tak ja Ke and conn tor k yani ki non-circular bana k
    /*public static Node deleteNodeWithGivenValue(Node head, int key) {
         if (head == null)
        return null;

        if (head.next == head) {
            if (head.val == key)
                return null;
            else
                return head;
        }

        Node tail = head;
        while(tail.next != head) tail = tail.next;
        tail.next = null;

        // checking if we have to delete the head node
        if(head.val == key){
            head = head.next;
            tail.next = head;
            return head;
        }

        Node prev = head;
        Node checkval = head.next;

        while(checkval != null){
            if(checkval.val == key){
                prev.next = checkval.next;
                break;
            }
            prev = prev.next;
            checkval = checkval.next;
        }

        // tail.next = head; // ye use karenge to jab last node delete hoga tab nullPointerException hoga
        Node newTail = head;
        while (newTail.next != null) {
            newTail = newTail.next;
        }
        newTail.next = head;

        return head;
    }*/

    //Method - 2 without breaking the last connection
    public static Node deleteNodeWithGivenValue(Node head, int key) {
        if (head == null)  return null;

        // Single node
        if (head.next == head) {
            if (head.val == key) return null;
            else return head;
        }

        // checking if we have to delete the head node
        if(head.val == key){
            Node tail = head;
            while(tail.next != head) tail = tail.next;
            head = head.next;
            tail.next = head;
            return head;
        }

        // Delete non-head node
        Node prev = head;
        Node checkval = head.next;
        while(checkval != head){
            if(checkval.val == key){
                prev.next = checkval.next;
                return head;
            }
            prev = prev.next;
            checkval = checkval.next;
        }

        return head;
    }

    public static void display(Node head){
        System.out.print(head.val + " ");
        Node temp = head.next;
        while(temp != head){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
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

        System.out.print("The original circular list is: ");
        display(head);

        System.out.print("Enter the value of node to be deleted: ");
        int key = sc.nextInt();

        head = deleteNodeWithGivenValue(head, key);
        System.out.print("The updated circular list is: ");
        display(head);
    }
}