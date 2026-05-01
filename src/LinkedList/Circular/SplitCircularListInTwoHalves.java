package LinkedList.Circular;

import java.util.Scanner;

public class SplitCircularListInTwoHalves {
    static class Pair {
        Node first;
        Node second;

        Pair(Node first, Node second) {
            this.first = first;
            this.second = second;
        }
    }

    public static Pair splitInHalves(Node head) {
        if (head == null || head.next == head) return new Pair(head, null);

        Node slow = head, fast = head;
        while(fast.next != head && fast.next.next != head){
            fast = fast.next.next;
            slow = slow.next;
        }

        // even no. of nodes - Isme fast ka next ka next head hoga, so fast ko aage badha dete hai yaniki last me kar dete hai
        if(fast.next.next == head) fast = fast.next;

        Node h2 = slow.next;
        slow.next = head;
        fast.next = h2;

        return new Pair(head, h2);
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

        // DISPLAY THE ORIGINAL LIST
        System.out.print("The original list is: ");
        display(head);

        // SPLITTING
        Pair result = splitInHalves(head);
        Node h1 = result.first;
        Node h2 = result.second;

        // DISPLAY THE CIRCULAR LISTS
        System.out.print("The split circular list 1 is: ");
        display(h1);

        System.out.print("The split circular list 2 is: ");
        display(h2);
    }
}