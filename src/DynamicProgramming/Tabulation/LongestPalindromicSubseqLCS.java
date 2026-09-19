package DynamicProgramming.Tabulation;

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

    // WITHOUT SPACE OPTIMIZATION
    /*public static int longestPalindromeSubseq(String s) {
        String t = reverse(s);
        int sl = s.length();

        int[][] dp = new int[sl+1][sl+1];
        for(int i=0; i<=sl; i++) dp[0][i] = 0; // a me 0 char hone pe no lcs
        for(int j=0; j<=sl; j++) dp[j][0] = 0; // b me 0 char hone pe no lcs

        for(int i=1; i<=sl; i++){
            for(int j=1; j<=sl; j++){
                if(s.charAt(i-1) == t.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[sl][sl];
    }*/

    // SPACE OPTIMIZED
    public static int longestPalindromeSubseq(String s) {
        String t = reverse(s);
        int sl = s.length();

        int[] dp = new int[sl+1];

        for(int i=1; i<=sl; i++){
            int diag = dp[0]; // dp[i-1][j-1] = 0
            for(int j=1; j<=sl; j++){
                int up = dp[j]; // dp[i-1][j]
                if(s.charAt(i-1) == t.charAt(j-1)) dp[j] = 1 + diag;
                else dp[j] = Math.max(dp[j], dp[j-1]);

                diag = up;
            }
        }

        return dp[sl];
    }

    public static void main(String[] args) {

        System.out.println(longestPalindromeSubseq("bbbab")); // Expected: 4
        System.out.println(longestPalindromeSubseq("cbbd"));  // Expected: 2
        System.out.println(longestPalindromeSubseq("a"));     // Expected: 1
        System.out.println(longestPalindromeSubseq("abc"));   // Expected: 1
        System.out.println(longestPalindromeSubseq("racecar")); // Expected: 7
    }
}
