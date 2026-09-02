package DynamicProgramming.Memoization;

import java.util.Arrays;

public class ZeroOneKnapsack {
    // BASIC RECURSION - SIDHA
    /*public static int knapsack(int[] wt, int[] val, int capacity) {
        return solveKnapsack(0, wt, val, capacity);
    }

    private static int solveKnapsack(int i, int[] wt, int[] val, int C) {
        if(i >= wt.length || C == 0) return 0; //bahar chala gaya ya bhar gaya

        // TAKE - if capacity jyada ya barabar hai current weight k
        int take = 0;
        if(C >= wt[i])
            take = val[i] + solveKnapsack(i+1, wt, val, C-wt[i]);

        // SKIP
        int skip = solveKnapsack(i+1, wt, val, C);

        return Math.max(take, skip);
    }*/

    // BASIC RECURSION ULTA - Easy to make bottom up
    /*public static int knapsack(int[] wt, int[] val, int capacity) {
        return solveKnapsack(wt.length, wt, val, capacity);
    }

    private static int solveKnapsack(int n, int[] wt, int[] val, int C) {
        if(n <= 0 || C == 0) return 0;

        // TAKE - if capacity jyada ya barabar hai current weight k
        int take = 0;
        if(C >= wt[n-1])
            take = val[n-1] + solveKnapsack(n-1, wt, val, C-wt[n-1]);

        // SKIP
        int skip = solveKnapsack(n-1, wt, val, C);

        return Math.max(take, skip);
    }*/

    // MEMOIZATION SIDHA KA
    /*public static int knapsack(int[] wt, int[] val, int capacity) {
        // i vary from 0 to n-1 , C vary from 0 to C ie C+1
        int[][] dp = new int[wt.length][capacity+1]; // dp of [i][c]
        for(int[] row: dp) Arrays.fill(row, -1);

        return solveKnapsack(0, wt, val, capacity, dp);
    }

    private static int solveKnapsack(int i, int[] wt, int[] val, int C, int[][] dp) {
        if(i >= wt.length || C == 0) return 0;

        if(dp[i][C] != -1) return dp[i][C];

        // TAKE - if capacity jyada ya barabar hai current weight k
        int take = 0;
        if(C >= wt[i])
            take = val[i] + solveKnapsack(i+1, wt, val, C-wt[i], dp);

        // SKIP
        int skip = solveKnapsack(i+1, wt, val, C, dp);

        return dp[i][C] = Math.max(take, skip);
    }*/

    // MEMOIZATION ULTA KA
    public static int knapsack(int[] wt, int[] val, int capacity) {
        int n = wt.length;

        // n vary kar rha hai n se 0 tak yani n+1 and capacity , C se 0 tak yani capacity+1
        int[][] dp = new int[n+1][capacity+1];
        for(int[] row: dp) Arrays.fill(row, -1);

        return solveKnapsack(n, wt, val, capacity, dp);
    }

    private static int solveKnapsack(int n, int[] wt, int[] val, int C, int[][] dp) {
        if(n <= 0 || C == 0) return 0;

        if(dp[n][C] != -1) return dp[n][C];

        // TAKE - if capacity jyada ya barabar hai current weight k
        int take = 0;
        if(C >= wt[n-1])
            take = val[n-1] + solveKnapsack(n-1, wt, val, C-wt[n-1], dp);

        // SKIP
        int skip = solveKnapsack(n-1, wt, val, C, dp);

        return dp[n][C] = Math.max(take, skip);
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] wt1 = {1, 2, 3};
        int[] val1 = {10, 15, 40};
        int capacity1 = 6;

        System.out.println(knapsack(wt1, val1, capacity1));
        // Expected: 65

        // Test Case 2
        int[] wt2 = {10, 20, 30};
        int[] val2 = {60, 100, 120};
        int capacity2 = 50;

        System.out.println(knapsack(wt2, val2, capacity2));
        // Expected: 220

        // Test Case 3
        int[] wt3 = {2, 3, 4, 5};
        int[] val3 = {3, 4, 5, 6};
        int capacity3 = 5;

        System.out.println(knapsack(wt3, val3, capacity3));
        // Expected: 7

        // Test Case 4
        int[] wt4 = {5, 3, 8, 16};
        int[] val4 = {1, 2, 9, 10};
        int capacity4 = 8;

        System.out.println(knapsack(wt4, val4, capacity4));
        // Expected: 9
    }
}