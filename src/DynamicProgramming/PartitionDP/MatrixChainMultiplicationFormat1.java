package DynamicProgramming.PartitionDP;

public class MatrixChainMultiplicationFormat1 {
    public static int MCM(int[][] arr) {
        return cost(0, arr.length-1, arr);
    }

    private static int cost(int i, int j, int[][] arr) {
        if(i == j) return 0;

        int minCost = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int C = arr[i][0] * arr[k][1] * arr[j][1];
            int totalCost = cost(i, k, arr) + cost(k+1, j, arr) + C;
            minCost = Math.min(minCost, totalCost);
        }

        return minCost;
    }

    public static void main(String[] args) {

        int[][] arr1 = {
                {40, 20},
                {20, 30},
                {30, 10},
                {10, 30}
        };
        System.out.println(MCM(arr1)); // 26000


        int[][] arr2 = {
                {10, 20},
                {20, 30},
                {30, 40},
                {40, 30}
        };
        System.out.println(MCM(arr2)); // 30000


        int[][] arr3 = {
                {10, 20},
                {20, 30}
        };
        System.out.println(MCM(arr3)); // 6000


        int[][] arr4 = {
                {10, 20},
                {20, 30},
                {30, 40},
                {40, 50}
        };
        System.out.println(MCM(arr4)); // 38000


        int[][] arr5 = {
                {10, 20}
        };
        System.out.println(MCM(arr5)); // 0


        int[][] arr6 = {
                {5, 10},
                {10, 3},
                {3, 12},
                {12, 5},
                {5, 50},
                {50, 6}
        };
        System.out.println(MCM(arr6)); // 2010
    }
}
