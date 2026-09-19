package DynamicProgramming.Memoization;

import java.util.Arrays;

public class LongestPalindromicSubseqLCS {
    // reverse the string
    public static String reverse(String s){
        StringBuilder sb = new StringBuilder(s);
        int i = 0, j = sb.length()-1;
        while (i < j){
            char ch = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, ch);
            i++; j--;
        }

        return sb.toString();
    }

    // BASIC RECURSION
    /*public static int longestPalindromeSubseq(String s) {
        String t = reverse(s);
        return lcs(0, 0, s, t);
    }

    private static int lcs(int i, int j, String s, String t) {
        if(i == s.length() || j == t.length()) return 0;

        if(s.charAt(i) == t.charAt(j)) return 1 + lcs(i+1, j+1, s, t);
        else return Math.max(lcs(i+1, j, s, t), lcs(i, j+1, s, t));
    }*/

    // MEMOIZATION SIDHA
    /*public static int longestPalindromeSubseq(String s) {
        String t = reverse(s);
        int sl = s.length(), tl = t.length();

        int[][] dp = new int[sl][tl];
        for(int[] row: dp) Arrays.fill(row, -1);

        return lcs(0, 0, s, t, dp);
    }

    private static int lcs(int i, int j, String s, String t, int[][] dp) {
        if(i == s.length() || j == t.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == t.charAt(j)) return dp[i][j] = 1 + lcs(i+1, j+1, s, t, dp);
        else return dp[i][j] = Math.max(lcs(i+1, j, s, t, dp), lcs(i, j+1, s, t, dp));
    }*/

    // MEMOIZATION ULTA - better for tabulation conversion.
    public static int longestPalindromeSubseq(String s) {
        String t = reverse(s);
        int sl = s.length(), tl = t.length();

        int[][] dp = new int[sl+1][tl+1];
        for(int[] row: dp) Arrays.fill(row, -1);

        return lcs(sl, tl, s, t, dp);
    }

    private static int lcs(int i, int j, String s, String t, int[][] dp) {
        if(i == 0 || j == 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i-1) == t.charAt(j-1)) return dp[i][j] = 1 + lcs(i-1, j-1, s, t, dp);
        else return dp[i][j] = Math.max(lcs(i-1, j, s, t, dp), lcs(i, j-1, s, t, dp));
    }

    public static void main(String[] args) {

        System.out.println(longestPalindromeSubseq("bbbab")); // Expected: 4
        System.out.println(longestPalindromeSubseq("cbbd"));  // Expected: 2
        System.out.println(longestPalindromeSubseq("a"));     // Expected: 1
        System.out.println(longestPalindromeSubseq("abc"));   // Expected: 1
        System.out.println(longestPalindromeSubseq("racecar")); // Expected: 7
    }
}
