package DynamicProgramming.PartitionDP;

import java.util.Arrays;

public class MinCostToCutAStick {
    // BASIC RECURSION
    /*public static int minCost(int n, int[] cuts) {
        int l = cuts.length;

        int[] arr = new int[l+2]; // 0 and n insert karna hai
        for(int i=0; i<l; i++) arr[i] = cuts[i];
        arr[l] = 0;
        arr[l+1] = n;
        Arrays.sort(arr);

        return findCost(0, arr.length-1, arr);
    }

    private static int findCost(int i, int j, int[] arr) {
        if(j-i < 2) return 0; // length 2 se kam ho gaya to no cuts possible

        int minCost = Integer.MAX_VALUE;
        for(int k=i+1; k<=j-1; k++){
            int currCost = arr[j] - arr[i];
            int tc = findCost(i, k, arr) + findCost(k, j, arr) + currCost;
            minCost = Math.min(minCost, tc);
        }

        return minCost;
    }*/

    // MEMOIZATION
    /*public static int minCost(int n, int[] cuts) {
        int l = cuts.length;

        int[] arr = new int[l+2]; // 0 and n insert karna hai
        for(int i=0; i<l; i++) arr[i] = cuts[i];
        arr[l] = 0;
        arr[l+1] = n;
        Arrays.sort(arr);

        int al = arr.length;

        // i -> 0 - al-1 | j -> al-1 - 0
        int[][] dp = new int[al][al];
        for(int[] row: dp) Arrays.fill(row, -1);

        return findCost(0, al-1, arr, dp);
    }

    private static int findCost(int i, int j, int[] arr, int[][] dp) {
        if(j-i < 2) return 0; // length 2 se kam ho gaya to no cuts possible

        if(dp[i][j] != -1) return dp[i][j];

        int minCost = Integer.MAX_VALUE;
        for(int k=i+1; k<=j-1; k++){
            int currCost = arr[j] - arr[i];
            int tc = findCost(i, k, arr, dp) + findCost(k, j, arr, dp) + currCost;
            minCost = Math.min(minCost, tc);
        }

        return dp[i][j] = minCost;
    }*/

    // TABULATION CONVERSION FROM MEMOIZATION
    public static int minCost(int n, int[] cuts) {
        int l = cuts.length;

        int[] arr = new int[l+2]; // 0 and n insert karna hai
        for(int i=0; i<l; i++) arr[i] = cuts[i];
        arr[l] = 0; arr[l+1] = n;
        Arrays.sort(arr);

        int al = arr.length;

        // i -> 0 - al-1 | j -> al-1 - 0
        int[][] dp = new int[al][al];
        for (int i=al-1; i>=0; i--){
            for(int j=i+2; j<al; j++){

                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i+1; k<j; k++){
                    int cc = arr[j] - arr[i];
                    int tc = dp[i][k] + dp[k][j] + cc; // findCost(i, k) + findCost(k, j) + currCost
                    dp[i][j] = Math.min(dp[i][j], tc);
                }
            }
        }

        return dp[0][al-1];
    }

    // ISKA GAP YA LENGTH WALA BADHIYA WALA SOLUTION BAD ME DEKHENGE

    public static void main(String[] args) {

        int n1 = 7;
        int[] cuts1 = {1, 3, 4, 5};
        System.out.println(minCost(n1, cuts1)); // 16


        int n2 = 9;
        int[] cuts2 = {5, 6, 1, 4, 2};
        System.out.println(minCost(n2, cuts2)); // 22


        int n3 = 10;
        int[] cuts3 = {2, 4, 7};
        System.out.println(minCost(n3, cuts3)); // 20


        int n4 = 100;
        int[] cuts4 = {25, 50, 75};
        System.out.println(minCost(n4, cuts4)); // 200
    }
}