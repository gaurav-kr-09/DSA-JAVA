package BinarySearch.Answerpattern;

import java.util.Arrays;

public class AggressiveCows {
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls); // sort kar do taki place karne me easy ho
        // min distance can be 1
        int lo = 1;
        // max distance will be difference bw max and min element in array
        int hi = stalls[stalls.length-1] - stalls[0];

        int ans = -1;
        while (lo <= hi){
            int mid = lo + (hi - lo)/2;

            if(isPossible(stalls, k, mid)){
                // matlab k cows rakhna with minimum distance mid is possible,
                // and answer is good now find larger min distance
                ans = mid;
                lo = mid + 1;
            }
            // k cows rakhna with minimum distance mid is not possible so decrease mid
            else hi = mid-1;
        }

        return ans;
    }

    private static boolean isPossible(int[] stall, int cows, int minAllowedDist){
        // since min distance maximize karna hai isiliye
        // first stall pe to cow hoga hi, so put that
        // coz placing earlier leaves more space for future cows
        int c = 1;
        int lastStallPosition = stall[0];

        // check if cows can be placed with distance mid
        for(int i=1; i<stall.length; i++){
            // if distance is >= mid then place that cow
            if(stall[i] - lastStallPosition >= minAllowedDist){
                c++;
                lastStallPosition = stall[i];
            }
            // if all cows are placed means possible
            if(cows == c) return true;
        }

        // all cows are not placed
        return false;
    }

    public static void main(String[] args) {
        int[] stalls1 = {1, 2, 4, 8, 9};
        int cows1 = 3;
        System.out.println(aggressiveCows(stalls1, cows1)); // 3

        int[] stalls2 = {10, 1, 2, 7, 5};
        int cows2 = 3;
        System.out.println(aggressiveCows(stalls2, cows2)); // 4

        int[] stalls3 = {2, 12, 11, 3, 26, 7};
        int cows3 = 5;
        System.out.println(aggressiveCows(stalls3, cows3)); // 1
    }
}
