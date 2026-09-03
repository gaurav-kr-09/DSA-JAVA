package DynamicProgramming.Memoization;

import java.util.Arrays;

public class CoinChangeLC322 {
    // BASIC RECURSION
    /*public static int coinChange(int[] coins, int amount) {
        int ans = (int)coinCount(0, coins, amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    // dekho yaha par ultimately answer me Math.min kr rhe hai,
    // so agar impossible state me agar 0 le le to min 0 hi aa jayega
    // so ham isko Infinite kar de rhe hai, and usko handle karne
    // ke liye long lena padega instead of int
    public static long coinCount(int i, int[] coins, int amount){
        if(amount == 0) return 0; // No more coins needed
        if(i >= 0 || amount < 0) return Integer.MAX_VALUE; // no possible combination

        long pick = Integer.MAX_VALUE;
        if(amount >= coins[i])
            pick = 1 + coinCount(i, coins, amount-coins[i]);

        long skip = coinCount(i+1, coins, amount);

        return Math.min(pick, skip);
    }*/

    // MEMOIZATION - SIDHA
    /*public static int coinChange(int[] coins, int amount) {
        int n = coins.length;

        // i vary from 0 to n-1 and amount from amount to 0
        long[][] dp = new long[n][amount+1];
        for(long[] row: dp) Arrays.fill(row, -1);

        int ans = (int)coinCount(0, coins, amount, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static long coinCount(int i, int[] coins, int amount, long[][] dp){
        if(amount == 0) return 0; // no more coins needed
        if(i >= coins.length || amount < 0) return Integer.MAX_VALUE; // No possible combination

        if(dp[i][amount] != -1) return dp[i][amount];

        long pick = Integer.MAX_VALUE;
        if(amount >= coins[i])
            pick = 1 + coinCount(i, coins, amount-coins[i], dp);

        long skip = coinCount(i+1, coins, amount, dp);

        return dp[i][amount] = Math.min(pick, skip);
    }*/

     // MEMOIZATION - ULTA
    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;

        // i vary from n to 0 and amount from amount to 0
        long[][] dp = new long[n+1][amount+1];
        for(long[] row: dp) Arrays.fill(row, -1);

        int ans = (int)coinCount(n, coins, amount, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static long coinCount(int n, int[] coins, int amount, long[][] dp){
        if(amount == 0) return 0; // no more coins needed
        if(n <= 0 || amount < 0) return Integer.MAX_VALUE; // No possible combination

        if(dp[n][amount] != -1) return dp[n][amount];

        long pick = Integer.MAX_VALUE;
        if(amount >= coins[n-1])
            pick = 1 + coinCount(n, coins, amount-coins[n-1], dp);

        long skip = coinCount(n-1, coins, amount, dp);

        return dp[n][amount] = Math.min(pick, skip);
    }

    public static void main(String[] args) {

        int[] coins1 = {1, 2, 5};
        System.out.println(coinChange(coins1, 11)); // Expected: 3

        int[] coins2 = {2};
        System.out.println(coinChange(coins2, 3)); // Expected: -1

        int[] coins3 = {1};
        System.out.println(coinChange(coins3, 0)); // Expected: 0

        int[] coins4 = {2, 5, 10, 1, 3};
        System.out.println(coinChange(coins4, 27)); // Expected: 4

        int[] coins5 = {186, 419, 83, 408};
        System.out.println(coinChange(coins5, 6249)); // Expected: 20

        int[] coins6 = {3, 7, 405, 436};
        System.out.println(coinChange(coins6, 8839)); // Expected: 25
    }
}