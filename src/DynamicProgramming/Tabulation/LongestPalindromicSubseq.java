package DynamicProgramming.Tabulation;

public class LongestPalindromicSubseq {
    // WITHOUT SPACE OPTIMIZATION
    public static int longestPalindromeSubseq(String s) {
        int n = s.length();

        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++) dp[i][i] = 1;

        for(int i=n-2; i>=0; i--) { // i+1 wale ka jarurat pahle hai so ulta loop
            for (int j=i+1; j<n; j++) { // if i>j return 0, so start from j=i+1
                // & j-1 is needed later, so sidha loop
                if(s.charAt(i) == s.charAt(j)) dp[i][j] = 2 + dp[i+1][j-1];
                else dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }

        return dp[0][n-1];
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab")); // Expected: 4
        System.out.println(longestPalindromeSubseq("cbbd"));  // Expected: 2
        System.out.println(longestPalindromeSubseq("a"));     // Expected: 1
        System.out.println(longestPalindromeSubseq("abc"));   // Expected: 1
        System.out.println(longestPalindromeSubseq("racecar")); // Expected: 7
    }
}
