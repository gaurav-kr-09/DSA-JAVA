package DynamicProgramming.Tabulation;

public class EditDistance {
    // Tabulation W/o space optimization
    /*public static int minDistance(String w1, String w2) {
        int al = w1.length();
        int bl = w2.length();

        int[][] dp = new int[al + 1][bl + 1];
        for(int i=0; i<=al; i++) dp[i][0] = i; // dusra string ka length 0, means pahla string ka sara char delete karna parega so i steps
        for(int j=0; j<=bl; j++) dp[0][j] = j; // pahla string ka length 0, means second string jitna char insert karna parega so j steps

        for(int i = 1; i <= al; i++) {
            for (int j = 1; j <= bl; j++) {
                if(w1.charAt(i-1) == w2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                // insert | delete | replace
                else dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
            }
        }

        return dp[al][bl];
    }*/

    // Tabulation space optimized
    public static int minDistance(String w1, String w2) {
        int al = w1.length();
        int bl = w2.length();

        int[] dp = new int[bl + 1];
        for(int j = 0; j <=bl; j++) dp[j] = j; // pahle string ka length 0, means pahla string me sara char insert karna parega so i steps

        for(int i = 1; i <= al; i++) {
            int diag = dp[0]; // dp[i-1][j-1]
            dp[0] = i; // since dp[i][0] should be i
            for (int j = 1; j <= bl; j++) {
                int up = dp[j]; // dp[i-1][j]
                if(w1.charAt(i-1) == w2.charAt(j-1)) dp[j] = diag;
                // insert | delete | replace
                else dp[j] = 1 + Math.min(dp[j-1], Math.min(up, diag));
                diag = up;
            }
        }

        return dp[bl];
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