package DynamicProgramming;

public class LongestCommonSupersequence {
    // ye to ans hai jab ham lcs alag se construct kar rhe hai and then ans reconstruct kar rhe hai
    /*public static String shortestCommonSupersequence(String a, String b) {
        int al = a.length(), bl = b.length();

        String lcs = LCS(a, b);

        // MAKING SCS
        StringBuilder ans = new StringBuilder();

        int i=0, j=0, k=0;
        while (k < lcs.length()){
            char kch = lcs.charAt(k);
            while(a.charAt(i) != kch){
                ans.append(a.charAt(i));
                i++;
            }
            while(b.charAt(j) != kch){
                ans.append(b.charAt(j));
                j++;
            }
            ans.append(kch);
            i++; j++; k++;
        }

        while (i < al){
            ans.append(a.charAt(i));
            i++;
        }
        while (j < bl){
            ans.append(b.charAt(j));
            j++;
        }

        return ans.toString();
    }

    // Function to Find LCS
    private static String LCS(String a, String b){
        int al = a.length(), bl = b.length();

        // filling the table
        int[][] dp = new int[al+1][bl+1];
        // i = 0 -> 0 | j = 0 -> 0
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

        // return ans;
        return ans.reverse().toString();
    }*/

    // ham chahe to answer reconstruction and lcs reconstruction ko ek me combine kar sakte hai
    public static String shortestCommonSupersequence(String a, String b) {
        int al = a.length(), bl = b.length();

        int[][] dp = new int[al+1][bl+1];
        // i = 0 -> 0 | j = 0 -> 0

        // filling the table
        for(int i=1; i<=al; i++){
            for(int j=1; j<=bl; j++){
                if(a.charAt(i-1) == b.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        StringBuilder scs = new StringBuilder();
        // combining answer and lcs reconstruction
        int i=al, j=bl;
        while (i > 0 && j > 0){
            // same pe diagonal else max
            if(a.charAt(i-1) == b.charAt(j-1)){
                scs.append(a.charAt(i-1));
                i--;
                j--;
            } else if(dp[i-1][j] > dp[i][j-1]){
                scs.append(a.charAt(i-1));
                i--;
            } else {
                scs.append(b.charAt(j-1));
                j--;
            }
        }

        while (i > 0){
            scs.append(a.charAt(i-1));
            i--;
        }
        while (j > 0){
            scs.append(b.charAt(j-1));
            j--;
        }

        return scs.reverse().toString();
    }

    public static void main(String[] args) {
        // Test Case 1
        String str1 = "abac";
        String str2 = "cab";
        System.out.println(shortestCommonSupersequence(str1, str2));
        // Expected: "cabac"

        // Test Case 2
        str1 = "aaaaaaaa";
        str2 = "aaaaaaaa";
        System.out.println(shortestCommonSupersequence(str1, str2));
        // Expected: "aaaaaaaa"

        // Test Case 3
        str1 = "geek";
        str2 = "eke";
        System.out.println(shortestCommonSupersequence(str1, str2));
        // Expected: "geeke" or another valid shortest SCS

        // Test Case 4
        str1 = "abc";
        str2 = "def";
        System.out.println(shortestCommonSupersequence(str1, str2));
        // Expected: any valid SCS of length 6, e.g. "abcdef"

        // Test Case 5
        str1 = "";
        str2 = "abc";
        System.out.println(shortestCommonSupersequence(str1, str2));
        // Expected: "abc"
    }
}