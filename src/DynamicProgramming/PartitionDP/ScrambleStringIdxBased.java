package DynamicProgramming.PartitionDP;

import java.util.Arrays;

public class ScrambleStringIdxBased {
    // BASIC RECURSION
    /*public static boolean isScramble(String s1, String s2) {
        return solve(0, 0, s1, s2, s1.length());
    }

    public static boolean solve(int i1, int i2, String s1, String s2, int len){
        if(s1.substring(i1, i1+len).equals(s2.substring(i2, i2+len))) return true;

        for(int k=1; k<len; k++){
            boolean swap = solve(i1, i2+len-k, s1, s2, k)
                    && solve(i1+k, i2, s1, s2, len-k);
            if(swap) return true;

            boolean notSwap = solve(i1, i2, s1, s2, k)
                    && solve(i1+k, i2+k, s1, s2, len-k);
            if(notSwap) return true;
        }

        return false;
    }*/

    // MEMOIZATION
    public static boolean isScramble(String s1, String s2) {
        int n = s1.length();

        // 3 varying states i1, i2, len
        int[][][] dp = new int[n][n][n+1];
        for (int[][] plane : dp)
            for (int[] row : plane)
                Arrays.fill(row, -1);
        // -1 -> unsolved, 1 -> true, 0 -> false

        return solve(0, 0, s1, s2, n, dp);
    }

    public static boolean solve(int i1, int i2, String s1, String s2, int len, int[][][] dp){
        if(s1.substring(i1, i1+len).equals(s2.substring(i2, i2+len))) return true;

        if (dp[i1][i2][len] != -1) return dp[i1][i2][len] == 1;

        int ans = 0; // easy rahega
        for(int k=1; k<len; k++){
            boolean swap = solve(i1, i2+len-k, s1, s2, k, dp)
                    && solve(i1+k, i2, s1, s2, len-k, dp);
            if(swap){
                ans = 1;
                break;
            }

            boolean notSwap = solve(i1, i2, s1, s2, k, dp)
                    && solve(i1+k, i2+k, s1, s2, len-k, dp);
            if(notSwap){
                ans = 1;
                break;
            }
        }

        dp[i1][i2][len] = ans;
        return ans == 1;
    }

    public static void main(String[] args) {

        String s1 = "great";
        String s2 = "rgeat";
        System.out.println(isScramble(s1, s2)); // Expected: true

        String s3 = "abcde";
        String s4 = "caebd";
        System.out.println(isScramble(s3, s4)); // Expected: false

        String s5 = "a";
        String s6 = "a";
        System.out.println(isScramble(s5, s6)); // Expected: true

        String s7 = "abc";
        String s8 = "bca";
        System.out.println(isScramble(s7, s8)); // Expected: true
    }
}