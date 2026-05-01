package Stacks;

import java.util.Scanner;

public class RemoveNodesFromListLC2487 {
    // Method -1 using stacks - not good uses extra space O(n)
    /*public static Node removeNodes(Node head) {
        Stack<Node> st = new Stack<>();
        Node temp = head;

        while(temp != null){
            while(!st.isEmpty() && st.peek().val < temp.val) st.pop();
            st.push(temp);
            temp = temp.next;
        }

        while(!st.isEmpty()){
            Node top = st.pop();
            top.next = temp;
            temp = top;
        }
        return temp;
    }*/

    // Method -2by reversing and traversing, no xtra space
    public static Node removeNodes(Node head) {
        head = reverse(head);
        int max = head.val;

        Node temp = head.next, dummy = head;
        while(temp != null){
            if(temp.val >= max){
                max = temp.val;
                dummy.next = temp;
                dummy = dummy.next;
            }
            temp = temp.next;
        }
        dummy.next = null;

        return reverse(head);
    }

    public static Node reverse(Node head){
        if(head == null || head.next == null) return head;
        Node prev = null, curr = head;
        while(curr != null){
            Node fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        return prev;
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

        System.out.print("The linked list is: ");
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.val+ " ");
        }

        head = removeNodes(head);
        
        System.out.print("\nThe swapped linked list is: ");
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.val+ " ");
        }
    }
}