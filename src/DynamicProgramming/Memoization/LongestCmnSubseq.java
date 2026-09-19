package DynamicProgramming.Memoization;

import java.util.Arrays;

public class LongestCmnSubseq {
    // BASIC RECURSION
    /*public static int longestCommonSubsequence(String a, String b) {
        return lcs(0, 0, a, b);
    }

    private static int lcs(int i, int j, String a, String b) { // i -> 1st Str, j -> 2nd str
         if(i == a.length() || j == b.length()) return 0;

         if(a.charAt(i) == b.charAt(j)) return 1 + lcs(i+1, j+1, a, b);
         else return Math.max(lcs(i+1, j, a, b), lcs(i, j+1, a, b));
    }*/

    // MEMOIZATION
    /*public static int longestCommonSubsequence(String a, String b) {
        int al = a.length(), bl = b.length();

        // i -> 0 to al | j -> 0 to bl
        int[][] dp = new int[al][bl];
        for(int[] row: dp) Arrays.fill(row, -1);

        return lcs(0, 0, a, b, dp);
    }

    private static int lcs(int i, int j, String a, String b, int[][] dp) { // i -> 1st Str, j -> 2nd str
        if(i == a.length() || j == b.length()) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(a.charAt(i) == b.charAt(j)) return dp[i][j] = 1 + lcs(i+1, j+1, a, b, dp);
        else return dp[i][j] = Math.max(lcs(i+1, j, a, b, dp), lcs(i, j+1, a, b, dp));
    }*/

    // MEMOIZATION ULTA - better for tabulation conversion
    public static int longestCommonSubsequence(String a, String b) {
        int al = a.length(), bl = b.length();

        // i -> 0 to al | j -> 0 to bl
        // int[][] dp = new int[al][bl];
        // for(int[] row: dp) Arrays.fill(row, -1);
        // return lcs(al-1, bl-1, a, b, dp);

        // or better
        // i -> 0 to al | j -> 0 to bl
        int[][] dp = new int[al+1][bl+1];
        for(int[] row: dp) Arrays.fill(row, -1);
        return lcs(al, bl, a, b, dp);
    }

    // private static int lcs(int i, int j, String a, String b, int[][] dp) { // i -> 1st Str, j -> 2nd str
    //     if(i < 0 || j < 0) return 0;

    //     if(dp[i][j] != -1) return dp[i][j];

    //     if(a.charAt(i) == b.charAt(j)) return dp[i][j] = 1 + lcs(i-1, j-1, a, b, dp);
    //     else return dp[i][j] = Math.max(lcs(i-1, j, a, b, dp), lcs(i, j-1, a, b, dp));
    // }

    // or
    private static int lcs(int i, int j, String a, String b, int[][] dp) { // i -> 1st Str, j -> 2nd str
        if(i == 0 || j == 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(a.charAt(i-1) == b.charAt(j-1)) return dp[i][j] = 1 + lcs(i-1, j-1, a, b, dp);
        else return dp[i][j] = Math.max(lcs(i-1, j, a, b, dp), lcs(i, j-1, a, b, dp));
    }

    public static void main(String[] args) {

        System.out.println(longestCommonSubsequence(
                "abcde", "ace"
        )); // Expected: 3

        System.out.println(longestCommonSubsequence(
                "abc", "abc"
        )); // Expected: 3

        System.out.println(longestCommonSubsequence(
                "abc", "def"
        )); // Expected: 0

        System.out.println(longestCommonSubsequence(
                "bl", "yby"
        )); // Expected: 1

        System.out.println(longestCommonSubsequence(
                "oxcpqrsvwf", "shmtulqrypy"
        )); // Expected: 2
    }
}
