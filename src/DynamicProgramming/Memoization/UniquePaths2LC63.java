package DynamicProgramming.Memoization;

import java.util.Arrays;

public class UniquePaths2LC63 {
    // Basic recursion
    /*public static int uniquePathsWithObstacles(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1) return 0;

        return paths(0, 0, rows - 1, cols - 1, grid);
    }

    public static int paths(int sr, int sc, int er, int ec, int[][] grid){
        if(sr > er || sc > ec) return 0;
        if(sr == er && sc == ec) return 1;

        if(grid[sr][sc] == 1) return 0; // blocked cell

        int downPaths = paths(sr+1, sc, er, ec, grid);
        int rightPaths = paths(sr, sc+1, er, ec, grid);

        return downPaths + rightPaths;
    }*/

    // Memoization
    public static int[][] dp;
    public static int uniquePathsWithObstacles(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1) return 0;

        dp = new int[rows][cols];
        for(int[] row: dp) Arrays.fill(row, -1);

        return paths(0, 0, rows - 1, cols - 1, grid);
    }

    public static int paths(int sr, int sc, int er, int ec, int[][] grid){
        if(sr > er || sc > ec) return 0;
        if(sr == er && sc == ec) return 1;

        if(dp[sr][sc] != -1) return dp[sr][sc];
        if(grid[sr][sc] == 1) return dp[sr][sc] = 0; // blocked cell

        int downPaths = paths(sr+1, sc, er, ec, grid);
        int rightPaths = paths(sr, sc+1, er, ec, grid);

        return dp[sr][sc] = downPaths + rightPaths;
    }

    public static void main(String[] args) {
        int[][] grid1 = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(uniquePathsWithObstacles(grid1)); // 2


        int[][] grid2 = {
                {0, 1},
                {0, 0}
        };
        System.out.println(uniquePathsWithObstacles(grid2)); // 1


        int[][] grid3 = {
                {0, 0},
                {1, 1}
        };
        System.out.println(uniquePathsWithObstacles(grid3)); // 0


        int[][] grid4 = {
                {0, 0},
                {0, 0}
        };
        System.out.println(uniquePathsWithObstacles(grid4)); // 2


        int[][] grid5 = {
                {1}
        };
        System.out.println(uniquePathsWithObstacles(grid5)); // 0
    }
}