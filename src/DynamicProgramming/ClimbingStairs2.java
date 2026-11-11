package DynamicProgramming;

public class ClimbingStairs2 {
    // Basic recursion
    /*public static int climbStairs(int n, int[] costs) {
        return minCost(0, n, costs);
    }

    public static int minCost(int i, int n, int[] costs){
        if(i == n) return 0;

        int c1 = Integer.MAX_VALUE;
        int c2 = Integer.MAX_VALUE;
        int c3 = Integer.MAX_VALUE;

        int j = i + 1; // ek step
        if(j <= n) c1 = costs[j-1] + (j-i) * (j-i) + minCost(j, n, costs);

        j = i + 2; // 2 step
        if(j <= n) c2 = costs[j-1] + (j-i) * (j-i) + minCost(j, n, costs);

        j = i + 3; // 2 step
        if(j <= n) c3 = costs[j-1] + (j-i) * (j-i) + minCost(j, n, costs);

        return Math.min(c1, Math.min(c2, c3));
    }*/

    // memoization
    /*public static int climbStairs(int n, int[] costs) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return minCost(0, n, costs, dp);
    }

    public static int minCost(int i, int n, int[] costs, int[] dp){
        if(i == n) return 0;
        if(dp[i] != -1) return dp[i];

        int c1 = Integer.MAX_VALUE;
        int c2 = Integer.MAX_VALUE;
        int c3 = Integer.MAX_VALUE;

        int j = i + 1; // ek step
        if(j <= n) c1 = costs[j-1] + (j-i) * (j-i) + minCost(j, n, costs, dp);

        j = i + 2; // 2 step
        if(j <= n) c2 = costs[j-1] + (j-i) * (j-i) + minCost(j, n, costs, dp);

        j = i + 3; // 2 step
        if(j <= n) c3 = costs[j-1] + (j-i) * (j-i) + minCost(j, n, costs, dp);

        return dp[i] = Math.min(c1, Math.min(c2, c3));
    }*/

    // Tabulation
    public static int climbStairs(int n, int[] costs) {
        int[] dp = new int[n+1];

        for(int i = n-1; i >= 0; i--){
            int c1 = Integer.MAX_VALUE;
            int c2 = Integer.MAX_VALUE;
            int c3 = Integer.MAX_VALUE;

            int j = i + 1; // ek step
            if(j <= n) c1 = costs[j-1] + (j-i) * (j-i) + dp[j];

            j = i + 2; // 2 step
            if(j <= n) c2 = costs[j-1] + (j-i) * (j-i) + dp[j];

            j = i + 3; // 2 step
            if(j <= n) c3 = costs[j-1] + (j-i) * (j-i) + dp[j];

            dp[i] = Math.min(c1, Math.min(c2, c3));
        }

        return dp[0];
    }

    public static void main(String[] args) {
        int[][] costs = {
                {1, 2, 3, 4},
                {5, 1, 6, 2},
                {9, 8, 3},
                {1},
                {1, 2}
        };

        int[] n = {4, 4, 3, 1, 2};

        int[] expected = {13, 11, 12, 2, 5};

        for (int i = 0; i < n.length; i++) {
            int result = climbStairs(n[i], costs[i]);

            System.out.println("Test Case " + (i + 1));
            System.out.println("Expected: " + expected[i]);
            System.out.println("Actual:   " + result);
            System.out.println("Status:   " +
                    (result == expected[i] ? "PASS" : "FAIL"));
            System.out.println();
        }
    }
}