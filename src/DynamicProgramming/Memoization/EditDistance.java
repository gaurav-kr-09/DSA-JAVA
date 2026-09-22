package DynamicProgramming.Memoization;

import java.util.Arrays;

public class EditDistance {
    // BASIC RECURSION
    /*public static int al, bl;
    public static int minDistance(String word1, String word2) {
        al = word1.length();
        bl = word2.length();
        return minSteps(0, 0, word1, word2);
    }

    public static int minSteps(int i, int j, String a, String b){
        if(i == al) return bl-j; // itna char insert karna parega a me
        if(j == bl) return al-i; // itna char delete karna parega a se

        if(a.charAt(i) == b.charAt(j)) return minSteps(i+1, j+1, a, b);
        else {
            int ins = minSteps(i, j+1, a, b);
            int del = minSteps(i+1, j, a, b);
            int rep = minSteps(i+1, j+1, a, b);

            return 1 + Math.min(ins, Math.min(del, rep));
        }
    }*/

    // MEMOIZATION - SIDHA
    /*public static int al, bl;
    public static int minDistance(String word1, String word2) {
        al = word1.length();
        bl = word2.length();

        // i -> 0 to al-1 | j -> 0 to bl-1
        int[][] dp = new int[al][bl];
        for(int[] row: dp) Arrays.fill(row, -1);

        return minSteps(0, 0, word1, word2, dp);
    }

    public static int minSteps(int i, int j, String a, String b, int[][] dp){
        if(i == al) return bl-j; // itna char insert karna parega a me
        if(j == bl) return al-i; // itna char delete karna parega a se

        if(dp[i][j] != -1) return dp[i][j];

        if(a.charAt(i) == b.charAt(j)) return dp[i][j] = minSteps(i+1, j+1, a, b, dp);
        else {
            int ins = minSteps(i, j+1, a, b, dp);
            int del = minSteps(i+1, j, a, b, dp);
            int rep = minSteps(i+1, j+1, a, b, dp);

            return dp[i][j] = 1 + Math.min(ins, Math.min(del, rep));
        }
    }*/

    // MEMOIZATION ULTA - Better for tabulation conversion
    public static int minDistance(String word1, String word2) {
        int al = word1.length();
        int bl = word2.length();

        int[][] dp = new int[al + 1][bl + 1];
        for(int[] row : dp) Arrays.fill(row, -1);

        return minSteps(al, bl, word1, word2, dp);
    }

    public static int minSteps(int i, int j, String a, String b, int[][] dp){
        if(i == 0) return j; // itna char insert karna parega a me
        if(j == 0) return i; // itna char delete karna parega a se

        if(dp[i][j] != -1) return dp[i][j];

        if(a.charAt(i-1) == b.charAt(j-1)) return dp[i][j] = minSteps(i-1, j-1, a, b, dp);
        else {
            int ins = minSteps(i, j-1, a, b, dp);
            int del = minSteps(i-1, j, a, b, dp);
            int rep = minSteps(i-1, j-1, a, b, dp);

            return dp[i][j] = 1 + Math.min(ins, Math.min(del, rep));
        }
    }

    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));       // Expected: 3
        System.out.println(minDistance("intention", "execution")); // Expected: 5
        System.out.println(minDistance("abc", "abc"));         // Expected: 0
        System.out.println(minDistance("abc", "def"));         // Expected: 3
        System.out.println(minDistance("", "abc"));            // Expected: 3
        System.out.println(minDistance("abc", ""));            // Expected: 3
        System.out.println(minDistance("a", "b"));             // Expected: 1
        System.out.println(minDistance("abc", "ac"));          // Expected: 1
        System.out.println(minDistance("kitten", "sitting"));  // Expected: 3
    }
}