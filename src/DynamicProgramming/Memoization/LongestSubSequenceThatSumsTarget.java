package DynamicProgramming.Memoization;

import java.util.Arrays;

public class LongestSubSequenceThatSumsTarget {
    // BASIC RECURSION
    /*public static int lengthOfLongestSubsequence(int[] nums, int target) {
        int ans = longestSeq(0, nums, target);
        return ans < 0 ? -1: ans;
    }

    private static int longestSeq(int i, int[] nums, int target) {
        if(target == 0) return 0; // no more elements needed
        // if(i >= nums.length || target < 0) return -1; // No possible combination
        // but agar ye liye and pick ka value -1 aaya to 1 + -1 = 0 ho jayega
        // and agar skip ka v value -1 aa gaya to max 0 ho jayega
        // but actual me -1 hona chahiye , so use Integer.Min value or -ve of (nums.length + 1)
        if(i >= nums.length || target < 0) return Integer.MIN_VALUE; // No possible combination

        int pick = Integer.MIN_VALUE;
        if(target >= nums[i])
            pick = 1 + longestSeq(i+1, nums, target-nums[i]);

        int skip = longestSeq(i+1, nums, target);

        return Math.max(pick, skip);
    }*/

    // MEMOIZATION - SIDHA
    /*public static int lengthOfLongestSubsequence(int[] nums, int target) {
        int n = nums.length;;

        // i vary from 0 to n-1 and target varies from target to 0
        int[][] dp = new int[n][target+1];
        for(int[] row: dp) Arrays.fill(row, -1);

        int ans = longestSeq(0, nums, target, dp);
        return ans < 0 ? -1: ans;
    }

    private static int longestSeq(int i, int[] nums, int target, int[][] dp) {
        if(target == 0) return 0; // no more elements needed
        if(i >= nums.length || target < 0) return Integer.MIN_VALUE; // No possible combination

        if(dp[i][target] != -1) return dp[i][target];

        int pick = Integer.MIN_VALUE;
        if(target >= nums[i])
            pick = 1 + longestSeq(i+1, nums, target-nums[i], dp);

        int skip = longestSeq(i+1, nums, target, dp);

        return dp[i][target] = Math.max(pick, skip);
    }*/

    // MEMOIZATION - ULTA
    public static int lengthOfLongestSubsequence(int[] nums, int target) {
        int n = nums.length;;

        // i vary from n to 0 and target varies from target to 0
        int[][] dp = new int[n+1][target+1];
        for(int[] row: dp) Arrays.fill(row, -1);

        int ans = longestSeq(n, nums, target, dp);
        return ans < 0 ? -1: ans;
    }

    private static int longestSeq(int n, int[] nums, int target, int[][] dp) {
        if(target == 0) return 0; // no more elements needed
        if(n <= 0 || target < 0) return Integer.MIN_VALUE; // No possible combination

        if(dp[n][target] != -1) return dp[n][target];

        int pick = Integer.MIN_VALUE;
        if(target >= nums[n-1])
            pick = 1 + longestSeq(n-1, nums, target-nums[n-1], dp);

        int skip = longestSeq(n-1, nums, target, dp);

        return dp[n][target] = Math.max(pick, skip);
    }

    public static void main(String[] args) {

        int[] nums1 = {4, 1, 3, 2, 1, 5};
        System.out.println(lengthOfLongestSubsequence(nums1, 7)); // Expected: 4

        int[] nums2 = {1, 1, 1, 1, 1};
        System.out.println(lengthOfLongestSubsequence(nums2, 3)); // Expected: 3

        int[] nums3 = {3, 2, 1};
        System.out.println(lengthOfLongestSubsequence(nums3, 7)); // Expected: -1

        int[] nums4 = {1, 2, 3, 4, 5};
        System.out.println(lengthOfLongestSubsequence(nums4, 6)); // Expected: 3

        int[] nums5 = {2, 4, 6, 8};
        System.out.println(lengthOfLongestSubsequence(nums5, 10)); // Expected: 2

        int[] nums6 = {5, 1, 1, 1, 1, 1};
        System.out.println(lengthOfLongestSubsequence(nums6, 5)); // Expected: 5
    }
}