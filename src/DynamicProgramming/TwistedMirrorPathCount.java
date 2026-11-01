package DynamicProgramming;

import java.util.Arrays;

public class TwistedMirrorPathCount {
    // unique paths ke jaisa hi hai but ek twist hai ki agar 1
    // aa gaya to agar right ja rhe hai to down murna parega &
    // agar down ja rhe hai and 1 aa gaya to right murna parega
    // total no. of ways batana hai ki start se end pe ja sakte hai
    // to ek kam kar sakte hai ek to i & j and ek dir variable maintain
    // karte hai jisme 0 batayega ki right ja rhe the and 1 batayega
    // ki down ja rhe the

    // Recursive solution
    /*public static int er, ec;
    public static int countPaths(int[][] grid) {
        er = grid.length;
        ec = grid[0].length;

        return paths(0, 0, -1, grid);
    }

    private static int paths(int sr, int sc, int dir, int[][] grid) {
        // dir = 0 -> right | 1 -> left
        if(sr >= er || sc >= ec) return 0; // bahar
        if(sr == er-1 && sc == ec-1) return 1; // destination aa gaya

        int rightWays = 0;
        int downWays = 0;
        if(grid[sr][sc] == 1){ // mirror hai
            // right hai to down jana parega & down hai to right
            if(dir == 0) downWays = paths(sr+1, sc, 1, grid); // right -> go down
            else rightWays = paths(sr, sc+1, 0, grid); // down -> go right
        }else{ // no mirror kahi v ja sakte hai
            downWays = paths(sr+1, sc, 1, grid);
            rightWays = paths(sr, sc+1, 0, grid);
        }

        return rightWays + downWays;
    }*/

    // Memoizing the recursive solution
    public static int er, ec;
    public static int MOD = (int) 1e9+7;
    public static int countPaths(int[][] grid) {
        er = grid.length;
        ec = grid[0].length;

        // sr -> 0 - er-1 | sc -> 0 - ec-1 | dir -> 0-1
        // but dir 3 size ka le rhe hai taki -1 jo bhej
        // rhe hai by default wo handle ho jaye & dir+1
        // check kar lenge isse 0 wala 1 pe and 1 wala 2
        // pe check hoga
        int[][][] dp = new int[er][ec][3];
        for(int[][] rows: dp)
            for(int[] cell: rows)
                Arrays.fill(cell, -1);

        return paths(0, 0, -1, grid, dp);
    }

    private static int paths(int sr, int sc, int dir, int[][] grid, int[][][] dp) {
        // dir = 0 -> right | 1 -> left
        if(sr >= er || sc >= ec) return 0; // bahar
        if(sr == er-1 && sc == ec-1) return 1; // destination aa gaya

        if(dp[sr][sc][dir+1] != -1) return dp[sr][sc][dir+1];
        int rightWays = 0;
        int downWays = 0;
        if(grid[sr][sc] == 1){ // mirror hai
            // right hai to down jana parega & down hai to right
            if(dir == 0) downWays = paths(sr+1, sc, 1, grid, dp); // right -> go down
            else rightWays = paths(sr, sc+1, 0, grid, dp); // down -> go right
        }else{ // no mirror kahi v ja sakte hai
            downWays = paths(sr+1, sc, 1, grid, dp);
            rightWays = paths(sr, sc+1, 0, grid, dp);
        }

        return dp[sr][sc][dir+1] = (rightWays + downWays) % MOD;
    }

    public static void main(String[] args) {

        int[][] grid1 = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 0, 0}
        };
        System.out.println(countPaths(grid1)); // Expected: 5


        int[][] grid2 = {
                {0, 0},
                {0, 0}
        };
        System.out.println(countPaths(grid2)); // Expected: 2


        int[][] grid3 = {
                {0, 1, 1},
                {1, 1, 0}
        };
        System.out.println(countPaths(grid3)); // Expected: 1
    }
}