package DynamicProgramming.Memoization;

import java.util.Arrays;

public class DeleteOprnForTwoStrings {
    // MEMOIZATION SIDHA
    /*public static int minDistance(String a, String b) {
        int al = a.length(), bl = b.length();

        // i -> 0 to al | j -> 0 to bl
        int[][] dp = new int[al][bl];
        for(int[] row: dp) Arrays.fill(row, -1);

        int cl = lcs(0, 0, a, b, dp); // common subsq length
        return al + bl - 2*cl; // (al - cl) + (bl - cl)
    }

    private static int lcs(int i, int j, String a, String b, int[][] dp) {
        if(i == a.length() || j == b.length()) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(a.charAt(i) == b.charAt(j)) return dp[i][j] = 1 + lcs(i+1, j+1, a, b, dp);
        else return dp[i][j] = Math.max(lcs(i+1, j, a, b, dp), lcs(i, j+1, a, b, dp));
    }*/

    // MEMOIZATION ULTA - better for tabulation
    public static int minDistance(String a, String b) {
        int al = a.length(), bl = b.length();

        // i -> 0 to al | j -> 0 to bl
        int[][] dp = new int[al+1][bl+1];
        for(int[] row: dp) Arrays.fill(row, -1);

        int cl = lcs(al, bl, a, b, dp); // common subsq length
        return al + bl - 2*cl; // (al - cl) + (bl - cl)
    }

    private static int lcs(int i, int j, String a, String b, int[][] dp) {
        if(i == 0 || j == 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(a.charAt(i-1) == b.charAt(j-1)) return dp[i][j] = 1 + lcs(i-1, j-1, a, b, dp);
        else return dp[i][j] = Math.max(lcs(i-1, j, a, b, dp), lcs(i, j-1, a, b, dp));
    }

    public static void main(String[] args) {

        System.out.println(minDistance("sea", "eat"));       // Expected: 2
        System.out.println(minDistance("leetcode", "etco")); // Expected: 4
        System.out.println(minDistance("abc", "abc"));       // Expected: 0
        System.out.println(minDistance("abc", "def"));       // Expected: 6
        System.out.println(minDistance("", "abc"));          // Expected: 3
        System.out.println(minDistance("abc", ""));          // Expected: 3
        System.out.println(minDistance("a", "a"));           // Expected: 0
        System.out.println(minDistance("abc", "ac"));        // Expected: 1
    }
}