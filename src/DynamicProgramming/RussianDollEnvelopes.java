package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RussianDollEnvelopes  {
    // LIS - using DP, will give TLE
    /*public static int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;

        // {a, b} = a - width, b - height
        Arrays.sort(envelopes, (a, b) -> {
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]); // width ascending
            return Integer.compare(b[1], a[1]); // height descending
        });

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int lis = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<i; j++){
                if(envelopes[j][1] < envelopes[i][1]) dp[i] = Math.max(dp[i], dp[j]+1);
            }
            lis = Math.max(lis, dp[i]);
        }

        return lis;
    }*/

    // Using Patience sorting
    public static int maxEnvelopes(int[][] envs) {
        int n = envs.length;

        // {a, b} = a - width, b - height
        Arrays.sort(envs, (a, b) -> {
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]); // width ascending
            return Integer.compare(b[1], a[1]); // height descending
        });

        List<Integer> sorted = new ArrayList<>();
        for(int i=0; i<n; i++){
            int ijg = findJustGreater(sorted, envs[i][1]); // Index Of Just Greater of equal
            if (ijg == sorted.size()) sorted.add(envs[i][1]);
            else sorted.set(ijg, envs[i][1]);
        }

        return sorted.size();
    }

    public static int findJustGreater(List<Integer> arr, int target){
        int n = arr.size();
        int lo = 0, hi = n-1;
        int ans = n; // sab chhota hua to last me hoga answer
        while (lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(arr.get(mid) >= target){
                ans = mid;
                hi = mid-1; // aur chhota dhundh jo bada ho
            }
            else lo = mid+1;
        }

        return ans;
    }

    public static void main(String[] args) {

        int[][] envelopes1 = {
                {5, 4},
                {6, 4},
                {6, 7},
                {2, 3}
        };

        System.out.println(maxEnvelopes(envelopes1)); // Expected: 3


        int[][] envelopes2 = {
                {1, 1},
                {1, 1},
                {1, 1}
        };

        System.out.println(maxEnvelopes(envelopes2)); // Expected: 1


        int[][] envelopes3 = {
                {4, 5},
                {4, 6},
                {6, 7},
                {2, 3},
                {1, 1}
        };

        System.out.println(maxEnvelopes(envelopes3)); // Expected: 4


        int[][] envelopes4 = {
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 5}
        };

        System.out.println(maxEnvelopes(envelopes4)); // Expected: 4
    }
}