package DynamicProgramming;

public class LongestPalindromicSubstring {
    // Normal bottom up
    /*public static String longestPalindrome(String s) {
        int n = s.length();

        int st = 0, end = 0, len = 0;
        boolean[][] dp = new boolean[n][n];
        for(int l=1; l<=n; l++){
            for(int i=0; i+l-1<n; i++){
                int j = i+l-1;
                if(i == j) dp[i][j] = true;
                else if(i+1 == j) dp[i][j] = (s.charAt(i) == s.charAt(j));
                else dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]);

                if(dp[i][j] && j-i+1 > len) {
                    len = j-i+1;
                    st = i;
                    end = j;
                }
            }
        }

        return s.substring(st, end+1);
    }*/

    // SMART TARIKA
    public static String longestPalindrome(String s) {
        int st = 0, end = 0;
        for(int i=0; i<s.length(); i++){
            int l1 = lenOfPal(i, i, s); // odd length palindrome
            int l2 = lenOfPal(i, i+1, s); // even length palindrome
            int len = Math.max(l1, l2);

            if(len > end-st){
                st = i - (len-1)/2;
                end = i + len/2;
            }
        }

        return s.substring(st, end+1);
    }

    private static int lenOfPal(int i, int j, String s) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        return j-i-1;
    }

    public static void main(String[] args) {
        // Test Case 1
        String s = "babad";
        System.out.println(longestPalindrome(s));
        // Expected: "bab" or "aba"

        // Test Case 2
        s = "cbbd";
        System.out.println(longestPalindrome(s));
        // Expected: "bb"

        // Test Case 3
        s = "a";
        System.out.println(longestPalindrome(s));
        // Expected: "a"

        // Test Case 4
        s = "ac";
        System.out.println(longestPalindrome(s));
        // Expected: "a" or "c"

        // Test Case 5
        s = "forgeeksskeegfor";
        System.out.println(longestPalindrome(s));
        // Expected: "geeksskeeg"
    }
}
