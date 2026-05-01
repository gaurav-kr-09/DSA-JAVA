package LinkedList;

import java.util.Scanner;

public class KthNodeFromLast {

    // 2 pass
    /*public static int kthNode(Node head, int k){
        int length = 0;
        Node temp = head;

        while (temp != null){
            temp = temp.next;
            length++;
        }

        temp = head;
        int kthNodeFromTheLast = length - k + 1;
        for (int i = 1; i < kthNodeFromTheLast; i++) {
            temp = temp.next;
        }
        return temp.val;
    }*/

    // using slow fast pointers
    public static int kthNode(Node head, int k){
        Node slow = head, fast = head;

        for (int i = 1; i <= k; i++) {
            if(fast == null) return -1;
            fast = fast.next;
        }

        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        return slow.val;
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

        System.out.println("Kth node from last is: "+ kthNode(head, k));
    }
}
