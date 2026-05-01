package Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQ {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);q.add(20);q.add(30);q.add(40);q.add(50);
        System.out.print("Original queue is: "+q);

        Stack<Integer> st = new Stack<>();
        /*int n = q.size();
        for (int i = 0; i < n; i++) {
            st.push(q.remove());
        }*/

        while (!q.isEmpty()) st.push(q.remove());
        while (!st.isEmpty()) q.add(st.pop());

        System.out.println("\nReverse queue is: "+ q);
    }
}
