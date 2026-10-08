package DynamicProgramming.PartitionDP;

public class MCMTabulationConversion {
    public static int MCM(int[] arr) {
        int n = arr.length;

        // i -> 0 - n-2 | j -> n-2 - 0
        int[][] dp = new int[n-1][n-1];

        // METHOD 1
        /*
        for(int i=n-2; i>=0; i--){ // i ulta kyuki niche wale row ka val pahle chahiye ie dp[k+1][j]
            for(int j=0; j<=n-2; j++){ // j sidha kyuki left ka val pahle chahiye ie dp[i][k]
                // base case -> if i=j means 1 hi matrix hai so cost 0 and
                // i > j means subproblem DNE so cost = 0, jo java me by default hota hai
                if(i >= j){
                    dp[i][j] = 0;
                    continue;
                }

                dp[i][j] = Integer.MAX_VALUE; // kyuki jab min lenge to 0 (by default wala) na aa jaye
                for(int k=i; k<j; k++){
                    int C = arr[i] * arr[k+1] * arr[j+1];
                    int tc = dp[i][k] + dp[k+1][j] + C; // cost(i, k, arr, dp) + cost(k+1, j, arr, dp) + C
                    dp[i][j] = Math.min(dp[i][j], tc);
                }
            }
        }

        return dp[0][n-2]; // kyuki
        // recursion me answer tha cost(0, n-2, arr)
        // last calculated cell to yahi hai and loop v yahi khatam ho rha hai
        */

        // METHOD 2 - BUT EK OR OPTIMIZATION POSSIBLE HAI
        // loop k andar ham check kar rhe hai if (i >= j) and then 0 fill karke
        // aage nahi badh rhe hai usse achha j ko i+1 se hi start kade to aur achha
        for(int i=n-2; i>=0; i--){
            for(int j=i+1; j<=n-2; j++){

                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i; k<j; k++){
                    int C = arr[i] * arr[k+1] * arr[j+1];
                    int tc = dp[i][k] + dp[k+1][j] + C; // cost(i, k, arr, dp) + cost(k+1, j, arr, dp)
                    dp[i][j] = Math.min(dp[i][j], tc);
                }
            }
        }

        return dp[0][n-2];
    }

    private static int cost(int i, int j, int[] arr, int[][] dp) {
        if(i == j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int minCost = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int C = arr[i] * arr[k+1] * arr[j+1];
            int totalCost = cost(i, k, arr, dp) + cost(k+1, j, arr, dp) + C;
            minCost = Math.min(minCost, totalCost);
        }

        return dp[i][j] = minCost;
    }

    public static void main(String[] args) {

        int[] arr1 = {40, 20, 30, 10, 30};
        System.out.println(MCM(arr1)); // 26000

        int[] arr2 = {10, 20, 30, 40, 30};
        System.out.println(MCM(arr2)); // 30000

        int[] arr3 = {10, 20, 30};
        System.out.println(MCM(arr3)); // 6000

        int[] arr4 = {10, 20, 30, 40, 50};
        System.out.println(MCM(arr4)); // 38000

        int[] arr5 = {10, 20};
        System.out.println(MCM(arr5)); // 0

        int[] arr6 = {5, 10, 3, 12, 5, 50, 6};
        System.out.println(MCM(arr6)); // 2010
    }
}