package LinkedList.Doubly;

import java.util.Scanner;

public class RemoveDuplicatesFromDoublyList {
    public static Node removeDuplicate(Node head) {
        if(head == null || head.next == null) return head;
        Node pre = head, curr = head.next;

        while(curr != null){
            if(pre.val == curr.val) curr = curr.next;
            else{
                pre.next = curr;
                curr.prev = pre;
                pre = curr;
                curr = curr.next;
            }
        }
        pre.next = null;
        return head;
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

        head = removeDuplicate(head);

        System.out.print("The Duplicate removed Doubly list is: ");
        display(head);

//        System.out.println(head.next.prev.val);
    }
}
