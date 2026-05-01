package Heaps;

import java.util.PriorityQueue;

public class PriorityQueueSTL {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(20);
        pq.add(-30);
        pq.add(40);

        System.out.println(pq); // ye pure heap ko print karega level order ki tarah

        System.out.println(pq.peek()); // will give min element kyuki ye min heap hai

        System.out.println(pq.size()); // ye size of pq dega

        pq.remove(20);

        System.out.println(pq.size());
        System.out.println(pq);

        // Traversing
        for(int ele: pq){
            System.out.print(ele + " ");
        }
    }
}