package DynamicProgramming.TreeDP;

public class UniqueBST {
    // Pure recursion
    /*public static int numTrees(int n) {
        if(n <= 1) return 1;

        int ans = 0;

        for(int c=1; c<=n; c++){ // sabko centre banaye bari bai se
            ans += (numTrees(c-1) * numTrees(n-c));
        }

        return ans;
    }*/

    // memoization
    /*public static int numTrees(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return countTrees(n, dp);
    }

    public static int countTrees(int n, int[] dp){
        if(n <= 1) return 1;

        if(dp[n] != -1) return dp[n];

        int temp = 0;
        for(int c=1; c<=n; c++){ // sabko centre banaye bari bai se
            temp += (countTrees(c-1, dp) * countTrees(n-c, dp));
        }

        return dp[n] = temp;
    }*/

    // jo samjhe the uske a/c answer
    /*public static int numTrees(int n) {
        if(n <= 1) return 1;

        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=n; i++){ // jiske liye answer nikalna hai uska loop
            for(int c=1; c<=i; c++){ // sabko bari bari se centre bana rhe hai
                dp[i] += (dp[c-1] * dp[i-c]); // left wala * right wale ka sum
            }
        }

        return dp[n];
    }*/

    // slightly better - same chiz
    /*public static int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;

        for(int i=1; i<=n; i++){ // jiske liye answer nikalna hai uska loop
            for(int c=1; c<=i; c++){ // sabko bari bari se centre bana rhe hai
                dp[i] += (dp[c-1] * dp[i-c]); // left wala * right wale ka sum
            }
        }

        return dp[n];
    }*/

    // catalan series ka observation based
    /*public static int numTrees(int n) {
        int up = 2, bottom = 2;

        long ans = 1;
        for(int i=1; i<=n; i++){
            ans = ans * up /bottom;

            up += 4;
            bottom += 1;
        }

        return (int)ans;
    }*/

    // better observation
    public static int numTrees(int n) {
        long ans = 1;
        for(int i=1; i<=n; i++){
            ans = ans * 2 * (2L*i - 1) / (i+1);
        }

        return (int)ans;
    }

    public static void main(String[] args) {
        System.out.println(numTrees(1)); // Expected: 1
        System.out.println(numTrees(2)); // Expected: 2
        System.out.println(numTrees(3)); // Expected: 5
        System.out.println(numTrees(4)); // Expected: 14
        System.out.println(numTrees(5)); // Expected: 42
        System.out.println(numTrees(6)); // Expected: 132
    }
}