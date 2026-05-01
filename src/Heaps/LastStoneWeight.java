package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    private static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int ele: stones) pq.add(ele);

        while (pq.size() > 1){
            int put = pq.poll() - pq.poll();
            if(put != 0) pq.add(put);
        }

        return pq.isEmpty() ? 0 : pq.peek();
    }
    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1}; // ans -> 1

        System.out.println("Weight of last stone remaining is: " + lastStoneWeight(stones));
    }
}