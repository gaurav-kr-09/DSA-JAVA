package DynamicProgramming.Memoization;

import java.util.Arrays;

public class VisitArrayPositionsToMaximizeScoreLC2786 {
    // BASIC RECURSION
    /*public static long maxScore(int[] nums, int x) {
        int cp = Math.abs(nums[0] % 2);
        // Index 0 already picked, start recursion from index 1
        return nums[0] + getScore(1, cp, nums, x);
    }

    public static long getScore(int i, int parity, int[] nums, int x){
        if(i == nums.length) return 0; // bahar aa gaye to score 0

        // -> jab sara -ve hoga to score -ve v ho sakta hai
        long pick; // long pick = Long.MIN_VALUE
        int cp = Math.abs(nums[i] % 2); // cp -> current parity
        if(cp == parity)
            pick = nums[i] + getScore(i+1, parity, nums, x);
        else pick = nums[i] - x + getScore(i+1, cp, nums, x);

        long skip = getScore(i+1, parity, nums, x);
        return Math.max(pick, skip);
    }*/

    // MEMOIZATION - SIDHA
    public static long maxScore(int[] nums, int x) {
        int n = nums.length;

        // i varies from 0 to n-1 | parity -> 0 & 1 i.e. 2
        long[][] dp = new long[n][2];
        // for(long[] row: dp) Arrays.fill(row, -1);
        // -1 ko flag bana rhe hai but agar score v -1 aa gaya
        // to extra calculations hoga so use -INF as flag
        for(long[] row: dp) Arrays.fill(row, Long.MIN_VALUE);

        int cp = Math.abs(nums[0] % 2);
        // Index 0 already picked, start recursion from index 1
        return nums[0] + getScore(1, cp, nums, x, dp);
    }

    public static long getScore(int i, int parity, int[] nums, int x, long[][] dp){
        if(i == nums.length) return 0; // bahar aa gaye to score 0

        if(dp[i][parity] != Long.MIN_VALUE) return dp[i][parity];

        // -> jab sara -ve hoga to score -ve v ho sakta hai
        long pick; // long pick = Long.MIN_VALUE
        int cp = Math.abs(nums[i] % 2); // cp -> current parity
        if(cp == parity)
            pick = nums[i] + getScore(i+1, parity, nums, x, dp);
        else pick = nums[i] - x + getScore(i+1, cp, nums, x, dp);

        long skip = getScore(i+1, parity, nums, x, dp);
        return dp[i][parity] = Math.max(pick, skip);
    }

    // MEMOIZATION - ULTA - isme nahi banega kyuki aage ka value pick karna hai

    public static void main(String[] args) {

        int[] nums1 = {2, 3, 6, 1, 9, 2};
        System.out.println(maxScore(nums1, 5)); // Expected: 13

        int[] nums2 = {-5, 5};
        System.out.println(maxScore(nums2, 10)); // Expected: 0

        int[] nums3 = {3, 3, 3, 3};
        System.out.println(maxScore(nums3, 3)); // Expected: 12

        int[] nums4 = {-1, -2, -3, 4, 5};
        System.out.println(maxScore(nums4, 2)); // Expected: 9

        int[] nums5 = {1, 2, -3, 4, -5, 6};
        System.out.println(maxScore(nums5, 2)); // Expected: 13
    }
}