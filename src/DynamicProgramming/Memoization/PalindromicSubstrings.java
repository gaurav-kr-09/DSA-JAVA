package DynamicProgramming.Memoization;

import java.util.Arrays;

public class PalindromicSubstrings {
    // BASIC RECURSION
    /*public static int countSubstrings(String s) {
        int count = 0;

        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                if(isPal(s, i, j)) count++;
            }
        }

        return count;
    }

    // recursive palindrome check
    public static boolean isPal(String s, int i, int j){
        if(i >= j) return true;
        if(s.charAt(i) == s.charAt(j)) return isPal(s, i+1, j-1);
        return false;
    }*/

    // MEMOIZATION
    public static int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        // i -> 0 - n-1 | j -> 0 - n-1
        int[][] dp = new int[n][n];
        for(int[] row: dp) Arrays.fill(row, -1);
        // 1 mean true, 0 means false, -1 means not solved

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(isPal(s, i, j, dp) == 1) count++;
            }
        }

        return count;
    }

    public static int isPal(String s, int i, int j, int[][] dp){
        if(i >= j) return 1;

        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == s.charAt(j)) return dp[i][j] = isPal(s, i+1, j-1, dp);
        return dp[i][j] = 0;
    }

    public static void main(String[] args) {
        // Test Case 1
        String s = "abc";
        System.out.println(countSubstrings(s));
        // Expected: 3

        // Test Case 2
        s = "aaa";
        System.out.println(countSubstrings(s));
        // Expected: 6

        // Test Case 3
        s = "aba";
        System.out.println(countSubstrings(s));
        // Expected: 4

        // Test Case 4
        s = "racecar";
        System.out.println(countSubstrings(s));
        // Expected: 10

        // Test Case 5
        s = "a";
        System.out.println(countSubstrings(s));
        // Expected: 1
    }
}