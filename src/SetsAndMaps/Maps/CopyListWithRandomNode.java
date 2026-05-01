package SetsAndMaps.Maps;

import java.util.HashMap;

public class CopyListWithRandomNode {
    static class ListNode {
        int val;
        ListNode next;
        ListNode random;
        ListNode(int val) {
            this.val = val;
        }
    }

    // iska do soln to hamlog pahle hi dekh chuke the  one of them was
    /*private static ListNode copyRandomList (ListNode head) {
        // ADDING COPY OF EACH NODE NEXT TO THEM
        ListNode curr = head;
        while(curr != null){
            ListNode newNode = new ListNode(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        // ASSIGNING RANDOM
        curr = head;
        while (curr != null){
            if(curr.random != null) curr.next.random = curr.random.next;
            curr = curr.next.next;
        }

        // removing the original Nodes
        curr = head;
        ListNode copyHead = head.next;
        while (curr != null){
            ListNode copy = curr.next;
            curr.next = copy.next;
            if(copy.next != null)copy.next = copy.next.next;
            curr = curr.next;
        }

        return copyHead;
    }*/

    // Using hashmap for building concept otherwise pichhla wala badhiya tha
    private static ListNode copyRandomList (ListNode head) {
        HashMap<ListNode, ListNode> map = new HashMap<>(); // map to store original and copy node for getting random

        ListNode curr = head;
        ListNode dummy = new ListNode(-1); // iska next copied node ka head hoga
        ListNode currCopy = dummy;

        // Making copy and storing Node and copy in map at the same time
        while (curr != null){
            currCopy.next = new ListNode(curr.val);
            map.put(curr, currCopy.next);
            curr = curr.next;
            currCopy = currCopy.next;
        }

        // CONNECTING RANDOM POINTER
        curr = head;
        currCopy = dummy.next;
        while(curr != null){
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
            currCopy = currCopy.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(7);
        ListNode b = new ListNode(13);
        ListNode c = new ListNode(11);
        ListNode d = new ListNode(10);
        ListNode e = new ListNode(1);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;

        a.random = c;
        b.random = b;
        c.random = e;
        d.random = c;
        e.random = a;

        ListNode head = a;
        System.out.print("The original linked list is: ");
        for (ListNode temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.val+ " R " + temp.random.val + " -> ");
        }

        ListNode head2 = copyRandomList(head);

        System.out.print("\nThe deep copied linked list is: ");
        for (ListNode temp = head2; temp != null; temp = temp.next) {
            System.out.print(temp.val+ " R " + temp.random.val + " -> ");
        }

        //Coniforming that both lists are different i.e. deep copy
        System.out.println();
        System.out.println(head);
        System.out.println(head2);
    }
}
