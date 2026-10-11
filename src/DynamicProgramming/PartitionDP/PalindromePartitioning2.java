package DynamicProgramming.PartitionDP;

import java.util.Arrays;

public class PalindromePartitioning2 {
    // BASIC RECURSION
    /*public static int minCut(String s) {
        int n = s.length();
        return cuts(0, n-1, s);
    }

    private static int cuts(int i, int j, String s) {
        if(isPal(s, i, j)) return 0;

        int minCuts = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++){
            int temp = 1 + cuts(i, k, s) + cuts(k+1, j, s);
            minCuts = Math.min(minCuts, temp);
        }

        return minCuts;
    }*/

    // MEMOIZATION - Leetcode pe ye v TLE de dega
    public static int minCut(String s) {
        int n = s.length();

        // i -> 0 - n-1 | j -> n-1 - 0
        int[][] dp = new int[n][n];
        for(int[] row: dp) Arrays.fill(row, -1);

        return cuts(0, n-1, s, dp);
    }

    private static int cuts(int i, int j, String s, int[][] dp) {
        if(isPal(s, i, j)) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        int minCuts = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++){
            int temp = 1 + cuts(i, k, s, dp) + cuts(k+1, j, s, dp);
            minCuts = Math.min(minCuts, temp);
        }

        return dp[i][j] = minCuts;
    }

    private static boolean isPal(String s, int i, int j) {
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {

        String s1 = "aab";
        System.out.println(minCut(s1)); // Expected: 1

        String s2 = "a";
        System.out.println(minCut(s2)); // Expected: 0

        String s3 = "ab";
        System.out.println(minCut(s3)); // Expected: 1

        String s4 = "aabaa";
        System.out.println(minCut(s4)); // Expected: 0

        String s5 = "abcde";
        System.out.println(minCut(s5)); // Expected: 4
    }
}