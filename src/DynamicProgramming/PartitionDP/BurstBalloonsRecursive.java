package DynamicProgramming.PartitionDP;

import java.util.Arrays;

public class BurstBalloonsRecursive {
    // BASIC RECURSION
    /*public static int maxCoins(int[] nums) {
        int n = nums.length;

        int[] arr = new int[n+2];
        arr[0] = arr[n+1] = 1;
        for(int i=1; i<=n; i++) arr[i] = nums[i-1];

        return coinsCount(1, n, arr);
    }

    public static int coinsCount(int i, int j, int[] arr){
        if(i > j) return 0; // subproblem DNE

        int maxCoins = Integer.MIN_VALUE;
        for(int k=i; k<=j; k++){
            int coinsK = arr[i-1] * arr[k] * arr[j+1];
            int tc = coinsCount(i, k-1, arr) + coinsK + coinsCount(k+1, j, arr);
            maxCoins = Math.max(maxCoins, tc);
        }

        return maxCoins;
    }*/

    // MEMOIZATION
    public static int maxCoins(int[] nums) {
        int n = nums.length;

        int[] arr = new int[n+2];
        arr[0] = arr[n+1] = 1;
        for(int i=1; i<=n; i++) arr[i] = nums[i-1];

        // i -> 1 se n | j -> n se 1
        // but nums[n], arr[n+1] pe chala gaya hai
        // star me 1 add karne k bad so take size n+1
        int[][] dp = new int[n+1][n+1];
        for(int[] row: dp) Arrays.fill(row, -1);

        return coinsCount(1, n, arr, dp);
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