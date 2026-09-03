package DynamicProgramming.Tabulation;

import java.util.Arrays;

public class CoinChangeLC322 {
    // Tabulation - Without space optimization
    /*public static int coinChange(int[] coins, int amount) {
        int n = coins.length;

        // i vary from n to 0 and amount from amount to 0
        long[][] dp = new long[n+1][amount+1];
        for(int i=0; i<=n; i++) dp[i][0] = 0; // jab amount 0 to need 0
        for(int i=1; i<=amount; i++) dp[0][i] =  Integer.MAX_VALUE; // 0 coins se positive amount banana impossible -> infinity.

        for(int i=1; i<=n; i++){
            for(int j=1; j<=amount; j++){
                long pick = Integer.MAX_VALUE;
                if(j >= coins[i-1]) // amount >= coins[n-1]
                    pick = 1 + dp[i][j-coins[i-1]]; // coinCount(n, coins, amount-coins[n-1], dp);

                long skip = dp[i-1][j]; // coinCount(n-1, coins, amount, dp);

                dp[i][j] = Math.min(pick, skip);
            }
        }

        int ans = (int)dp[n][amount];
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }*/

    // tabulation with space optimization
    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1); // 0 coins se positive amount banana impossible -> infinity.
        dp[0] = 0; // 0 amount banane k liye 0 coins needed

        for(int i=1; i<=n; i++){
            for(int j=coins[i-1]; j<=amount; j++){ // sidha loop coz we need updated value also // amount >= coins[n-1]
                int pick = 1 + dp[j-coins[i-1]];
                int skip = dp[j];
                dp[j] = Math.min(pick, skip);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
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