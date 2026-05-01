package Heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeCoveringElementsFromKLists {
    private static class TripletGFG implements Comparable<TripletGFG>{
        int num;
        int row;
        int col;
        public TripletGFG(int num, int row, int col){
            this.num = num;
            this.row = row;
            this.col = col;
        }

        public int compareTo(TripletGFG t){
            return Integer.compare(this.num, t.num);
        }
    }

    // GFG wala assume karta hai sab ka size barabar hoga but LC wala nahi
    public ArrayList<Integer> findSmallestRangeGFG(int[][] nums) {
        int k = nums.length, n = nums[0].length;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        PriorityQueue<TripletGFG> pq = new PriorityQueue<>();
        for(int i = 0; i < k; i++){
            max = Math.max(max, nums[i][0]);
            min = Math.min(min, nums[i][0]);
            pq.add(new TripletGFG(nums[i][0], i, 0));
        }

        int a = min, b = max; // [a, b] is the required range
        while(true){
            TripletGFG top = pq.remove();
            int ele = top.num, row = top.row, col = top.col;
            if((max - ele) < (b - a)){
                a = ele;
                b = max;
            }

            if(col == n-1) break;
            int next = nums[row][col+1];
            max = Math.max(max, next);
            pq.add(new TripletGFG(next, row, col+1));
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(a); ans.add(b);
        return ans;
    }

    private static class Triplet implements Comparable<Triplet>{
        int val;
        int row;
        int col;

        public Triplet(int val, int row, int col){
            this.val = val;
            this.row = row;
            this.col = col;
        }

        public int compareTo(Triplet t){
            return Integer.compare(this.val, t.val);
        }
    }

    public static int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Triplet> pq = new PriorityQueue<>();

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        // Add first element of each list in heap & make the range among them
        for(int i = 0; i < nums.size(); i++){
            pq.add(new Triplet(nums.get(i).get(0), i, 0));
            max = Math.max(max, nums.get(i).get(0));
            min = Math.min(min, nums.get(i).get(0));
        }

        int a = min, b = max; // [a,b] is the required range

        while(true){
            Triplet top = pq.remove();

            // if naya range chhota hai purane range se to range = new range
            int currVal = top.val;
            if(max-currVal < b-a){
                b = max;
                a = currVal;
            }

            int currRow = top.row, currCol = top.col;

            // agar wo row khatam ho gaya jiska element next ban k aane wala hai, to loop break
            if(currCol == nums.get(currRow).size() - 1) break;

            // agar naya aane wala elemnt max se bada hai to new element is max
            int nextVal = nums.get(currRow).get(currCol+1); // next value to come in heap
            if(nextVal > max) max = nextVal;

            // heap me naya value dal do
            pq.add(new Triplet(nextVal, currRow, currCol+1));
        }

        return new int[]{a, b};
    }

    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();

        arr.add(Arrays.asList(4,10,15,24,26));
        arr.add(Arrays.asList(0,9,12,20));
        arr.add(Arrays.asList(5,18,22,30));

        int[] ans = smallestRange(arr); // ans -> [20,24]

        System.out.println("Smallest range is: [" + ans[0] + "," + ans[1] + "]");
    }
}