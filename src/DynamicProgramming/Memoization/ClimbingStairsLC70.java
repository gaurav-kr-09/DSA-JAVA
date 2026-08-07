package DynamicProgramming.Memoization;

import java.util.Arrays;

public class ClimbingStairsLC70 {
    // Basic recursion
    /*public static int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;

        return climbStairs(n-1) + climbStairs(n-2);
    }*/

    // DP - Memoization
    public static int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return climb(n, dp);
    }

    public static int climb(int n, int[] dp){
        if(n == 1) return 1;
        if(n == 2) return 2;

        if(dp[n] != -1) return dp[n];

        return dp[n] = climb(n-1, dp) + climb(n-2, dp);
    }

    public static void main(String[] args) {
        System.out.println("n = 1 -> " + climbStairs(1));   // 1

        System.out.println("n = 2 -> " + climbStairs(2));   // 2

        System.out.println("n = 3 -> " + climbStairs(3));   // 3

        System.out.println("n = 4 -> " + climbStairs(4));   // 5

        System.out.println("n = 5 -> " + climbStairs(5));   // 8

        System.out.println("n = 6 -> " + climbStairs(6));   // 13

        System.out.println("n = 7 -> " + climbStairs(7));   // 21

        System.out.println("n = 10 -> " + climbStairs(10)); // 89
    }
}