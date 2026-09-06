package DynamicProgramming.Memoization;

import java.util.Arrays;

public class TargetSumLC494 {
    // BASIC RECURSION
    /*public static int findTargetSumWays(int[] nums, int target) {
        return ways(0, nums, target);
    }

    public static int ways(int i, int[] nums, int target){
        if(i == nums.length){
            if(target == 0) return 1; // 1 valid way
            else return 0;
        }

        int plus = ways(i+1, nums, target - nums[i]); // agar plus karenge to target chhota hoga
        int minus = ways(i+1, nums, target + nums[i]); // agar minus karenge to target badhega

        return plus + minus; // return total ways
    }*/

    // BASIC RECURSION - But easier to memoize
    /*public static int findTargetSumWays(int[] nums, int target) {
        return ways(0, nums, 0, target);
    }

    public static int ways(int i, int[] nums, int cSum, int target){
        if(i == nums.length){
            if(cSum == target) return 1; // 1 valid way
            else return 0;
        }

        int plus = ways(i+1, nums, cSum + nums[i], target);
        int minus = ways(i+1, nums,  cSum - nums[i], target);

        return plus + minus; // return total ways
    }*/

    // MEMOIZATION - SIDHA
    /*public static int sum;
    public static int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        sum = 0;
        for(int num: nums) sum += num;

        // i vary from 0 to n-1 | cSum from -sum to sum
        int[][] dp = new int[n][2*sum + 1];
        for(int[] row: dp) Arrays.fill(row, -1);

        return ways(0, nums, 0, target, dp);
    }

    public static int ways(int i, int[] nums, int cSum, int target, int[][] dp){
        if(i == nums.length){
            if(cSum == target) return 1; // 1 valid way
            else return 0;
        }

        if(dp[i][sum + cSum] != -1) return dp[i][sum + cSum]; // sum acts as offset

        int plus = ways(i+1, nums, cSum + nums[i], target, dp);
        int minus = ways(i+1, nums,  cSum - nums[i], target, dp);

        return dp[i][sum + cSum] = plus + minus; // return total ways
    }*/

    // MEMOIZATION - ULTA
    /*public static int sum;
    public static int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        sum = 0;
        for(int num: nums) sum += num;

        // i vary from n to 0 | cSum from -sum to sum
        int[][] dp = new int[n+1][2*sum + 1];
        for(int[] row: dp) Arrays.fill(row, -1);

        return ways(n, nums, 0, target, dp);
    }

    public static int ways(int n, int[] nums, int cSum, int target, int[][] dp){
        if(n == 0){
            if(cSum == target) return 1; // 1 valid way
            else return 0;
        }

        if(dp[n][sum + cSum] != -1) return dp[n][sum + cSum]; // sum acts as offset

        int plus = ways(n-1, nums, cSum + nums[n-1], target, dp);
        int minus = ways(n-1, nums,  cSum - nums[n-1], target, dp);

        return dp[n][sum + cSum] = plus + minus; // return total ways
    }*/

    // Reducing problem to subset sum problem
    // BASIC RECURSION
    /*public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num: nums) sum += num;

        if(Math.abs(target) > sum) return 0; // target bada ho gaya - impossible to achieve
        if((target + sum) % 2 != 0) return 0; // odd ho jayega to 2 se divide karne pe integer ahi milega

        int newTarget = (target + sum) / 2;

        return ways(0, nums, newTarget);
    }

    private static int ways(int i, int[] nums, int target) {
        // if(target == 0) return 1; // target achieved
        // if(i >= nums.length || target < 0) return 0; // bahar chala gaya
        // but in dono test case me ek dikkat hai
        // jab target 0 ho gaya to 1 aa jayega but agar uske aage
        // koi 0 aur bacha ho to wo to consider hi nahi hoga !!!
        // isiliye jab pura array khatam ho uske bad hi condn dekho
        if(i == nums.length) return target == 0 ? 1 : 0;

        int pick = 0;
        if(target >= nums[i])
            pick = ways(i+1, nums, target-nums[i]);

        int skip = ways(i+1, nums, target);

        return pick + skip;
    }*/

    // MEMOIZATION
    /*public static int findTargetSumWays(int[] nums, int target) {
        int n = nums.length, sum = 0;
        for(int num: nums) sum += num;

        if(Math.abs(target) > sum) return 0; // target bada ho gaya - impossible to achieve
        if((target + sum) % 2 != 0) return 0; // odd ho jayega to 2 se divide karne pe integer ahi milega

        int newTarget = (target + sum) / 2;

        // i vary from 0 to n-1 and newTar from newTar to 0
        int[][] dp = new int[n][newTarget+1];
        for(int[] row: dp) Arrays.fill(row, -1);

        return ways(0, nums, newTarget, dp);
    }

    private static int ways(int i, int[] nums, int target, int[][] dp) {
        if(i == nums.length) return target == 0 ? 1 : 0;

        if(dp[i][target] != -1) return dp[i][target];

        int pick = 0;
        if(target >= nums[i])
            pick = ways(i+1, nums, target-nums[i], dp);

        int skip = ways(i+1, nums, target, dp);

        return dp[i][target] = pick + skip;
    }*/

    // MEMOIZATION - ULTA
    public static int findTargetSumWays(int[] nums, int target) {
        int n = nums.length, sum = 0;
        for(int num: nums) sum += num;

        if(Math.abs(target) > sum) return 0; // target bada ho gaya - impossible to achieve
        if((target + sum) % 2 != 0) return 0; // odd ho jayega to 2 se divide karne pe integer ahi milega

        int newTarget = (target + sum) / 2;

        // i vary from n to 0 and newTar from newTar to 0
        int[][] dp = new int[n+1][newTarget+1];
        for(int[] row: dp) Arrays.fill(row, -1);

        return ways(n, nums, newTarget, dp);
    }

    private static int ways(int n, int[] nums, int target, int[][] dp) {
        if(n == 0) return target == 0 ? 1 : 0;

        if(dp[n][target] != -1) return dp[n][target];

        int pick = 0;
        if(target >= nums[n-1])
            pick = ways(n-1, nums, target-nums[n-1], dp);

        int skip = ways(n-1, nums, target, dp);

        return dp[n][target] = pick + skip;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 1, 1, 1, 1};
        System.out.println(findTargetSumWays(nums1, 3)); // Expected: 5

        int[] nums2 = {1};
        System.out.println(findTargetSumWays(nums2, 1)); // Expected: 1

        int[] nums3 = {1};
        System.out.println(findTargetSumWays(nums3, 2)); // Expected: 0

        int[] nums4 = {2, 2, 2, 2};
        System.out.println(findTargetSumWays(nums4, 0)); // Expected: 6

        int[] nums5 = {0, 0, 0, 0, 0, 0, 0, 0, 1};
        System.out.println(findTargetSumWays(nums5, 1)); // Expected: 256

        int[] nums6 = {1, 2, 3, 4, 5};
        System.out.println(findTargetSumWays(nums6, 3)); // Expected: 3
    }
}
