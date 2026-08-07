package DynamicProgramming.Memoization;

import java.util.Arrays;

public class UniquePathsLC62 {
    // Basic recursion
    /*public static int uniquePaths(int m, int n) {
        if(m == 1 || n == 1) return 1;
        return uniquePaths(m-1, n) + uniquePaths(m, n-1);
    }*/

    //Basic recursion 2
    /*public static int uniquePaths(int m, int n) {
       return paths(0, 0, m, n);
    }

    private static int paths(int cr, int cc, int er, int ec) {
        if(cr >= er || cc >= ec) return 0; // bahar aa gaya

        // if(cr == er-1 || cc == ec - 1) return 1; // last row ya column me chale gaye to ekhi rasta bachega
        if(cr == er-1 && cc == ec - 1) return 1; // exact destination pe ek path

        int rightways = paths(cr, cc+1, er, ec);
        int downWays = paths(cr+1, cc, er, ec);

        return rightways + downWays;
    }*/

    // Memoization 2d
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] row: dp) Arrays.fill(row, -1);

        return paths(0, 0, m, n, dp);
    }

    private static int paths(int cr, int cc, int er, int ec, int[][] dp) {
        if(cr >= er || cc >= ec) return 0; // bahar aa gaya
        if(cr == er-1 && cc == ec - 1) return 1; // exact destination pe ek path

        if(dp[cr][cc] != -1) return dp[cr][cc];

        int rightways = paths(cr, cc+1, er, ec, dp);
        int downWays = paths(cr+1, cc, er, ec, dp);

        return dp[cr][cc] = rightways + downWays;
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
