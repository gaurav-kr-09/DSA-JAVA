package DynamicProgramming.PartitionDP;

public class BurstBalloonsBottomUP {
    // Converted to tabulation
    public static int maxCoins(int[] nums) {
        int n = nums.length;

        int[] arr = new int[n+2];
        arr[0] = arr[n+1] = 1;
        for(int i=1; i<=n; i++) arr[i] = nums[i-1];

        // agar dp ka size n+1 lenge and jab, coinsK = arr([i-1]*[k]*[j+1]) ye kar rhe hai
        // and j<=n ho rha hai to j+1 bahar chala jayega n+1 ke, so take n+2 as dp ka size
        int[][] dp = new int[n+2][n+2];

        // niche wale row ka and curr me left ka value pahle chahiye
        // so bahar wala loop ulta and andar wala sidha chalega
        for(int i=n; i>=1; i--){
            for(int j=i; j<=n; j++){ // since j should be >= i

                dp[i][j] = Integer.MIN_VALUE;
                for(int k=i; k<=j; k++){
                    int coinsK = arr[i-1] * arr[k] * arr[j+1];
                    int tc = dp[i][k-1] + coinsK + dp[k+1][j]; // cc(i, k-1) + cc(k+1, j);
                    dp[i][j] = Math.max(dp[i][j], tc);
                }
            }
        }

        return dp[1][n];
    }

    public static int coinsCount(int i, int j, int[] arr, int[][] dp){
        if(i > j) return 0; // subproblem DNE

        if(dp[i][j] != -1) return dp[i][j];

        int maxCoins = Integer.MIN_VALUE;
        for(int k=i; k<=j; k++){
            int coinsK = arr[i-1] * arr[k] * arr[j+1];
            int tc = coinsCount(i, k-1, arr, dp) + coinsK + coinsCount(k+1, j, arr, dp);
            maxCoins = Math.max(maxCoins, tc);
        }

        return dp[i][j] = maxCoins;
    }

    public static void main(String[] args) {

        int[] nums1 = {3, 1, 5, 8};
        System.out.println(maxCoins(nums1)); // Expected: 167

        int[] nums2 = {1, 5};
        System.out.println(maxCoins(nums2)); // Expected: 10

        int[] nums3 = {3};
        System.out.println(maxCoins(nums3)); // Expected: 3

        int[] nums4 = {1, 1, 1};
        System.out.println(maxCoins(nums4)); // Expected: 3
    }
}