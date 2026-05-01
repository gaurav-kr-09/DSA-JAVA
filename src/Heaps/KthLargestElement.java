package Heaps;

import java.util.PriorityQueue;

public class KthLargestElement {
    private static int kthSmallest(int[] arr, int k) {
        // Make a mean heap so that Kth largest remain on top
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int ele: arr){
            pq.add(ele);
            if(pq.size() > k) pq.poll(); // pq.remove() -> safer
        }
        
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] arr = {3,2,3,1,2,4,5,5,6};
        int k = 4; // ans = 4;

        System.out.println("Kth smallest element in array is: " + kthSmallest(arr, k));
    }
}