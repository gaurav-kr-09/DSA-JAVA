package LinkedList.Circular;

import java.util.Scanner;

public class SinglyToCircular {
    public static void displaySingly(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void displayCircular(Node head){
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

        // DISPLAY THE ORIGINAL LIST
        System.out.print("The original list is: ");
        displaySingly(head);

        // CONVERTING TO CIRCULAR
        if(head == null){
            System.out.println("Empty List");
            return;
        }else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = head;
        }

        // DISPLAY THE CIRCULAR LIST
        System.out.print("The converted circular list is: ");
        displayCircular(head);
    }
}
