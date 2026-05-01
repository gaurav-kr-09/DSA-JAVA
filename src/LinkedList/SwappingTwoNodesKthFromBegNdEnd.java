package LinkedList;

import java.util.Scanner;

public class SwappingTwoNodesKthFromBegNdEnd {
    public static Node swapNodesValues(Node head, int k){
        Node fast = head, slow = head, firstk = head;

        for(int i = 1; i< k; i++){
            fast = fast.next;
            firstk = firstk.next;
        }

        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        int temp = slow.val;
        slow.val = firstk.val;
        firstk.val = temp;

        //--/--/////////////////  Isme node swap karne ka logic likhna hai.
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

        System.out.print("\nEnter k: ");
        int k = sc.nextInt();

        head = swapNodesValues(head, k);
        System.out.print("Deleted list is: ");
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.val+ " ");
        }
    }
}
