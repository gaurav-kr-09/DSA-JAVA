package LinkedList;

import java.util.Scanner;

public class MaxTwinSum {
    public static int twinPairs(Node head){
         Node fast = head.next, slow = head;

         while(fast != null && fast.next != null){
             slow = slow.next;
             fast = fast.next.next;
         }

         Node head2 = reverse(slow.next);

         int maxSum = 0;
         while (head2 != null){
             maxSum = Math.max(maxSum, head.val + head2.val);
             head = head.next;
             head2 = head2.next;
         }

         return maxSum;
    }

    public static Node reverse(Node head){
        if(head == null || head.next == null) return head;

        Node prev = null, curr = head, fwd = null;
        while (curr != null){
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        return prev;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the list elements separated by a single space for list (even no. of elements): ");
        String[] input = sc.nextLine().split(" ");

        Node head = null, current = null;

        for(String s: input){
            Node newNode = new Node(Integer.parseInt(s));

            if(head == null) head = newNode;
            else current.next = newNode;

            current = newNode;
        }

        System.out.print("The linked list1 is: ");
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.val+ " ");
        }

        System.out.println("\nMax Twin sum is: "+ twinPairs(head));
    }
}
