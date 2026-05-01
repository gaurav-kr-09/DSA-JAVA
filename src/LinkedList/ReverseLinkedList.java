package LinkedList;

import java.util.Scanner;

public class ReverseLinkedList {
    //Method 1 - using ArrayList
    /*private static Node reverse(Node head) {
        if(head == null || head.next == null) return head;
        ArrayList<Node> arr = new ArrayList<>();

        Node temp = head;
        while (temp != null){
            arr.add(temp);
            temp = temp.next;
        }

        int n = arr.size();
        for (int i = n-1; i > 0; i--) {
            arr.get(i).next = arr.get(i-1);
        }

        arr.getFirst().next = null;

        return arr.getLast();
    }*/

    //Method 2 - using 3 pointers Iterative approach
    /*private static Node reverse(Node head) {
        Node prev = null, curr = head, fwd = null;

        while(curr != null){
            fwd = curr.next;
            curr.next = prev;

            prev = curr;
            curr = fwd;
        }

        return prev;
    }*/

    //Method 3 - using recursive approach
    private static Node reverse(Node head) {
        if(head == null || head.next == null) return head;
        Node a = head.next;
        head.next = null;

        Node b = reverse(a);
        a.next = head;

        return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the list elements separated by a single space for list: ");
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

        head = reverse(head);
        System.out.print("\nThe swapped linked list is: ");
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.val+ " ");
        }
    }
}
