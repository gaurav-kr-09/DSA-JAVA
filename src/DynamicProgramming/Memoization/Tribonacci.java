package DynamicProgramming.Memoization;

import java.util.Arrays;

public class Tribonacci {
    // Simple recursion - TLE
    /*public static int tribonacci(int n) {
        if(n <= 1) return n;
        if(n == 2) return 1;

        return tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);
    }*/

    // Memoization - DP
    public static int tribonacci(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return tribo(n, dp);
    }

    // Memoization
    public static int tribo(int n, int[] dp){
        if(n <= 1) return n;
        if(n == 2) return 1;

        if(dp[n] != -1) return dp[n];
        return dp[n] = tribo(n-1, dp) + tribo(n-2, dp) + tribo(n-3, dp);
    }

    public static void main(String[] args) {

        System.out.println("Tribonacci(0) = " + tribonacci(0));   // 0

        System.out.println("Tribonacci(1) = " + tribonacci(1));   // 1

        System.out.println("Tribonacci(2) = " + tribonacci(2));   // 1

        System.out.println("Tribonacci(3) = " + tribonacci(3));   // 2

        System.out.println("Tribonacci(4) = " + tribonacci(4));   // 4

        System.out.println("Tribonacci(5) = " + tribonacci(5));   // 7

        System.out.println("Tribonacci(10) = " + tribonacci(10)); // 149

        System.out.println("Tribonacci(25) = " + tribonacci(25)); // 1389537
    }
}
