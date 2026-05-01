package LinkedList.Doubly;

import java.util.Scanner;

public class Reverse {
    // Method 1 - using three pointers
    /*public static Node reverse(Node head){
        if(head == null || head.next == null) return head;
        Node pre = null, fwd = null, curr = head;

        while(curr != null){
            fwd = curr.next;
            curr.next = pre;
            curr.prev = fwd;
            pre = curr;
            curr = fwd;
        }

        return pre;
    }*/

    // Method 2 - using two pointers
    public static Node reverse(Node head){
        if(head == null || head.next == null) return head;
        Node curr = head, temp = null;

        while(curr != null){
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;

            curr = curr.prev;
        }

        return temp.prev;
    }

    public static void display(Node head){
        if(head == null) return;
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp .next;
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

        System.out.print("The original Doubly list is: ");
        display(head);

        head = reverse(head);

        System.out.print("The Reversed Doubly list is: ");
        display(head);
    }
}
