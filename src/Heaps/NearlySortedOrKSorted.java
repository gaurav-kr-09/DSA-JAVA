package Heaps;

import java.util.PriorityQueue;

public class NearlySortedOrKSorted {
    private static void nearlySorted(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int i = 0;
        for(int ele: arr){
            pq.add(ele);
            if(pq.size() > k) arr[i++] = pq.poll();
        }

        while(!pq.isEmpty()) arr[i++] = pq.poll();
    }
    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;
        nearlySorted(arr, k);
        System.out.print("Sorted array is: ");
        for(int ele: arr){
            System.out.print(ele + " ");
        }
    }
}