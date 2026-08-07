package DynamicProgramming.Tabulation;

public class MinimumPathSumLC64 {
    // Extra space
    /*public static int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int[][] dp = new int[r][c];

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(i == 0 && j == 0) dp[i][j] = grid[i][j];
                else if(i == 0) dp[i][j] = grid[i][j] + dp[i][j-1];
                else if(j == 0) dp[i][j] = grid[i][j] + dp[i-1][j];
                else dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[r-1][c-1];
    }*/

    // Without extra space
    public static int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(i == 0 && j == 0) continue;
                else if(i == 0) grid[i][j] += grid[i][j-1];
                else if(j == 0) grid[i][j] += grid[i-1][j];
                else grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }

        return grid[r-1][c-1];
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