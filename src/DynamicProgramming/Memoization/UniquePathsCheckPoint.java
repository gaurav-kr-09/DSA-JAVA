package DynamicProgramming.Memoization;

import java.util.Arrays;

public class UniquePathsCheckPoint {
    // BASIC RECURSION
    /*public static int uniquePaths(int m, int n, int[][] checkpoints) {
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
        if(cr > er || cc > ec) return 0;

        if(cr == er && cc == ec) return 1;

        int rightWays = paths(cr, cc+1, er, ec);
        int downWays = paths(cr+1, cc, er, ec);

        return rightWays + downWays;
    }*/

    // MEMOIZATION
    public static int[][] dp;
    public static int uniquePaths(int m, int n, int[][] checkpoints) {
        int ans = 1;

        int cr = 0, cc = 0;
        for(int[] points: checkpoints){
            int er = points[0];
            int ec = points[1];

            dp = new int[m][n];
            for(int[] row: dp) Arrays.fill(row, -1);

            ans *= paths(cr, cc, er, ec);

            cr = er;
            cc = ec;
        }

        // last checkpoint -> destination
        dp = new int[m][n];
        for(int[] row: dp) Arrays.fill(row, -1);
        ans *= paths(cr, cc, m-1, n-1);

        return ans;
    }

    public static int paths(int cr, int cc, int er, int ec){
        if(cr > er || cc > ec) return 0;

        if(cr == er && cc == ec) return 1;
        if(dp[cr][cc] != -1) return dp[cr][cc];

        int rightWays = paths(cr, cc+1, er, ec);
        int downWays = paths(cr+1, cc, er, ec);

        return dp[cr][cc] = rightWays + downWays;
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