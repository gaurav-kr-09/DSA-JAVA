package Queues.STLorJCF;

// import java.util.ArrayDeque;

import java.util.LinkedList;
import java.util.Queue;

public class BasicSTL {
    public static void main(String[] args) {
        // Isme new Queue nahi likhte hai
        // Queue<Integer> q = new ArrayDeque<>();
        Queue<Integer> q = new LinkedList<>();

        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);

        System.out.println(q);
        System.out.println("Size is: "+ q.size());
        System.out.println("Peek is: "+ q.peek());

        q.remove();

        System.out.println(q);
        System.out.println("Size is: "+ q.size());
        System.out.println("Peek is: "+ q.peek());

        System.out.println(q.remove());
    }
}
