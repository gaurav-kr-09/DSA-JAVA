package DynamicProgramming.Tabulation;

import java.util.Arrays;

public class ZeroOneKnapsack {
    // TABULATION - WITHOUT SPACE OPTIMIZATION
    /*public static int knapsack(int[] wt, int[] val, int C) {
        int n = wt.length;

        // wahi ulta recursion se laya hu ye
        int[][] dp = new int[n+1][C +1];

        // agar item 0 ya capacity 0 to profit v 0
        // waise ye karne ka need nahi hai java me already 0 hota hai
        // but for understanding
        for(int i=0; i<=C; i++)  dp[0][i] = 0;
        for(int i=0; i<=n; i++)  dp[i][0] = 0;

        // filling the dp table
        for(int i=1; i<=n; i++){ // n items ie n+1 rows
            for(int j=1; j<=C; j++){ // C capacity ie C+1 cols
                // TAKE
                int take = 0;
                if(j >= wt[i-1]) // if(C >= wt[n-1])
                    take = val[i-1] + dp[i-1][j - wt[i-1]]; // val[n-1] + solve(n-1, wt, val, C-wt[n-1]);

                // SKIP
                int skip = dp[i-1][j]; // solve(n-1, wt, val, C);

                dp[i][j] = Math.max(take, skip);
            }
        }

        return dp[n][C];
    }*/

    // WITH SPACE OPTIMIZATION
    public static int knapsack(int[] wt, int[] val, int C) {
        int n = wt.length;

        int[] dp = new int[C+1];
        Arrays.fill(dp, 0); // not needed in java

        // dp wala array fill karna
        for(int i=1; i<=n; i++){ // n bar chalayenge
            /*for(int j=C; j >= 0; j--){ // ulta chalao kyuki purane row ka value use karna hai
                // TAKE
                int take = 0;
                if(j >= wt[i-1]) // if(C >= wt[n-1])
                    take = val[i-1] + dp[j - wt[i-1]]; // val[n-1] + solve(n-1, wt, val, C-wt[n-1]);

                // SKIP
                int skip = dp[j]; // solve(n-1, wt, val, C);

                dp[j] = Math.max(take, skip);
            }*/

            // andar wale loop ko j >= wt[i-1] tak v kar sakte hai
            // kyuki waha pe to zero ya purana dp[j] hi aayega since C < wt[i]
            // and andar v if ( j >= wt[i-1]) wala condn lagane
            // Ka koi jarurat nahi hai
            for(int j=C; j >= wt[i-1]; j--){
                int take = val[i-1] + dp[j - wt[i-1]]; // val[n-1] + solve(n-1, wt, val, C-wt[n-1]);
                int skip = dp[j]; // solve(n-1, wt, val, C);

                dp[j] = Math.max(take, skip);
            }
        }

        return dp[C];
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