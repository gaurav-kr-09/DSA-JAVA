package Heaps;

import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    // ISKA BEST SOLUTION MILTA HAI BUCKET SORT SE

    // Using Comparable
    /*static class Pair implements Comparable<Pair>{
        int val;
        int freq;
        Pair(int val, int freq){
            this.val = val;
            this.freq = freq;
        }

        public int compareTo(Pair p){
            if(this.freq == p.freq) return Integer.compare(this.val, p.val);
            // upar wala  line is not needed as it's given that answer is unique
            // but for extra security or if given to choose answer of smaller values
            return Integer.compare(this.freq, p.freq);
        }
    }

    private static int[] topKFrequent(int[] arr, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int ele: arr) {
            freq.put(ele, freq.getOrDefault(ele, 0) + 1);
        }

        // Min heap
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int ele: freq.keySet()){
            pq.add(new Pair(ele, freq.get(ele)));
            if(pq.size() > k) pq.poll();
        }

        int[] ans = new int[k];
        int i = 0;
        while(!pq.isEmpty()) ans[i++] = pq.poll().val;
        return ans;
    }*/

    // Using comparator
    private static int[] topKFrequent(int[] arr, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int ele: arr) {
            freq.put(ele, freq.getOrDefault(ele, 0) + 1);
        }

        // Min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(freq.get(a), freq.get(b)));

        for(int ele: freq.keySet()){
            pq.add(ele);
            if(pq.size() > k) pq.poll();
        }

        int[] ans = new int[k];
        int i = 0;
        while(!pq.isEmpty()) ans[i++] = pq.poll();
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,2,1,2,3,1,3,2};
        int k = 2; // ans 1, 2

        System.out.print("K most frequent elements are: ");
        for(int ele: topKFrequent(arr, k)){
            System.out.print(ele + " ");
        };
    }
}
