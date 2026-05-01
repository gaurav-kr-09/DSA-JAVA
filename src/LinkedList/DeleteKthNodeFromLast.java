package LinkedList;

import java.util.Scanner;

public class DeleteKthNodeFromLast {
    // Method - 1 fast ko head.next se initialize kar k 
    /*public static Node removeNthFromEnd(Node head, int n) {
        Node fast = head.next;
        if(fast == null){
            head = null;
            return head;
        }
        Node slow = head;

        for(int i = 1; i <= n; i++){
            if(fast == null){
                head = head.next;
                return head;
            }
            fast = fast.next;
        }

        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }*/

    // Method - 2 - fast.next != null instead of fast != null
    /*public static Node removeNthFromEnd(Node head, int n) {
        Node fast = head;
        Node slow = head;

        for(int i = 1; i <= n; i++){
            fast = fast.next;
        }

        // In case jab n size k barabar ho jaye to fast null pe aa chuka hoga
        if(fast == null) return head.next;

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }*/

    // Method - 3 - ek dummy node bana ke
    public static Node removeNthFromEnd(Node head, int n) {
        // ek dummy node bana k
        Node dummy = new Node(-1);
        dummy.next = head;
        Node fast = head;
        Node slow = dummy;

        for(int i = 1; i <= n; i++){
            fast = fast.next;
        }

        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
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

        System.out.print("\nEnter k: ");
        int k = sc.nextInt();

        head = removeNthFromEnd(head, k);
        System.out.print("Deleted list is:  ");
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.val+ " ");
        }
    }
}
