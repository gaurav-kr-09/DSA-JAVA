package Heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KLargestElement {
    private static ArrayList<Integer> kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int ele: arr){
            pq.add(ele);
            if(pq.size() > k) pq.poll();
        }

        ArrayList<Integer> ans = new ArrayList<>();

        int i = 0;
        while(!pq.isEmpty()){
            ans.addFirst(pq.poll());
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 23, 12, 9, 30, 2, 50};
        int k = 3; // ans = {50, 30, 23};

        System.out.println("K largest elements in decreasing order is: " + kthSmallest(arr, k));
    }
}