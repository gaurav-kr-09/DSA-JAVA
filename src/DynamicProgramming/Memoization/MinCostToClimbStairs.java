package DynamicProgramming.Memoization;

import java.util.Arrays;

public class MinCostToClimbStairs {
    // Method 1: Recursion Without DP
    /*public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        return Math.min(minCost(cost, n-1), minCost(cost, n-2));
    }

    public static int minCost(int[] cost, int idx) {
        if(idx == 0 || idx == 1) return cost[idx];
        return cost[idx] + Math.min(minCost(cost, idx-1), minCost(cost, idx-2));
    }*/

    // Method 2: Optimized with DP
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return Math.min(minCost(cost, n-1, dp), minCost(cost, n-2, dp));
    }

    public static int minCost(int[] cost, int idx, int[] dp) {
        if(idx == 0 || idx == 1) return cost[idx];

        if(dp[idx] != -1) return dp[idx];
        return dp[idx] = cost[idx] + Math.min(minCost(cost, idx-1, dp), minCost(cost, idx-2, dp));
    }

    public static void main(String[] args) {

        System.out.println(minCostClimbingStairs(new int[]{10, 15, 20}));                  // 15

        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1})); // 6

        System.out.println(minCostClimbingStairs(new int[]{0, 0, 0, 0}));                  // 0

        System.out.println(minCostClimbingStairs(new int[]{5, 10}));                       // 5

        System.out.println(minCostClimbingStairs(new int[]{10, 20, 30, 15}));              // 35

        System.out.println(minCostClimbingStairs(new int[]{1, 2, 3, 4, 5}));               // 6

        System.out.println(minCostClimbingStairs(new int[]{5, 5, 5, 5, 5}));               // 10
    }
}
