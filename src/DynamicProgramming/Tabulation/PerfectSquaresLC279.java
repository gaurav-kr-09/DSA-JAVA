package DynamicProgramming.Tabulation;

public class PerfectSquaresLC279 {
    public static int numSquares(int n) {
        int[] dp = new int[n+1];

        // n bar loop chalao
        for(int i=1; i <= n; i++){
            dp[i] = Integer.MAX_VALUE;

            // sare nos. ka value calculate karo
            for(int j=1; j*j<=i; j++){
                int res = 1 + dp[i - j*j];
                dp[i] = Math.min(dp[i], res);
            }
        }

        return dp[n];
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
