package LinkedList.Circular;

import java.util.Scanner;

public class CircularList {
    // DISPLAY METHOD - 1
    /*public static void display(Node head){
        Node temp = head;
        while(temp.next != head){
            System.out.print(temp.val + " "); // Isse last wala element print nahi hoga.
            temp = temp.next;
        }
        System.out.println(temp.val); // To print the last value and going to next line
    }*/

    // DISPLAY METHOD - 2
    public static void display(Node head){
        System.out.print(head.val + " "); // To print first element
        Node temp = head.next;
        while(temp != head){
            System.out.print(temp.val + " "); // To print all elements other than head
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the list elements separated by a single space for circular list: ");
        String[] input = sc.nextLine().split(" ");

        Node head = null, current = null;

        for(String s: input){
            Node newNode = new Node(Integer.parseInt(s));

            if(head == null) head = newNode;
            else current.next = newNode;

            current = newNode;
        }
        //Assuming that the List is not empty
        current.next = head;

        // DISPLAY THE ORIGINAL LIST
        System.out.print("The original Circular list is: ");
        display(head);
    }
}