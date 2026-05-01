package LinkedList;

import java.util.Scanner;

class TestNode{
    int val;
    TestNode next;

    TestNode(int val){
        this.val = val;
    }
}

public class TakingInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Method - 1
        /*System.out.print("Enter the no. of nodes: ");
        int n = sc.nextInt();

        System.out.print("Enter the node value (0): ");
        TestNode head = new TestNode(sc.nextInt());
        TestNode current = head;

        for (int i = 1; i < n; i++) {
            System.out.print("Enter the node value (" +i + "): ");
            TestNode newNode = new TestNode(sc.nextInt());

            current.next = newNode;
            current = newNode;
        }*/

        // Method - 2
        /*System.out.print("Enter elements separated by space: ");
        String[] input = sc.nextLine().split(" ");

        TestNode head = new TestNode(Integer.parseInt(input[0]));
        TestNode current = head;

        for(int i = 1; i < input.length; i++){
            current.next = new TestNode(Integer.parseInt(input[i]));
            current = current.next;
        }*/

        // Method - 3
        System.out.print("Enter elements separated by space: ");
        String[] input = sc.nextLine().split(" ");

        TestNode head = null, current = null;

        for(String s: input){
            TestNode newNode = new TestNode(Integer.parseInt(s));

            if(head == null){
                head = newNode;
                current = newNode;
            }else{
                current.next = newNode;
                current = newNode;
            }
        }

        // Printing
        System.out.print("THe linked list elements are: ");
        for(TestNode temp = head; temp != null; temp = temp.next){
            System.out.print(temp.val + " ");
        }
    }
}