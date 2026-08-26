package DynamicProgramming.Tabulation;

public class UniquePaths2LC63 {
    public static int uniquePathsWithObstacles(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1) return 0; // agar source ya destination hi blocked hai, to no path
        int[][] dp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) dp[i][j] = 0; // Obstacle
                else if (i == 0 && j == 0) dp[i][j] = 1; // if 1st cell is not obstacle then 1 way
                else if (i == 0) dp[i][j] = dp[i][j-1]; // 1st row sirf apne left wale pe depend karega
                else if (j == 0) dp[i][j] = dp[i-1][j]; // 1st col sirf apne upar wale pe depend karega
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; // dp[i][j] = upar + left
            }
        }

        return dp[rows-1][cols-1];
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