package DynamicProgramming.Tabulation;

public class UniquePathsCheckPoint {
    public static int uniquePaths(int m, int n, int[][] checkpoints) {
        int ans = 1;

        int cr = 0, cc = 0;
        for(int[] points: checkpoints){
            int er = points[0];
            int ec = points[1];

            ans *= paths(cr, cc, er, ec);

            cr = er;
            cc = ec;
        }

        // last checkpoint -> destination
        ans *= paths(cr, cc, m-1, n-1);

        return ans;
    }

    public static int paths(int cr, int cc, int er, int ec){
        int rows = er - cr + 1;
        int cols = ec - cc + 1;

        int[][] dp = new int[rows][cols];
        dp[0][0] = 1;

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if (i == 0 && j == 0) dp[i][j] = 1;
                else if (i == 0) dp[i][j] = dp[i][j - 1];
                else if (j == 0) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[rows-1][cols-1];
    }

    public static void main(String[] args) {

        // Test Case 1
        // Must pass through (1,1)
        int[][] checkpoints1 = {
                {1, 1}
        };
        System.out.println(uniquePaths(3, 3, checkpoints1)); // Expected: 4


        // Test Case 2
        // Must pass through (1,1) -> (2,2)
        int[][] checkpoints2 = {
                {1, 1},
                {2, 2}
        };
        System.out.println(uniquePaths(4, 4, checkpoints2)); // Expected: 8


        // Test Case 3
        // Must pass through (1,1) -> (2,2) -> (3,3)
        int[][] checkpoints3 = {
                {1, 1},
                {2, 2},
                {3, 3}
        };
        System.out.println(uniquePaths(4, 4, checkpoints3)); // Expected: 8


        // Test Case 4
        // Must pass through (1,2) -> (2,3)
        int[][] checkpoints4 = {
                {1, 2},
                {2, 3}
        };
        System.out.println(uniquePaths(4, 5, checkpoints4)); // Expected: 12
    }
}