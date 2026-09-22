package DynamicProgramming.Tabulation;

public class MinInsertionStepsForPalindrome {
    public static int minInsertions(String s) {
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

        return n - dp[0][n-1];
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