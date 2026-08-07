package DynamicProgramming.Memoization;

import java.util.Arrays;

public class MinimumPathSumLC64 {
    // Basic recursion
    /*public static int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        return minSum(0, 0, r, c, grid);
    }

    private static int minSum(int cr, int cc, int er, int ec, int[][] grid) {
        if(cr >= er || cc >= ec) return Integer.MAX_VALUE; // bahar aa gaya
        if(cr == er-1 && cc == ec - 1) return grid[cr][cc];

        int right = minSum(cr, cc+1, er, ec, grid);
        int down = minSum(cr+1, cc, er, ec, grid);

        return grid[cr][cc] + Math.min(right, down);
    }*/

    // Dynamic Programming
    public static int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int[][] dp = new int[r][c];
        for(int[] row: dp) Arrays.fill(row, -1);

        return minSum(0, 0, r, c, grid, dp);
    }

    private static int minSum(int cr, int cc, int er, int ec, int[][] grid, int[][] dp) {
        if(cr >= er || cc >= ec) return Integer.MAX_VALUE; // bahar aa gaya
        if(cr == er-1 && cc == ec - 1) return grid[cr][cc];

        if(dp[cr][cc] != -1) return dp[cr][cc];

        int right = minSum(cr, cc+1, er, ec, grid, dp);
        int down = minSum(cr+1, cc, er, ec, grid, dp);

        return dp[cr][cc] = grid[cr][cc] + Math.min(right, down);
    }

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        })); // 7

        System.out.println(minPathSum(new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        })); // 12

        System.out.println(minPathSum(new int[][]{
                {5}
        })); // 5

        System.out.println(minPathSum(new int[][]{
                {1, 2, 5},
                {3, 2, 1}
        })); // 6

        System.out.println(minPathSum(new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        })); // 5

        System.out.println(minPathSum(new int[][]{
                {7, 1, 3, 5},
                {2, 8, 1, 4},
                {1, 2, 2, 1}
        })); // 15
    }
}