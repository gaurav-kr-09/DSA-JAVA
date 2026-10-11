package DynamicProgramming.PartitionDP;

public class PalindromePartitioning2StdTabulation {
    public static int minCut(String s) {
        int n = s.length();

        // Making and filling isPal table
        boolean[][] isPal = new boolean[n][n];

        // WAY - 1
        /*for(int i=n-1; i>=0; i--){ // isPal[i+1][j-1]) isme niche wale row ka val pahle chahiye so ulta loop
            for(int j=i; j<n; j++){
                char ich = s.charAt(i);
                char jch = s.charAt(j);

                if(j-i == 0) isPal[i][j] = true; // 1 len
                else if(j-i == 1) isPal[i][j] = (ich == jch); // 2 len
                else isPal[i][j] = (ich == jch && isPal[i+1][j-1]); // > 2 len
            }
        }*/

        // WAY - 2
        /*for(int i=n-1; i>=0; i--){ // isPal[i+1][j-1]) isme niche wale row ka val pahle chahiye so ulta loop
            for(int j=i; j<n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i <= 2) isPal[i][j] = true; // 1, 2, 3 len
                    else isPal[i][j] = isPal[i+1][j-1];
                }
            }
        }*/

        // WAY - 3, length vary karke sare length ka pal check karo
        for(int i=0; i<n; i++) isPal[i][i] = true; // 1 length ka
        for(int L=2; L<=n; L++){
            for(int i=0; i<n-L+1; i++){ // i<n-L+1 kyuki j valid v to hona chahiye
                int j = i+L-1;

                char ich = s.charAt(i);
                char jch = s.charAt(j);

                if(L == 2) isPal[i][j] = (ich == jch); // 2 length ka
                else isPal[i][j] = (ich == jch && isPal[i+1][j-1]);
            }
        }

        // finding minimum cuts
        int[] dp = new int[n]; // dp[i] = min cuts req to split s[0..i]
        for(int i=0; i<n; i++){
            if(isPal[0][i]) dp[i] = 0; // no cuts required
            else{
                // har jagah cut marna parega
                dp[i] = Integer.MAX_VALUE;
                for(int k=0; k<=i-1; k++){
                    if(isPal[k+1][i] && 1 + dp[k] < dp[i])
                        dp[i] = 1 + dp[k];
                }
            }
        }

        return dp[n-1];
    }

    public static void main(String[] args) {

        String s1 = "aab";
        System.out.println(minCut(s1)); // Expected: 1

        String s2 = "a";
        System.out.println(minCut(s2)); // Expected: 0

        String s3 = "ab";
        System.out.println(minCut(s3)); // Expected: 1

        String s4 = "aabaa";
        System.out.println(minCut(s4)); // Expected: 0

        String s5 = "abcde";
        System.out.println(minCut(s5)); // Expected: 4
    }
}