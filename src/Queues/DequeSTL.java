package Queues;

import java.util.Deque;
//import java.util.ArrayDeque;
import java.util.LinkedList;

public class DequeSTL {
    public static void main(String[] args) {
        // Deque<Integer> dq = new ArrayDeque<>();
        Deque<Integer> dq = new LinkedList<>();

        dq.addLast(1);
        dq.addLast(2);
        dq.addLast(3);
        dq.addLast(4);
        System.out.println(dq);

        dq.addFirst(5);
        System.out.println(dq);

        dq.removeFirst();
        System.out.println(dq);

        dq.removeLast();
        System.out.println(dq);

        System.out.println(dq.getFirst());
        System.out.println(dq.getLast());

        // System.out.println(dq.reversed()); // -> ye reverse original ko nahi karta ek naya copy deta hai.

        // basic queue ki tarah hi hoga ye sab niche wala
        dq.add(5);
        System.out.println(dq);
        dq.remove();
        System.out.println(dq);

        dq.removeAll(dq); // removes everything
        System.out.println(dq);

        dq.add(1);
        dq.add(2);
        dq.add(1);
        dq.add(1);
        dq.add(4);
        dq.add(1);
        System.out.println(dq);

        dq.removeFirstOccurrence(1);
        System.out.println(dq);

        dq.removeLastOccurrence(1);
        System.out.println(dq);
    }
}