package LinkedList.Doubly;

import java.util.Scanner;

public class DoublyList {
    public static void display(Node head){
        if(head == null) return;
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp .next;
        }
        System.out.println();
    }

    public static Node addAtHead(Node head, int val){
        Node newNode = new Node(val);
        if(head == null) return newNode;
        newNode.next = head;
        newNode.prev = null;
        head.prev = newNode;
        return newNode;
    }

    public static Node addAtTail(Node head, int val){
        Node newNode = new Node(val);
        if(head == null) return newNode;

        //Travel to end to find tail
        Node temp = head;
        while (temp.next != null) temp = temp.next;

        newNode.next = null;
        newNode.prev = temp;
        temp.next = newNode;
        return head;
    }

    public static Node addAtIndex(Node head, int index, int val){
        if(index < 1){
            System.out.println("-ve index");
            return head;
        }
        if(index == 1) return addAtHead(head, val);

        Node newNode = new Node(val);
        Node temp = head;
        for (int i = 1; i < index-1 && temp != null; i++) temp = temp.next;

        if(temp == null){
            System.out.println("Index greater than list");
            return head;
        }

        newNode.next = temp.next;
        newNode.prev = temp;
        if(temp.next != null) temp.next.prev = newNode;
        temp.next = newNode;
        return head;
    }

    public static Node deleteAtHead(Node head){
        if(head == null || head.next == null) return null;

        head = head.next;
        head.prev = null;
        return head;
    }

    public static Node deleteAtTail(Node head){
        if(head == null || head.next == null) return null;

        // travelling to just before tail
        Node tail = head;
        while(tail.next.next != null) tail = tail.next;

        //M -1
        // tail.next.prev = null;
        // tail.next = null;

        //M-2
         tail.next = null;

        //M-3
        //while(tail.next != null) tail = tail.next;
        //tail = tail.prev;
        //tail.next = null;

        return head;
    }

    public static Node deleteAtIndex(Node head, int index){

        if(index < 1){
            System.out.println("-ve index");
            return head;
        }
        if(head == null) return null;
        if(index == 1) return deleteAtHead(head);

        Node temp = head;
        for (int i = 1; i < index-1 && temp != null; i++) temp = temp.next;

        if(temp == null || temp.next == null){
            System.out.println("Index greater than list");
            return head;
        }

        if(temp.next.next != null) temp.next.next.prev = temp;
        temp.next = temp.next.next;

        return head;
    }

    public static void displayReverse(Node head){
        if(head == null) return;
        Node temp = head;
        while(temp.next != null) temp = temp .next;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the list elements separated by a single space for doubly list: ");
        String[] input = sc.nextLine().split(" ");

        Node head = null, current = null;
        for(String s: input){
            Node newNode = new Node(Integer.parseInt(s));
            if(head == null){
                head = newNode;
                head.prev = null;
            }
            else{
                current.next = newNode;
                newNode.prev = current;
            }

            current = newNode;
        }

        // DISPLAY THE ORIGINAL LIST
        System.out.print("The original Doubly list is: ");
        display(head);

//        // ADDING AT HEAD
//        System.out.print("Enter value to add at head: ");
//        head = addAtHead(head,sc.nextInt());
//        System.out.print("The head added Doubly list is: ");
//        display(head);
//
//        // ADDING AT TAIL
//        System.out.print("Enter value to add at tail: ");
//        head = addAtTail(head,sc.nextInt());
//        System.out.print("The tail added Doubly list is: ");
//        display(head);
//
//        // ADDING AT INDEX - 1 BASED INDEXING
//        System.out.print("Enter index: ");
//        int index = sc.nextInt();
//        System.out.print("Enter value to add at index: ");
//        head = addAtIndex(head, index, sc.nextInt());
//        System.out.print("The indexical added Doubly list is: ");
//        display(head);

//        //Delete At head;
//        head = deleteAtHead(head);
//        System.out.print("The head deleted Doubly list is: ");
//        display(head);
//
//        //Delete At tail;
//        head = deleteAtTail(head);
//        System.out.print("The tail deleted Doubly list is: ");
//        display(head);

//        // Delete at index
//        System.out.print("Enter index: ");
//        head = deleteAtIndex(head, sc.nextInt());
//        System.out.print("The tail deleted Doubly list is: ");
//        display(head);

        //Displaying in reverse order
        System.out.print("The Reversed Doubly list is: ");
        displayReverse(head);
    }
}
