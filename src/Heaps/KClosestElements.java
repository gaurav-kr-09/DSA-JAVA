package Heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestElements {
    // ISKA BEST SOLUTION HOTA HAI BINARY SEARCH + SLIDING WINDOW SE

    // Using Max heap with comparator
    /*public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        //Max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int diff = Math.abs(x-b) - Math.abs(x-a); // always >= 0
            if(diff == 0) return Integer.compare(b, a); // if 0 then remove larger first
            return diff; // else remove the element with larger difference
        });

        for(int ele: arr){
            pq.add(ele);
            if(pq.size() > k) pq.poll();
        }

        List<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()) ans.add(pq.poll());
        Collections.sort(ans);
        return ans;
    }*/

    // Using Max heap with comparable
    static class Pair implements Comparable<Pair>{
        int val;
        int absDist;
        Pair(int val, int absDist){
            this.val = val;
            this.absDist = absDist;
        }

        public int compareTo(Pair p){
            int absDist = Integer.compare(this.absDist, p.absDist);
            if(absDist == 0) return Integer.compare(this.val, p.val);
            return absDist;
        }
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        //Max heap
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int ele: arr){
            pq.add(new Pair(ele, Math.abs(x - ele)));
            if(pq.size() > k) pq.poll();
        }

        List<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()) ans.add(pq.poll().val);

        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 4;
        int x = 3;
        System.out.println("K closest elements are: "+ findClosestElements(arr, k, x)); // ans -> 1, 2, 3, 4
    }
}