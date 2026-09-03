package DynamicProgramming.Memoization;

import java.util.Arrays;

public class UnboundedKnapsack {
    // BASIC RECURSION
    /*public static int unboundedKnapsack(int[] weight, int[] value, int capacity) {
        return maxProfit(0, weight, value, capacity);
    }

    private static int maxProfit(int i, int[] wt, int[] val, int C) {
        if(i >= wt.length || C == 0) return 0;

        int take = 0;
        if(C >= wt[i])
            take = val[i] + maxProfit(i, wt, val, C-wt[i]); // key change -> i instead of i+1

        int skip = maxProfit(i+1, wt, val, C);

        return Math.max(take, skip);
    }*/

    // MEMOIZATION
    /*public static int unboundedKnapsack(int[] wt, int[] val, int capacity) {
        // 2 varying states, i changes from 0 to n-1 and capacity C to 0
        int[][] dp = new int[val.length][capacity+1];
        for(int[] row: dp) Arrays.fill(row, -1);

        return maxProfit(0, wt, val, capacity, dp);
    }

    private static int maxProfit(int i, int[] wt, int[] val, int C, int[][] dp) {
        if(i >= wt.length || C == 0) return 0;

        if(dp[i][C] != -1) return dp[i][C];

        int take = 0;
        if(C >= wt[i])
            take = val[i] + maxProfit(i, wt, val, C-wt[i], dp); // key change -> i instead of i+1

        int skip = maxProfit(i+1, wt, val, C, dp);

        return dp[i][C] = Math.max(take, skip);
    }*/

    // ULTA MEMOIZATION
    public static int unboundedKnapsack(int[] wt, int[] val, int capacity) {
        int n = wt.length;

        // 2 varying states, i changes from n to 0 and capacity C to 0
        int[][] dp = new int[val.length+1][capacity+1];
        for(int[] row: dp) Arrays.fill(row, -1);

        return maxProfit(n, wt, val, capacity, dp);
    }

    private static int maxProfit(int n, int[] wt, int[] val, int C, int[][] dp) {
        if(n <= 0|| C == 0) return 0;

        if(dp[n][C] != -1) return dp[n][C];

        int take = 0;
        if(C >= wt[n-1])
            take = val[n-1] + maxProfit(n, wt, val, C-wt[n-1], dp); // key change -> i instead of i+1

        int skip = maxProfit(n-1, wt, val, C, dp);

        return dp[n][C] = Math.max(take, skip);
    }

    public static void main(String[] args) {
        int[] weight1 = {2, 3, 4, 5};
        int[] value1 = {40, 50, 60, 70};
        System.out.println(unboundedKnapsack(weight1, value1, 8)); // Expected: 160
        // 4 + 4 → 60 + 60 = 120
        // 2 + 2 + 2 + 2 → 40 * 4 = 160


        int[] weight2 = {3, 4, 5};
        int[] value2 = {50, 60, 70};
        System.out.println(unboundedKnapsack(weight2, value2, 11)); // Expected: 170
        // 3 + 3 + 5 → 50 + 50 + 70 = 170
        // 3 + 4 + 4 → 50 + 60 + 60 = 170
        // 3 + 3 + 3 → 150
        // Need DP to find optimum


        int[] weight3 = {1, 3, 4};
        int[] value3 = {10, 40, 50};
        System.out.println(unboundedKnapsack(weight3, value3, 6)); // Expected: 80
        // 3 + 3 → 40 + 40 = 80


        int[] weight4 = {2, 5, 7};
        int[] value4 = {10, 30, 40};
        System.out.println(unboundedKnapsack(weight4, value4, 12)); // Expected: 70
        // 5 + 5 + 2 → 30 + 30 + 10 = 70 actually
        // So Expected: 70


        int[] weight5 = {3, 4, 6};
        int[] value5 = {40, 50, 70};
        System.out.println(unboundedKnapsack(weight5, value5, 12)); // Expected: 160
        // 3 + 3 + 3 + 3 → 40 * 4 = 160
    }
}