package DynamicProgramming.Memoization;

import java.util.Arrays;

public class MinXorPathIngrid {
    // ye kam to kar rha hai but ye achha solution nahi hai
    public static int m, n;
    public static int[][][] dp;
    public static int minCost(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        dp = new int[m][n][1024];
        for(int[][] temp: dp)
            for(int[] row: temp) Arrays.fill(row, -1);

        return paths(0, 0, grid, 0);
    }

    public static int paths(int cr, int cc, int[][] grid, int xor) {
        if(cr >= m || cc >= n) return Integer.MAX_VALUE; // bahar;

        xor ^= grid[cr][cc];

        if(cr == m-1 && cc == n - 1) return xor; // exact destination

        // isko niche isiliye la rhe hai kyuki curr wale ka v xor lena hai
        if(dp[cr][cc][xor] != -1) return dp[cr][cc][xor];

        int right = paths(cr, cc+1, grid, xor);
        int down = paths(cr+1, cc, grid, xor);

        return dp[cr][cc][xor] = Math.min(right, down);
    }

    public static void main(String[] args) {
        int[][] grid1 = {
                {1, 2},
                {3, 4}
        };
        System.out.println(minCost(grid1)); // Expected: 6

        int[][] grid2 = {
                {6, 7},
                {5, 8}
        };
        System.out.println(minCost(grid2)); // Expected: 9

        int[][] grid3 = {
                {2, 7, 5}
        };
        System.out.println(minCost(grid3)); // Expected: 0

        int[][] grid4 = {
                {5}
        };
        System.out.println(minCost(grid4)); // Expected: 5

        int[][] grid5 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(minCost(grid5)); // Expected: 7
    }
}