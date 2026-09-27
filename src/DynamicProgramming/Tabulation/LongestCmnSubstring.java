package DynamicProgramming.Tabulation;

public class LongestCmnSubstring {
    // TABULATION - W/O space optimization
    /*public static int longestCommonSubstring(String a, String b) {
        int al = a.length(), bl = b.length();

        int[][] dp = new int[al+1][bl+1];
        // i = 0 -> 0 | j = 0 -> 0
        int max = 0; // kam se kam 0 length ka LCSubstr hoga hi

        for(int i=1; i<=al; i++){
            for(int j=1; j<=bl; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    max = Math.max(max, dp[i][j]);
                }
                else dp[i][j] = 0;
            }
        }

        return max;
    }*/

    // TABULATION - space optimized
    public static int longestCommonSubstring(String a, String b) {
        int al = a.length(), bl = b.length();

        int[] dp = new int[bl+1];
        // i = 0 -> 0 | j = 0 -> 0
        int max = 0; // kam se kam 0 length ka LCSubstr hoga hi

        for(int i=1; i<=al; i++){
            int diag = dp[0];
            for(int j=1; j<=bl; j++){
                int up = dp[j];
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[j] = 1 + diag;
                    max = Math.max(max, dp[j]);
                }
                else dp[j] = 0;

                diag = up;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        // Test Case 1
        String s1 = "abcde";
        String s2 = "abfce";
        System.out.println(longestCommonSubstring(s1, s2));
        // Expected: 2

        // Test Case 2
        s1 = "abcdxyz";
        s2 = "xyzabcd";
        System.out.println(longestCommonSubstring(s1, s2));
        // Expected: 4

        // Test Case 3
        s1 = "zxabcdezy";
        s2 = "yzabcdezx";
        System.out.println(longestCommonSubstring(s1, s2));
        // Expected: 6

        // Test Case 4
        s1 = "abc";
        s2 = "def";
        System.out.println(longestCommonSubstring(s1, s2));
        // Expected: 0

        // Test Case 5
        s1 = "aaaa";
        s2 = "aa";
        System.out.println(longestCommonSubstring(s1, s2));
        // Expected: 2
    }
}