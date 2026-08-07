package DynamicProgramming.Tabulation;

public class UniquePathsLC62 {
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i == 0 || j == 0) dp[i][j] = 1;
                // dp[i][j] = upar + left
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {

        System.out.println(uniquePaths(3, 7));   // 28

        System.out.println(uniquePaths(3, 2));   // 3

        System.out.println(uniquePaths(7, 3));   // 28

        System.out.println(uniquePaths(3, 3));   // 6

        System.out.println(uniquePaths(1, 1));   // 1

        System.out.println(uniquePaths(1, 5));   // 1

        System.out.println(uniquePaths(5, 1));   // 1

        System.out.println(uniquePaths(10, 10)); // 48620
    }
}
