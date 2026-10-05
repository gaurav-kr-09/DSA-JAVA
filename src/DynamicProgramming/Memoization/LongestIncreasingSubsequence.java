package DynamicProgramming.Memoization;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    // BASIC RECURSION
    /*public static int lengthOfLIS(int[] nums) {
        return lis(0, -10001, nums);
    }

    // p means jo element previously liye the
    public static int lis(int i, int p, int[] nums){
        if(i >= nums.length) return 0;

        int pick = 0;
        if(p == -1 || p < nums[i]) // ya to p chhota hona chahiye nahi to i=0
            pick = 1 + lis(i+1, nums[i], nums);
        int skip = lis(i+1, p, nums);

        return Math.max(pick, skip);
    }*/

    // BASIC RECURSION - BETTER
    /*public static int lengthOfLIS(int[] nums) {
        return lis(0, -1, nums);
    }

    // p means index jiska element pahle liye the
    public static int lis(int i, int p, int[] nums){
        if(i >= nums.length) return 0;

        int pick = 0;
        if(p == -1 || nums[p] < nums[i]) // ya to nums[p] chhota hona chahiye nahi to i=0
            pick = 1 + lis(i+1, i, nums);
        int skip = lis(i+1, p, nums);

        return Math.max(pick, skip);
    }*/

    // Memoization
    /*public static int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n];
        for(int[]  row: dp) Arrays.fill(row, -1);

        return lis(0, -1, nums, dp);
    }

    // p means index jiska element pahle liye the
    public static int lis(int i, int p, int[] nums, int[][] dp){
        if(i >= nums.length) return 0;

        if(p != -1 && dp[i][p] != -1) return dp[i][p];

        int pick = 0;
        if(p == -1 || nums[p] < nums[i]) // ya to nums[p] chhota hona chahiye nahi to i=0
            pick = 1 + lis(i+1, i, nums, dp);
        int skip = lis(i+1, p, nums, dp);

        int res = Math.max(pick, skip);
        return p == -1 ? res : (dp[i][p] = res);
    }*/

    // memoization hi hai bas upar wale me p = -1 ko
    // bar bar handle karna pad rha tha to kyu na dp
    // me hi p ko n+1 tak vary kara ke p = -1 ko handle kar le
    public  static int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n+1];
        for(int[]  row: dp) Arrays.fill(row, -1);

        return lis(0, -1, nums, dp);
    }

    // p means index jiska element pahle liye the
    public  static int lis(int i, int p, int[] nums, int[][] dp){
        if(i >= nums.length) return 0;

        if(dp[i][p+1] != -1) return dp[i][p+1];

        int pick = 0;
        if(p == -1 || nums[p] < nums[i])
            pick = 1 + lis(i+1, i, nums, dp);
        int skip = lis(i+1, p, nums, dp);

        return dp[i][p+1] = Math.max(pick, skip);
    }

    public static void main(String[] args) {
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums1)); // Expected: 4


        int[] nums2 = {0, 1, 0, 3, 2, 3};
        System.out.println(lengthOfLIS(nums2)); // Expected: 4


        int[] nums3 = {7, 7, 7, 7, 7, 7, 7};
        System.out.println(lengthOfLIS(nums3)); // Expected: 1


        int[] nums4 = {1};
        System.out.println(lengthOfLIS(nums4)); // Expected: 1


        int[] nums5 = {5, 4, 3, 2, 1};
        System.out.println(lengthOfLIS(nums5)); // Expected: 1
    }
}