package DynamicProgramming.Memoization;

import java.util.Arrays;

public class PerfectSquaresLC279 {
    // BASIC RECURSION - it will fail for larger nos. even 100
    /*public static int numSquares(int n) {
        if(n == 0) return 0;

        int min = Integer.MAX_VALUE;
        for(int i=1; i*i<=n; i++){
            int result = 1 + numSquares(n-i*i);
            min = Math.min(min, result);
        }

        return min;
    }*/

    // Memoization
    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return helper(n, dp);
    }

    private static int helper(int n, int[] dp) {
        if(n == 0) return 0;

        if(dp[n] != -1) return dp[n];

        int min = Integer.MAX_VALUE;
        for(int i=1; i*i<=n; i++){
            int result = 1 + helper(n - i*i, dp);
            min = Math.min(min, result);
        }

        return dp[n] = min;
    }

    public static void main(String[] args) {
        // Test Case 1
        int n1 = 12;
        System.out.println(numSquares(n1)); // Expected: 3
        // 4 + 4 + 4


        // Test Case 2
        int n2 = 13;
        System.out.println(numSquares(n2)); // Expected: 2
        // 4 + 9


        // Test Case 3
        int n3 = 1;
        System.out.println(numSquares(n3)); // Expected: 1
        // 1


        // Test Case 4
        int n4 = 43;
        System.out.println(numSquares(n4)); // Expected: 3
        // 25 + 9 + 9


        // Test Case 5
        int n5 = 100;
        System.out.println(numSquares(n5)); // Expected: 1
        // 100
    }
}
