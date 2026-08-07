package DynamicProgramming.Memoization;

import java.util.Arrays;

public class HouseRobber2 {
    // Basic recursion
    /*public static int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        int case1 = amount(nums, 0, n-1); // Case 1: 0 to n-1 - last skip
        int case2 = amount(nums, 1, n); // Case 2: 1 to n - first skip

        return Math.max(case1, case2);
    }

    private static int amount(int[] nums, int i, int end) {
        if(i >= end) return 0;

        int take = nums[i] + amount(nums, i+2, end);
        int skip = amount(nums, i+1, end);

        return Math.max(take, skip);
    }*/

    // DP - Memoization
    public static int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        // Case 1: 0 to n-1
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        int case1 = amount(nums, 0, n-1, dp1);

        // Case 2: 1 to n
        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        int case2 = amount(nums, 1, n, dp2);

        return Math.max(case1, case2);
    }

    private static int amount(int[] nums, int i, int end, int[] dp) {
        if(i >= end) return 0;

        if(dp[i] != -1) return dp[i];
        int take = nums[i] + amount(nums, i+2, end, dp);
        int skip = amount(nums, i+1, end, dp);

        return dp[i] = Math.max(take, skip);
    }

    public static void main(String[] args) {

        System.out.println(rob(new int[]{2, 3, 2}));                 // 3

        System.out.println(rob(new int[]{1, 2, 3, 1}));              // 4

        System.out.println(rob(new int[]{1, 2, 3}));                 // 3

        System.out.println(rob(new int[]{1}));                       // 1

        System.out.println(rob(new int[]{1, 2}));                    // 2

        System.out.println(rob(new int[]{2, 1, 1, 2}));              // 3

        System.out.println(rob(new int[]{200, 3, 140, 20, 10}));     // 340

        System.out.println(rob(new int[]{4, 1, 2, 7, 5, 3, 1}));     // 14
    }
}
