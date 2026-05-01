package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {
    private static int kthSmallest(int[] arr, int k) {
        // Made a max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int ele: arr){
            pq.add(ele);
            if(pq.size() > k) pq.poll(); // -> safer version of pq.remove()
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 4, 3, 48, 6, 2, 33, 53, 10};
        int k = 4; // ans = 5;

        System.out.println("Kth smallest element in array is: " + kthSmallest(arr, k));
    }
}
