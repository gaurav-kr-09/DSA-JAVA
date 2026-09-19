package DynamicProgramming.Tabulation;

public class LongestCmnSubseq {
    // WITHOUT SPACE OPTIMIZATION
    /*public static int longestCommonSubsequence(String a, String b) {
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

        return dp[al][bl];
    }*/

    // SPACE OPTIMIZED
    public static int longestCommonSubsequence(String a, String b) {
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

        return dp[bl];
    }

    private static int lcs(int i, int j, String a, String b, int[][] dp) { // i -> 1st Str, j -> 2nd str
        if(i == a.length() || j == b.length()) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(a.charAt(i) == b.charAt(j)) return dp[i][j] = 1 + lcs(i+1, j+1, a, b, dp);
        else return dp[i][j] = Math.max(lcs(i+1, j, a, b, dp), lcs(i, j+1, a, b, dp));
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
