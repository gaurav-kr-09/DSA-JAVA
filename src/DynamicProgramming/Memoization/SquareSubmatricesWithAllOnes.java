package DynamicProgramming.Memoization;

import java.util.Arrays;

public class SquareSubmatricesWithAllOnes {
    // Basic recursion
    /*public static int countSquares(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                ans += solve(i, j, mat);
        }

        return ans;
    }

    public static int solve(int i, int j, int[][] mat){
        if(i < 0 || j < 0) return 0; // bahar
        if(mat[i][j] == 0) return 0;

        int top = solve(i-1, j, mat);
        int left = solve(i, j-1, mat);
        int diag = solve(i-1, j-1, mat);

        return 1 + Math.min(top, Math.min(left, diag));
    }*/

    // Memoization
    public static int[][] dp;
    public static int countSquares(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        dp = new int[rows][cols];
        for(int[] row: dp) Arrays.fill(row, -1);

        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                ans += solve(i, j, mat);
        }

        return ans;
    }

    public static int solve(int i, int j, int[][] mat){
        if(i < 0 || j < 0) return 0; // bahar

        if(dp[i][j] != -1) return dp[i][j]; // DP me value hai
        if(mat[i][j] == 0) return dp[i][j] = 0; // DP me 0 add karo

        int top = solve(i-1, j, mat);
        int left = solve(i, j-1, mat);
        int diag = solve(i-1, j-1, mat);

        return dp[i][j] = 1 + Math.min(top, Math.min(left, diag));
    }



    public static void main(String[] args) {

        System.out.println(countSquares(new int[][]{
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        })); // 15

        System.out.println(countSquares(new int[][]{
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        })); // 7

        System.out.println(countSquares(new int[][]{
                {1}
        })); // 1

        System.out.println(countSquares(new int[][]{
                {0}
        })); // 0

        System.out.println(countSquares(new int[][]{
                {1, 1},
                {1, 1}
        })); // 5

        System.out.println(countSquares(new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        })); // 14
    }
}