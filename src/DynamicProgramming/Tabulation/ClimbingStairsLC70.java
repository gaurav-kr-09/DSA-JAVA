package DynamicProgramming.Tabulation;

public class ClimbingStairsLC70 {
    // Unoptimized space
    /*public static int climbStairs(int n) {
        int[] dp = new int[n+1];

        dp[1] = 1;
        if(n > 1) dp[2] = 2;

        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }*/

    // Space optimized
    public static int climbStairs(int n) {
        if(n <= 1) return 1;

        int prevWays = 1;
        int CurrWays = 2;

        for(int i=3; i<=n; i++){
            int nextWays = prevWays + CurrWays;
            prevWays = CurrWays;
            CurrWays = nextWays;
        }

        return CurrWays;
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