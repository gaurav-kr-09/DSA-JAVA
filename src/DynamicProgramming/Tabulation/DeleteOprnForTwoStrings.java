package DynamicProgramming.Tabulation;

import java.util.Arrays;

public class DeleteOprnForTwoStrings {
    // TABULATION - W/O SPACE OPTIMIZATION
    /*public static int minDistance(String a, String b) {
        int al = a.length(), bl = b.length();

        // i -> 0 to al | j -> 0 to bl
        int[][] dp = new int[al+1][bl+1];
        for(int i=0; i<=bl; i++) dp[0][i] = 0; // a me 0 char hone pe no lcs
        for(int j=0; j<=al; j++) dp[j][0] = 0; // b me 0 char hone pe no lcs

        for(int i=1; i<=al; i++){
            for(int j=1; j<=bl; j++){
                if(a.charAt(i-1) == b.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        int cl =  dp[al][bl];
        return al + bl - 2*cl; // (al - cl) + (bl - cl)
    }*/

    // TABULATION - SPACE OPTIMIZED
    public static int minDistance(String a, String b) {
        int al = a.length(), bl = b.length();

        int[] dp = new int[bl+1];

        for(int i=1; i<=al; i++){
            int diag = dp[0]; // dp[i-1][j-1] = 0
            for(int j=1; j<=bl; j++){
                int up = dp[j]; // dp[i-1][j]
                if(a.charAt(i-1) == b.charAt(j-1)) dp[j] = 1 + diag;
                else dp[j] = Math.max(dp[j], dp[j-1]);

                diag = up;
            }
        }

        int cl =  dp[bl];
        return al + bl - 2*cl; // (al - cl) + (bl - cl)
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