package DynamicProgramming.Tabulation;

public class MinCostToClimbStairs {
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i=2; i<n; i++){
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }

        return Math.min(dp[n-1], dp[n-2]);
    }

    public static void main(String[] args) {

        System.out.println(minCostClimbingStairs(new int[]{10, 15, 20}));                  // 15

        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1})); // 6

        System.out.println(minCostClimbingStairs(new int[]{0, 0, 0, 0}));                  // 0

        System.out.println(minCostClimbingStairs(new int[]{5, 10}));                       // 5

        System.out.println(minCostClimbingStairs(new int[]{10, 20, 30, 15}));              // 35

        System.out.println(minCostClimbingStairs(new int[]{1, 2, 3, 4, 5}));               // 6

        System.out.println(minCostClimbingStairs(new int[]{5, 5, 5, 5, 5}));               // 10
    }
}
