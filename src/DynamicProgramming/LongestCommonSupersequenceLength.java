package DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSupersequenceLength {
    public static int longestCommonSupersequence(String a, String b) {
        int al = a.length(), bl = b.length();

        int[][] dp = new int[al][bl];
        for(int[] row: dp) Arrays.fill(row, -1);

        return a.length() + b.length() - 2 * lcs(0, 0, a, b, dp);
    }

    private static int lcs(int i, int j, String a, String b, int[][] dp) { // i -> 1st Str, j -> 2nd str
        if(i == a.length() || j == b.length()) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(a.charAt(i) == b.charAt(j)) return dp[i][j] = 1 + lcs(i+1, j+1, a, b, dp);
        else return dp[i][j] = Math.max(lcs(i+1, j, a, b, dp), lcs(i, j+1, a, b, dp));
    }

    public static void main(String[] args) {

        // Test Case 1
        String a = "abac";
        String b = "cab";
        System.out.println(longestCommonSupersequence(a, b));
        // Expected: 5

        // Test Case 2
        a = "abc";
        b = "abc";
        System.out.println(longestCommonSupersequence(a, b));
        // Expected: 3

        // Test Case 3
        a = "abc";
        b = "def";
        System.out.println(longestCommonSupersequence(a, b));
        // Expected: 6

        // Test Case 4
        a = "geek";
        b = "eke";
        System.out.println(longestCommonSupersequence(a, b));
        // Expected: 5

        // Test Case 5
        a = "";
        b = "abc";
        System.out.println(longestCommonSupersequence(a, b));
        // Expected: 3
    }
}