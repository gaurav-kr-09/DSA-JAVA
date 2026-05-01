package LinkedList;

import java.util.Scanner;

public class ReverseSublistOfList {
    //Method 1 - sare node ko arrayList me dal k selected part reverse kar de.
    /*public static Node reverseSublist(Node head, int left, int right) {
        //Approach 1 using arraylist - SC O(n)
        if(left == right || head == null || head.next == null) return head;
        ArrayList<Node> arr = new ArrayList<>();
        Node temp = head;
        while(temp != null){
            arr.add(temp);
            temp = temp.next;
        }

        int i = left - 1, j = right - 1;
        while (i < j){
            Node temp1 = arr.get(i), temp2 = arr.get(j);
            arr.set(i, temp2);
            arr.set(j, temp1);
            i++;
            j--;
        }

        for(i = 0; i < arr.size(); i++){
            arr.get(i).next = (i == arr.size() - 1) ? arr.get(i).next = null :  arr.get(i+1);
        }

        return arr.getFirst();
    }*/
    
    //Method 2 - list ko 3 part me divide kar k middle wale ko reverse kar do.
    /*public static Node reverseSublist(Node head, int left, int right) {
        if(left == right || head == null || head.next == null) return head;
        Node dummy = new Node(-1);
        dummy.next = head;

        //Finding tail of 1
        Node tail1 = dummy;
        for (int i = 1; i < left; i++) {
            tail1 = tail1.next;
        }

        Node head2 = tail1.next, tail2 = tail1.next;
        //Finding tail of 2
        for(int i = left; i < right; i++){
            tail2 = tail2.next;
        }

        Node head3 = tail2.next;
        tail2.next = null;// Breaking middle List
        tail1.next = reverse(head2);
        // abb head2 reverse karne k bad tail2 ban chuka hai;
        head2.next = head3;

        return dummy.next;
    }

    public static Node reverse(Node head){
        if(head == null || head.next == null) return head;
        Node prev = null, fwd = null, curr = head;
        while (curr != null){
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        return prev;
    }*/

    // Method -3 head insertion wala, no need to write seperate fn of reverse
    public static Node reverseSublist(Node head, int left, int right){
        if(left == right || head == null) return head;
        Node dummy = new Node(-1);
        dummy.next = head;

        // traverse to just before left
        Node prev = dummy;
        for(int i = 1; i < left; i++){
            prev = prev.next;
        }

        // reversing using head insertion
        Node curr = prev.next;
        for(int i = 1; i <= right-left; i++){
            Node temp = prev.next;

            prev.next = curr.next;
            curr.next = curr.next.next;
            prev.next.next = temp;
        }

        return dummy.next;
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

        int left = 2, right = 5;
        head = reverseSublist(head,left, right);

        System.out.print("\nThe resulting linked list is: ");
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.val+ " ");
        }
    }
}