package DynamicProgramming.Memoization;

import java.util.Arrays;

public class HouseRobber {
    // Galat approach
    /*public static int rob(int[] nums) {
        int n = nums.length;

        int osum = 0, esum = 0;
        for(int i=0; i<n; i++){
            if(i % 2 == 1) osum += nums[i];
            else esum += nums[i];
        }

        return Math.max(osum, esum);
    }*/

    // Basic recursion - will give TLE
    /*public static int rob(int[] nums) {
        return amount(nums, 0);
    }

    public static int amount(int[] arr, int i){
        if(i >= arr.length) return 0;

        // Sare element k pas do option ya to lo ya mat lo
        int take = arr[i] + amount(arr, i+2);
        int skip = amount(arr, i+1);

        return Math.max(take, skip);
    }*/

    // Using Memoization
    public static int rob(int[] nums) {
        int n = nums.length;

        // i varies from 0 to n-1
        // dp[i] stores the value of amount(i)
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return amount(nums, 0, dp);
    }

    public static int amount(int[] arr, int i, int[] dp){
        if(i >= arr.length) return 0;

        if(dp[i] != -1) return dp[i];
        int take = arr[i] + amount(arr, i+2, dp);
        int skip = amount(arr, i+1, dp);

        return dp[i] = Math.max(take, skip);
    }

    public static void main(String[] args) {

        System.out.println(rob(new int[]{1, 2, 3, 1}));              // 4

        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));           // 12

        System.out.println(rob(new int[]{2, 1, 1, 2}));              // 4

        System.out.println(rob(new int[]{1, 3, 1, 3, 100}));         // 103

        System.out.println(rob(new int[]{5}));                       // 5

        System.out.println(rob(new int[]{2, 1}));                    // 2

        System.out.println(rob(new int[]{2, 1, 1, 2, 5, 1}));        // 8

        System.out.println(rob(new int[]{6, 6, 4, 8, 4, 3, 3, 10})); // 27
    }
}