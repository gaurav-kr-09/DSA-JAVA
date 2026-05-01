package LinkedList;

import java.util.Scanner;

public class PalindromeLinkedList {
    //Method -1 using arrayList
    /*public static boolean palindrome(Node head){
        if(head == null  || head.next == null) return true;

        ArrayList<Integer> arr = new ArrayList<>();
        Node temp = head;
        while(temp != null){
            arr.add(temp.val);
            temp = temp.next;
        }

        int i = 0, j = arr.size() -1;
        while (i < j){
            if(!Objects.equals(arr.get(i), arr.get(j))) return false;
            i++;
            j--;
        }
        return true;
    }*/

    //Method -2 using reverse
    public static boolean palindrome(Node head){
        if(head == null  || head.next == null) return true;

        Node slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node head2 = slow.next;
        slow.next = null;

        head2 = reverse(head2);

        Node i = head, j = head2;

        while (i != null && j != null){
            if(i.val != j.val) return false;
            i = i.next;
            j = j.next;
        }
        return true;
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

        if(palindrome(head)) System.out.println("\nPalindrome");
        else System.out.println("\nNot a palindrome");
    }
}
