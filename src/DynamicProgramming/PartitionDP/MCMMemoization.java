package DynamicProgramming.PartitionDP;

import java.util.Arrays;

public class MCMMemoization {
    public static int MCM(int[] arr) {
        int n = arr.length;

        // i -> 0 - n-2 | j -> n-2 - 0
        int[][] dp = new int[n-1][n-1];
        for(int[] row: dp) Arrays.fill(row, -1);

        return cost(0, n-2, arr, dp);
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