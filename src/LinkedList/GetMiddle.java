package LinkedList;

import java.util.Scanner;

public class GetMiddle {
    //2 pass solution
    /*public static int getMiddle(Node head){
        Node temp = head;
        int length = 0;
         // Counting the total elements
        while(temp != null){
            temp = temp.next;
            length ++;
        }

        int middle = length/2; // total 5 middle 2 i.e 3sra element and if total is 6 then middle = 3 i.e 4th element which is required answer
        temp = head;
        for(int i = 0; i < middle; i++){
            temp = temp.next;
        }
        return temp.val;
    }*/

    //1 pass solution - aka slow fast pointer approach or Floyd's Cycle-Finding Algorithm or the Tortoise and Hare Algorithm.
    public static int getMiddle(Node head){
        Node fast = head, slow = head;

        while(fast!= null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
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

        System.out.print("\nThe middle element is: "+ getMiddle(head));
    }
}
