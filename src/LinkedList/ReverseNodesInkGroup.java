//package LinkedList;
//
//import java.util.Scanner;
//
//public class ReverseNodesInkGroup {
//    private static Node reverseNodes(Node head, int k) {
// /+++++++++++++++++++++++++++++ Will solve it later++++++++++++++++++++++++++++++++++++
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter the list elements separated by a single space for list (even no. of elements): ");
//        String[] input = sc.nextLine().split(" ");
//
//        Node head = null, current = null;
//
//        for(String s: input){
//            Node newNode = new Node(Integer.parseInt(s));
//
//            if(head == null) head = newNode;
//            else current.next = newNode;
//
//            current = newNode;
//        }
//
//        System.out.print("The linked list1 is: ");
//        for (Node temp = head; temp != null; temp = temp.next) {
//            System.out.print(temp.val+ " ");
//        }
//
//        System.out.print("\nEnter k: ");
//        int k = sc.nextInt();
//
//        head = reverseNodes(head,k);
//
//        System.out.print("\nThe resulting linked list is: ");
//        for (Node temp = head; temp != null; temp = temp.next) {
//            System.out.print(temp.val+ " ");
//        }
//    }
//}
