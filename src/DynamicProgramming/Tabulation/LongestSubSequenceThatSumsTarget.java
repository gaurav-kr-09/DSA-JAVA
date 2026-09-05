package DynamicProgramming.Tabulation;

import java.util.Arrays;

public class LongestSubSequenceThatSumsTarget {
    // Tabulation - Without space optimization
    /*public static int lengthOfLongestSubsequence(int[] nums, int target) {
        int n = nums.length;;

        // i vary from n to 0 and target varies from target to 0
        int[][] dp = new int[n+1][target+1];
        for(int i=0; i<=n; i++) dp[i][0] = 0; // target 0 k liye 0 nos. needed
        for(int i=1; i<=target; i++) dp[0][i] = Integer.MIN_VALUE; // 0 nos. can't make a +ve target

        for(int i=1; i<=n; i++){
            for(int j=1; j<=target; j++){
                int pick = Integer.MIN_VALUE;
                if(j >= nums[i-1])
                    pick = 1 + dp[i-1][j-nums[i-1]];

                int skip = dp[i-1][j];

                dp[i][j] = Math.max(pick, skip);
            }
        }

        return dp[n][target] < 0 ? -1: dp[n][target];
    }*/

    // tabulation with space optimization
    public static int lengthOfLongestSubsequence(int[] nums, int target) {
        int n = nums.length;;

        int[]dp = new int[target+1];
        Arrays.fill(dp, Integer.MIN_VALUE); // 0 nos. can't make a +ve target
        dp[0] = 0; // 0 nos. needed for target 0

        for(int i=1; i<=n; i++){
            for(int j=target; j>=nums[i-1]; j--){ // since we want older values so ulta loop
                int pick = 1 + dp[j-nums[i-1]];
                int skip = dp[j];
                dp[j] = Math.max(pick, skip);
            }
        }

        return dp[target] < 0 ? -1: dp[target];
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