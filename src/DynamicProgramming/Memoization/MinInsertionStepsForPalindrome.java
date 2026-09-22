package DynamicProgramming.Memoization;

import java.util.Arrays;

public class MinInsertionStepsForPalindrome {
    // BASIC RECURSION
    /*public static int minInsertions(String s) {
        // JO ALREADY PALINDROME HAI US SAB KO WAISE HI RAHNE DENGE
        // BAKI KO PALINDROME BANANA HOGA, SO BAKI STRING KA REVERSE ADD KARNA HOGA
        // SO TOTAL LENGTH ME SE LONGEST PALINDROME KA LENGTH GHATA DO, THAT WILL BE ANSWER
        return s.length() - lps(0, s.length()-1, s);
    }

    public static int lps(int i, int j, String s){
        if(i > j) return 0; // khatam
        if(i == j) return 1; // ek letter ka

        // aage pichhe same -- to 2 letter ka palindromic seq.
        if(s.charAt(i) == s.charAt(j)) return 2 + lps(i+1, j-1, s);
        else return Math.max(lps(i+1, j, s), lps(i, j-1, s));
    }*/

    // MEMOIZATION
    public static int minInsertions(String s) {
        int n = s.length();

        // i -> 0 to n-1 | j -> 0 to n-1
        int[][] dp = new int[n][n];
        for(int[] row: dp) Arrays.fill(row, -1);

        return s.length() - lps(0, s.length()-1, s, dp);
    }

    public static int lps(int i, int j, String s, int[][] dp){
        if(i > j) return 0; // khatam
        if(i == j) return 1; // ek letter ka

        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == s.charAt(j)) return dp[i][j] = 2 + lps(i+1, j-1, s, dp);
        else return dp[i][j] = Math.max(lps(i+1, j, s, dp), lps(i, j-1, s, dp));
    }

    public static void main(String[] args) {

        System.out.println(minInsertions("zzazz"));      // Expected: 0
        System.out.println(minInsertions("mbadm"));      // Expected: 2
        System.out.println(minInsertions("leetcode"));   // Expected: 5
        System.out.println(minInsertions("g"));          // Expected: 0
        System.out.println(minInsertions("no"));         // Expected: 1
        System.out.println(minInsertions("race"));       // Expected: 3
        System.out.println(minInsertions("abcda"));      // Expected: 2
    }
}