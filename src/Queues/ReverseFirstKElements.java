package Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKElements {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);q.add(20);q.add(30);q.add(40);q.add(50);q.add(60);q.add(70);
        System.out.print("Original queue is: "+q);

        Stack<Integer> st = new Stack<>();
        int k = 3; // 30 20 10 40 50 60 70
        for(int i = 0; i < k; i++){
            st.push(q.remove());
        }

        while (!st.isEmpty()) q.add(st.pop());

        int n = q.size();
        for(int i = 0; i < n-k; i++){
            q.add(q.remove());
        }

        System.out.print("\nK reversed queue is: "+ q);
    }
}