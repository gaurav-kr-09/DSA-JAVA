package DynamicProgramming;

public class PrintingLCS {
    public static String printLCS(String a, String b) {
        int al = a.length(), bl = b.length();

        int[][] dp = new int[al+1][bl+1];

        // FILLING THE TABLE
        // for(int j=0; j<=bl; j++) dp[0][j] = 0;
        // for(int i=0; i<=al; i++) dp[i][0] = 0;
        for(int i=1; i<=al; i++){
            for(int j=1; j<=bl; j++){
                if(a.charAt(i-1) == b.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        // Finding the answer
        StringBuilder ans = new StringBuilder();
        int i=al, j=bl;
        while (i > 0 && j > 0){
            // same pe diagonal else max
            if(a.charAt(i-1) == b.charAt(j-1)){
                ans.append(a.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]) i--;
            else j--;
        }

        // returning the answer
        return ans.reverse().toString();
    }

    public static void main(String[] args) {

        System.out.println(printLCS("abcde", "ace"));       // Expected: "ace"
        System.out.println(printLCS("abc", "abc"));         // Expected: "abc"
        System.out.println(printLCS("abc", "def"));         // Expected: ""
        System.out.println(printLCS("abc", "ac"));          // Expected: "ac"
        System.out.println(printLCS("AGGTAB", "GXTXAYB"));  // Expected: "GTAB"
        System.out.println(printLCS("abcbdab", "bdcaba"));  // Expected: "bcba" / "bdab"
        System.out.println(printLCS("", "abc"));            // Expected: ""
        System.out.println(printLCS("abc", ""));            // Expected: ""
        System.out.println(printLCS("a", "a"));             // Expected: "a"
        System.out.println(printLCS("a", "b"));             // Expected: ""
    }
}