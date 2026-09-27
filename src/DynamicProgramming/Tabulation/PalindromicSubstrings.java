package DynamicProgramming.Tabulation;

public class PalindromicSubstrings {
    // NORMAL BOTTOM UP
    /*public static int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        // i -> 0 - n-1 | j -> 0 - n-1
        boolean[][] dp = new boolean[n][n];

        for(int l=1; l<=n; l++){
            for(int i=0; i+l-1<n; i++){
                int j = i+l-1;

                if(i == j) dp[i][j] = true; // 1 length ka string
                else if(i+1 == j) dp[i][j] = (s.charAt(i) == s.charAt(j)); // 2 length ka string
                else dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]); // genric case

                if(dp[i][j]) count++;
            }
        }

        return count;
    }*/

    // SMART WAY
    public static int count;
    public static int countSubstrings(String s) {
        int n = s.length();
        count = 0;
        for(int i=0; i<n; i++){
            isPal(i, i, s, n); // odd length palindrome
            isPal(i, i+1, s, n); // even length palindrome
        }

        return count;
    }

    private static void isPal(int i, int j, String s, int n) {
        while(i >= 0 && j < n && s.charAt(i) == s.charAt(j)){
            count++;
            i--;
            j++;
        }
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