package Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InterleaveQueue {
    // Method 1: using a queue
    /*public static Queue<Integer> interleave(Queue<Integer> q){
        Queue<Integer> q2 = new LinkedList<>();
        int half = q.size() / 2;

        for(int i = 0; i < half; i++) q2.add(q.remove());

        while(!q2.isEmpty()){
            q.add(q2.remove());
            q.add(q.remove());
        }
        return q;
    }*/

    // Method 2: using only one stack
    public static Queue<Integer> interleave(Queue<Integer> q){
        // Using a stack only
        Stack<Integer> st = new Stack<>();
        int half = q.size() / 2;

        // add the half in stack
        for(int i = 0; i < half; i++) st.push(q.remove());

        // add the reversed first half in queue
        while(!st.isEmpty()) q.add(st.pop());

        // add the second half in stack
        for(int i = 0; i < half; i++) st.push(q.remove());

        // operation - from st to q and q to st
        while(!st.isEmpty()){
            q.add(st.pop());
            q.add(q.remove());
        }

        // reverse the q
        while(!q.isEmpty()) st.push(q.remove());
        while(!st.isEmpty()) q.add(st.pop());

        return q;
    }
    public static void main(String[] args) {
        // input -> 1 2 3 4 5 6 7 8
        // output -> 1 5 2 6 3 7 4 8
        Queue<Integer> q = new LinkedList<>();
        q.add(1); q.add(2); q.add(3); q.add(4); q.add(5); q.add(6); q.add(7); q.add(8);
        System.out.println("original q is: "+ q);

        System.out.println("Interleaved queue is: "+ interleave(q));
    }
}
