package DynamicProgramming.Tabulation;

public class UnboundedKnapsack {
    // TABULATION - WITHOUT SPACE OPTIMIZATION
    /*public static int unboundedKnapsack(int[] wt, int[] val, int C) {
        int n = wt.length;

        int[][] dp = new int[n+1][C +1];
        // agar item 0 ya capacity 0 to profit v 0
        // for(int i=0; i<=n; i++) dp[i][0] = 0; // Unnecessary
        // for(int i=0; i<=C; i++) dp[0][i] = 0; // Unnecessary


        for(int i=1; i<=n; i++){
            for(int j=1; j<=C; j++){
                // TAKE
                int take = 0;
                if(j >= wt[i-1]) // if(C >= wt[n-1])
                    take = val[i-1] + dp[i][j - wt[i-1]]; // val[n-1] + maxProfit(n, wt, val, C-wt[n-1], dp);

                // key change - dekh 0/1 me ye tha
                // take = val[i-1] + dp["i-1"][j - wt[i-1]]; // val[n-1] + solve(n-1, wt, val, C-wt[n-1]);
                // usme dp[i-1] tha kyuki usme reuse nahi karna tha isiliye purana value use kar liye
                // but isme we can reuse so use updated value

                // SKIP
                int skip = dp[i-1][j]; // solve(n-1, wt, val, C);

                dp[i][j] = Math.max(take, skip);
            }
        }

        return dp[n][C];
    }*/

    // SPACE OPTIMIZED TABULATION
    public static int unboundedKnapsack(int[] wt, int[] val, int C) {
        int n = wt.length;

        int[] dp = new int[C +1];


        for(int i=1; i<=n; i++){
            for(int j=wt[i-1]; j<=C; j++){ // if(C >= wt[n-1]) isiliye aise v kar sakte hai
                // isme andar wala loop sidha chalayenge, unlike 0/1
                // kyuki isme updated value chahiye due to same item reuse
                int take = val[i-1] + dp[j - wt[i-1]]; // val[n-1] + maxProfit(n, wt, val, C-wt[n-1], dp);
                int skip = dp[j]; // solve(n-1, wt, val, C);

                dp[j] = Math.max(take, skip);
            }
        }

        return dp[C];
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