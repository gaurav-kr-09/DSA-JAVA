package DynamicProgramming.Tabulation;

import java.util.Arrays;

public class SubsetSumProblem {
    //  Without SPACE OPTIMIZATION
    /*public static boolean subsetSum(int[] arr, int target) {
        int n = arr.length;

        boolean[][] dp = new boolean[n+1][target+1];
        for(int i=0; i<=n; i++) dp[i][0] = true; // 0 sum always possible
        for(int i=1; i<=target; i++) dp[0][i] = false; // impossible to get sum > 0 with no item

        for(int i=1; i<=n; i++){
            for(int j=1; j<=target; j++){
                boolean pick = false;
                if(j >= arr[i-1]) // isSumTar(n-1, arr, target-arr[n-1], dp)
                    pick = dp[i-1][j-arr[i-1]];

                boolean skip = dp[i-1][j]; // isSumTar(n-1, arr, target, dp);

                dp[i][j] = pick || skip;
            }
        }

        return dp[n][target];
    }*/

    // SPACE OPTIMIZED
    public static boolean subsetSum(int[] arr, int target) {
        int n = arr.length;

        boolean[] dp = new boolean[target+1];
        Arrays.fill(dp, false); // Unnecessary
        dp[0] = true;

        for(int i=1; i<=n; i++){
            for(int j=target; j>= arr[i-1]; j--){ // since we want older values
                boolean pick = dp[j-arr[i-1]];
                boolean skip = dp[j];

                dp[j] = pick || skip;
            }
        }

        return dp[target];
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