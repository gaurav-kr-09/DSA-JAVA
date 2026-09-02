package DynamicProgramming.Memoization;

import java.util.Arrays;

public class SubsetSumProblem {
    // SIDHA RECURSION
    // -------------------------------------------------------

    // BASIC RECURSION
    /*public static boolean subsetSum(int[] arr, int target) {
        return isSumTar(0, arr, target);
    }

    private static boolean isSumTar(int i, int[] arr, int target) {
        if(target == 0) return true;
        if(i >= arr.length || target < 0) return false;

        boolean pick = isSumTar(i+1, arr, target-arr[i]);
        boolean skip = isSumTar(i+1, arr, target);

        return pick || skip;
    }*/

    // MEMOIZATION - Using Boolean wrapper class
    // if we use boolean data type to uska array by default
    // false se bhara hoga to retrieval k time ye pata nahi chalega
    // ki computed false hai ya default wala - so use Boolean class
    // it has 3 value true, false, null
    /*public static boolean subsetSum(int[] arr, int target) {
        // I vary from 0 to n-1 and target from target to 0
        Boolean[][] dp = new Boolean[arr.length][target + 1];
        for(Boolean[] row: dp) Arrays.fill(row, null); // unnecessary

        return isSumTar(0, arr, target, dp);
    }

    private static boolean isSumTar(int i, int[] arr, int target, Boolean[][] dp) {
        if(target == 0) return true;
        if(i >= arr.length || target < 0) return false;

        if(dp[i][target] != null) return dp[i][target];

        boolean pick = isSumTar(i+1, arr, target-arr[i], dp);
        boolean skip = isSumTar(i+1, arr, target, dp);

        return dp[i][target] = pick || skip;
    }*/

    // MEMOIZATION - Using integer dp
    /*public static boolean subsetSum(int[] arr, int target) {
        // I vary from 0 to n-1 and target from target to 0
        int[][] dp = new int[arr.length][target + 1];
        for(int[] row: dp) Arrays.fill(row, -1);

        return isSumTar(0, arr, target, dp);
    }

    private static boolean isSumTar(int i, int[] arr, int target, int[][] dp) {
        if(target == 0) return true;
        if(i >= arr.length || target < 0) return false;

        if(dp[i][target] != -1) return dp[i][target] == 1;
        // -1 = not computed
        //  0 = computed false
        //  1 = computed true

        boolean pick = isSumTar(i+1, arr, target-arr[i], dp);
        boolean skip = isSumTar(i+1, arr, target, dp);

        boolean result = pick || skip;
        dp[i][target] = result ? 1 : 0;

        return result;
    }*/

    // ULTA
    // -------------------------------------------------------

    // MEMOIZATION USING Boolean
    public static boolean subsetSum(int[] arr, int target) {
        int n = arr.length;

        // I vary from n to 0 and target from target to 0
        Boolean[][] dp = new Boolean[n+1][target + 1];
        for(Boolean[] row: dp) Arrays.fill(row, null); // unnecessary

        return isSumTar(n, arr, target, dp);
    }

    private static boolean isSumTar(int n, int[] arr, int target, Boolean[][] dp) {
        if(target == 0) return true;
        if(n <= 0 || target < 0) return false;

        if(dp[n][target] != null) return dp[n][target];

        boolean pick = isSumTar(n-1, arr, target-arr[n-1], dp);
        boolean skip = isSumTar(n-1, arr, target, dp);

        return dp[n][target] = pick || skip;
    }

    public static void main(String[] args) {

        int[] arr1 = {2, 3, 7, 8, 10};
        System.out.println(subsetSum(arr1, 11)); // Expected: true

        int[] arr2 = {2, 3, 7, 8, 10};
        System.out.println(subsetSum(arr2, 14)); // Expected: false

        int[] arr3 = {3, 34, 4, 12, 5, 2};
        System.out.println(subsetSum(arr3, 9)); // Expected: true

        int[] arr4 = {3, 34, 4, 12, 5, 2};
        System.out.println(subsetSum(arr4, 30)); // Expected: false

        int[] arr5 = {1, 2, 3, 7};
        System.out.println(subsetSum(arr5, 6)); // Expected: true

        int[] arr6 = {1, 2, 7, 1, 5};
        System.out.println(subsetSum(arr6, 10)); // Expected: true

        int[] arr7 = {1, 2, 3};
        System.out.println(subsetSum(arr7, 7)); // Expected: false
    }
}