package LinkedList;

import java.util.Scanner;

public class NodesBetweenCriticalPointsLC2058 {
    public static int[] nodesBetweenCriticalPoints(Node head){
        int idx = 2, minDist = Integer.MAX_VALUE, firstIdx = -1, lastIdx = -1;
        Node a = head, b = a.next, c = b.next;

        while(c != null){
            if((b.val > a.val && b.val > c.val) || (b.val < a.val && b.val < c.val)){
                if(firstIdx == -1) firstIdx = idx;

                if(lastIdx != -1){
                    int dist = idx - lastIdx;
                    minDist = Math.min(dist, minDist);
                }

                lastIdx = idx;
            }
            idx++;
            a = a.next;
            b = b.next;
            c = c.next;
        }

        int maxDist = lastIdx - firstIdx;
        if(maxDist == 0) maxDist = minDist = -1;
        return new int[] {minDist, maxDist};
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
        System.out.print("The original linked list is: ");
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.val+ " ");
        }

        int[] ans = nodesBetweenCriticalPoints(head);
        System.out.println("MinDist is: "+ ans[0] + " & MaxDist is: "+ ans[1]);
    }
}
