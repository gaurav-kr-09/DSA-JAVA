package DynamicProgramming.Memoization;

import java.util.Arrays;

public class CountDerangements {
    // Basic recursion
    /*public static long derangeCount(int n) {
        if(n == 0) return 1;
        if(n <= 2) return n - 1;

        return (n-1) * (derangeCount(n-2) + derangeCount(n-1));
    }*/

    // Memoization
    public static long derangeCount(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return count(n, dp);
    }

    public static int count(int n, int[] dp){
        if(n == 0) return 1;
        if(n <= 2) return n - 1;

        if(dp[n] != -1) return dp[n];
        return dp[n] = (n-1) * (count(n-2, dp) + count(n-1, dp));
    }

    public static void main(String[] args) {

        System.out.println("D(0) = " + derangeCount(0));   // 1

        System.out.println("D(1) = " + derangeCount(1));   // 0

        System.out.println("D(2) = " + derangeCount(2));   // 1

        System.out.println("D(3) = " + derangeCount(3));   // 2

        System.out.println("D(4) = " + derangeCount(4));   // 9

        System.out.println("D(5) = " + derangeCount(5));   // 44

        System.out.println("D(6) = " + derangeCount(6));   // 265

        System.out.println("D(7) = " + derangeCount(7));   // 1854

        System.out.println("D(8) = " + derangeCount(8));   // 14833
    }
}